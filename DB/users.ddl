-- mydatabase.users definition

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '使用者ID',
  `user_name` varchar(255) NOT NULL COMMENT '使用者名稱',
  `email` varchar(255) NOT NULL COMMENT '電子信箱',
  `account` varchar(255) NOT NULL COMMENT '扣款帳戶',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='使用者';