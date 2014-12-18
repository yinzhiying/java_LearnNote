/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50165
Source Host           : localhost:3306
Source Database       : xscj

Target Server Type    : MYSQL
Target Server Version : 50165
File Encoding         : 65001

Date: 2014-12-18 17:35:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for curriculum
-- ----------------------------
DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum` (
  `kecheng` varchar(255) DEFAULT NULL,
  `xingqiyi` varchar(255) DEFAULT NULL,
  `xingqier` varchar(255) DEFAULT NULL,
  `xingqisan` varchar(255) DEFAULT NULL,
  `xingqisi` varchar(255) DEFAULT NULL,
  `xingqiwu` varchar(255) DEFAULT NULL,
  `xingqiliu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of curriculum
-- ----------------------------
INSERT INTO `curriculum` VALUES (null, 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Firiday', 'Saturday');
INSERT INTO `curriculum` VALUES (null, 'jsp', 'java', 'uml', 'test', 'jsp', 'test');
INSERT INTO `curriculum` VALUES (null, 'uml', 'html', 'jsp', 'jsp', 'test', null);
INSERT INTO `curriculum` VALUES (null, 'test', 'html', 'jsp', 'jsp', 'test', null);
