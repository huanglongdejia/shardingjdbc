CREATE TABLE `t_order_0` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` BIGINT NOT NULL COMMENT '订单号',
  `user_id` INT NOT NULL COMMENT '用户id',
  `status` VARCHAR (50) COMMENT '状态',
  `created_date` DATETIME NOT NULL COMMENT '创建时间',
  `modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '订单表' ;

CREATE TABLE `t_order_1` LIKE `t_order_0` ;

CREATE TABLE `t_order_item_0` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `order_id` BIGINT COMMENT '订单id',
  `user_id` INT NOT NULL COMMENT '用户id',
  `created_date` DATETIME NOT NULL COMMENT '创建时间',
  `modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '订单项表' ;

CREATE TABLE `t_order_item_1` LIKE `t_order_item_0` ;





-- 链接地址： 127.0.0.1:3306
--
-- 库名：sharding_jdbc_ds_0
--
-- 用户名：root
--
-- 密码：123456
--
-- 链接地址： 127.0.0.1:3306
--
-- 库名：sharding_jdbc_ds_1
--
-- 用户名：root
--
-- 密码：123456
