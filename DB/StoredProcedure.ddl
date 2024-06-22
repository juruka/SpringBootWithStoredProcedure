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

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`add_like_list`(
    IN n_order_numbers INT,
    IN n_account varchar(255),
    IN n_total_fee decimal(10,2),
    IN n_total_amount decimal(10,2),
    IN n_product_no INT
)
BEGIN 
    INSERT INTO like_list(order_numbers, account, total_fee, total_amount, product_no) 
    VALUES(n_order_numbers, n_account, n_total_fee, n_total_amount, n_product_no);
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`add_new_product`(
    IN n_name VARCHAR(255),
    IN n_price decimal(10,2),
    IN n_fee_rate decimal(4,2),
    OUT product_no INT
)
BEGIN 
    INSERT INTO products(product_name, price, fee_rate)
    VALUES(n_name, n_price, n_fee_rate);
    SET product_no = LAST_INSERT_ID();
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`get_products`(
    IN n_no INT
)
BEGIN 
    SELECT * FROM products p  WHERE p.no = n_no;
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`get_user_all`()
BEGIN 
    SELECT * FROM users;
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`get_user_by_id`(IN in_id INT)
BEGIN 
    SELECT * FROM users u WHERE u.user_id = in_id;
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`get_user_like_list`(
    IN n_account varchar(255)
)
BEGIN 
    SELECT * FROM like_list WHERE account = n_account and status = 1;
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`update_like_list`(
    IN n_sn INT,
    IN n_order_numbers INT,
    IN n_account varchar(255),
    IN n_total_fee decimal(10,2),
    IN n_total_amount decimal(10,2),
    IN n_status INT
    
)
BEGIN 
    UPDATE like_list
    SET order_numbers = n_order_numbers,
        account = n_account,
        total_fee = n_total_fee,
        total_amount = n_total_amount,
        status = n_status
    WHERE sn = n_sn;
END;

CREATE DEFINER=`root`@`localhost` PROCEDURE `mydatabase`.`update_products`(
    IN n_no INT,
    IN n_name VARCHAR(255),
    IN n_price decimal(10,2),
    IN n_fee_rate decimal(4,2)
)
BEGIN 
    UPDATE products p 
    SET p.product_name = n_name,
        p.price = n_price,
        p.fee_rate = n_fee_rate
    WHERE p.no = n_no;
END;