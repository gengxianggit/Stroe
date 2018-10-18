/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : company

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-10-09 08:27:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('1', 'aaaa');
INSERT INTO `content` VALUES ('2', 'aac');
INSERT INTO `content` VALUES ('3', 'aad');
INSERT INTO `content` VALUES ('4', 'aaaaaa');
INSERT INTO `content` VALUES ('5', 'afrdwra');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('2', '开发部', '4');
INSERT INTO `department` VALUES ('3', '科研部', '5');
INSERT INTO `department` VALUES ('4', '财务部', '3');
INSERT INTO `department` VALUES ('5', '小黑部', '1');
INSERT INTO `department` VALUES ('6', '服务部', '1');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(110) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  `e_id` int(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '大佬别', '男', '20', '1', null);
INSERT INTO `employee` VALUES ('2', '小绿', '女', '56', null, null);
INSERT INTO `employee` VALUES ('3', '小黑', '男', '201', null, null);
INSERT INTO `employee` VALUES ('4', '小红', '女', '20', null, null);
INSERT INTO `employee` VALUES ('5', '校长', '男', '35', '3', null);
INSERT INTO `employee` VALUES ('6', '菜狗', '男', '12', '2', null);
INSERT INTO `employee` VALUES ('8', '小王', '女', '21', '5', null);
INSERT INTO `employee` VALUES ('9', '耿祥', '男', '23', '5', null);
INSERT INTO `employee` VALUES ('25', '耿祥', '男', '12', null, null);
INSERT INTO `employee` VALUES ('27', '小王八1', '男', '12', '3', null);
INSERT INTO `employee` VALUES ('33', '张三', '男', '12', '2', null);
INSERT INTO `employee` VALUES ('37', '里为斯', '男', '23', '2', null);
INSERT INTO `employee` VALUES ('38', '耿祥', '男', '23', '3', '61046829-2ca9-4f85-8641-1358b4fc94da.jpg');
INSERT INTO `employee` VALUES ('50', '萨达姆', '男', '60', '3', null);
INSERT INTO `employee` VALUES ('51', '阿凡达', '男', '2500', '22', null);
INSERT INTO `employee` VALUES ('52', '维斯刘', '男', '23', '6', null);
INSERT INTO `employee` VALUES ('53', '阿甘', '男', '42', '4', null);
INSERT INTO `employee` VALUES ('55', '多少1', '男', '45', '3', '321e096c-bde0-426e-b464-f9245f200b84.jpg');
INSERT INTO `employee` VALUES ('56', '阿贾克斯1', '男', '12', '4', '69e7c891-f16e-4339-bd69-9f9d37a88264.jpg');
INSERT INTO `employee` VALUES ('61', '萨达', '男', '12', '5', '94fa591f-5c53-4335-a12f-479b3ccf28a9.jpg');
INSERT INTO `employee` VALUES ('67', '小小', '男', '23', '4', '80635e9a-501e-408e-beb9-01bf87cc1a15.jpg');
INSERT INTO `employee` VALUES ('69', '后日', '男', '1000', '2', 'faed6ec1-cd89-43a8-80c3-abf1f4410e42.jpg!q95.jpg');
INSERT INTO `employee` VALUES ('70', '王者', '男', '12', null, 'c1e6db6c-5835-4592-aa9c-97d5ae7f2d16.jpg');
INSERT INTO `employee` VALUES ('71', '荣耀', '女', '15', null, 'd84df925-ec01-451c-bc4a-5f9c49ff593d.jpg');
INSERT INTO `employee` VALUES ('72', '孙悟空', '男', '1000', '8', '217c3632-1286-4b6c-8bff-b089bf059050.jpg');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '開發部');
INSERT INTO `project` VALUES ('2', 'ris');
INSERT INTO `project` VALUES ('3', 'his');
INSERT INTO `project` VALUES ('4', 'dis');
INSERT INTO `project` VALUES ('5', '保安部');
INSERT INTO `project` VALUES ('6', 'lis');

