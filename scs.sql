/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21 : Database - db_computer_sale
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_computer_sale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_computer_sale`;

/*Table structure for table `deploy` */

DROP TABLE IF EXISTS `deploy`;

CREATE TABLE `deploy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `screenSize` varchar(32) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `cpu` varchar(64) DEFAULT NULL,
  `videoCard` varchar(64) DEFAULT NULL,
  `ram` varchar(64) DEFAULT NULL,
  `hardPan` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `deploy` */

insert  into `deploy`(`id`,`productId`,`screenSize`,`weight`,`cpu`,`videoCard`,`ram`,`hardPan`) values (2,9,'15.6',5,'i7','英伟达','未知','未知');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `typeId` varchar(128) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '0',
  `inPrice` double NOT NULL,
  `outPrice` double DEFAULT NULL,
  `inTime` date NOT NULL,
  `supplier` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`typeId`,`amount`,`inPrice`,`outPrice`,`inTime`,`supplier`) values (9,'联想','y500',501,5000,NULL,'2018-10-30','联想');

/*Table structure for table `salary` */

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yearMonth` date NOT NULL,
  `salary` double NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salary` */

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salesManId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `productName` varchar(128) NOT NULL,
  `outPrice` double NOT NULL,
  `salesTime` date NOT NULL,
  `buyerName` varchar(64) NOT NULL,
  `buyTel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `sales` */

insert  into `sales`(`id`,`salesManId`,`productId`,`productName`,`outPrice`,`salesTime`,`buyerName`,`buyTel`) values (2,4,9,'联想',5000,'2018-11-21','测试买家','13800138222'),(3,3,9,'联想',5555,'2018-11-21','张三','1355555555'),(6,4,9,'联想',5600,'2018-10-27','测试买家3','1300125487'),(7,4,9,'联想',6500,'2018-10-27','测试买家4','1355122222'),(8,4,9,'联想',5557,'2018-10-28','测试买家5','13000000000');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) DEFAULT NULL,
  `sex` int(1) NOT NULL DEFAULT '1',
  `birth` date NOT NULL,
  `addr` varchar(256) NOT NULL,
  `inTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `basicSalary` double NOT NULL,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`birth`,`addr`,`inTime`,`basicSalary`,`isDelete`,`tel`) values (2,'张三',NULL,1,'2010-06-14','南山大道','2018-11-14 16:00:00',3500,0,'13551256664'),(3,'李四',NULL,1,'1961-11-13','北山大道','1997-11-14 16:00:00',3200,0,'13800138000'),(4,'王五',NULL,1,'1961-11-13','北山大道','1997-11-14 16:00:00',3200,0,'13800138000'),(5,'测试',NULL,1,'2018-10-27','南山区','2018-10-28 16:00:00',3400,0,'13551256634');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
