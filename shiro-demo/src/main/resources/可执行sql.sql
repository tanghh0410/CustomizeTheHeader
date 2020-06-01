CREATE TABLE `show_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字段所在页面',
  `table_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `field_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字段名称',
  `database_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '数据库字段名称',
  `entity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实体类字段名称',
  `field_order` int(11) DEFAULT NULL COMMENT '默认排序',
  `field_open` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否启用(0-是，1-否）',
  `is_del` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10299 DEFAULT CHARSET=utf8 COMMENT='全局字段表';

CREATE TABLE `user_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `column_id` int(11) DEFAULT NULL COMMENT '与show_column表字段关联的id',
  `user_id` int(11) DEFAULT NULL COMMENT '与用户表关联的id',
  `field_open` char(2) DEFAULT NULL COMMENT '字段是否开启（0代表开启 1代表关闭）',
  `is_del` char(2) DEFAULT NULL COMMENT '字段是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

CREATE TABLE `bos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `is_del` char(2) DEFAULT NULL COMMENT '是否删除 （0代表不删 1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `bos_user`(`user_name`, `password`, `is_del`) VALUES (1, 'soup_tang', 'c4ca4238a0b923820dcc509a6f75849b', '0');
INSERT INTO `bos_user`(`user_name`, `password`, `is_del`) VALUES (2, 'csdn博客', 'c4ca4238a0b923820dcc509a6f75849b', '0');


INSERT INTO `project`(`customer_name`, `project_name`, `project_group`, `type1`, `type2`, `type3`, `project_address`, `project_leader`, `superior_manager`, `business_leader`, `project_checker`, `is_del`) VALUES (1, '客户名称11', '项目名称11', '1111', NULL, NULL, NULL, '上海', '测试人员', '测试人员', '测试人员', '测试人员', '0');
INSERT INTO `project`(`customer_name`, `project_name`, `project_group`, `type1`, `type2`, `type3`, `project_address`, `project_leader`, `superior_manager`, `business_leader`, `project_checker`, `is_del`) VALUES (2, '客户名称2222', '项目名称33333', '111', NULL, NULL, NULL, '安徽', '测试人员', '测试人员', '测试人员', '测试人员', '0');