-- ----------------------------
-- Table structure for `relation`
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `id` int(11) NOT NULL DEFAULT '0',
  `d_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation` VALUES ('1', '2');
INSERT INTO `relation` VALUES ('1', '4');
INSERT INTO `relation` VALUES ('1', '5');
INSERT INTO `relation` VALUES ('2', '2');
INSERT INTO `relation` VALUES ('2', '3');
INSERT INTO `relation` VALUES ('2', '4');
INSERT INTO `relation` VALUES ('2', '5');
INSERT INTO `relation` VALUES ('2', '22');
INSERT INTO `relation` VALUES ('3', '2');
INSERT INTO `relation` VALUES ('4', '2');
INSERT INTO `relation` VALUES ('4', '4');
INSERT INTO `relation` VALUES ('5', '2');
INSERT INTO `relation` VALUES ('5', '22');
INSERT INTO `relation` VALUES ('6', '2');
INSERT INTO `relation` VALUES ('6', '24');
INSERT INTO `relation` VALUES ('13', '2');
INSERT INTO `relation` VALUES ('14', '2');
INSERT INTO `relation` VALUES ('15', '2');
INSERT INTO `relation` VALUES ('15', '22');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `e_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('183', '4', '5', '78', '一般');
INSERT INTO `score` VALUES ('184', '1', '5', '76', '一般');
INSERT INTO `score` VALUES ('185', '3', '1', '78', '一般');
INSERT INTO `score` VALUES ('186', '3', '2', '50', '不及格');
INSERT INTO `score` VALUES ('187', '3', '3', '60', '及格');
INSERT INTO `score` VALUES ('188', '3', '4', '90', '优秀');
INSERT INTO `score` VALUES ('189', '2', '2', '111', '优秀');
INSERT INTO `score` VALUES ('190', '2', '1', '70', '一般');
INSERT INTO `score` VALUES ('192', '1', '0', '12', '不及格');
INSERT INTO `score` VALUES ('193', '2', '4', '12', '不及格');
INSERT INTO `score` VALUES ('194', '2', '4', '12', '不及格');
INSERT INTO `score` VALUES ('195', '9', '2', '12', '不及格');
INSERT INTO `score` VALUES ('196', '3', '5', '90', '优秀');
INSERT INTO `score` VALUES ('198', '3', '6', '70', '一般');
INSERT INTO `score` VALUES ('199', '4', '2', '10', '不及格');
INSERT INTO `score` VALUES ('203', '6', '3', '100', '优秀');
INSERT INTO `score` VALUES ('204', '6', '6', '12', '不及格');
INSERT INTO `score` VALUES ('205', '6', '4', '54', '不及格');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('27', '耿祥', '28CA05D8BFC76E26267C4F868919E33C', '0075CA23B289B8EB9E65E215B440B878');
INSERT INTO `user` VALUES ('28', '老朱', '118EA52055B93B8296869FE9697FDFF3', '72D76CBCA95DC0B46C108981878F3AB5');
INSERT INTO `user` VALUES ('29', '小黑', '57F7726D2162983AF317F01798F6061F', 'F893A14001A03195C8EC9798B139977E');

-- ----------------------------
-- View structure for `d_prelation`
-- ----------------------------
DROP VIEW IF EXISTS `d_prelation`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `d_prelation` AS select `r`.`id` AS `pid`,`r`.`d_id` AS `did`,`p`.`name` AS `pname`,`d`.`name` AS `dname` from ((`department` `d` left join `relation` `r` on((`d`.`id` = `r`.`d_id`))) left join `project` `p` on((`p`.`id` = `r`.`id`))) ;

-- ----------------------------
-- View structure for `sumview`
-- ----------------------------
DROP VIEW IF EXISTS `sumview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sumview` AS select `s`.`id` AS `sid`,`e`.`id` AS `eid`,`e`.`name` AS `ename`,`e`.`sex` AS `sex`,`d`.`id` AS `did`,`d`.`name` AS `dname`,`p`.`id` AS `pid`,`p`.`name` AS `pname`,`s`.`grade` AS `grade`,`s`.`value` AS `value` from ((((`employee` `e` left join `department` `d` on((`e`.`e_id` = `d`.`id`))) left join `relation` `r` on((`d`.`id` = `r`.`d_id`))) left join `project` `p` on((`p`.`id` = `r`.`id`))) left join `score` `s` on(((`e`.`id` = `s`.`e_id`) and (`p`.`id` = `s`.`r_id`)))) ;

-- ----------------------------
-- Procedure structure for `setnum`
-- ----------------------------
DROP PROCEDURE IF EXISTS `setnum`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setnum`()
BEGIN
	#RECLARE  tid INT;
