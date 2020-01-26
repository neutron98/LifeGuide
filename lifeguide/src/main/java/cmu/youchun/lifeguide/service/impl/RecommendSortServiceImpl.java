package cmu.youchun.lifeguide.service.impl;

import cmu.youchun.lifeguide.config.SparkConfig;
import cmu.youchun.lifeguide.service.RecommendSortService;
import cmu.youchun.lifeguide.model.ShopSortModel;
import org.apache.spark.ml.classification.LogisticRegressionModel;
import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendSortServiceImpl implements RecommendSortService {

    private SparkSession sparkSession;

    private LogisticRegressionModel lrModel;


    @PostConstruct
    public void init(){
        //Load LR Model
        sparkSession = SparkSession.builder().master("local").appName(SparkConfig.APP_NAME).getOrCreate();
        lrModel = LogisticRegressionModel.load(SparkConfig.LR_DATA_PATH);
    }
    @Override
    public List<Integer> sort(List<Integer> shopIdList, Integer userId){
        //Feature Engineering: produce features based on the 11-dimendional x for LR Model.
        // the call the predict method

        // return a list of ShopSortModel
        List<ShopSortModel> list = new ArrayList<>();
        for(Integer shopId : shopIdList){
            // TODO: Use data from cache or database
            // fake data here
            Vector v = Vectors.dense(1,0,0,0,0,1,0.6,0,0,1,0);
            //
            Vector result = lrModel.predictProbability(v);
            double[] arr = result.toArray();
            double score = arr[1];
            // construct a ShopSortModel
            ShopSortModel shopSortModel = new ShopSortModel();
            shopSortModel.setShopId(shopId);
            shopSortModel.setScore(score);
            list.add(shopSortModel);
        }
        // sort the ShopSortModel list
        Collections.sort(list);
        // Return sorted id list
        return list.stream().map(shopSortModel -> shopSortModel.getShopId()).collect(Collectors.toList());


    }
}
