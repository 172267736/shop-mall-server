/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : shop_mall

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 28/10/2020 17:20:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for event_track
-- ----------------------------
DROP TABLE IF EXISTS `event_track`;
CREATE TABLE `event_track`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `event_who` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件人',
  `event_do` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件',
  `event_when` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发生时间',
  `event_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号',
  `event_device_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型',
  `event_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '时间说明',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_event_who`(`event_who`) USING BTREE,
  INDEX `idx_event_do`(`event_do`) USING BTREE,
  INDEX `idx_event_when`(`event_when`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '埋点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of event_track
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goods_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `big_imgs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '大图集合',
  `goods_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情',
  `goods_video` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品视频',
  `goods_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品说明',
  `belong_classify_ids` json NULL COMMENT '所属分类编号',
  `goods_tags` json NULL COMMENT '商品标签',
  `top_sort` int(0) NOT NULL DEFAULT 0 COMMENT '置顶序号',
  `original_price` double NOT NULL COMMENT '商品原价（单位：元）',
  `current_price` double NOT NULL COMMENT '商品现价（单位：元）',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否上架（0：否；1：是）',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for goods_classify
-- ----------------------------
DROP TABLE IF EXISTS `goods_classify`;
CREATE TABLE `goods_classify`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `classify_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `classify_parent_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '父编号',
  `classify_icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图标',
  `classify_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类说明',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_classify
-- ----------------------------

-- ----------------------------
-- Table structure for goods_property_key
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_key`;
CREATE TABLE `goods_property_key`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goods_unique_id` bigint(0) NOT NULL COMMENT '商品编号',
  `property_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品属性key',
  `property_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品属性名称',
  `property_key_sort` int(0) NOT NULL DEFAULT 0 COMMENT '商品属性key排序',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_goods_unique_id`(`goods_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性键表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_property_key
-- ----------------------------

-- ----------------------------
-- Table structure for goods_property_value
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_value`;
CREATE TABLE `goods_property_value`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goods_property_key_unique_id` bigint(0) NOT NULL COMMENT '商品属性编号',
  `property_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品属性值',
  `price_increase` double NOT NULL COMMENT '价格涨幅（单位：元）',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_goods_property_key_unique_id`(`goods_property_key_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_property_value
-- ----------------------------

-- ----------------------------
-- Table structure for goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goods_unique_id` bigint(0) NOT NULL COMMENT '商品编号',
  `goods_stock` int(0) NOT NULL COMMENT '商品库存',
  `stock_unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存单位',
  `small_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小图',
  `bind_property` json NULL COMMENT '绑定的属性',
  `price` double NOT NULL COMMENT '价格',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_goods_unique_id`(`goods_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------

-- ----------------------------
-- Table structure for kv_store
-- ----------------------------
DROP TABLE IF EXISTS `kv_store`;
CREATE TABLE `kv_store`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一键',
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名一',
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名二',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `key_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key说明',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  UNIQUE INDEX `idx_key`(`key`) USING BTREE,
  INDEX `idx_first_name`(`first_name`) USING BTREE,
  INDEX `idx_last_name`(`last_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kv_store
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `parent_unique_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '父编号',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `menu_type` tinyint(0) NOT NULL COMMENT '菜单类型（1：菜单；2：功能；3：按钮/接口）',
  `sort_number` int(0) NOT NULL DEFAULT 0 COMMENT '排序号',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_parent_unique_id`(`parent_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `menu_unique_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '菜单编号',
  `role_unique_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '角色编号',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_menu_unique_id`(`menu_unique_id`) USING BTREE,
  INDEX `idx_role_unique_id`(`role_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `order_number` bigint(0) NOT NULL COMMENT '订单号',
  `thirdpart_order_number` int(0) NOT NULL COMMENT '三方订单号',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态（0：待支付；1：支付中；2：支付成功；3：支付失败）',
  `expire_state` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否超时（0：否；1：是）',
  `pay_user_unique_id` bigint(0) NULL DEFAULT NULL COMMENT '支付用户',
  `should_pay_money` double NOT NULL COMMENT '应支付金额（单位：元）',
  `actual_pay_money` double NOT NULL COMMENT '实支付金额（单位：元）',
  `pay_type` int(0) NOT NULL COMMENT '支付类型（1：微信；2：支付宝；3：其他；）',
  `pay_result_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '支付结果说明',
  `pay_over_time` datetime(0) NULL DEFAULT NULL COMMENT '支付完成时间',
  `allocation_address_unique_id` bigint(0) NOT NULL COMMENT '收货地址编号',
  `order_remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '订单备注',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  UNIQUE INDEX `idx_order_number`(`order_number`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_pay_user_unique_id`(`pay_user_unique_id`) USING BTREE,
  INDEX `idx_allocation_address_unique_id`(`allocation_address_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_account
-- ----------------------------
DROP TABLE IF EXISTS `order_account`;
CREATE TABLE `order_account`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `order_unique_id` bigint(0) NOT NULL COMMENT '订单编号',
  `goods_unique_id` bigint(0) NOT NULL COMMENT '商品编号',
  `goods_sku_unique_id` bigint(0) NOT NULL COMMENT '库存编号',
  `price` double NOT NULL COMMENT '价格',
  `goods_information` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品信息',
  `account_remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '清单备注',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_order_unique_id`(`order_unique_id`) USING BTREE,
  INDEX `idx_goods_unique_id`(`goods_unique_id`) USING BTREE,
  INDEX `idx_goods_sku_unique_id`(`goods_sku_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单清单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_account
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_unique_id` bigint(0) NOT NULL COMMENT '用户编号',
  `role_unique_id` bigint(0) NOT NULL COMMENT '角色编号',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_user_unique_id`(`user_unique_id`) USING BTREE,
  INDEX `idx_role_unique_id`(`role_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_admin
-- ----------------------------
DROP TABLE IF EXISTS `user_admin`;
CREATE TABLE `user_admin`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `salt` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码盐',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `header_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_state` tinyint(0) NOT NULL DEFAULT 0 COMMENT '用户状态（0：正常；1：异常）',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_admin
-- ----------------------------

-- ----------------------------
-- Table structure for user_allocation_address
-- ----------------------------
DROP TABLE IF EXISTS `user_allocation_address`;
CREATE TABLE `user_allocation_address`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_unique_id` bigint(0) NOT NULL COMMENT '用户编号',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '市',
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区',
  `road` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路/街道',
  `address_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `tag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址标签',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_user_unique_id`(`user_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配送地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_allocation_address
-- ----------------------------

-- ----------------------------
-- Table structure for user_app
-- ----------------------------
DROP TABLE IF EXISTS `user_app`;
CREATE TABLE `user_app`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `header_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `sex` tinyint(0) NOT NULL COMMENT '性别（0：未知；1：男；2：女；）',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '应用用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_app
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