DECLARE tid INT;
declare num1 int ;

DECLARE isloop  INT DEFAULT 1;

DECLARE  cur CURSOR for SELECT  d.id,COUNT(e_id) from department as d left  JOIN employee ON (d.id=e_id) GROUP BY E_id ;
declare  CONTINUE HANDLER  for not FOUND set isloop=0;
open cur;

WHILE  (isloop>0 )
DO
FETCH cur  into  tid ,num1;
 UPDATE department  SET  num= num1  where(id=tid);

   
END WHILE;
CLOSE cur;



END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `setgrade`
-- ----------------------------
DROP FUNCTION IF EXISTS `setgrade`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `setgrade`(`tvalue` int) RETURNS varchar(50) CHARSET utf8mb4
BEGIN
	#Routine body goes here...
DECLARE  tgrade VARCHAR(50);

IF tvalue>=90
THEN
set tgrade='优秀';
ELSEIF tvalue>=80
THEN
SET tgrade='良好';
ELSEIF tvalue>=70
THEN
SET tgrade='一般';
ELSEIF tvalue>=60
THEN
SET tgrade='及格';
ELSE
SET tgrade='不及格';
end if;
RETURN tgrade;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `add`;
DELIMITER ;;
CREATE TRIGGER `add` AFTER INSERT ON `employee` FOR EACH ROW begin
update department set num=ifnull(num,0)+1 where (id=new.e_id);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `updae`;
DELIMITER ;;
CREATE TRIGGER `updae` AFTER UPDATE ON `employee` FOR EACH ROW begin
update department  set num=ifnull(num,0)+1 where(id=new.e_id);
update department  set num=ifnull(num,0)-1 where(id=old.e_id);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `delete`;
DELIMITER ;;
CREATE TRIGGER `delete` AFTER DELETE ON `employee` FOR EACH ROW begin
update department  set num=ifnull(num,0)-1 where(id=old.e_id);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `454`;
DELIMITER ;;
CREATE TRIGGER `454` BEFORE INSERT ON `score` FOR EACH ROW BEGIN
DECLARE  tgrade VARCHAR(50);
DECLARE  tvalue int;
set tvalue=new.value;
IF tvalue>=90
THEN
set tgrade='优秀';
ELSEIF tvalue>=80
THEN
SET tgrade='良好';
ELSEIF tvalue>=70
THEN
SET tgrade='一般';
ELSEIF tvalue>=60
THEN
SET tgrade='及格';
ELSE
SET tgrade='不及格';
end if;
set new.grade=tgrade;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `132`;
DELIMITER ;;
CREATE TRIGGER `132` BEFORE UPDATE ON `score` FOR EACH ROW BEGIN
DECLARE  tgrade VARCHAR(50);
DECLARE  tvalue int;
set tvalue=new.value;
IF tvalue>=90
THEN
set tgrade='优秀';
ELSEIF tvalue>=80
THEN
SET tgrade='良好';
ELSEIF tvalue>=70
THEN
SET tgrade='一般';
ELSEIF tvalue>=60
THEN
SET tgrade='及格';
ElSEIF  tvalue>=0
THEN
SET tgrade='不及格';
else
set  tgrade=null;
end if;
set new.grade=tgrade;
END
;;
DELIMITER ;
