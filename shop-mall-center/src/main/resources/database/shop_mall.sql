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

 Date: 06/11/2020 10:57:52
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
  `event_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件来源',
  `event_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '时间说明',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_event_who`(`event_who`) USING BTREE,
  INDEX `idx_event_do`(`event_do`) USING BTREE,
  INDEX `idx_event_when`(`event_when`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '埋点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of event_track
-- ----------------------------
INSERT INTO `event_track` VALUES (3, 'admin', 'admin_login', '2020-11-05 15:47:46', 'version', 'server', '客户端登录', 0, '2020-11-05 15:47:46', '2020-11-05 15:47:46');
INSERT INTO `event_track` VALUES (4, 'admin', 'admin_login', '2020-11-05 15:50:02', 'version', 'server', '客户端登录', 0, '2020-11-05 15:50:01', '2020-11-05 15:50:01');
INSERT INTO `event_track` VALUES (5, 'admin', 'admin_login', '2020-11-05 15:50:25', 'version', 'server', '客户端登录', 0, '2020-11-05 15:50:25', '2020-11-05 15:50:25');
INSERT INTO `event_track` VALUES (6, 'admin', 'admin_login', '2020-11-05 16:01:20', 'version', 'server', '客户端登录', 0, '2020-11-05 16:01:20', '2020-11-05 16:01:20');
INSERT INTO `event_track` VALUES (7, 'admin', 'admin_login', '2020-11-05 16:01:56', 'version', 'server', '客户端登录', 0, '2020-11-05 16:01:55', '2020-11-05 16:01:55');
INSERT INTO `event_track` VALUES (8, 'admin', 'admin_login', '2020-11-05 16:07:39', 'version', 'server', '客户端登录', 0, '2020-11-05 16:07:39', '2020-11-05 16:07:39');
INSERT INTO `event_track` VALUES (9, 'admin', 'admin_login', '2020-11-05 16:22:28', 'version', 'server', '客户端登录', 0, '2020-11-05 16:22:28', '2020-11-05 16:22:28');
INSERT INTO `event_track` VALUES (10, 'admin', 'admin_login', '2020-11-06 08:59:55', 'version', 'server', '客户端登录', 0, '2020-11-06 08:59:55', '2020-11-06 08:59:55');
INSERT INTO `event_track` VALUES (11, 'admin', 'admin_login', '2020-11-06 09:55:21', 'version', 'server', '客户端登录', 0, '2020-11-06 09:55:21', '2020-11-06 09:55:21');

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
  `stock_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存单位',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否上架（0：否；1：是）',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性键表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性值表' ROW_FORMAT = Dynamic;

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
  `small_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小图',
  `bind_property` json NULL COMMENT '绑定的属性',
  `price` double NOT NULL COMMENT '价格',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_goods_unique_id`(`goods_unique_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品库存表' ROW_FORMAT = Dynamic;

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
  `menu_type` tinyint(0) NOT NULL COMMENT '菜单类型（1：菜单；2：子菜单；3：按钮/接口）',
  `sort_number` int(0) NOT NULL DEFAULT 0 COMMENT '排序号',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_parent_unique_id`(`parent_unique_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '系统盘点', NULL, 1, 0, NULL, 0, '2020-11-05 15:29:15', '2020-11-05 15:29:15');
INSERT INTO `menu` VALUES (2, 1, '用户管理', '/user.html', 2, 0, NULL, 0, '2020-11-05 15:29:48', '2020-11-05 15:29:48');
INSERT INTO `menu` VALUES (3, 2, '用户列表', '/user/list', 3, 0, NULL, 0, '2020-11-05 15:30:14', '2020-11-05 15:30:14');
INSERT INTO `menu` VALUES (4, 2, '新增用户', '/user/save', 3, 0, NULL, 0, '2020-11-05 15:30:32', '2020-11-05 15:30:35');
INSERT INTO `menu` VALUES (5, 2, '用户注销', '/user/loginOut', 3, 0, NULL, 0, '2020-11-05 15:31:21', '2020-11-05 15:31:21');
INSERT INTO `menu` VALUES (6, 2, '用户删除', '/user/delete', 3, 0, NULL, 0, '2020-11-05 15:31:43', '2020-11-05 15:31:43');
INSERT INTO `menu` VALUES (7, 2, '用户编辑', '/user/update', 3, 0, NULL, 0, '2020-11-05 15:32:01', '2020-11-05 15:32:01');
INSERT INTO `menu` VALUES (8, 2, '更新密码', '/user/password/update', 3, 0, NULL, 0, '2020-11-05 15:32:21', '2020-11-05 15:32:21');
INSERT INTO `menu` VALUES (9, 1, '角色管理', '/role.html', 2, 0, NULL, 0, '2020-11-05 16:03:22', '2020-11-05 16:05:51');
INSERT INTO `menu` VALUES (10, 9, '角色列表', '/role/list', 3, 0, NULL, 0, '2020-11-05 16:03:53', '2020-11-05 16:04:06');
INSERT INTO `menu` VALUES (11, 9, '删除角色', '/role/delete', 3, 0, NULL, 0, '2020-11-05 16:04:38', '2020-11-05 16:04:38');
INSERT INTO `menu` VALUES (12, 9, '添加角色', '/role/save', 3, 0, NULL, 0, '2020-11-05 16:05:01', '2020-11-05 16:05:01');
INSERT INTO `menu` VALUES (13, 9, '编辑角色', '/role/update', 3, 0, NULL, 0, '2020-11-05 16:05:17', '2020-11-05 16:05:17');
INSERT INTO `menu` VALUES (14, 1, '菜单管理', '/menu.html', 2, 0, NULL, 0, '2020-11-05 16:05:39', '2020-11-05 16:05:56');
INSERT INTO `menu` VALUES (15, 14, '菜单列表', '/menu/list', 3, 0, NULL, 0, '2020-11-05 16:06:17', '2020-11-05 16:06:17');
INSERT INTO `menu` VALUES (16, 14, '用户菜单', '/menu/listByUser', 3, 0, NULL, 0, '2020-11-05 16:06:36', '2020-11-05 16:06:36');
INSERT INTO `menu` VALUES (17, 14, '添加菜单', '/menu/save', 3, 0, NULL, 0, '2020-11-05 16:07:05', '2020-11-05 16:07:05');
INSERT INTO `menu` VALUES (18, 14, '编辑菜单', '/menu/update', 3, 0, NULL, 0, '2020-11-05 16:07:22', '2020-11-05 16:07:22');
INSERT INTO `menu` VALUES (19, 1, '字典配置', '/config.html', 2, 0, NULL, 0, '2020-11-06 09:04:51', '2020-11-06 09:04:51');
INSERT INTO `menu` VALUES (20, 19, '字典列表', '/kv/store/list', 3, 0, NULL, 0, '2020-11-06 09:06:03', '2020-11-06 09:06:03');
INSERT INTO `menu` VALUES (21, 19, '字典新增', '/kv/store/save', 3, 0, NULL, 0, '2020-11-06 09:06:25', '2020-11-06 09:06:25');
INSERT INTO `menu` VALUES (22, 19, '字典更新', '/kv/store/update', 3, 0, NULL, 0, '2020-11-06 09:08:41', '2020-11-06 09:08:41');
INSERT INTO `menu` VALUES (23, 19, '字典删除', '/kv/store/delete', 3, 0, NULL, 0, '2020-11-06 09:12:27', '2020-11-06 09:12:27');
INSERT INTO `menu` VALUES (24, 1, '行为埋点', '/event.html', 2, 0, NULL, 0, '2020-11-06 09:14:45', '2020-11-06 09:14:45');
INSERT INTO `menu` VALUES (25, 24, '埋点列表', '/event/track/list', 3, 0, NULL, 0, '2020-11-06 09:20:39', '2020-11-06 09:20:39');
INSERT INTO `menu` VALUES (26, 24, '添加埋点', '/event/track/save', 3, 0, NULL, 0, '2020-11-06 09:21:26', '2020-11-06 09:21:26');
INSERT INTO `menu` VALUES (27, 0, '商城运营', NULL, 1, 0, NULL, 0, '2020-11-06 09:22:07', '2020-11-06 09:22:07');
INSERT INTO `menu` VALUES (28, 27, '商品分类', '/type.html', 2, 0, NULL, 0, '2020-11-06 09:22:46', '2020-11-06 09:22:46');
INSERT INTO `menu` VALUES (29, 28, '分类列表', '/goods/type/list', 3, 0, NULL, 0, '2020-11-06 09:23:39', '2020-11-06 09:23:39');
INSERT INTO `menu` VALUES (30, 28, '添加分类', '/goods/type/save', 3, 0, NULL, 0, '2020-11-06 09:23:59', '2020-11-06 09:23:59');
INSERT INTO `menu` VALUES (31, 27, '商品管理', '/goods.html', 2, 0, NULL, 0, '2020-11-06 09:26:20', '2020-11-06 09:26:20');
INSERT INTO `menu` VALUES (32, 31, '添加商品', '/goods/save', 3, 0, NULL, 0, '2020-11-06 09:26:39', '2020-11-06 09:26:39');
INSERT INTO `menu` VALUES (33, 31, '更新商品', '/goods/update', 3, 0, NULL, 0, '2020-11-06 09:27:15', '2020-11-06 09:27:15');
INSERT INTO `menu` VALUES (34, 27, '订单浏览', '/order.html', 2, 0, NULL, 0, '2020-11-06 09:28:08', '2020-11-06 09:28:08');
INSERT INTO `menu` VALUES (35, 34, '订单列表', '/order/list', 3, 0, NULL, 0, '2020-11-06 09:28:26', '2020-11-06 09:28:26');
INSERT INTO `menu` VALUES (36, 34, '订单详情', '/order/getById', 3, 0, NULL, 0, '2020-11-06 09:29:00', '2020-11-06 09:29:00');
INSERT INTO `menu` VALUES (37, 27, '账台流水', '/account.html', 2, 0, NULL, 0, '2020-11-06 09:29:51', '2020-11-06 09:29:51');
INSERT INTO `menu` VALUES (38, 0, '客服售后', NULL, 1, 0, NULL, 0, '2020-11-06 09:30:28', '2020-11-06 09:30:28');
INSERT INTO `menu` VALUES (39, 38, '智能客服', '/s.html', 2, 0, NULL, 0, '2020-11-06 09:30:57', '2020-11-06 09:31:14');
INSERT INTO `menu` VALUES (40, 38, '售后服务', '/s.html', 2, 0, NULL, 0, '2020-11-06 09:31:10', '2020-11-06 09:31:19');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单清单表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_admin
-- ----------------------------
INSERT INTO `user_admin` VALUES (1, 'admin', 'hGrqCl', '625d250273638c5f512ce04ea8767d71', NULL, 0, '系统管理员', 0, '2020-11-05 15:23:55', '2020-11-06 10:51:49');

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
