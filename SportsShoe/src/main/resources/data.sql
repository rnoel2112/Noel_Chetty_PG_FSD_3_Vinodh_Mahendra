 CREATE TABLE IF NOT EXISTS `admin` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert IGNORE into admin (id, email,first_name,last_name,password ) values (1, 'admin@simplilearn.com', 'Simpli', 'Learn','admin');

CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert IGNORE into category (id, type, description) values (1, 'MenShoes', 	 'All Men Shoes');
insert IGNORE into category (id, type, description) values (2, 'WomenShoes', 'All Women Shoes');
insert IGNORE into category (id, type, description) values (3, 'KidShoes', 	 'All Kids Shoes');
insert IGNORE into category (id, type, description) values (4, 'Basketball', 'All Baseketball Shoes');
insert IGNORE into category (id, type, description) values (5, 'SocckerShoes', 'All Soccker  Shoes');
insert IGNORE into category (id, type, description) values (6, 'RunningShoes', 'All Running Shoes');


CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint NOT NULL,
  `cat_type` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `date_of_expiry` datetime DEFAULT NULL,
  `dateof_manufature` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `manufactured_by` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  `size` float DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (2,'MenShoes','Red','2025-03-15','2021-04-21','All New Mens Shoes','Nike',300,'Men Shoes',8,1)

/*
 
insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (1,'MenShoes','Blue','2025-03-15','2021-04-21','All New Mens Shoes','Nike',250,'Men Shoes',7.5,1)

insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (3,'MenShoes','White','2025-03-15','2021-04-21','All New Mens Shoes','Nike',350,'Men Shoes',9,1)
	

insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (4,'WomenShoes','Blue','2025-03-15','2021-04-21','All New Womens Shoes','Addidas',250,'Womens Shoes',6.5,2)
insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (5,'WomenShoes','Red','2025-03-15','2021-04-21','All New Womens Shoes','Addidas',320,'Womens Shoes',7,2)
insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (6,'WomenShoes','White','2025-03-15','2021-04-21','All New Womens Shoes','Addidas',310,'Womens Shoes',8,2)
insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (7,'WomenShoes','Yellow','2025-03-15','2021-04-21','All New Womens Shoes','Addidas',315,'Womens Shoes',8,2)

insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (8,'KidShoes','Blue','2025-03-15','2021-04-21','All New Kids Shoes','Puma',150,'Kids Shoes',6,3)

insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (9,'Basketball','Red','2025-03-15','2021-04-21','All Basketball Shoes','Puma',650,'Basketball Shoes',8,4)

insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (10,'SocckerShoes','Balck','2025-03-15','2021-04-21','All Soccker Shoes','Puma',450,'Soccker Shoes',8,5)

insert IGNORE into product (id,cat_type, color,date_of_expiry,dateof_manufature,description,manufactured_by,price,short_name,size,category_id)
	values (11,'RunningShoes','Blue','2025-03-15','2021-04-21','All Running Shoes','Puma',450,'RunningShoes Shoes',8,6)

*/
	
