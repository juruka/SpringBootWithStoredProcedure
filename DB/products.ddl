-- mydatabase.products definition

CREATE TABLE `products` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '產品流水號',
  `product_name` varchar(255) NOT NULL COMMENT '產品名稱',
  `price` decimal(10,2) NOT NULL COMMENT '產品價格',
  `fee_rate` decimal(4,2) NOT NULL COMMENT '手續費率(%) ex: 0.1 (10%) / 0.01 (1%)',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='產品';