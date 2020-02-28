CREATE TABLE `t_order` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `total_amout` decimal(10,2) DEFAULT NULL,
   `status` int DEFAULT NULL,
   `user_id` bigint DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
