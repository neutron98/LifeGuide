package cmu.youchun.lifeguide.spark.offline;


import cmu.youchun.lifeguide.config.SparkConfig;
import cmu.youchun.lifeguide.spark.RatingHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.function.ForeachPartitionFunction;
import org.apache.spark.ml.recommendation.ALSModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AlsRecallPredict {

    public static void main(String[] args) {
        //Initialize spark environment
        SparkSession sparkSession = SparkSession.builder().master("local").appName(SparkConfig.APP_NAME).getOrCreate();

        //Load model
        ALSModel alsModel = ALSModel.load(SparkConfig.ALS_DATA_PATH);

        //Load rating data
        Dataset<Row> ratingData = RatingHelper.getRatingData(sparkSession);

        // Offline predict for 5 users based on recall
        Dataset<Row> users = ratingData.select(alsModel.getUserCol()).distinct().limit(5);
        // recommend 20 items for the set of users
        Dataset<Row> userRecs = alsModel.recommendForUserSubset(users,20);
        
        // Partition
        userRecs.foreachPartition(new ForeachPartitionFunction<Row>() {
            @Override
            public void call(Iterator<Row> t) throws Exception {

                // A list of <userId> - <shopIdList> pairs
                List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

                t.forEachRemaining(action -> {
                    int userId = action.getInt(0);
                    List<GenericRowWithSchema> recommendationList = action.getList(1);
                    // get the recommended shopIdList for the user
                    List<Integer> shopIdList = new ArrayList<Integer>();
                    recommendationList.forEach(row -> {
                        Integer shopId = row.getInt(0);
                        shopIdList.add(shopId);
                    });
                    // convert shopIdList into String
                    String recommendData = StringUtils.join(shopIdList, ",");
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("userId", userId);
                    map.put("shopIdList", recommendData);
                    // add into result map
                    data.add(map);
                });
                insertToDB(data);
            }
        });
    }
    
    // end main() method

    /**
     * Helper method to insert data into MySQL
     * @param data list of userId - shopIdList Map
     * @throws SQLException
     */
    private static void insertToDB(List<Map<String,Object>> data) throws SQLException {
        // Build database connection
        // inside each partition because jobs are distributed in different partitions
        Connection connection = DriverManager.
                getConnection(SparkConfig.DB_URL);
        // Parse data using dynamic binding
        PreparedStatement preparedStatement = connection.
                prepareStatement("insert into recommend(user_id,shop_id_list)values(?,?)");
        data.forEach(stringObjectMap -> {
            try {
                preparedStatement.setInt(1, (Integer) stringObjectMap.get("userId"));
                preparedStatement.setString(2, (String) stringObjectMap.get("shopIdList"));

                preparedStatement.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        preparedStatement.executeBatch();
        connection.close();
    }

}
