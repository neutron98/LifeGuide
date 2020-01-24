insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(0,'Default',now(),now(),0 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(1,'Lucky Star Catering Management Co., Ltd.',now(),now(),2.5 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(2,'Peking Duck Co., Ltd.',now(),now(),2 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(3,'Hefei Food Manufacturing Co., Ltd.',now(),now(),2.6 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(4,'East End Brewery',now(),now(),0.9 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(5,'Mickey Light Food Co., Ltd.',now(),now(),3 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(6,'Jiuzhu Foods',now(),now(),5.0 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(7,'Riverbend Foods',now(),now(),2.7 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(8,'Baimu Food Company',now(),now(),2 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(9,'Hanshel Food Company',now(),now(),1.5 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(10,'Old Town Food Company',now(),now(),1.8 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(11,'White Bunny Food Company',now(),now(),4.6 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(12,'Lind, Inc',now(),now(),5 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(13,'Shenghua Food',now(),now(),0.7 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(14,'Yurun Goup',now(),now(),5 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(15,'Darry, Inc',now(),now(),1.7 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(16,'Raid Technology',now(),now(),5 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(17,'Hyatt Hotels Corporation',now(),now(),3 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(18,'Carlson Companies, Inc.',now(),now(),3.1 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(19,'Starwood Hotels & Resorts Worldwide, Inc.',now(),now(),0.2 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(20,'Best Western International, Inc.',now(),now(),3.8 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(21,'Choice Hotels International',now(),now(),0.2 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(22,'Hilton Worldwide',now(),now(),1.7 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(23,'Accor Hotels',now(),now(),1.8 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(24,'Marriott International, Inc',now(),now(),4.1 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(25,'Cendant Corporation',now(),now(),3 ,0);
insert into seller(id,name,created_time,updated_time,rating,disabled_flag) values(26,'InterContinental Hotels Group plc',now(),now(),2.8 ,0);



INSERT INTO `category` VALUES ('1', '2019-06-10 15:33:37', '2019-06-10 15:33:37', 'Restaurants', '/static/image/firstpage/food_u.png', '99'),
('2', '2019-06-10 15:34:34', '2019-06-10 15:34:34', 'Hotels', '/static/image/firstpage/snack_u.png', '98'),
('3', '2019-06-10 15:36:36', '2019-06-10 15:36:36', 'Leisures', '/static/image/firstpage/bar_o.png', '97'),
('4', '2019-06-10 15:37:09', '2019-06-10 15:37:09', 'Marriage', '/static/image/firstpage/jiehun.png', '96'),
('5', '2019-06-10 15:37:31', '2019-06-10 15:37:31', 'Massage', '/static/image/firstpage/zuliao.png', '96'),
('6', '2019-06-10 15:37:49', '2019-06-10 15:37:49', 'Karaoke', '/static/image/firstpage/ktv_u.png', '95'),
('7', '2019-06-10 15:38:14', '2019-06-10 15:38:14', 'Attractions', '/static/image/firstpage/jingdian.png', '94'),
('8', '2019-06-10 15:38:35', '2019-06-10 15:38:35', 'Beauty', '/static/image/firstpage/liren.png', '93');


insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(1,'Lucky Star Noodles',now(),now(),4.9,156,120.915855,31.195341,1,'New, Trending','10:00','22:00','36 Chuachang Road, Shanghai',1,'/static/image/shopcover/xchg.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(2,'Lucky Star Noodles',now(),now(),0.4,79,121.44355,31.189323,1,'Love the snacks','10:00','22:00','899 Linling Road, Shanghai',1,'/static/image/shopcover/zoocoffee.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(3,'Lucky Star Noodles',now(),now(),4.7,101,121.44355,31.189323,1,'Big tables, WIFI-enabled','10:00','22:00','399 Caoxi North Road, Shanghai',1,'/static/image/shopcover/six.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(4,'Applewood Peking Duck',now(),now(),2,152,121.524878,31.306419,1,'Beautiful window views, WIFI-enabled','11:00','21:00','1099 Xiangyin Road, Shanghai',2,'/static/image/shopcover/yjbf.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(5,'Delta Peking Duck',now(),now(),2.3,187,121.519875,31.305236,1,'Pork belly','11:00','21:00','Handan Road and Guobin Road, Shanghai',2,'/static/image/shopcover/jbw.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(6,'Yukiyama Japanese Restaurant',now(),now(),2.3 ,78,121.524878,31.306419,1,'Cozy atmosphere','11:00','21:00','1099 Xiangyin Road, Shanghai',4,'/static/image/shopcover/mwsk.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(7,'Western Ends',now(),now(),4.7 ,100,121.515074,31.309411,1,'Awesome music','11:00','21:00','246 University Road, Shanghai',4,'/static/image/shopcover/lsy.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(8,'LAVA Lounge',now(),now(),2 ,152,121.52136,31.30837,1,'Awesome music','11:00','21:00','98 Songhu Road, Shanghai',4,'/static/image/shopcover/jtyjj.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(9,'Hyatt Hotel',now(),now(),2.2 ,176,121.525843,31.306172,2,'Beautiful window views','11:00','21:00','88 East Guoding Road, Shanghai',17,'/static/image/shopcover/dfjzw.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(10,'Hyatt Place',now(),now(),0.5 ,182,121.322846,31.196742,2,'Buffet','11:00','21:00','No.9 Shenhong Road, Shanghai',17,'/static/image/shopcover/secretroom09.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(11,'Hyatt Place Shanghai New Hongqiao',now(),now(),1,74,121.238362,31.156899,2,'Buffet','11:00','21:00','2799 Huqingping Highway, Shanghai',17,'/static/image/shopcover/secretroom08.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(12,'Hyatt Cafe',now(),now(),2 ,71,121.651921,30.679819,1,'Private Rooms','11:00','21:00','665 Nanqiao Huancheng East Road, Shanghai',17,'/static/image/shopcover/secretroom07.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(13,'Hongqiao Atomic Hilton Hotel',now(),now(),4.5 ,96,121.40127,31.193517,2,'2019 Best Hotels in Shanghai','11:00','21:00','1116 Hong Song East Rd, Shanghai',22,'/static/image/shopcover/secretroom06.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(14,'Hilton Hampton Hotels',now(),now(),1.7 ,176,121.053774,30.953049,2,'Luxury','11:00','21:00','Lane 59, Panyang Road, Huacao Town, Shanghai',22,'/static/image/shopcover/secretroom05.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(15,'Resident Inn by Marriott',now(),now(),4.1 ,187,121.479098,31.197688,2,'Luxury','11:00','21:00','99 Jiangbin Road, Shanghai',23,'/static/image/shopcover/secretroom04.jpg');

insert into shop(id,name,created_time,updated_time,rating,price_per_consumer,longitude,latitude,category_id,tags,start_time,end_time,address,seller_id,icon_url)
values(16,'Courtyard by Marriott',now(),now(),3,163,121.452481,31.285934,2,'Luxury','11:00','21:00','333 Guangzhong West Road, Shanghai',23,'/static/image/shopcover/secretroom03.jpg');
