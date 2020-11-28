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

 Date: 28/11/2020 13:46:16
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
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '埋点表' ROW_FORMAT = Dynamic;

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
INSERT INTO `event_track` VALUES (12, 'admin', 'admin_login', '2020-11-06 11:06:57', 'version', 'server', '客户端登录', 0, '2020-11-06 11:06:56', '2020-11-06 11:06:56');
INSERT INTO `event_track` VALUES (13, 'admin', 'admin_login', '2020-11-06 11:06:59', 'version', 'server', '客户端登录', 0, '2020-11-06 11:06:59', '2020-11-06 11:06:59');
INSERT INTO `event_track` VALUES (14, 'admin', 'admin_login', '2020-11-06 11:07:35', 'version', 'server', '客户端登录', 0, '2020-11-06 11:07:34', '2020-11-06 11:07:34');
INSERT INTO `event_track` VALUES (15, 'admin', 'admin_login', '2020-11-06 11:08:17', 'version', 'server', '客户端登录', 0, '2020-11-06 11:08:16', '2020-11-06 11:08:16');
INSERT INTO `event_track` VALUES (16, 'admin', 'admin_login', '2020-11-06 11:09:20', 'version', 'server', '客户端登录', 0, '2020-11-06 11:09:20', '2020-11-06 11:09:20');
INSERT INTO `event_track` VALUES (17, 'admin', 'admin_login', '2020-11-06 14:54:26', 'version', 'server', '客户端登录', 0, '2020-11-06 14:54:25', '2020-11-06 14:54:25');
INSERT INTO `event_track` VALUES (18, 'admin', 'admin_login', '2020-11-06 15:35:36', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:36', '2020-11-06 15:35:36');
INSERT INTO `event_track` VALUES (19, 'admin', 'admin_login', '2020-11-06 15:35:39', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:39', '2020-11-06 15:35:39');
INSERT INTO `event_track` VALUES (20, 'admin', 'admin_login', '2020-11-06 15:35:41', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:40', '2020-11-06 15:35:40');
INSERT INTO `event_track` VALUES (21, 'admin', 'admin_login', '2020-11-06 15:35:42', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:42', '2020-11-06 15:35:42');
INSERT INTO `event_track` VALUES (22, 'admin', 'admin_login', '2020-11-06 15:35:44', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:43', '2020-11-06 15:35:43');
INSERT INTO `event_track` VALUES (23, '', 'admin_login', '2020-11-06 15:35:45', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:44', '2020-11-06 15:35:44');
INSERT INTO `event_track` VALUES (24, 'admin', 'admin_login', '2020-11-06 15:35:49', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:48', '2020-11-06 15:35:48');
INSERT INTO `event_track` VALUES (25, 'admin', 'admin_login', '2020-11-06 15:35:51', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:51', '2020-11-06 15:35:51');
INSERT INTO `event_track` VALUES (26, 'admin', 'admin_login', '2020-11-06 15:35:53', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:52', '2020-11-06 15:35:52');
INSERT INTO `event_track` VALUES (27, 'admin', 'admin_login', '2020-11-06 15:35:54', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:54', '2020-11-06 15:35:54');
INSERT INTO `event_track` VALUES (28, 'admin', 'admin_login', '2020-11-06 15:35:57', 'version', 'server', '客户端登录', 0, '2020-11-06 15:35:56', '2020-11-06 15:35:56');
INSERT INTO `event_track` VALUES (29, 'admin', 'admin_login', '2020-11-06 15:36:29', 'version', 'server', '客户端登录', 0, '2020-11-06 15:36:28', '2020-11-06 15:36:28');
INSERT INTO `event_track` VALUES (30, 'admin', 'admin_login', '2020-11-06 15:43:00', 'version', 'server', '客户端登录', 0, '2020-11-06 15:42:59', '2020-11-06 15:42:59');
INSERT INTO `event_track` VALUES (31, 'admin', 'admin_login', '2020-11-09 16:16:23', 'version', 'server', '客户端登录', 0, '2020-11-09 16:16:22', '2020-11-09 16:16:22');
INSERT INTO `event_track` VALUES (32, 'admin', 'admin_login', '2020-11-09 17:21:31', 'version', 'server', '客户端登录', 0, '2020-11-09 17:21:30', '2020-11-09 17:21:30');
INSERT INTO `event_track` VALUES (33, 'admin', 'admin_login', '2020-11-09 17:21:50', 'version', 'server', '客户端登录', 0, '2020-11-09 17:21:49', '2020-11-09 17:21:49');
INSERT INTO `event_track` VALUES (34, 'admin', 'admin_login', '2020-11-10 09:16:02', 'version', 'server', '客户端登录', 0, '2020-11-10 09:16:01', '2020-11-10 09:16:01');
INSERT INTO `event_track` VALUES (35, 'admin', 'admin_login', '2020-11-10 09:53:13', 'version', 'server', '客户端登录', 0, '2020-11-10 09:53:12', '2020-11-10 09:53:12');
INSERT INTO `event_track` VALUES (36, 'admin', 'admin_login', '2020-11-10 10:40:58', 'version', 'server', '客户端登录', 0, '2020-11-10 10:40:58', '2020-11-10 10:40:58');
INSERT INTO `event_track` VALUES (37, 'admin', 'admin_login', '2020-11-10 10:42:51', 'version', 'server', '客户端登录', 0, '2020-11-10 10:42:50', '2020-11-10 10:42:50');
INSERT INTO `event_track` VALUES (38, 'admin', 'admin_login', '2020-11-10 11:10:50', 'version', 'server', '客户端登录', 0, '2020-11-10 11:10:50', '2020-11-10 11:10:50');
INSERT INTO `event_track` VALUES (39, 'admin', 'admin_save_role', '2020-11-10 16:07:37', 'version', 'server', '新增角色', 0, '2020-11-10 16:07:36', '2020-11-10 16:07:36');
INSERT INTO `event_track` VALUES (40, 'admin', 'admin_save_role', '2020-11-10 16:07:45', 'version', 'server', '新增角色', 0, '2020-11-10 16:07:44', '2020-11-10 16:07:44');
INSERT INTO `event_track` VALUES (41, 'admin', 'admin_save_role', '2020-11-10 16:07:50', 'version', 'server', '新增角色', 0, '2020-11-10 16:07:50', '2020-11-10 16:07:50');
INSERT INTO `event_track` VALUES (42, 'admin', 'admin_save_role', '2020-11-10 16:07:58', 'version', 'server', '新增角色', 0, '2020-11-10 16:07:57', '2020-11-10 16:07:57');
INSERT INTO `event_track` VALUES (43, 'admin', 'admin_save_role', '2020-11-10 16:08:05', 'version', 'server', '新增角色', 0, '2020-11-10 16:08:04', '2020-11-10 16:08:04');
INSERT INTO `event_track` VALUES (44, 'admin', 'admin_save_role', '2020-11-10 16:08:14', 'version', 'server', '新增角色', 0, '2020-11-10 16:08:13', '2020-11-10 16:08:13');
INSERT INTO `event_track` VALUES (45, 'admin', 'admin_login', '2020-11-11 09:23:18', 'version', 'server', '客户端登录', 0, '2020-11-11 09:23:17', '2020-11-11 09:23:17');
INSERT INTO `event_track` VALUES (46, NULL, 'admin_login', '2020-11-11 10:09:12', 'version', 'server', '客户端登录', 0, '2020-11-11 10:09:12', '2020-11-11 10:09:12');
INSERT INTO `event_track` VALUES (47, NULL, 'admin_login', '2020-11-11 10:20:33', 'version', 'server', '客户端登录', 0, '2020-11-11 10:20:33', '2020-11-11 10:20:33');
INSERT INTO `event_track` VALUES (48, NULL, 'admin_login', '2020-11-11 10:28:16', 'version', 'server', '客户端登录', 0, '2020-11-11 10:28:15', '2020-11-11 10:28:15');
INSERT INTO `event_track` VALUES (49, 'admin', 'admin_login_out', '2020-11-11 10:32:27', 'version', 'server', '客户端登出', 0, '2020-11-11 10:32:27', '2020-11-11 10:32:27');
INSERT INTO `event_track` VALUES (50, NULL, 'admin_login', '2020-11-11 10:32:30', 'version', 'server', '客户端登录', 0, '2020-11-11 10:32:30', '2020-11-11 10:32:30');
INSERT INTO `event_track` VALUES (51, 'admin', 'admin_update_password', '2020-11-11 10:32:47', 'version', 'server', '更新密码', 0, '2020-11-11 10:32:46', '2020-11-11 10:32:46');
INSERT INTO `event_track` VALUES (52, 'admin', 'admin_login_out', '2020-11-11 10:32:57', 'version', 'server', '客户端登出', 0, '2020-11-11 10:32:56', '2020-11-11 10:32:56');
INSERT INTO `event_track` VALUES (53, NULL, 'admin_login', '2020-11-11 10:32:59', 'version', 'server', '客户端登录', 0, '2020-11-11 10:32:58', '2020-11-11 10:32:58');
INSERT INTO `event_track` VALUES (54, NULL, 'admin_login', '2020-11-11 10:33:02', 'version', 'server', '客户端登录', 0, '2020-11-11 10:33:02', '2020-11-11 10:33:02');
INSERT INTO `event_track` VALUES (55, 'admin', 'admin_login_out', '2020-11-11 10:34:20', 'version', 'server', '客户端登出', 0, '2020-11-11 10:34:19', '2020-11-11 10:34:19');
INSERT INTO `event_track` VALUES (56, NULL, 'admin_login', '2020-11-11 10:34:21', 'version', 'server', '客户端登录', 0, '2020-11-11 10:34:21', '2020-11-11 10:34:21');
INSERT INTO `event_track` VALUES (57, NULL, 'admin_login', '2020-11-11 10:34:25', 'version', 'server', '客户端登录', 0, '2020-11-11 10:34:25', '2020-11-11 10:34:25');
INSERT INTO `event_track` VALUES (58, 'admin', 'admin_login_out', '2020-11-11 10:35:08', 'version', 'server', '客户端登出', 0, '2020-11-11 10:35:07', '2020-11-11 10:35:07');
INSERT INTO `event_track` VALUES (59, NULL, 'admin_login', '2020-11-11 10:35:09', 'version', 'server', '客户端登录', 0, '2020-11-11 10:35:09', '2020-11-11 10:35:09');
INSERT INTO `event_track` VALUES (60, NULL, 'admin_login', '2020-11-11 10:35:12', 'version', 'server', '客户端登录', 0, '2020-11-11 10:35:11', '2020-11-11 10:35:11');
INSERT INTO `event_track` VALUES (61, NULL, 'admin_login', '2020-11-11 10:35:18', 'version', 'server', '客户端登录', 0, '2020-11-11 10:35:18', '2020-11-11 10:35:18');
INSERT INTO `event_track` VALUES (62, 'admin', 'admin_save_user', '2020-11-11 10:41:39', 'version', 'server', '新增用户', 0, '2020-11-11 10:41:39', '2020-11-11 10:41:39');
INSERT INTO `event_track` VALUES (63, 'admin', 'admin_delete_user', '2020-11-11 10:47:25', 'version', 'server', '删除用户', 0, '2020-11-11 10:47:25', '2020-11-11 10:47:25');
INSERT INTO `event_track` VALUES (64, 'admin', 'admin_save_user', '2020-11-11 10:47:33', 'version', 'server', '新增用户', 0, '2020-11-11 10:47:32', '2020-11-11 10:47:32');
INSERT INTO `event_track` VALUES (65, 'admin', 'admin_save_user', '2020-11-11 10:49:58', 'version', 'server', '新增用户', 0, '2020-11-11 10:49:58', '2020-11-11 10:49:58');
INSERT INTO `event_track` VALUES (66, 'admin', 'admin_save_user', '2020-11-11 10:51:19', 'version', 'server', '新增用户', 0, '2020-11-11 10:51:18', '2020-11-11 10:51:18');
INSERT INTO `event_track` VALUES (67, 'admin', 'admin_login_out', '2020-11-11 10:55:12', 'version', 'server', '客户端登出', 0, '2020-11-11 10:55:11', '2020-11-11 10:55:11');
INSERT INTO `event_track` VALUES (68, NULL, 'admin_login', '2020-11-11 10:55:13', 'version', 'server', '客户端登录', 0, '2020-11-11 10:55:13', '2020-11-11 10:55:13');
INSERT INTO `event_track` VALUES (69, 'admin', 'admin_update_user', '2020-11-11 10:56:48', 'version', 'server', '编辑用户', 0, '2020-11-11 10:56:47', '2020-11-11 10:56:47');
INSERT INTO `event_track` VALUES (70, 'admin', 'admin_delete_user', '2020-11-11 10:57:04', 'version', 'server', '删除用户', 0, '2020-11-11 10:57:03', '2020-11-11 10:57:03');
INSERT INTO `event_track` VALUES (71, 'admin', 'admin_save_user', '2020-11-11 11:16:49', 'version', 'server', '新增用户', 0, '2020-11-11 11:16:49', '2020-11-11 11:16:49');
INSERT INTO `event_track` VALUES (72, 'admin', 'admin_save_dic', '2020-11-11 11:33:18', 'version', 'server', '新增字典', 0, '2020-11-11 11:33:18', '2020-11-11 11:33:18');
INSERT INTO `event_track` VALUES (73, 'admin', 'admin_save_dic', '2020-11-11 11:34:41', 'version', 'server', '新增字典', 0, '2020-11-11 11:34:41', '2020-11-11 11:34:41');
INSERT INTO `event_track` VALUES (74, 'admin', 'admin_login_out', '2020-11-11 11:39:44', 'version', 'server', '客户端登出', 0, '2020-11-11 11:39:43', '2020-11-11 11:39:43');
INSERT INTO `event_track` VALUES (75, NULL, 'admin_login', '2020-11-11 11:39:46', 'version', 'server', '客户端登录', 0, '2020-11-11 11:39:46', '2020-11-11 11:39:46');
INSERT INTO `event_track` VALUES (76, 'admin', 'admin_login_out', '2020-11-11 11:40:30', 'version', 'server', '客户端登出', 0, '2020-11-11 11:40:30', '2020-11-11 11:40:30');
INSERT INTO `event_track` VALUES (77, NULL, 'admin_login', '2020-11-11 11:40:31', 'version', 'server', '客户端登录', 0, '2020-11-11 11:40:30', '2020-11-11 11:40:30');
INSERT INTO `event_track` VALUES (78, 'admin', 'admin_update_dic', '2020-11-11 11:40:44', 'version', 'server', '编辑字典', 0, '2020-11-11 11:40:43', '2020-11-11 11:40:43');
INSERT INTO `event_track` VALUES (79, 'admin', 'admin_delete_dic', '2020-11-11 11:40:51', 'version', 'server', '删除字典', 0, '2020-11-11 11:40:50', '2020-11-11 11:40:50');
INSERT INTO `event_track` VALUES (80, 'admin', 'admin_delete_user', '2020-11-11 14:19:32', 'version', 'server', '删除用户', 0, '2020-11-11 14:19:31', '2020-11-11 14:19:31');
INSERT INTO `event_track` VALUES (81, 'admin', 'admin_login_out', '2020-11-11 14:46:05', 'version', 'server', '客户端登出', 0, '2020-11-11 14:46:05', '2020-11-11 14:46:05');
INSERT INTO `event_track` VALUES (82, NULL, 'admin_login', '2020-11-11 14:46:08', 'version', 'server', '客户端登录', 0, '2020-11-11 14:46:08', '2020-11-11 14:46:08');
INSERT INTO `event_track` VALUES (83, 'admin', 'admin_save_dic', '2020-11-11 14:46:21', 'version', 'server', '新增字典', 0, '2020-11-11 14:46:20', '2020-11-11 14:46:20');
INSERT INTO `event_track` VALUES (84, 'admin', 'admin_delete_dic', '2020-11-11 15:03:58', 'version', 'server', '删除字典', 0, '2020-11-11 15:03:57', '2020-11-11 15:03:57');
INSERT INTO `event_track` VALUES (85, 'admin', 'admin_delete_user', '2020-11-11 15:09:01', 'version', 'server', '删除用户', 0, '2020-11-11 15:09:00', '2020-11-11 15:09:00');
INSERT INTO `event_track` VALUES (86, 'admin', 'admin_delete_role', '2020-11-11 15:10:06', 'version', 'server', '删除角色', 0, '2020-11-11 15:10:05', '2020-11-11 15:10:05');
INSERT INTO `event_track` VALUES (87, 'admin', 'admin_delete_role', '2020-11-11 15:10:13', 'version', 'server', '删除角色', 0, '2020-11-11 15:10:13', '2020-11-11 15:10:13');
INSERT INTO `event_track` VALUES (88, 'admin', 'admin_save_goods_classify', '2020-11-12 11:11:10', 'version', 'server', '新增商品分类', 0, '2020-11-12 11:11:10', '2020-11-12 11:11:10');
INSERT INTO `event_track` VALUES (89, 'admin', 'admin_save_goods_classify', '2020-11-12 11:11:30', 'version', 'server', '新增商品分类', 0, '2020-11-12 11:11:30', '2020-11-12 11:11:30');
INSERT INTO `event_track` VALUES (90, 'admin', 'admin_save_goods_classify', '2020-11-12 11:14:40', 'version', 'server', '新增商品分类', 0, '2020-11-12 11:14:39', '2020-11-12 11:14:39');
INSERT INTO `event_track` VALUES (91, 'admin', 'admin_login_out', '2020-11-12 11:32:48', 'version', 'server', '客户端登出', 0, '2020-11-12 11:32:47', '2020-11-12 11:32:47');
INSERT INTO `event_track` VALUES (92, NULL, 'admin_login', '2020-11-12 11:32:50', 'version', 'server', '客户端登录', 0, '2020-11-12 11:32:49', '2020-11-12 11:32:49');
INSERT INTO `event_track` VALUES (93, 'admin', 'admin_save_goods_classify', '2020-11-12 12:01:02', 'version', 'server', '新增商品分类', 0, '2020-11-12 12:01:02', '2020-11-12 12:01:02');
INSERT INTO `event_track` VALUES (94, 'admin', 'admin_login_out', '2020-11-12 14:35:26', 'version', 'server', '客户端登出', 0, '2020-11-12 14:35:25', '2020-11-12 14:35:25');
INSERT INTO `event_track` VALUES (95, NULL, 'admin_login', '2020-11-12 14:35:29', 'version', 'server', '客户端登录', 0, '2020-11-12 14:35:29', '2020-11-12 14:35:29');
INSERT INTO `event_track` VALUES (96, NULL, 'admin_login', '2020-11-12 14:56:38', 'version', 'server', '客户端登录', 0, '2020-11-12 14:56:38', '2020-11-12 14:56:38');
INSERT INTO `event_track` VALUES (97, 'admin', 'admin_login_out', '2020-11-12 15:36:16', 'version', 'server', '客户端登出', 0, '2020-11-12 15:36:16', '2020-11-12 15:36:16');
INSERT INTO `event_track` VALUES (98, NULL, 'admin_login', '2020-11-12 15:36:18', 'version', 'server', '客户端登录', 0, '2020-11-12 15:36:17', '2020-11-12 15:36:17');
INSERT INTO `event_track` VALUES (99, NULL, 'admin_login', '2020-11-12 17:06:43', 'version', 'server', '客户端登录', 0, '2020-11-12 17:06:43', '2020-11-12 17:06:43');
INSERT INTO `event_track` VALUES (100, NULL, 'admin_login', '2020-11-12 17:10:57', 'version', 'server', '客户端登录', 0, '2020-11-12 17:10:56', '2020-11-12 17:10:56');
INSERT INTO `event_track` VALUES (101, NULL, 'admin_login', '2020-11-12 17:15:25', 'version', 'server', '客户端登录', 0, '2020-11-12 17:15:24', '2020-11-12 17:15:24');
INSERT INTO `event_track` VALUES (102, NULL, 'admin_login', '2020-11-12 17:40:10', 'version', 'server', '客户端登录', 0, '2020-11-12 17:40:10', '2020-11-12 17:40:10');
INSERT INTO `event_track` VALUES (103, NULL, 'admin_login', '2020-11-12 17:57:04', 'version', 'server', '客户端登录', 0, '2020-11-12 17:57:03', '2020-11-12 17:57:03');
INSERT INTO `event_track` VALUES (104, NULL, 'admin_login', '2020-11-12 18:19:33', 'version', 'server', '客户端登录', 0, '2020-11-12 18:19:32', '2020-11-12 18:19:32');
INSERT INTO `event_track` VALUES (105, NULL, 'admin_login', '2020-11-12 18:46:53', 'version', 'server', '客户端登录', 0, '2020-11-12 18:46:53', '2020-11-12 18:46:53');
INSERT INTO `event_track` VALUES (106, NULL, 'admin_login', '2020-11-12 19:02:35', 'version', 'server', '客户端登录', 0, '2020-11-12 19:02:34', '2020-11-12 19:02:34');
INSERT INTO `event_track` VALUES (107, NULL, 'admin_login', '2020-11-12 19:04:48', 'version', 'server', '客户端登录', 0, '2020-11-12 19:04:48', '2020-11-12 19:04:48');
INSERT INTO `event_track` VALUES (108, NULL, 'admin_login', '2020-11-13 09:39:15', 'version', 'server', '客户端登录', 0, '2020-11-13 09:39:14', '2020-11-13 09:39:14');
INSERT INTO `event_track` VALUES (109, 'admin', 'admin_login_out', '2020-11-13 10:04:58', 'version', 'server', '客户端登出', 0, '2020-11-13 10:04:58', '2020-11-13 10:04:58');
INSERT INTO `event_track` VALUES (110, NULL, 'admin_login', '2020-11-13 10:05:00', 'version', 'server', '客户端登录', 0, '2020-11-13 10:04:59', '2020-11-13 10:04:59');
INSERT INTO `event_track` VALUES (111, 'admin', 'admin_login_out', '2020-11-13 10:05:56', 'version', 'server', '客户端登出', 0, '2020-11-13 10:05:56', '2020-11-13 10:05:56');
INSERT INTO `event_track` VALUES (112, NULL, 'admin_login', '2020-11-13 10:05:57', 'version', 'server', '客户端登录', 0, '2020-11-13 10:05:57', '2020-11-13 10:05:57');
INSERT INTO `event_track` VALUES (113, NULL, 'admin_login', '2020-11-13 11:57:14', 'version', 'server', '客户端登录', 0, '2020-11-13 11:57:13', '2020-11-13 11:57:13');
INSERT INTO `event_track` VALUES (114, NULL, 'admin_login', '2020-11-13 12:11:42', 'version', 'server', '客户端登录', 0, '2020-11-13 12:11:42', '2020-11-13 12:11:42');
INSERT INTO `event_track` VALUES (115, 'admin', 'admin_login_out', '2020-11-13 15:14:13', 'version', 'server', '客户端登出', 0, '2020-11-13 15:14:12', '2020-11-13 15:14:12');
INSERT INTO `event_track` VALUES (116, NULL, 'admin_login', '2020-11-13 15:14:16', 'version', 'server', '客户端登录', 0, '2020-11-13 15:14:15', '2020-11-13 15:14:15');
INSERT INTO `event_track` VALUES (117, NULL, 'admin_login', '2020-11-13 15:31:48', 'version', 'server', '客户端登录', 0, '2020-11-13 15:31:48', '2020-11-13 15:31:48');
INSERT INTO `event_track` VALUES (118, NULL, 'admin_login', '2020-11-13 15:39:48', 'version', 'server', '客户端登录', 0, '2020-11-13 15:39:47', '2020-11-13 15:39:47');
INSERT INTO `event_track` VALUES (119, NULL, 'admin_login', '2020-11-13 15:49:58', 'version', 'server', '客户端登录', 0, '2020-11-13 15:49:57', '2020-11-13 15:49:57');
INSERT INTO `event_track` VALUES (120, NULL, 'admin_login', '2020-11-13 15:53:34', 'version', 'server', '客户端登录', 0, '2020-11-13 15:53:33', '2020-11-13 15:53:33');
INSERT INTO `event_track` VALUES (121, 'admin', 'admin_update_goods_price', '2020-11-13 16:36:05', 'version', 'server', '更新商品价格', 0, '2020-11-13 16:36:04', '2020-11-13 16:36:04');
INSERT INTO `event_track` VALUES (122, NULL, 'admin_login', '2020-11-13 16:44:40', 'version', 'server', '客户端登录', 0, '2020-11-13 16:44:39', '2020-11-13 16:44:39');
INSERT INTO `event_track` VALUES (123, NULL, 'admin_login', '2020-11-13 16:45:21', 'version', 'server', '客户端登录', 0, '2020-11-13 16:45:21', '2020-11-13 16:45:21');
INSERT INTO `event_track` VALUES (124, NULL, 'admin_login', '2020-11-16 21:38:50', 'version', 'server', '客户端登录', 0, '2020-11-16 21:38:50', '2020-11-16 21:38:50');
INSERT INTO `event_track` VALUES (125, 'admin', 'admin_save_user', '2020-11-16 21:40:33', 'version', 'server', '新增用户', 0, '2020-11-16 21:40:33', '2020-11-16 21:40:33');
INSERT INTO `event_track` VALUES (126, 'admin', 'admin_save_role', '2020-11-16 21:41:11', 'version', 'server', '新增角色', 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `event_track` VALUES (127, 'admin', 'admin_update_user', '2020-11-16 21:41:19', 'version', 'server', '编辑用户', 0, '2020-11-16 21:41:18', '2020-11-16 21:41:18');
INSERT INTO `event_track` VALUES (128, 'admin', 'admin_login_out', '2020-11-16 21:42:45', 'version', 'server', '客户端登出', 0, '2020-11-16 21:42:44', '2020-11-16 21:42:44');
INSERT INTO `event_track` VALUES (129, NULL, 'admin_login', '2020-11-16 21:42:46', 'version', 'server', '客户端登录', 0, '2020-11-16 21:42:46', '2020-11-16 21:42:46');
INSERT INTO `event_track` VALUES (130, NULL, 'admin_login', '2020-11-28 13:40:40', 'version', 'server', '客户端登录', 0, '2020-11-28 13:40:39', '2020-11-28 13:40:39');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goods_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `big_imgs` json NULL COMMENT '大图集合',
  `goods_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `goods_brand_logo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌logo',
  `goods_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情',
  `goods_video` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品视频',
  `goods_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品说明',
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '牙刷', '[\"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg\"]', '田七', NULL, 'https://www.baidu.com', NULL, '牙刷-11.11全球爱刷牙', '[1]', '[\"热卖\", \"人气\"]', 0, 15, 10, '支', 0, 0, '2020-11-11 15:23:25', '2020-11-12 16:03:12');
INSERT INTO `goods` VALUES (2, '自行车', '[\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg\", \"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2374204501,2228147283&fm=26&gp=0.jpg\", \"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1777373690,2829084043&fm=26&gp=0.jpg\", \"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=275317745,3102505007&fm=26&gp=0.jpg\"]', '凤凰', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1753053766,2083115541&fm=26&gp=0.jpg', 'https://www.baidu.com', 'http://v5-dy-h.ixigua.com/3ed445a5c956e266565827b6690f822a/5fad1298/video/tos/cn/tos-cn-ve-15/da833d8ecc4942dda8138cb4595d5395/?a=1128&br=2157&bt=719&cr=0&cs=0&dr=0&ds=3&er=&l=202011121746190101980670435A01ED6B&lr=aweme_search_suffix&mime_type=video_mp4&qs=0&rc=am5wbjdmZDpoeDMzNmkzM0ApODY4PGdpaDw8N2Y1NDY6aGdyZjM2aGhwNGhfLS1gLTBzcy5iXl8zMjIxXzZjMV4xMzA6Yw%3D%3D&vl=&vr=', '支架自行车-引领潮流，解锁时尚', '[2]', '[\"时尚\", \"热卖\", \"人气\"]', 0, 1599, 1299, '辆', 0, 0, '2020-11-11 15:43:11', '2020-11-13 15:51:47');
INSERT INTO `goods` VALUES (3, '自行车', '[\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg\"]', '阳光', NULL, 'https://www.baidu.com', NULL, '支架自行车-引领潮流，解锁时尚', '[2, 3]', '[\"活动\"]', 0, 699, 499, '辆', 1, 0, '2020-11-11 15:43:11', '2020-11-12 16:03:25');
INSERT INTO `goods` VALUES (4, '自行车', '[\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg\"]', '迪卡侬', NULL, 'https://www.baidu.com', NULL, '支架自行车-引领潮流，解锁时尚', '[2]', '[\"优惠\"]', 0, 589, 499, '辆', 1, 0, '2020-11-11 15:43:11', '2020-11-12 16:03:31');
INSERT INTO `goods` VALUES (5, '自行车', '[\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg\"]', '天狼', NULL, 'https://www.baidu.com', NULL, '支架自行车-引领潮流，解锁时尚', '[2, 3]', '[\"性价比\"]', 0, 499, 399, '辆', 0, 0, '2020-11-11 15:43:11', '2020-11-12 16:03:40');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_classify
-- ----------------------------
INSERT INTO `goods_classify` VALUES (1, '生活用品', 0, NULL, NULL, 0, '2020-11-11 15:22:04', '2020-11-11 15:22:04');
INSERT INTO `goods_classify` VALUES (2, '交通工具', 0, NULL, NULL, 0, '2020-11-11 15:42:29', '2020-11-11 15:42:29');
INSERT INTO `goods_classify` VALUES (3, '自行车', 2, NULL, NULL, 0, '2020-11-12 11:50:11', '2020-11-12 11:50:11');
INSERT INTO `goods_classify` VALUES (4, '摩托车', 2, '', '', 0, '2020-11-12 12:01:02', '2020-11-12 12:01:02');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性键表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_property_key
-- ----------------------------
INSERT INTO `goods_property_key` VALUES (1, 1, 'type', '类型', 0, 0, '2020-11-11 15:24:23', '2020-11-13 09:51:11');
INSERT INTO `goods_property_key` VALUES (2, 1, 'color', '颜色', 0, 0, '2020-11-11 15:24:38', '2020-11-13 09:51:16');
INSERT INTO `goods_property_key` VALUES (3, 2, 'color', '颜色', 0, 0, '2020-11-11 15:43:38', '2020-11-13 09:51:19');
INSERT INTO `goods_property_key` VALUES (4, 2, 'speed', '变速类型', 0, 0, '2020-11-13 14:09:04', '2020-11-13 14:09:04');

-- ----------------------------
-- Table structure for goods_property_value
-- ----------------------------
DROP TABLE IF EXISTS `goods_property_value`;
CREATE TABLE `goods_property_value`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goods_property_key_unique_id` bigint(0) NOT NULL COMMENT '商品属性编号',
  `property_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品属性值',
  `value_cost` double NOT NULL DEFAULT 0 COMMENT '价格涨幅（单位：元）',
  `value_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一标识',
  `property_value_sort` int(0) NOT NULL DEFAULT 0 COMMENT '属性值排序',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_goods_property_key_unique_id`(`goods_property_key_unique_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_property_value
-- ----------------------------
INSERT INTO `goods_property_value` VALUES (1, 1, '软毛', 2, 'd2df847d-c92f-4137-8a61-9b92bcab2e00', 0, 0, '2020-11-11 15:25:00', '2020-11-11 15:31:45');
INSERT INTO `goods_property_value` VALUES (2, 1, '硬毛', 0, 'd972b4a4-6ef2-487e-baba-40d3c8cff793', 0, 0, '2020-11-11 15:26:15', '2020-11-11 15:31:48');
INSERT INTO `goods_property_value` VALUES (3, 2, '黄', 0, '0af6cb53-ed69-4a2d-bd9c-a804b0335690', 0, 0, '2020-11-11 15:26:39', '2020-11-11 15:31:52');
INSERT INTO `goods_property_value` VALUES (4, 2, '红', 0, '2f9f528b-253b-4f54-8f72-4170d0772118', 0, 0, '2020-11-11 15:26:57', '2020-11-11 15:31:57');
INSERT INTO `goods_property_value` VALUES (5, 2, '花纹', 0, '70587a02-67be-4625-be60-9855e51be99e', 0, 0, '2020-11-11 15:27:21', '2020-11-11 15:31:57');
INSERT INTO `goods_property_value` VALUES (6, 2, '绿', 0, 'bb8300f9-a894-4876-bf7d-a398685b94d8', 0, 0, '2020-11-11 15:27:30', '2020-11-11 15:32:03');
INSERT INTO `goods_property_value` VALUES (7, 3, '豹纹', 0, 'd751359f-bd3f-4bd0-80e7-39b8273e897b', 0, 0, '2020-11-11 15:44:18', '2020-11-11 15:44:18');
INSERT INTO `goods_property_value` VALUES (8, 3, '黑骑士', 0, '4dd0ced4-60d1-48a1-8997-2a51f2864d5d', 0, 0, '2020-11-11 15:44:40', '2020-11-11 15:44:40');
INSERT INTO `goods_property_value` VALUES (9, 4, '24变速', 0, '4dd0ced4-60d1-48a1-8997-2a51f2864d5s', 0, 0, '2020-11-13 14:09:34', '2020-11-13 14:09:46');
INSERT INTO `goods_property_value` VALUES (10, 4, '18变速', 0, '4dd0ced4-60d1-48a1-8997-2a51f2864d5w', 0, 0, '2020-11-13 14:10:03', '2020-11-13 14:10:08');

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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------
INSERT INTO `goods_sku` VALUES (1, 1, 20, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d2df847d-c92f-4137-8a61-9b92bcab2e00\", \"color\": \"0af6cb53-ed69-4a2d-bd9c-a804b0335690\"}', 12, 0, '2020-11-11 15:36:05', '2020-11-11 15:36:05');
INSERT INTO `goods_sku` VALUES (2, 1, 10, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d2df847d-c92f-4137-8a61-9b92bcab2e00\", \"color\": \"2f9f528b-253b-4f54-8f72-4170d0772118\"}', 12, 0, '2020-11-11 15:36:05', '2020-11-11 15:37:59');
INSERT INTO `goods_sku` VALUES (3, 1, 6, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d2df847d-c92f-4137-8a61-9b92bcab2e00\", \"color\": \"70587a02-67be-4625-be60-9855e51be99e\"}', 12, 0, '2020-11-11 15:36:05', '2020-11-11 15:38:07');
INSERT INTO `goods_sku` VALUES (4, 1, 4, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d2df847d-c92f-4137-8a61-9b92bcab2e00\", \"color\": \"bb8300f9-a894-4876-bf7d-a398685b94d8\"}', 12, 0, '2020-11-11 15:36:05', '2020-11-11 15:38:14');
INSERT INTO `goods_sku` VALUES (5, 1, 7, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d972b4a4-6ef2-487e-baba-40d3c8cff793\", \"color\": \"0af6cb53-ed69-4a2d-bd9c-a804b0335690\"}', 10, 0, '2020-11-11 15:36:05', '2020-11-11 15:39:49');
INSERT INTO `goods_sku` VALUES (6, 1, 60, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d972b4a4-6ef2-487e-baba-40d3c8cff793\", \"color\": \"2f9f528b-253b-4f54-8f72-4170d0772118\"}', 10, 0, '2020-11-11 15:36:05', '2020-11-11 15:39:54');
INSERT INTO `goods_sku` VALUES (7, 1, 18, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d972b4a4-6ef2-487e-baba-40d3c8cff793\", \"color\": \"70587a02-67be-4625-be60-9855e51be99e\"}', 10, 0, '2020-11-11 15:36:05', '2020-11-11 15:39:54');
INSERT INTO `goods_sku` VALUES (8, 1, 3, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1616821659,1565568552&fm=26&gp=0.jpg', '{\"type\": \"d972b4a4-6ef2-487e-baba-40d3c8cff793\", \"color\": \"bb8300f9-a894-4876-bf7d-a398685b94d8\"}', 10, 0, '2020-11-11 15:36:05', '2020-11-11 15:39:54');
INSERT INTO `goods_sku` VALUES (9, 2, 2312, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg', '{\"color\": \"d751359f-bd3f-4bd0-80e7-39b8273e897b\", \"speed\": \"4dd0ced4-60d1-48a1-8997-2a51f2864d5s\"}', 1299, 0, '2020-11-11 15:45:35', '2020-11-13 15:18:53');
INSERT INTO `goods_sku` VALUES (10, 2, 1766, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg', '{\"color\": \"4dd0ced4-60d1-48a1-8997-2a51f2864d5d\", \"speed\": \"4dd0ced4-60d1-48a1-8997-2a51f2864d5w\"}', 1299, 0, '2020-11-11 15:46:17', '2020-11-13 15:20:04');
INSERT INTO `goods_sku` VALUES (11, 2, 46, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg', '{\"color\": \"4dd0ced4-60d1-48a1-8997-2a51f2864d5d\", \"speed\": \"4dd0ced4-60d1-48a1-8997-2a51f2864d5s\"}', 1299, 0, '2020-11-13 15:18:00', '2020-11-13 15:20:19');
INSERT INTO `goods_sku` VALUES (12, 2, 96, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3245035836,3374189235&fm=26&gp=0.jpg', '{\"color\": \"d751359f-bd3f-4bd0-80e7-39b8273e897b\", \"speed\": \"4dd0ced4-60d1-48a1-8997-2a51f2864d5w\"}', 1299, 0, '2020-11-13 15:18:16', '2020-11-13 15:20:35');

-- ----------------------------
-- Table structure for kv_store
-- ----------------------------
DROP TABLE IF EXISTS `kv_store`;
CREATE TABLE `kv_store`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `key_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一键',
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名一',
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名二',
  `store_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `key_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key说明',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  UNIQUE INDEX `idx_key`(`key_flag`) USING BTREE,
  INDEX `idx_first_name`(`first_name`) USING BTREE,
  INDEX `idx_last_name`(`last_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kv_store
-- ----------------------------
INSERT INTO `kv_store` VALUES (1, '1231', '1231', '三大', '12312', '1231', 1, '2020-11-11 11:33:18', '2020-11-11 11:40:50');
INSERT INTO `kv_store` VALUES (2, 'asda', 'dasd', 'asda', 'asda', 'asda', 1, '2020-11-11 11:34:41', '2020-11-11 15:03:57');
INSERT INTO `kv_store` VALUES (3, 'da', 'asda', '', 'ada', NULL, 1, '2020-11-11 14:46:20', '2020-11-11 15:03:57');

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
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '系统盘点', NULL, 1, 0, 'fa fa-ioxhost', 0, '2020-11-05 15:29:15', '2020-11-10 10:26:55');
INSERT INTO `menu` VALUES (2, 1, '用户管理', '/user.html', 2, 0, 'fa fa-user-circle', 0, '2020-11-05 15:29:48', '2020-11-10 10:27:37');
INSERT INTO `menu` VALUES (3, 2, '用户列表', '/user/list', 3, 0, NULL, 0, '2020-11-05 15:30:14', '2020-11-05 15:30:14');
INSERT INTO `menu` VALUES (4, 2, '新增用户', '/user/save', 3, 0, NULL, 0, '2020-11-05 15:30:32', '2020-11-05 15:30:35');
INSERT INTO `menu` VALUES (5, 2, '用户注销', '/user/loginOut', 3, 0, NULL, 0, '2020-11-05 15:31:21', '2020-11-05 15:31:21');
INSERT INTO `menu` VALUES (6, 2, '用户删除', '/user/delete', 3, 0, NULL, 0, '2020-11-05 15:31:43', '2020-11-05 15:31:43');
INSERT INTO `menu` VALUES (7, 2, '用户编辑', '/user/update', 3, 0, NULL, 0, '2020-11-05 15:32:01', '2020-11-05 15:32:01');
INSERT INTO `menu` VALUES (8, 2, '更新密码', '/user/password/update', 3, 0, NULL, 0, '2020-11-05 15:32:21', '2020-11-05 15:32:21');
INSERT INTO `menu` VALUES (9, 1, '角色管理', '/role.html', 2, 0, 'fa fa-users', 0, '2020-11-05 16:03:22', '2020-11-10 10:28:11');
INSERT INTO `menu` VALUES (10, 9, '角色列表', '/role/list', 3, 0, NULL, 0, '2020-11-05 16:03:53', '2020-11-05 16:04:06');
INSERT INTO `menu` VALUES (11, 9, '删除角色', '/role/delete', 3, 0, NULL, 0, '2020-11-05 16:04:38', '2020-11-05 16:04:38');
INSERT INTO `menu` VALUES (12, 9, '添加角色', '/role/save', 3, 0, NULL, 0, '2020-11-05 16:05:01', '2020-11-05 16:05:01');
INSERT INTO `menu` VALUES (13, 9, '编辑角色', '/role/update', 3, 0, NULL, 0, '2020-11-05 16:05:17', '2020-11-05 16:05:17');
INSERT INTO `menu` VALUES (14, 1, '菜单管理', '/menu.html', 2, 0, 'fa fa-bars', 0, '2020-11-05 16:05:39', '2020-11-10 10:29:04');
INSERT INTO `menu` VALUES (15, 14, '菜单列表', '/menu/list', 3, 0, NULL, 0, '2020-11-05 16:06:17', '2020-11-05 16:06:17');
INSERT INTO `menu` VALUES (16, 14, '用户菜单', '/menu/listByUser', 3, 0, NULL, 0, '2020-11-05 16:06:36', '2020-11-11 10:35:16');
INSERT INTO `menu` VALUES (17, 14, '添加菜单', '/menu/save', 3, 0, NULL, 0, '2020-11-05 16:07:05', '2020-11-05 16:07:05');
INSERT INTO `menu` VALUES (18, 14, '编辑菜单', '/menu/update', 3, 0, NULL, 0, '2020-11-05 16:07:22', '2020-11-05 16:07:22');
INSERT INTO `menu` VALUES (19, 1, '字典配置', '/config.html', 2, 0, 'fa fa-cog', 0, '2020-11-06 09:04:51', '2020-11-10 10:24:40');
INSERT INTO `menu` VALUES (20, 19, '字典列表', '/kv/store/list', 3, 0, NULL, 0, '2020-11-06 09:06:03', '2020-11-06 09:06:03');
INSERT INTO `menu` VALUES (21, 19, '字典新增', '/kv/store/save', 3, 0, NULL, 0, '2020-11-06 09:06:25', '2020-11-06 09:06:25');
INSERT INTO `menu` VALUES (22, 19, '字典更新', '/kv/store/update', 3, 0, NULL, 0, '2020-11-06 09:08:41', '2020-11-06 09:08:41');
INSERT INTO `menu` VALUES (23, 19, '字典删除', '/kv/store/delete', 3, 0, NULL, 0, '2020-11-06 09:12:27', '2020-11-06 09:12:27');
INSERT INTO `menu` VALUES (24, 1, '事件埋点', '/event.html', 2, 0, 'fa fa-thumb-tack', 0, '2020-11-06 09:14:45', '2020-11-12 10:41:00');
INSERT INTO `menu` VALUES (25, 24, '事件列表', '/event/track/list', 3, 0, NULL, 0, '2020-11-06 09:20:39', '2020-11-12 10:41:05');
INSERT INTO `menu` VALUES (26, 24, '添加事件', '/event/track/save', 3, 0, NULL, 0, '2020-11-06 09:21:26', '2020-11-12 10:41:10');
INSERT INTO `menu` VALUES (27, 0, '商城运营', NULL, 1, 0, 'fa fa-shopping-cart', 0, '2020-11-06 09:22:07', '2020-11-10 10:30:59');
INSERT INTO `menu` VALUES (28, 27, '商品分类', '/type.html', 2, 0, 'fa fa-glass', 0, '2020-11-06 09:22:46', '2020-11-10 10:31:25');
INSERT INTO `menu` VALUES (29, 28, '分类列表', '/goods/type/list', 3, 0, NULL, 0, '2020-11-06 09:23:39', '2020-11-06 09:23:39');
INSERT INTO `menu` VALUES (30, 28, '添加分类', '/goods/type/save', 3, 0, NULL, 0, '2020-11-06 09:23:59', '2020-11-06 09:23:59');
INSERT INTO `menu` VALUES (31, 27, '商品管理', '/goods.html', 2, 0, 'fa fa-gift', 0, '2020-11-06 09:26:20', '2020-11-10 10:34:17');
INSERT INTO `menu` VALUES (32, 31, '添加商品', '/goods/save', 3, 0, NULL, 0, '2020-11-06 09:26:39', '2020-11-06 09:26:39');
INSERT INTO `menu` VALUES (33, 31, '更新商品状态', '/goods/updateStatus', 3, 0, NULL, 0, '2020-11-06 09:27:15', '2020-11-12 15:34:52');
INSERT INTO `menu` VALUES (34, 27, '订单浏览', '/order.html', 2, 0, 'fa fa-paypal', 0, '2020-11-06 09:28:08', '2020-11-10 10:35:57');
INSERT INTO `menu` VALUES (35, 34, '订单列表', '/order/list', 3, 0, NULL, 0, '2020-11-06 09:28:26', '2020-11-06 09:28:26');
INSERT INTO `menu` VALUES (36, 34, '订单详情', '/order/getById', 3, 0, NULL, 0, '2020-11-06 09:29:00', '2020-11-06 09:29:00');
INSERT INTO `menu` VALUES (37, 27, '账台流水', '/account.html', 2, 0, 'fa fa-money', 0, '2020-11-06 09:29:51', '2020-11-10 10:37:22');
INSERT INTO `menu` VALUES (38, 0, '客服售后', NULL, 1, 0, 'fa fa-envira', 0, '2020-11-06 09:30:28', '2020-11-10 11:11:56');
INSERT INTO `menu` VALUES (39, 38, '智能客服', '/s.html', 2, 0, NULL, 0, '2020-11-06 09:30:57', '2020-11-06 09:31:14');
INSERT INTO `menu` VALUES (40, 38, '售后服务', '/s.html', 2, 0, NULL, 0, '2020-11-06 09:31:10', '2020-11-06 09:31:19');
INSERT INTO `menu` VALUES (41, 14, '全部菜单', '/menu/listAll', 3, 0, NULL, 0, '2020-11-06 14:54:15', '2020-11-06 14:54:15');
INSERT INTO `menu` VALUES (42, 14, '菜单详情', '/menu/detail', 3, 0, NULL, 0, '2020-11-06 15:42:54', '2020-11-06 15:42:54');
INSERT INTO `menu` VALUES (43, 27, '胜多负少', '/s.html', 2, 0, NULL, 1, '2020-11-09 16:25:08', '2020-11-10 10:38:15');
INSERT INTO `menu` VALUES (44, 14, '删除菜单', '/menu/delete', 3, 0, NULL, 1, '2020-11-10 09:51:51', '2020-11-10 09:55:20');
INSERT INTO `menu` VALUES (45, 9, '角色详情', '/role/detail', 3, 0, NULL, 0, '2020-11-10 11:10:36', '2020-11-10 11:10:36');
INSERT INTO `menu` VALUES (46, 9, '全部角色', '/role/listAll', 3, 0, NULL, 0, '2020-11-11 09:15:02', '2020-11-11 09:15:23');
INSERT INTO `menu` VALUES (47, 2, '用户详情', '/user/detail', 3, 0, NULL, 0, '2020-11-11 10:54:56', '2020-11-11 10:55:08');
INSERT INTO `menu` VALUES (48, 19, '字典详情', '/kv/store/detail', 3, 0, NULL, 0, '2020-11-11 11:40:26', '2020-11-11 11:40:26');
INSERT INTO `menu` VALUES (49, 28, '全部分类', '/goods/type/listAll', 3, 0, NULL, 0, '2020-11-12 11:32:03', '2020-11-12 11:32:03');
INSERT INTO `menu` VALUES (50, 28, '编辑分类', '/goods/type/update', 3, 0, NULL, 0, '2020-11-12 11:32:26', '2020-11-12 11:32:26');
INSERT INTO `menu` VALUES (51, 28, '分类详情', '/goods/type/detail', 3, 0, NULL, 0, '2020-11-12 11:32:43', '2020-11-12 11:32:43');
INSERT INTO `menu` VALUES (52, 31, '商品列表', '/goods/list', 3, 0, NULL, 0, '2020-11-12 15:34:10', '2020-11-12 15:34:10');
INSERT INTO `menu` VALUES (53, 31, '商品详情', '/goods/detail', 3, 0, NULL, 0, '2020-11-12 15:34:29', '2020-11-12 15:34:29');
INSERT INTO `menu` VALUES (54, 31, '更新商品库存', '/goods/updateSku', 3, 0, NULL, 0, '2020-11-12 15:35:16', '2020-11-12 15:35:16');
INSERT INTO `menu` VALUES (55, 31, '更新商品价格', '/goods/updatePrice', 3, 0, NULL, 0, '2020-11-12 15:36:11', '2020-11-12 15:36:11');
INSERT INTO `menu` VALUES (56, 31, '商品属性', '/goods/property/listByGoodsId', 3, 0, NULL, 0, '2020-11-13 10:05:51', '2020-11-13 15:13:29');
INSERT INTO `menu` VALUES (57, 32, '商品库存', '/goods/sku/listByGoodsId', 3, 0, NULL, 0, '2020-11-13 15:13:43', '2020-11-13 15:13:52');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `menu_unique_id` bigint(0) NOT NULL COMMENT '菜单编号',
  `role_unique_id` bigint(0) NOT NULL COMMENT '角色编号',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_menu_unique_id`(`menu_unique_id`) USING BTREE,
  INDEX `idx_role_unique_id`(`role_unique_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 330 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (97, 1, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (98, 2, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (99, 3, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (100, 4, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (101, 5, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (102, 6, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (103, 7, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (104, 8, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (105, 9, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (106, 10, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (107, 11, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (108, 12, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (109, 13, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (110, 45, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (111, 14, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (112, 15, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (113, 16, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (114, 17, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (115, 18, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (116, 41, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (117, 42, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (118, 19, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (119, 20, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (120, 21, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (121, 22, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (122, 23, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (123, 24, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (124, 25, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (125, 26, 17, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (126, 27, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (127, 28, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (128, 29, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (129, 30, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (130, 31, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (131, 32, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (132, 33, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (133, 34, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (134, 35, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (135, 36, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (136, 37, 18, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `menu_role` VALUES (137, 1, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (138, 2, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (139, 3, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (140, 4, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (141, 5, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (142, 6, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (143, 7, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (144, 8, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (145, 9, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (146, 10, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (147, 11, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (148, 12, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (149, 13, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (150, 45, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (151, 14, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (152, 15, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (153, 16, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (154, 17, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (155, 18, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (156, 41, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (157, 42, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (158, 19, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (159, 20, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (160, 21, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (161, 22, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (162, 23, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (163, 24, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (164, 25, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (165, 26, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (166, 38, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (167, 39, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (168, 40, 19, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `menu_role` VALUES (169, 1, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (170, 2, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (171, 3, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (172, 4, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (173, 5, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (174, 6, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (175, 7, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (176, 8, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (177, 9, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (178, 10, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (179, 11, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (180, 12, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (181, 13, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (182, 45, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (183, 14, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (184, 15, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (185, 16, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (186, 17, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (187, 18, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (188, 41, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (189, 42, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (190, 19, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (191, 20, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (192, 21, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (193, 22, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (194, 23, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (195, 24, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (196, 25, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (197, 26, 20, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (198, 1, 21, 1, '2020-11-10 14:06:50', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (199, 19, 21, 1, '2020-11-10 14:06:50', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (200, 20, 21, 1, '2020-11-10 14:06:50', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (201, 1, 22, 1, '2020-11-10 14:09:51', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (202, 2, 22, 1, '2020-11-10 14:09:51', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (203, 4, 22, 1, '2020-11-10 14:09:51', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (204, 1, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (205, 2, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (206, 3, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (207, 4, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (208, 5, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (209, 6, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (210, 7, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (211, 8, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (212, 9, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (213, 10, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (214, 11, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (215, 12, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (216, 13, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (217, 45, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (218, 14, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (219, 15, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (220, 16, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (221, 17, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (222, 18, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (223, 41, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (224, 42, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (225, 19, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (226, 20, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (227, 21, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (228, 22, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (229, 23, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (230, 24, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (231, 25, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (232, 26, 23, 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (233, 1, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (234, 14, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (235, 15, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (236, 16, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (237, 17, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (238, 18, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (239, 41, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (240, 42, 24, 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (241, 1, 25, 1, '2020-11-10 16:07:50', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (242, 2, 25, 1, '2020-11-10 16:07:50', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (243, 5, 25, 1, '2020-11-10 16:07:50', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (244, 1, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (245, 2, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (246, 3, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (247, 4, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (248, 5, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (249, 6, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (250, 7, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (251, 8, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (252, 9, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (253, 10, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (254, 11, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (255, 12, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (256, 13, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (257, 45, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (258, 14, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (259, 15, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (260, 16, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (261, 17, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (262, 18, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (263, 41, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (264, 42, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (265, 19, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (266, 20, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (267, 21, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (268, 22, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (269, 23, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (270, 24, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (271, 25, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (272, 26, 26, 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (273, 1, 28, 1, '2020-11-10 16:08:13', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (274, 24, 28, 1, '2020-11-10 16:08:13', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (275, 25, 28, 1, '2020-11-10 16:08:13', '2020-11-11 15:10:05');
INSERT INTO `menu_role` VALUES (276, 1, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (277, 2, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (278, 3, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (279, 4, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (280, 5, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (281, 6, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (282, 7, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (283, 8, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (284, 47, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (285, 9, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (286, 10, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (287, 11, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (288, 12, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (289, 13, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (290, 45, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (291, 46, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (292, 14, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (293, 15, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (294, 16, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (295, 17, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (296, 18, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (297, 41, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (298, 42, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (299, 19, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (300, 20, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (301, 21, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (302, 22, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (303, 23, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (304, 48, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (305, 24, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (306, 25, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (307, 26, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (308, 27, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (309, 28, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (310, 29, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (311, 30, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (312, 49, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (313, 50, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (314, 51, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (315, 31, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (316, 32, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (317, 57, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (318, 33, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (319, 52, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (320, 53, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (321, 54, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (322, 55, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (323, 56, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (324, 34, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (325, 35, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (326, 36, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (327, 37, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (328, 38, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (329, 39, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');
INSERT INTO `menu_role` VALUES (330, 40, 29, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `order_number` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `thirdpart_order_number` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '三方订单号',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '订单状态（0：待支付；1：支付中；2：支付成功；3：支付失败）',
  `expire_state` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否超时（0：否；1：是）',
  `pay_user_unique_id` bigint(0) NOT NULL COMMENT '支付用户',
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
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (3, '2020111116112014766901', '9887965442132465', 2, 0, 1, 1409, 1409, 1, '支付成功', '2020-11-11 16:18:37', 1, NULL, 0, '2020-11-11 16:18:42', '2020-11-11 16:18:42');
INSERT INTO `order` VALUES (4, '2020111116112014766902', '9887965442132466', 2, 0, 3, 10, 10, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 16:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (5, '2020111116112014766903', '9887965442132467', 2, 0, 5, 24, 24, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (6, '2020111116112014766904', '9887965442132468', 2, 0, 2, 1399, 1399, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:24:26');
INSERT INTO `order` VALUES (7, '2020111116112014766905', '9887965442132470', 2, 0, 1, 20, 20, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (8, '2020111116112014766906', '9887965442132471', 2, 0, 4, 1399, 1399, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (10, '2020111116112014766912', '9887965442132472', 2, 0, 3, 12, 12, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:24:30');
INSERT INTO `order` VALUES (11, '2020111116112014766913', '9887965442132474', 2, 0, 1, 1411, 1411, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (12, '2020111116112014766914', '9887965442132475', 2, 0, 2, 10, 10, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (16, '2020111116112014766915', '9887965442132476', 2, 0, 4, 1399, 1399, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (17, '2020111116112014766916', '9887965442132477', 2, 0, 1, 1411, 1411, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (18, '2020111116112014766917', '9887965442132478', 2, 0, 3, 24, 24, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (19, '2020111116112014766918', '9887965442132479', 2, 0, 2, 12, 12, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:24:55');
INSERT INTO `order` VALUES (20, '2020111116112014766919', '9887965442132480', 2, 0, 3, 1421, 1421, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (21, '2020111116112014766920', '9887965442132481', 2, 0, 4, 22, 22, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (22, '2020111116112014766921', '9887965442132482', 2, 0, 2, 24, 24, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');
INSERT INTO `order` VALUES (23, '2020111116112014766922', '9887965442132483', 2, 0, 1, 20, 20, 1, '支付成功', '2020-11-10 16:18:37', 1, NULL, 0, '2020-11-10 13:18:42', '2020-11-11 16:27:20');

-- ----------------------------
-- Table structure for order_account
-- ----------------------------
DROP TABLE IF EXISTS `order_account`;
CREATE TABLE `order_account`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `order_unique_id` bigint(0) NOT NULL COMMENT '订单编号',
  `goods_unique_id` bigint(0) NOT NULL COMMENT '商品编号',
  `goods_sku_unique_id` bigint(0) NOT NULL COMMENT '库存编号',
  `single_price` double NOT NULL COMMENT '单个价格',
  `buy_number` int(0) NOT NULL DEFAULT 1 COMMENT '购买数量',
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
INSERT INTO `order_account` VALUES (1, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:37');
INSERT INTO `order_account` VALUES (2, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (3, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (4, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (5, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (6, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (7, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (8, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (9, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (10, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (11, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (12, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (13, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (14, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (15, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (16, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (17, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');
INSERT INTO `order_account` VALUES (18, 1, 1, 5, 10, 1, NULL, 0, '2020-11-11 16:32:24', '2020-11-11 16:51:41');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色备注',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (17, '子管理员', NULL, 1, '2020-11-10 11:32:03', '2020-11-11 15:10:13');
INSERT INTO `role` VALUES (18, '商城运营专员', NULL, 1, '2020-11-10 11:32:18', '2020-11-11 15:10:13');
INSERT INTO `role` VALUES (19, '子管理员', NULL, 1, '2020-11-10 11:32:38', '2020-11-10 11:34:23');
INSERT INTO `role` VALUES (20, '子管理员', NULL, 1, '2020-11-10 11:32:57', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (21, 'dsaasd', NULL, 1, '2020-11-10 14:06:50', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (22, '123131', NULL, 1, '2020-11-10 14:09:51', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (23, 'dasg', 'asd', 1, '2020-11-10 14:10:17', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (24, 'sfaasd', 'aas', 1, '2020-11-10 16:07:36', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (25, '121251', NULL, 1, '2020-11-10 16:07:50', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (26, 'hfghd', 'asd', 1, '2020-11-10 16:07:57', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (27, 'sdkjskj', 'asda', 1, '2020-11-10 16:08:04', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (28, 'sfkjasjkfkja', NULL, 1, '2020-11-10 16:08:13', '2020-11-11 15:10:05');
INSERT INTO `role` VALUES (29, '媳妇', NULL, 0, '2020-11-16 21:41:10', '2020-11-16 21:41:10');

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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES (1, 2, 17, 0, '2020-11-11 10:41:39', '2020-11-11 10:41:39');
INSERT INTO `role_user` VALUES (2, 2, 18, 0, '2020-11-11 10:41:39', '2020-11-11 10:41:39');
INSERT INTO `role_user` VALUES (3, 2, 25, 0, '2020-11-11 10:41:39', '2020-11-11 10:41:39');
INSERT INTO `role_user` VALUES (4, 3, 17, 0, '2020-11-11 10:47:32', '2020-11-11 10:47:32');
INSERT INTO `role_user` VALUES (5, 4, 17, 0, '2020-11-11 10:49:58', '2020-11-11 10:49:58');
INSERT INTO `role_user` VALUES (6, 5, 17, 1, '2020-11-11 10:51:18', '2020-11-11 10:56:47');
INSERT INTO `role_user` VALUES (7, 5, 18, 1, '2020-11-11 10:51:18', '2020-11-11 10:56:47');
INSERT INTO `role_user` VALUES (8, 5, 27, 1, '2020-11-11 10:51:18', '2020-11-11 10:56:47');
INSERT INTO `role_user` VALUES (9, 5, 17, 0, '2020-11-11 10:56:47', '2020-11-11 10:56:47');
INSERT INTO `role_user` VALUES (10, 5, 18, 0, '2020-11-11 10:56:47', '2020-11-11 10:56:47');
INSERT INTO `role_user` VALUES (11, 5, 27, 0, '2020-11-11 10:56:47', '2020-11-11 10:56:47');
INSERT INTO `role_user` VALUES (12, 7, 29, 0, '2020-11-16 21:41:18', '2020-11-16 21:41:18');

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_admin
-- ----------------------------
INSERT INTO `user_admin` VALUES (1, 'admin', 'I5lHoF', 'efa5a38c5445a192ac15a2d560c6f7e9', NULL, 0, '系统管理员', 0, '2020-11-05 15:23:55', '2020-11-06 10:51:49');
INSERT INTO `user_admin` VALUES (2, '哥哥', 'BHbDLf', 'd08ca4eaa7661346e36cac7676fa8c02', NULL, 0, '123', 1, '2020-11-11 10:41:39', '2020-11-11 10:47:25');
INSERT INTO `user_admin` VALUES (3, 'gege', '7C1Cpb', '269ca8287fe8d799cb275ac734f420c2', NULL, 0, 'sdada', 1, '2020-11-11 10:47:32', '2020-11-11 15:09:00');
INSERT INTO `user_admin` VALUES (4, '1231', 'iqjvkE', '55c27e139fcb0a6a2b8be65e444e3327', NULL, 0, '123131', 1, '2020-11-11 10:49:58', '2020-11-11 10:57:03');
INSERT INTO `user_admin` VALUES (5, 'zaza', 'sTSaHu', '852f958aecae92853195842d8fdc5c95', NULL, 0, '123131', 1, '2020-11-11 10:51:18', '2020-11-11 15:09:00');
INSERT INTO `user_admin` VALUES (6, '', 'zjtsEI', '5072599073a30f077a9fe54a8313c5bd', NULL, 0, '', 1, '2020-11-11 11:16:49', '2020-11-11 14:19:31');
INSERT INTO `user_admin` VALUES (7, 'zyx', 'xhhk13', '5f2ef5cf811edfeaf6db734d85f2e22d', NULL, 0, '赵云霞', 0, '2020-11-16 21:40:33', '2020-11-16 21:40:33');

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
  `default_state` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否默认（0：否；1：是）',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_user_unique_id`(`user_unique_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配送地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_allocation_address
-- ----------------------------
INSERT INTO `user_allocation_address` VALUES (1, 1, '陕西省', '西安市', '临潼区', '步行街', '尼伯森洗车', '家', 0, 0, '2020-11-11 15:55:03', '2020-11-11 15:55:03');
INSERT INTO `user_allocation_address` VALUES (2, 1, '陕西省', '西安市', '雁塔区', '天谷七路环普产业园', '中软国际F2', '公司', 0, 0, '2020-11-11 15:56:07', '2020-11-11 15:59:12');
INSERT INTO `user_allocation_address` VALUES (3, 2, '陕西省', '西安市', '雁塔区', '科技二路', '甘家寨东二排', '公司', 0, 0, '2020-11-11 15:56:07', '2020-11-11 15:57:35');
INSERT INTO `user_allocation_address` VALUES (4, 3, '陕西省', '西安市', '雁塔区', '科技二路', '西部电子社区C', '公司', 0, 0, '2020-11-11 15:56:07', '2020-11-11 15:58:14');
INSERT INTO `user_allocation_address` VALUES (5, 4, '陕西省', '西安市', '雁塔区', '高新三路', '财富中心II期', '公司', 0, 0, '2020-11-11 15:56:07', '2020-11-11 15:58:43');
INSERT INTO `user_allocation_address` VALUES (6, 5, '陕西省', '西安市', '雁塔区', '高新六路', 'CROSS万象汇', '公司', 0, 0, '2020-11-11 15:56:07', '2020-11-11 15:59:37');

-- ----------------------------
-- Table structure for user_app
-- ----------------------------
DROP TABLE IF EXISTS `user_app`;
CREATE TABLE `user_app`  (
  `unique_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `header_img` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `sex` tinyint(0) NOT NULL COMMENT '性别（0：未知；1：男；2：女；）',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0：否；1：删除）',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`unique_id`) USING BTREE,
  INDEX `idx_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '应用用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_app
-- ----------------------------
INSERT INTO `user_app` VALUES (1, 'xkq17226', 'https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2974706256,1511610652&os=3158141674,97834865&simid=3441618805,391280528&pn=0&rn=1&di=185270&ln=30&fr=&fmq=1605080950762_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fup.enterdesk.com%2Fedpic_360_360%2F9a%2F39%2F8f%2F9a398f0ce506201f96ffe8c7b2949c4d.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined', 1, '13111111521', 'nisame', 0, '2020-11-11 15:49:58', '2020-11-11 15:49:58');
INSERT INTO `user_app` VALUES (2, 'zhaoyunxia', 'https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3547703274,3363083080&os=657727714,31897326&simid=4178600257,722350401&pn=1&rn=1&di=67680&ln=30&fr=&fmq=1605080950762_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fup.enterdesk.com%2Fedpic_360_360%2Fc7%2Ff6%2F10%2Fc7f610fe65c416a95d05f3f032aca224.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined', 2, '13111111522', '吃胖胖', 0, '2020-11-11 15:50:26', '2020-11-11 15:52:43');
INSERT INTO `user_app` VALUES (3, 'zhangsan', 'https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3947572783,1476163811&os=1369258967,3848188977&simid=3332769608,385249505&pn=3&rn=1&di=222200&ln=30&fr=&fmq=1605080950762_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201408%2F24%2F20140824154253_45Hay.png&rpstart=0&rpnum=0&adpicid=0&force=undefined', 0, '13111111523', '张三', 0, '2020-11-11 15:50:46', '2020-11-11 15:51:09');
INSERT INTO `user_app` VALUES (4, 'lisi', 'https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3896346676,3386489148&os=3791370142,1635916657&simid=4072413604,751395926&pn=5&rn=1&di=193490&ln=30&fr=&fmq=1605080950762_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fgaitaobao3.alicdn.com%2Ftfscom%2F34920879%2FTB1473379F040DDAD55_%2521%25210-item_pic%2FTB2sEwnh3LD8KJjSszeXXaGRpXa_%2521%25212669301247.jpg_300x300q90.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined', 2, '13892823217', '李四', 0, '2020-11-11 15:51:25', '2020-11-11 15:51:43');
INSERT INTO `user_app` VALUES (5, 'wangwu', 'https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1709216491,2536617744&os=1649831437,417542372&simid=93636522,745961300&pn=6&rn=1&di=224070&ln=30&fr=&fmq=1605080950762_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201408%2F30%2F20140830180834_XuWYJ.png&rpstart=0&rpnum=0&adpicid=0&force=undefined', 1, '13721235718', '王五', 0, '2020-11-11 15:53:15', '2020-11-11 15:53:15');

SET FOREIGN_KEY_CHECKS = 1;
