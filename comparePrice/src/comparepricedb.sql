# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     comparepricedb
# Server version:               5.6.15
# Server OS:                    Win64
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2014-03-26 11:39:44
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for comparepricedb
DROP DATABASE IF EXISTS `comparepricedb`;
CREATE DATABASE IF NOT EXISTS `comparepricedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `comparepricedb`;


# Dumping structure for table comparepricedb.brand
DROP TABLE IF EXISTS `brand`;
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '0',
  `weight` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.candidate_word
DROP TABLE IF EXISTS `candidate_word`;
CREATE TABLE IF NOT EXISTS `candidate_word` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `BRAND_FK1` (`bid`),
  CONSTRAINT `BRAND_FK1` FOREIGN KEY (`bid`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.comment
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `cid` int(10) NOT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `iscandidateword` tinyint(1) DEFAULT NULL,
  `specialstate` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `USER_FK1` (`uid`),
  KEY `COMMODITY_FK1` (`cid`),
  CONSTRAINT `COMMODITY_FK1` FOREIGN KEY (`cid`) REFERENCES `commodity` (`id`),
  CONSTRAINT `USER_FK1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.commodity
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE IF NOT EXISTS `commodity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `unit` int(2) DEFAULT NULL,
  `bid` int(10) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `onlineid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `BRAND_FK` (`bid`),
  CONSTRAINT `BRAND_FK` FOREIGN KEY (`bid`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.crawler_website
DROP TABLE IF EXISTS `crawler_website`;
CREATE TABLE IF NOT EXISTS `crawler_website` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `link` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.forbid_commodity
DROP TABLE IF EXISTS `forbid_commodity`;
CREATE TABLE IF NOT EXISTS `forbid_commodity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cid` int(10) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`),
  UNIQUE KEY `id` (`id`),
  KEY `COMMODITY_FK` (`cid`),
  CONSTRAINT `COMMODITY_FK` FOREIGN KEY (`cid`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.navy
DROP TABLE IF EXISTS `navy`;
CREATE TABLE IF NOT EXISTS `navy` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `flag` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `USER_FK` (`uid`),
  CONSTRAINT `USER_FK` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.sensitive_word
DROP TABLE IF EXISTS `sensitive_word`;
CREATE TABLE IF NOT EXISTS `sensitive_word` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.special_word
DROP TABLE IF EXISTS `special_word`;
CREATE TABLE IF NOT EXISTS `special_word` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `BRAND_FK2` (`bid`),
  CONSTRAINT `BRAND_FK2` FOREIGN KEY (`bid`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.synonym
DROP TABLE IF EXISTS `synonym`;
CREATE TABLE IF NOT EXISTS `synonym` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `flag` int(10) DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table comparepricedb.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `sensitivecount` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
