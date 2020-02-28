# LifeGuide

### Description
Consists of parts: 
1. An user-facing business search and recommendation system. In the search services, users are able to filter the results by category and tags, and choose to order the results by price. The recommendation service will rank the results based on user's location, user profile, and historical behavior (rating, price preference, click. etc). The model was trained offline using ALS model for the Recall layer and Logistic Regression for Rank.

2. A business administration system, which allows the admin to manage(add, delete, disable) shops displayed to users. 

### Tools and Technologies:
- Backend: Spring Boot 2.1.5
- Frontend: HTML, CSS, jQuery, Bootstrap 4
- Database: MySQL 5.6
- Data synchronization: Logstash 7.5.1
- Search: ElasticSearch 7.5.1
- Recommendation: Spark Mllib 2.4.4
- GeoLocation: Google Map API
- Data Collection and Preprocessing: Python 3.6, Jupyter Notebook

Data is collected with [Yelp Fusion API](https://www.yelp.com/developers/documentation/v3/business_search)
