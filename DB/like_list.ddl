-- mydatabase.like_list definition

CREATE TABLE `like_list` (
  `sn` int NOT NULL AUTO_INCREMENT COMMENT '流水序號',
  `order_numbers` int NOT NULL COMMENT '購買數量',
  `account` varchar(255) NOT NULL COMMENT '扣款帳號',
  `total_fee` decimal(10,2) NOT NULL COMMENT '總手續費用(台幣計價)',
  `total_amount` decimal(10,2) NOT NULL COMMENT '預計扣款總金額',
  `status` int NOT NULL DEFAULT '1' COMMENT '狀態(1:啟用 0:刪除)',
  `product_no` int NOT NULL COMMENT '商品編號',
  PRIMARY KEY (`sn`),
  KEY `like_list_users_FK` (`account`),
  KEY `fk_products_no` (`product_no`),
  CONSTRAINT `fk_products_no` FOREIGN KEY (`product_no`) REFERENCES `products` (`no`),
  CONSTRAINT `like_list_users_FK` FOREIGN KEY (`account`) REFERENCES `users` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='訂單';