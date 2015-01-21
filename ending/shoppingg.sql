/*
Navicat MySQL Data Transfer

Source Server         : cyr
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-12-20 18:45:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `Aid` int(11) NOT NULL,
  `Aname` varchar(50) NOT NULL,
  `Apwd` varchar(20) NOT NULL,
  `Alevel` varchar(10) DEFAULT '普通',
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('10001', 'cyr', '123456', '超级');
INSERT INTO `admininfo` VALUES ('10002', 'yzy', '123456', '普通');

-- ----------------------------
-- Table structure for goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `Gid` int(11) NOT NULL,
  `Gname` varchar(100) NOT NULL,
  `Gprice` double NOT NULL,
  `Gclass` varchar(50) DEFAULT '杂货',
  `Gamount` int(11) NOT NULL,
  `Gdate` datetime DEFAULT NULL,
  `Gimgurl` varchar(100) DEFAULT NULL,
  `Glook` int(11) DEFAULT '0',
  `Gintro` text,
  `Gbrief` text,
  PRIMARY KEY (`Gid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of goodsinfo
-- ----------------------------
INSERT INTO `goodsinfo` VALUES ('807200001', '乖,摸摸头', '45', 'book', '34', '2014-12-20 12:20:45', 'D://workspace1//shopping//WebContent//img//book//3.jpg', '0', '作者：大冰', '《乖，摸摸头》内容简介：真实的故事自有万钧之力\r\n《乖，摸摸头》讲述了12个真实的传奇故事，或许会让你看到那些你永远无法去体会的生活，见识那些可能你永远都无法结交的人。\r\n《乖，摸摸头》一书记录了大冰十余年的江湖游历，以及他和他朋友们的爱与温暖的传奇故事。这些故事与风花雪月无关，与鸡汤小清新无关，有的是无畏的奋斗和孤身的寻找，有的是疯狂的爱情和极致的浪漫……12个故事，12种善意，如点点星光与烛火，给所有心怀希望的人们以温暖和光芒。请相信，这个世界上真的有人在过着你想要的生活。忽晴忽雨的江湖，祝你有梦为马，随处可栖。\r\n你我迤逦人世间，每个人都需要被善意地摸摸头。不论你晴朗或是阴霾，低谷期还是巅峰期，愿你永远被这个世间的善意所护持。善良是一种天赋，善意是一份选择。《乖，摸摸头》不仅仅是一本书，还是一份善意，更是一份心意。你想对谁说一声“乖，摸摸头”？请把这本书送给他（她），希望他亦能明了你的心意。');
INSERT INTO `goodsinfo` VALUES ('807200002', '当时忍住就好了(哈佛大学性格自修课)平装', '23', 'book', '12', '2014-12-20 12:23:02', 'D://workspace1//shopping//WebContent//img//book//8.jpg', '1', '作者:肯·林德纳,译者:钱峰', '《当时忍住就好了》内容简介：亲爱的读者，《当时忍住就好了》供你陶冶情操的散文集，也不只是一本供你消遣时光的故事书，这是一本告诉你如何驾驭自己能量的奇书。如果能认真读下去，你会被很多贴心的故事所启发，也会因为许多奇妙的心理技巧而改变自己，从此拥有一个“不后悔的人生”。“当时忍住就好了”，生活中有多少人发出过这样的感叹，就会有多少人需要《当时忍住就好了》的帮助。她或许并不迷人，但于我们的人生而言，她必定有用。那么，就请静下你的心灵，打开你的思维，随着这本书开始一场自我修炼的旅程吧。');
INSERT INTO `goodsinfo` VALUES ('807200003', '(2015版)考研1号英语:考研真相', '45', 'book', '123', '2014-12-20 12:29:31', 'D://workspace1//shopping//WebContent//img//book//1.jpg', '0', '本书分上下两册，共十年真题及解析。上册为2005年至2011年七年的真题及解析；下册为2012年至2014年三年的真题及解析', '一、首创真题“词汇难句”模式——精解词汇，图解难句\r\n二、首创真题“选项表析”模式——定位答案，总结技巧\r\n三、首创真题“佳句模仿”模式——真题佳句，用于写作　\r\n四、新增真题“篇章结构”模式——文章结构，宏观图解\r\n五、首创真题“英汉对照”模式——左右对照，方便学习\r\n六、首创真题“全文录音”模式——美音MP3，培养语感');
INSERT INTO `goodsinfo` VALUES ('807200004', '托福考试官方指南', '55', 'book', '43', '2014-12-20 12:31:02', 'D://workspace1//shopping//WebContent//img//book//2.jpg', '0', '《托福考试官方指南(第4版)》为ETS在中国独家授权版本，也是ETS为托福考试编写的唯一一本官方指南的最新版。', '书中全面介绍了托福考试的相关信息，包括托福考试读、听、说、写各部分题型与答题策略，提供了大量翔实的备考资料与权威指导，同时附有题型分析、模拟样题、备考策略、计分体制、写作题库等，是托福考生必备的权威辅导书。《托福考试官方指南(第4版)》所附CD-ROM包含书中3套全真模拟测试题和全部音频文件，仿真界面帮助考生体验真实考场环境。\r\n《托福考试官方指南(第4版)》以新课程标准的要求为依据，对考纲研究透彻。准确把握教材，又不拘泥于教材。注重知识间、学科间的联系，培养创新能力，知识覆盖全面，包含了教材中全部的知识点，便于学生学习。');
INSERT INTO `goodsinfo` VALUES ('807200005', '马尔克斯:番石榴飘香', '67', 'book', '45', '2014-12-20 12:32:20', 'D://workspace1//shopping//WebContent//img//book//4.jpg', '0', '作者:加西亚马尔克斯 P.A.门多萨,译者:林一安', '《番石榴飘香》内容：快来围观最全面、最真实、最风趣可爱的加博吧！《番石榴飘香》是另一位哥伦比亚作家P.A.门多萨和加西亚?马尔克斯的谈话录，内容涉及马尔克斯人生的各个方面，穿插着门多萨介绍谈话背景的优美散文，被读者誉为“打开马尔克斯世界的钥匙”。《番石榴飘香》可说是最有名、流传最广的马尔克斯访谈录，书中的许多句子后来都成了读者心目中马尔克斯的标志性言论。\r\n莫言、余华等几乎所有一线作家，在谈到自己的文学创作历程时，都会提到这本书。强调一下，《番石榴飘香》并不是一本端庄范的书，正如亲爱的老马并不是一个端庄范的作家，本书的有些篇章，老马的自我爆料简直让人目瞪口呆。');
INSERT INTO `goodsinfo` VALUES ('807200006', '眠空', '34', 'book', '89', '2014-12-20 12:34:55', 'D://workspace1//shopping//WebContent//img//book//5.jpg', '1', '作者:安妮宝贝', '《眠空》是安妮宝贝继《素年锦时》暌违五年之后的最新散文集。《安妮宝贝:眠空》是某种生发、循环、分解、消释。这些文字对我而言，如同把一枚铁钉敲入岩石，缓慢、坚定、持续、深入；也如同把一封书信投入大海，随手撒落，没有目的。它们是内心的一种知觉和清理。——安妮宝贝\r\n安妮宝贝是当代最受欢迎的作家之一，已出版《告别薇安》《八月未央》《蔷薇岛屿》《清醒纪》《莲花》《素年锦时》《春宴》等多部作品，曾任文学读物《大方》主编，在年轻读者中深具影响力。\r\n在《眠空》中，安妮宝贝以清简思省的文字，记录写作、生活、旅行、爱情、阅读、审美等各种观点和细节点滴，具有直指人心的力量。');
INSERT INTO `goodsinfo` VALUES ('807200007', '知识的边界', '34', 'book', '100', '2014-12-20 12:36:46', 'D://workspace1//shopping//WebContent//img//book//9.jpg', '0', '戴维温伯格(David Weinberger)(作者),胡泳(译者),高美(译者)', '曾经，我们知道怎么去获取知识。我们的答案来自于书籍或者专家。我们会确定事实，继续前进。而在网络时代，知识已经进入了网络中，出现了史上最多的知识，但这些知识是不同的。所有确定性都被连根拔起，话题再无边界，没有人对任何事情能达成一致。\r\n然而，对于知识的捕猎者而言，这是最好的时期——如果你知道如何获取知识的话。作者在本书中向我们展示了网络化的知识（networked knowledge）如何增进对商界、科学界、教育界和政府的理解，并且，和人们不得不依赖传统专业知识来源的时代相比，它又怎样做到令人们可以做出更明智的决策。\r\n这本开创性的著作，动摇了我们知识观的基础——从事实的作用到书籍的价值到专家的权威性——为知识在互联世界的未来提供了具有说服力的愿景。');
INSERT INTO `goodsinfo` VALUES ('807200008', '优雅的力量:让你脱颖而出的4种特质修炼', '67', 'book', '89', '2014-12-20 12:39:09', 'D://workspace1//shopping//WebContent//img//book//7.jpg', '0', '杰奎琳惠特摩尔(作者),高艳芳(译者)', '《优雅的力量:让你脱颖而出的4种特质修炼》继《商务礼仪》之后，畅销书作家、著名社交礼仪专家杰奎琳?惠特摩尔又一力作！杰奎琳用自己白手起家的创业成功路启迪读者，语言亲切自然，极富感染力与说服力。《优雅的力量:让你脱颖而出的4种特质修炼》翻译意达文雅，装帧设计精良，为你提供最佳的视觉与精神体验！多位各界名家倾情力荐。\r\n《优雅的力量:让你脱颖而出的4种特质修炼》的重点不在于礼节礼仪，而在于如何建立一种更持久、更有意义的人际关系，以及如何在自己的生活中以人为先。通过学习如何培养四种性格特质：气质、优雅、专业和热情，你就能够推动自己迈向成功。成功就如同目的地之对于旅行一样。《优雅的力量:让你脱颖而出的4种特质修炼》的目的是使这个旅行，你的旅行成为一个更有计划性、更有意义的一个过程。\r\n阅读《优雅的力量:让你脱颖而出的4种特质修炼》就是对自己进行投资；它将帮助你做好准备，随时迎接机遇来叩响你的大门。把这四种杰出的特质应用到日常的实践中，你会抓住那些稍纵即逝的机遇；你会有更好的人际关系，扩展视野，满怀信心地将事业推向更高阶段。');
INSERT INTO `goodsinfo` VALUES ('807200009', '人性的弱点(卡耐基手稿还原版)', '35', 'book', '67', '2014-12-20 12:40:34', 'D://workspace1//shopping//WebContent//img//book//6.jpg', '0', '戴尔卡耐基(Dale Carnegie)(作者),陶曚(译者)', '《人性的弱点(卡耐基手稿还原版)》内容简介：《人性的弱点》是1937年最初首印版本原汁原味的复刻，收录了卡耐基本人、他的朋友为此书所写的内容推荐与背景介绍，并完整保留首版中卡耐基对婚姻与家庭的真知灼见。此外，本版新译的语言风格更贴近当下人们的阅读喜好，在融合时下语言风潮的同时也不失中文特有的韵味。人性的弱点》作为一本实用的人际关系著作，从人性本质的角度，挖掘出潜藏在人们体内的弱点，使人们能够充分认识自己，并不断改造自己，从而能有所长进，直至取得最后的成功。在过去的77年里，戴尔?卡耐基的忠告带领着上千万名读者攀登上成功的阶梯，无论在事业方面还是个人生活上，他的箴言不断被一代代人实践与验证。在出版史上，《人性的弱点(卡耐基手稿还原版)》创造了全世界图书销售空前的记录。在经济萧条时期之后，《人性的弱点(卡耐基手稿还原版)》满足了普遍存在的人性的需要，触动了读者的神经，在当今社会依然有其特有的借鉴价值。');

-- ----------------------------
-- Table structure for ordergoods
-- ----------------------------
DROP TABLE IF EXISTS `ordergoods`;
CREATE TABLE `ordergoods` (
  `OGid` int(11) NOT NULL,
  `Oid` int(11) NOT NULL,
  `Uid` int(11) NOT NULL,
  `Gid` int(11) NOT NULL,
  `OGamount` int(11) NOT NULL,
  `OGtotalprice` double NOT NULL,
  PRIMARY KEY (`OGid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of ordergoods
-- ----------------------------
INSERT INTO `ordergoods` VALUES ('1', '2', '10003', '807200001', '2', '734');
INSERT INTO `ordergoods` VALUES ('2', '3', '10003', '807200001', '1', '367');
INSERT INTO `ordergoods` VALUES ('3', '4', '10003', '807200001', '1', '367');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `Oid` int(11) NOT NULL,
  `Odate` datetime NOT NULL,
  `Aid` int(11) DEFAULT NULL,
  `Ostate` varchar(20) DEFAULT NULL,
  `Orecname` varchar(50) NOT NULL,
  `Orecadr` varchar(200) NOT NULL,
  `Orectel` varchar(20) DEFAULT NULL,
  `Uid` int(11) DEFAULT NULL,
  `Ototalprice` double DEFAULT NULL,
  PRIMARY KEY (`Oid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('1', '2014-12-16 09:25:45', '10001', '已发货', 'cyr', '山东工商学院', '18363803180', '10003', '367');
INSERT INTO `orderinfo` VALUES ('2', '2014-12-17 09:57:35', null, '未发货', 'cyr', '山东工商学院', '18363803180', '10003', '734');
INSERT INTO `orderinfo` VALUES ('3', '2014-12-17 15:33:56', null, '未发货', 'cyr', '山东工商学院', '18363803180', '10003', '367');
INSERT INTO `orderinfo` VALUES ('4', '2014-12-17 15:46:01', null, '未发货', '程亚如', '山东工商学院', '18363803180', '10003', '367');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `Uid` int(11) NOT NULL,
  `Uname` varchar(50) NOT NULL,
  `Upwd` varchar(20) NOT NULL,
  `Uemail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('10001', 'zrk', '860607', 'www.zrk@163.com');
INSERT INTO `userinfo` VALUES ('10002', 'wyy', '871216', 'www.wyy@163.com');
INSERT INTO `userinfo` VALUES ('10003', 'cyr', '6731121', '1258588446@qq.com');
INSERT INTO `userinfo` VALUES ('10004', 'yzy', '18363803091', '1258588446@qq.com');
INSERT INTO `userinfo` VALUES ('10005', 'gxd', '123456', '123456789@qq.com');
