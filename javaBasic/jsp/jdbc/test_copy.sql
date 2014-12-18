/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50165
Source Host           : localhost:3306
Source Database       : xscj

Target Server Type    : MYSQL
Target Server Version : 50165
File Encoding         : 65001

Date: 2014-12-18 17:36:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test_copy
-- ----------------------------
DROP TABLE IF EXISTS `test_copy`;
CREATE TABLE `test_copy` (
  `sno` char(255) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `picture` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of test_copy
-- ----------------------------
INSERT INTO `test_copy` VALUES ('1201', 'nihao', 'g:\\picture2.jpg');
INSERT INTO `test_copy` VALUES ('1202', 'lele', 'g:\\picture3.jpg');
INSERT INTO `test_copy` VALUES ('1206', 'hehe', 'g:\\picture.jpg');
INSERT INTO `test_copy` VALUES ('7', 'dd', null);
