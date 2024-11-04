/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : shopping

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 04/11/2024 13:57:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer`  (
  `b_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`b_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 500000002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES (500000001, '白给小子', 'zhijiebaigei@153.com', '猪王峡谷', '1111', '枫原万叶1.jpg');
INSERT INTO `buyer` VALUES (500000002, '芭芭拉', '1973676899@qq.com', '达州', '15985484', '芭芭拉1.jpg');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `g_id` int(0) NULL DEFAULT NULL,
  `b_id` int(0) NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  `status` int(0) NOT NULL,
  INDEX `FK_shopping_DE_REFERENCE_goods`(`g_id`) USING BTREE,
  INDEX `FK_shopping_DE_REFERENCE_ORDER`(`b_id`) USING BTREE,
  CONSTRAINT `FK_shopping_DE_REFERENCE_goods` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_shopping_DE_REFERENCE_ORDER` FOREIGN KEY (`b_id`) REFERENCES `buyer` (`b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `c_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (10001, '手机');
INSERT INTO `category` VALUES (10002, '电脑');
INSERT INTO `category` VALUES (10003, '游戏机');
INSERT INTO `category` VALUES (10004, '服务器');
INSERT INTO `category` VALUES (10005, '耳机');

-- ----------------------------
-- Table structure for category_tag
-- ----------------------------
DROP TABLE IF EXISTS `category_tag`;
CREATE TABLE `category_tag`  (
  `t_id` int(0) NULL DEFAULT NULL,
  `c_id` int(0) NULL DEFAULT NULL,
  INDEX `FK_CT_REFERENCE_TAG`(`t_id`) USING BTREE,
  INDEX `FK_CT_REFERENCE_CATEGORY`(`c_id`) USING BTREE,
  CONSTRAINT `FK_CT_REFERENCE_CATEGORY` FOREIGN KEY (`c_id`) REFERENCES `category` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_CT_REFERENCE_TAG` FOREIGN KEY (`t_id`) REFERENCES `tag` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_tag
-- ----------------------------
INSERT INTO `category_tag` VALUES (10001, 10001);
INSERT INTO `category_tag` VALUES (10001, 10002);
INSERT INTO `category_tag` VALUES (10001, 10003);
INSERT INTO `category_tag` VALUES (10001, 10004);
INSERT INTO `category_tag` VALUES (10001, 10005);
INSERT INTO `category_tag` VALUES (10002, 10001);
INSERT INTO `category_tag` VALUES (10002, 10002);
INSERT INTO `category_tag` VALUES (10002, 10003);
INSERT INTO `category_tag` VALUES (10002, 10004);
INSERT INTO `category_tag` VALUES (10002, 10005);
INSERT INTO `category_tag` VALUES (10003, 10005);
INSERT INTO `category_tag` VALUES (10003, 10002);
INSERT INTO `category_tag` VALUES (10003, 10003);
INSERT INTO `category_tag` VALUES (10003, 10004);
INSERT INTO `category_tag` VALUES (10003, 10001);
INSERT INTO `category_tag` VALUES (10004, 10002);
INSERT INTO `category_tag` VALUES (10004, 10003);
INSERT INTO `category_tag` VALUES (10004, 10004);
INSERT INTO `category_tag` VALUES (10004, 10005);
INSERT INTO `category_tag` VALUES (10004, 10001);
INSERT INTO `category_tag` VALUES (10005, 10002);
INSERT INTO `category_tag` VALUES (10005, 10003);
INSERT INTO `category_tag` VALUES (10005, 10004);
INSERT INTO `category_tag` VALUES (10005, 10005);
INSERT INTO `category_tag` VALUES (10005, 10001);
INSERT INTO `category_tag` VALUES (10006, 10005);
INSERT INTO `category_tag` VALUES (10006, 10002);
INSERT INTO `category_tag` VALUES (10006, 10003);
INSERT INTO `category_tag` VALUES (10006, 10004);
INSERT INTO `category_tag` VALUES (10006, 10001);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `g_id` int(0) NOT NULL AUTO_INCREMENT,
  `c_id` int(0) NULL DEFAULT NULL,
  `m_id` int(0) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `photo` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `describe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `status` int(0) NOT NULL,
  PRIMARY KEY (`g_id`) USING BTREE,
  INDEX `FK_GOODS_REFERENCE_CATEGORY`(`c_id`) USING BTREE,
  INDEX `FK_GOODS_REFERENCE_MERCHANT`(`m_id`) USING BTREE,
  CONSTRAINT `FK_GOODS_REFERENCE_CATEGORY` FOREIGN KEY (`c_id`) REFERENCES `category` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_GOODS_REFERENCE_MERCHANT` FOREIGN KEY (`m_id`) REFERENCES `merchant` (`m_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1000000004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1000000001, 10001, 100000001, '123123213', '雷系白色手机.jpg#水系黑色手机.jpg#水系白色手机.jpg##', 10000, 1000000, '4324234', 1);
INSERT INTO `goods` VALUES (1000000002, 10003, 100000001, '11111', '枫原万叶1.jpg#雷系白色手机.jpg#水系白色手机.jpg#水系黑色手机.jpg#', 2, 1, '2', 1);
INSERT INTO `goods` VALUES (1000000003, 10003, 100000001, '11111', '雷系白色手机.jpg#水系白色手机.jpg#水系黑色手机.jpg#钟离牌黑色电脑.jpg#', 111, 1, '32132', 1);
INSERT INTO `goods` VALUES (1000000004, 10001, 100000001, '三星C4', '枫原万叶1.jpg', 1000, 1000, '沙漠灰必备', 1);

-- ----------------------------
-- Table structure for goods_tag
-- ----------------------------
DROP TABLE IF EXISTS `goods_tag`;
CREATE TABLE `goods_tag`  (
  `t_id` int(0) NULL DEFAULT NULL,
  `g_id` int(0) NULL DEFAULT NULL,
  INDEX `FK_GOODS_TA_REFERENCE_TAG`(`t_id`) USING BTREE,
  INDEX `FK_GOODS_TA_REFERENCE_GOODS`(`g_id`) USING BTREE,
  CONSTRAINT `FK_GOODS_TA_REFERENCE_GOODS` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_GOODS_TA_REFERENCE_TAG` FOREIGN KEY (`t_id`) REFERENCES `tag` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_tag
-- ----------------------------
INSERT INTO `goods_tag` VALUES (10001, 1000000001);
INSERT INTO `goods_tag` VALUES (10002, 1000000001);
INSERT INTO `goods_tag` VALUES (10003, 1000000001);
INSERT INTO `goods_tag` VALUES (10001, 1000000002);
INSERT INTO `goods_tag` VALUES (10001, 1000000003);
INSERT INTO `goods_tag` VALUES (10002, 1000000003);
INSERT INTO `goods_tag` VALUES (10003, 1000000003);

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `g_id` int(0) NULL DEFAULT NULL,
  `b_id` int(0) NULL DEFAULT NULL,
  INDEX `FK_LIKE_REFERENCE_GOODS`(`g_id`) USING BTREE,
  INDEX `FK_LIKE_REFERENCE_BUYER`(`b_id`) USING BTREE,
  CONSTRAINT `FK_LIKE_REFERENCE_BUYER` FOREIGN KEY (`b_id`) REFERENCES `buyer` (`b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_LIKE_REFERENCE_GOODS` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `l_id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT NULL,
  `id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`l_id`) USING BTREE,
  UNIQUE INDEX `unique_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, '2', '2', 2, 100000001);
INSERT INTO `login` VALUES (2, '3', '3', 3, 0);
INSERT INTO `login` VALUES (3, '1', '1', 1, 500000001);
INSERT INTO `login` VALUES (4, '21', '21', 0, 100000002);
INSERT INTO `login` VALUES (5, '22', '22', 2, 100000003);
INSERT INTO `login` VALUES (6, '159', '1', 1, 500000002);

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `m_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100000003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES (100000001, '沙比三星', '101101101', '大寒冥国', '101@101.com', '阿贝多1.jpg', '这家店是真的垃圾（翻译官吐槽）');
INSERT INTO `merchant` VALUES (100000002, NULL, NULL, NULL, '1973676899@qq.com', NULL, NULL);
INSERT INTO `merchant` VALUES (100000003, '方盒子', '10086', '达州', '1973676899@qq.com', '可莉1.jpg', '《求生》官方');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `o_id` bigint(0) NOT NULL,
  `b_id` int(0) NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`o_id`) USING BTREE,
  INDEX `FK_ORDER_REFERENCE_buyer`(`b_id`) USING BTREE,
  CONSTRAINT `FK_ORDER_REFERENCE_buyer` FOREIGN KEY (`b_id`) REFERENCES `buyer` (`b_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (20240607184612123, 500000001, 10000, '2024-06-07 18:44:28', NULL, '阿杰·切', '1111', '奥林匹斯', 2);

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `g_id` int(0) NULL DEFAULT NULL,
  `o_id` bigint(0) NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  INDEX `FK_ORDER_DE_REFERENCE_GOODS`(`g_id`) USING BTREE,
  INDEX `FK_ORDER_DE_REFERENCE_ORDER`(`o_id`) USING BTREE,
  CONSTRAINT `FK_ORDER_DE_REFERENCE_GOODS` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ORDER_DE_REFERENCE_ORDER` FOREIGN KEY (`o_id`) REFERENCES `order` (`o_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_details
-- ----------------------------
INSERT INTO `order_details` VALUES (1000000001, 20240607184612123, 1, 10000);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `t_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (10001, '白色');
INSERT INTO `tag` VALUES (10002, '黑色');
INSERT INTO `tag` VALUES (10003, '绿色');
INSERT INTO `tag` VALUES (10004, '蓝色');
INSERT INTO `tag` VALUES (10005, '紫色');
INSERT INTO `tag` VALUES (10006, '红色');

SET FOREIGN_KEY_CHECKS = 1;
