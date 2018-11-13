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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `deploy` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `typeId` varchar(128) DEFAULT NULL,
  `amount` int(11) NOT NULL DEFAULT '0',
  `inPrice` double NOT NULL,
  `outPrice` double NOT NULL,
  `inTime` date NOT NULL,
  `supplier` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

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
  `buyerTel` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sales` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `sex` int(1) NOT NULL DEFAULT '1',
  `birth` date NOT NULL,
  `addr` varchar(256) NOT NULL,
  `inTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `basicSalary` double NOT NULL,
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`birth`,`addr`,`inTime`,`basicSalary`,`isDelete`,`tel`) values (1,'test','123455',1,'2018-11-16','南山','2018-11-02 11:16:49',3200,0,'13800138000');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
