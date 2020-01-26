package cmu.youchun.lifeguide.config;

public interface SparkConfig {
    String DATA_PATH = "file:///Users/neutron18/devtool/data/";
    String LR_DATA_PATH = DATA_PATH + "lrmodel";
    String ALS_DATA_PATH = DATA_PATH + "alsmodel";
    String APP_NAME = "LifeguideApp";
    String DB_URL = "jdbc:mysql://127.0.0.1:3306/lifeguidedb?" +
            "user=root&password=admin&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
}
