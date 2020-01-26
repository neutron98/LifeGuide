package cmu.youchun.lifeguide.spark.offline;

import cmu.youchun.lifeguide.config.SparkConfig;
import cmu.youchun.lifeguide.spark.RatingHelper;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.recommendation.ALS;
import org.apache.spark.ml.recommendation.ALSModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.io.Serializable;

/**
 * ALS Recall Algorithm Training
 */
public class AlsRecallTrain implements Serializable {

    public static void main(String[] args) throws IOException {
        //Initialize spark environment
        SparkSession sparkSession = SparkSession.builder().master("local").appName(SparkConfig.APP_NAME).getOrCreate();

        JavaRDD<String> csvFile = sparkSession.read().textFile(SparkConfig.DATA_PATH + "behavior.csv").toJavaRDD();

        Dataset<Row> ratingData = RatingHelper.getRatingData(sparkSession);

        //Split training and testing dataset by 8:2
        Dataset<Row>[] splits = ratingData.randomSplit(new double[]{0.8,0.2});
        Dataset<Row> trainingData = splits[0];
        Dataset<Row> testingData = splits[1];

        // Initialize model
        // If overfits: Enlarge the dataset, reduce rank, increase RegParam
        ALS als = new ALS().setMaxIter(10).setRank(5).setRegParam(0.01).
                setUserCol("userId").setItemCol("shopId").setRatingCol("rating");

        //Train model
        ALSModel alsModel = als.fit(trainingData);

        // Evaluate model
        Dataset<Row> predictions = alsModel.transform(testingData);

        //Calculate RMSE
        RegressionEvaluator evaluator = new RegressionEvaluator().setMetricName("rmse")
                .setLabelCol("rating").setPredictionCol("prediction");
        double rmse = evaluator.evaluate(predictions);
        System.out.println("rmse = "+rmse);

        alsModel.write().overwrite().save(SparkConfig.ALS_DATA_PATH);
    }

}
