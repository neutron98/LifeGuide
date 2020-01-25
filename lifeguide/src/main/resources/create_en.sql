CREATE TABLE `recommender`.`shop`  (
                                      `id` int(0) NOT NULL AUTO_INCREMENT,
                                      `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      `name` varchar(80) NOT NULL DEFAULT '',
                                      `rating` decimal(2, 1) NOT NULL DEFAULT 0 COMMENT '0~5',
                                      `price_level` int(0) NOT NULL DEFAULT 0,
                                      `latitude` decimal(10, 6) NOT NULL DEFAULT 0,
                                      `longitude` decimal(10, 6) NOT NULL DEFAULT 0,
                                      `category_id` int(0) NOT NULL DEFAULT 0,
                                      `tags` varchar(2000) NOT NULL DEFAULT '',
                                      `start_time` varchar(200) NOT NULL DEFAULT '',
                                      `end_time` varchar(200) NOT NULL DEFAULT '',
                                      `address` varchar(200) NOT NULL DEFAULT '',
                                      `seller_id` int(0) NOT NULL DEFAULT 0,
                                      `icon_url` varchar(100) NOT NULL DEFAULT '',
                                      PRIMARY KEY (`id`)

);