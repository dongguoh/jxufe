# MySQL-Front 3.2  (Build 10.15)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;

/*!40101 SET NAMES gbk */;
/*!40103 SET TIME_ZONE='SYSTEM' */;

# Host: 127.0.0.1    Database: jxufe
# ------------------------------------------------------
# Server version 5.2.0-falcon-alpha-community-nt

#
# Table structure for table account
#
DROP DATABASE IF EXISTS `jxufe`;
CREATE DATABASE `jxufe` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `jxufe`;
 
CREATE TABLE `informationtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '与information的classify相对应',
  `name` varchar(50) NOT NULL COMMENT '?ù?í???? ???? ?à??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE `linktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET gb2312 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `account` (
  `userId` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '0',
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;



#
# Table structure for table information
#

CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `file` varchar(100) DEFAULT NULL,
  `issue` varchar(30) DEFAULT NULL,
  `classify` int(11) NOT NULL DEFAULT '0' COMMENT '1:表示公告，2：表示新闻',
  PRIMARY KEY (`id`),
  KEY `classify` (`classify`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;



#
# Table structure for table informationtype
#



#
# Table structure for table jpkc
#

CREATE TABLE `jpkc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `teacher` varchar(30) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '0',
  `year` int(11) NOT NULL DEFAULT '0',
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;



#
# Table structure for table link
#

CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) CHARACTER SET gb2312 NOT NULL,
  `url` varchar(100) CHARACTER SET gb2312 NOT NULL,
  `image` varchar(100) CHARACTER SET gb2312 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `link_fk_linkType` (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;



#
# Table structure for table linktype
#



#
#  Foreign keys for table information
#

ALTER TABLE `information`
  ADD FOREIGN KEY (`classify`) REFERENCES `informationtype` (`id`);

#
#  Foreign keys for table link
#

ALTER TABLE `link`
  ADD FOREIGN KEY (`typeid`) REFERENCES `linktype` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
