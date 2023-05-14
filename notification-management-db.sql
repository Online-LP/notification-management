/*
SQLyog Professional v12.09 (64 bit)
MySQL - 10.3.13-MariaDB : Database - notification-management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`notification-management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `notification-management`;

/*Table structure for table `label_text` */

DROP TABLE IF EXISTS `label_text`;

CREATE TABLE `label_text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `labeltext` varchar(30) DEFAULT NULL,
  `language_id` int(11) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfx13ocdw2b7v21rx4s0lttpj3` (`language_id`),
  CONSTRAINT `FKfx13ocdw2b7v21rx4s0lttpj3` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `label_text` */

/*Table structure for table `language` */

DROP TABLE IF EXISTS `language`;

CREATE TABLE `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(36) NOT NULL,
  `name` varchar(36) NOT NULL,
  `iso2` varchar(2) DEFAULT NULL,
  `iso_code` varchar(32) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `language` */

insert  into `language`(`id`,`code`,`name`,`iso2`,`iso_code`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,'HINDI','Hindi','hi','hin',1,'2013-06-25 12:32:51.000000',1,'2020-07-10 15:15:00.000000'),(2,'ENGLISH','English','en','eng',1,'2013-06-25 12:33:11.000000',NULL,NULL),(3,'TELUGU','Telugu','te','Tel',1,'2016-04-06 00:00:00.000000',NULL,NULL),(4,'TAMIL','Tamil','ta','Tam',23,'2016-07-30 09:50:52.000000',NULL,NULL),(5,'KANNADA','Kannada','kn','kan',23,'2016-10-06 16:41:30.000000',NULL,NULL),(6,'ORIYA','Oriya','or','ori',23,'2016-10-06 17:28:21.000000',NULL,NULL),(7,'MARATHI','Marathi','mr','Mar',23,'2016-10-06 17:39:15.000000',1,'2018-09-05 15:49:34.000000'),(8,'Others','Others',NULL,'Others',23,'2016-10-08 17:28:19.000000',NULL,NULL),(9,'MALAYALAM','Malayalam','ml','MAL',1,'2016-12-27 11:11:53.000000',NULL,NULL),(10,'GUJRATI','Gujrati','gu','GUJ',1,'2016-12-27 11:12:28.000000',NULL,NULL),(11,'NEPALI','NEPALI',NULL,'NEP',1,'2016-12-27 11:12:50.000000',NULL,NULL),(12,'PUNJABI','Punjabi','pa','PUN',1,'2016-12-27 11:13:16.000000',NULL,NULL),(13,'BHOJPURI','Bhojpuri','hr','BHO',1,'2016-12-27 11:13:54.000000',NULL,NULL),(14,'BANGALA','BANGALA',NULL,'BAN',1,'2016-12-27 11:14:20.000000',1,'2020-07-12 23:58:49.000000'),(15,'URDU','URDU',NULL,'URD',1,'2016-12-27 11:14:34.000000',NULL,NULL),(16,'gujarati','english',NULL,'eng1',59,'2017-11-14 14:06:24.000000',59,'2017-11-14 14:07:04.000000'),(17,'testdemo','testdemo',NULL,'testdemo',1,'2020-07-12 23:59:28.000000',NULL,NULL),(18,'BENGALI','Bengali','bn','Ben',1,'2020-08-10 12:57:19.000000',NULL,NULL),(19,'Instrumental','Instrumental',NULL,'Ins',1,'2020-08-10 12:57:20.000000',NULL,NULL),(20,'Persian','Persian',NULL,'Per',1,'2021-01-18 15:31:14.000000',NULL,NULL),(21,'Pushto; Pashto','Pushto; Pashto',NULL,'Pus',1,'2021-01-18 15:31:24.000000',NULL,NULL),(22,'Odia','Odia',NULL,'Odi',1,'2021-01-18 15:31:28.000000',NULL,NULL),(23,'Rajasthani','Rajasthani',NULL,'Raj',1,'2021-01-18 15:31:28.000000',NULL,NULL),(24,'Nagpuri','Nagpuri',NULL,'Nag',1,'2021-06-29 14:54:47.000000',NULL,NULL),(25,'hr','hr',NULL,'hr',1,'2021-06-29 17:50:44.000000',NULL,NULL),(26,'kn','kn',NULL,'kn',1,'2021-06-29 17:50:45.000000',NULL,NULL),(27,'bn','bn',NULL,'bn',1,'2021-06-29 17:50:46.000000',NULL,NULL),(28,'mr','mr',NULL,'mr',1,'2021-06-29 17:50:48.000000',NULL,NULL),(29,'pa','pa',NULL,'pa',1,'2021-06-29 17:50:48.000000',NULL,NULL),(30,'ml','ml',NULL,'ml',1,'2021-06-29 17:50:48.000000',NULL,NULL),(31,'Assamese','Assamese',NULL,'Ass',1,'2021-07-28 11:47:22.000000',NULL,NULL),(32,'Korean','Korean',NULL,'Kor',42,'2021-07-28 16:21:20.000000',NULL,NULL),(33,'as','as',NULL,'as',1,'2021-08-09 16:09:21.000000',NULL,NULL),(34,'hv','hv',NULL,'hv',1,'2021-08-09 16:09:23.000000',NULL,NULL),(35,'Spanish','Spanish',NULL,'Spa',42,'2021-09-16 14:12:02.000000',NULL,NULL),(36,'Haryanvi','Haryanvi',NULL,'Har',42,'2021-09-16 14:12:23.000000',NULL,NULL),(37,'pu','pu',NULL,'pu',42,'2021-09-16 14:12:51.000000',NULL,NULL);

/*Table structure for table `message_type` */

DROP TABLE IF EXISTS `message_type`;

CREATE TABLE `message_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lkdrmpmq8pwcat2q77n97ul9e` (`code`),
  UNIQUE KEY `UKlkdrmpmq8pwcat2q77n97ul9e` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `message_type` */

insert  into `message_type`(`id`,`code`,`name`,`status`,`created_by`,`created_date`) values (1,'ALERT','Alert',1,166,'2013-09-23 17:15:12.000000'),(2,'WARNING','Warning',1,166,'2013-09-23 17:15:12.000000'),(3,'MESSAGE','Message Box',1,166,'2014-02-20 12:45:57.000000');

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(256) NOT NULL,
  `message` varchar(256) NOT NULL,
  `sms_message` varchar(256) DEFAULT NULL,
  `ref_key` varchar(32) NOT NULL,
  `ref_value` varchar(32) NOT NULL,
  `message_type_id` int(11) NOT NULL,
  `priority_id` int(11) NOT NULL,
  `has_attachment` bit(1) DEFAULT NULL,
  `attachment_path` varchar(128) DEFAULT NULL,
  `notification_sms_cat_id` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKimc3tew5w65am4nydfybvyf3j` (`message_type_id`),
  KEY `FKg67lpggcutr8y1425o9amfxp` (`notification_sms_cat_id`),
  KEY `FK2osvd7jwwiay8y7hx9ehgln26` (`priority_id`),
  CONSTRAINT `FK2osvd7jwwiay8y7hx9ehgln26` FOREIGN KEY (`priority_id`) REFERENCES `priority` (`id`),
  CONSTRAINT `FKg67lpggcutr8y1425o9amfxp` FOREIGN KEY (`notification_sms_cat_id`) REFERENCES `notification_category` (`id`),
  CONSTRAINT `FKimc3tew5w65am4nydfybvyf3j` FOREIGN KEY (`message_type_id`) REFERENCES `message_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `notification` */

insert  into `notification`(`id`,`subject`,`message`,`sms_message`,`ref_key`,`ref_value`,`message_type_id`,`priority_id`,`has_attachment`,`attachment_path`,`notification_sms_cat_id`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,'App User Password Request','Dear Admin,\r\n\r\nYour PASSWORD request\r\n\r\nhttp://localhost:9090/user-management/#/createnewPassword?username=admin&token=e74b79b2-444a-44c9-aef5-6ca2f4cd4b3f:1684004939558\r\n\r\nThanks.\r\n','','APP_USER_ID','1',3,2,NULL,NULL,1,1,'2023-05-14 00:39:43.000000',NULL,NULL),(2,'App User Password Request','Dear Admin,\r\n\r\nYour PASSWORD request\r\n\r\nhttp://localhost:9090/user-management/#/createnewPassword?username=admin&token=5a8a6cdb-ac0b-466b-a3c8-d7de9de3e3a7:1684005096315\r\n\r\nThanks.\r\n','','APP_USER_ID','1',3,2,NULL,NULL,1,1,'2023-05-14 00:41:36.000000',NULL,NULL),(3,'Password Reset Request','Password Reset Request For Admin http://localhost:9090/user-management/#/createnewPassword?username=admin&token=6095dcad-1d04-4bd9-9bed-4ebdd1eb9a88:1684006054354','Password Reset Request For Admin http://localhost:9090/user-management/#/createnewPassword?username=admin&token=6095dcad-1d04-4bd9-9bed-4ebdd1eb9a88:1684006054354','APP_USER_ID','1',3,2,NULL,NULL,1,1,'2023-05-14 00:57:34.000000',NULL,NULL),(4,'Password Reset Request','Password Reset Request For Admin http://localhost:9091/user-management/#/createnewPassword?username=admin&token=65354b0f-4c07-4575-92da-38f0bccebbc4:1684052888759','Password Reset Request For Admin http://localhost:9091/user-management/#/createnewPassword?username=admin&token=65354b0f-4c07-4575-92da-38f0bccebbc4:1684052888759','APP_USER_ID','1',3,2,NULL,NULL,1,1,'2023-05-14 13:58:09.000000',NULL,NULL);

/*Table structure for table `notification_category` */

DROP TABLE IF EXISTS `notification_category`;

CREATE TABLE `notification_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `description` varchar(64) DEFAULT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b9ykbn517uq97715cdqq6kf2b` (`code`),
  UNIQUE KEY `UKb9ykbn517uq97715cdqq6kf2b` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `notification_category` */

insert  into `notification_category`(`id`,`code`,`description`,`created_by`,`created_date`) values (1,'SEND_PASSWORD_MODULE','Send Password',1,'2023-05-05 14:59:50.000000'),(2,'RESET_PASSWORD_MODULE','Reset Password',1,'2023-05-05 14:59:50.000000'),(3,'CHANGE_PASSWORD_MODULE','Change Password',1,'2023-05-05 14:59:50.000000'),(4,'USER_AUTH_MODULE','User Authentication Module',1,'2023-05-05 14:59:50.000000'),(5,'OTP_NOTIFICATION','OTP Notification',1,'2023-05-05 14:59:50.000000');

/*Table structure for table `notification_details` */

DROP TABLE IF EXISTS `notification_details`;

CREATE TABLE `notification_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_id` int(11) NOT NULL,
  `sms_response` varchar(128) DEFAULT NULL,
  `mac_address` varchar(64) DEFAULT NULL,
  `sms_status` tinyint(4) NOT NULL,
  `email_status` tinyint(4) NOT NULL,
  `resend_count` int(11) DEFAULT NULL,
  `stb_status` tinyint(4) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhvjvveyf2h7llqmwr8niiubso` (`notification_id`),
  CONSTRAINT `FKhvjvveyf2h7llqmwr8niiubso` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `notification_details` */

insert  into `notification_details`(`id`,`notification_id`,`sms_response`,`mac_address`,`sms_status`,`email_status`,`resend_count`,`stb_status`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,1,NULL,'onlinelearning162@gmail.com',0,1,NULL,0,1,'2023-05-14 00:39:46.000000',NULL,NULL),(2,2,NULL,'onlinelearning162@gmail.com',0,1,NULL,0,1,'2023-05-14 00:41:36.000000',NULL,NULL),(3,3,NULL,'onlinelearning162@gmail.com',0,1,NULL,0,1,'2023-05-14 00:57:34.000000',NULL,NULL),(4,4,NULL,'onlinelearning162@gmail.com',0,1,NULL,0,1,'2023-05-14 13:58:09.000000',NULL,NULL);

/*Table structure for table `notification_template_details` */

DROP TABLE IF EXISTS `notification_template_details`;

CREATE TABLE `notification_template_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_template_master_id` int(11) NOT NULL,
  `email_subject` varchar(256) NOT NULL,
  `email_content` varchar(256) NOT NULL,
  `sms_content` varchar(256) NOT NULL,
  `language_id` int(11) NOT NULL,
  `ext_sms_template_id` varchar(32) DEFAULT NULL,
  `is_email_enabled` int(11) NOT NULL,
  `is_sms_enabled` int(11) NOT NULL,
  `message_type_id` int(11) DEFAULT NULL,
  `notification_cat_id` int(11) DEFAULT NULL,
  `priority_type_id` int(11) DEFAULT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe29frb5rdkqi9qyqyn6fewyac` (`language_id`),
  KEY `FKg0k2u4atom9d5jcrm32kl78x8` (`message_type_id`),
  KEY `FK5e0nl2juirat8fc7k38cyi28e` (`notification_cat_id`),
  KEY `FKno225r0f7mf4qneeqwfyceau7` (`notification_template_master_id`),
  KEY `FKo9c5wka56cxydyubswxno9knh` (`priority_type_id`),
  CONSTRAINT `FK5e0nl2juirat8fc7k38cyi28e` FOREIGN KEY (`notification_cat_id`) REFERENCES `notification_category` (`id`),
  CONSTRAINT `FKe29frb5rdkqi9qyqyn6fewyac` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`),
  CONSTRAINT `FKg0k2u4atom9d5jcrm32kl78x8` FOREIGN KEY (`message_type_id`) REFERENCES `message_type` (`id`),
  CONSTRAINT `FKno225r0f7mf4qneeqwfyceau7` FOREIGN KEY (`notification_template_master_id`) REFERENCES `notification_template_master` (`id`),
  CONSTRAINT `FKo9c5wka56cxydyubswxno9knh` FOREIGN KEY (`priority_type_id`) REFERENCES `priority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `notification_template_details` */

insert  into `notification_template_details`(`id`,`notification_template_master_id`,`email_subject`,`email_content`,`sms_content`,`language_id`,`ext_sms_template_id`,`is_email_enabled`,`is_sms_enabled`,`message_type_id`,`notification_cat_id`,`priority_type_id`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (19,1,'Password Reset Requested','Dear #TITLE# #FIRST_NAME#, \n\n Your password has been reset. \nYour credentials are \n UserName: #USER_NAME# \n Password: #PASSWORD# \n\n Regards,\n Suport Team','Dear #TITLE# #FIRST_NAME#, \n\n Your password has been reset. \nYour credentials are \n UserName: #USER_NAME# \n Password: #PASSWORD# \n\n Regards,\n Suport Team',2,NULL,1,1,3,2,1,1,'2023-05-13 22:02:09',NULL,NULL),(20,2,'Password Resend Requested','Dear #TITLE# #FIRST_NAME#, \n\n Your password has been resend. \n Your credentials are \n UserName: #USER_NAME# \n Password: #PASSWORD# \n\n Regards,\n Suport Team','Dear #TITLE# #FIRST_NAME#, \n\n Your password has been resend. \n Your credentials are \n UserName: #USER_NAME# \n Password: #PASSWORD# \n\n Regards,\n Suport Team',2,NULL,1,1,3,1,1,1,'2023-05-13 22:02:09',NULL,NULL),(21,3,'Password Changed','Dear #TITLE# #FIRST_NAME#, \n\n Your password has been Changed. \nYour UserName is : #USER_NAME# \n\n Regards,\n Suport Team','Dear #TITLE# #FIRST_NAME#, \n\n Your password has been Changed. \nYour UserName is : #USER_NAME# \n\n Regards,\n Suport Team',2,NULL,1,1,3,3,1,1,'2023-05-13 22:02:09',NULL,NULL),(22,4,'Device Login Credentials','Dear #TITLE# #FIRST_NAME#, \n\n Your Login Credentials are as below. \n UserName : #USER_NAME# \n Password : #PASSWORD# \n\n Regards,\n Suport Team','Dear #TITLE# #FIRST_NAME#, you are successfully registered. Your userid is #USER_NAME# password is #PASSWORD# thanks \n Suport Team.',2,NULL,1,1,3,4,1,1,'2023-05-13 22:02:09',NULL,NULL),(23,5,'OTP','OTP for #FRANCHISE_NAME# APP  registration is #OTP#  generated at #DATE_TIME# . Thank you.','OTP for #FRANCHISE_NAME# APP  registration is #OTP#  generated at #DATE_TIME# . Thank you. \n\nRegards,\n Suport Team',2,NULL,1,1,3,5,1,1,'2023-05-13 22:02:09',NULL,NULL),(24,6,'Password Reset Code','Dear #TITLE# #FIRST_NAME#, \n\n\nYour password reset code generated. \nYour Password reset code is : #PASSWORD_RESET_CODE# \nReset code Url: #PASSWORD_RESET_LINK#\n\n\nRegards,\n Suport Team','Dear #TITLE# #FIRST_NAME#, \n\n\nYour password reset code generated. \nYour Password reset code is : #PASSWORD_RESET_CODE# \nReset code Url: #PASSWORD_RESET_LINK#\n\n\nRegards,\n Suport Team',2,NULL,1,1,3,3,1,1,'2023-05-13 22:02:09',NULL,NULL),(26,7,'Login OTP','To proceed on Asianet Mobile TV plus Please use OTP #OTP#','To proceed on Asianet Mobile TV plus Please use OTP #OTP#',2,'4',1,1,3,5,1,1,'2023-05-14 00:37:37',NULL,NULL),(27,8,'App User Password Request','Dear #USER_NAME#,\r\n\r\nYour PASSWORD request\r\n\r\n#LINK#\r\n\r\nThanks.\r\n','',2,NULL,1,0,3,1,2,1,'2023-05-14 00:37:39',NULL,NULL);

/*Table structure for table `notification_template_master` */

DROP TABLE IF EXISTS `notification_template_master`;

CREATE TABLE `notification_template_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `name` varchar(128) NOT NULL,
  `place_holders` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bmabwc71c2kfbs9np14l6mgt7` (`code`),
  UNIQUE KEY `UK_mk8t4ec21o1mij4ncqfcqyjkd` (`name`),
  UNIQUE KEY `UKbmabwc71c2kfbs9np14l6mgt7` (`code`),
  UNIQUE KEY `UKmk8t4ec21o1mij4ncqfcqyjkd` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `notification_template_master` */

insert  into `notification_template_master`(`id`,`code`,`created_by`,`created_date`,`name`,`place_holders`) values (1,'USER_AUTH_PASSWORD_RESET',1,'2023-05-05 00:10:10.000000','User Auth Password Reset','#TITLE#,#FIRST_NAME#,#USER_NAME#,#PASSWORD#'),(2,'USER_AUTH_PASSWORD_RESEND',1,'2023-05-05 00:10:10.000000','User Auth Password Resend','#TITLE#,#FIRST_NAME#,#USER_NAME#,#PASSWORD#'),(3,'USER_AUTH_CHANGE_PASSWORD',1,'2023-05-05 00:10:10.000000','User Auth Change Password','#TITLE#,#FIRST_NAME#,#USER_NAME#'),(4,'USER_AUTH_CREDENTIALS_NEW',1,'2023-05-05 00:10:10.000000','User Auth Credentials New','#TITLE#,#FIRST_NAME#,#USER_NAME#,#PASSWORD#'),(5,'OTP_NOTIFICATION',1,'2023-05-05 00:10:10.000000','OTP Notification','#FRANCHISE_NAME#,#OTP#,#DATE_TIME#'),(6,'USER_AUTH_PASSWORD_RESET_CODE',1,'2023-05-05 00:10:10.000000','User Auth Password Reset Code','#TITLE#,#FIRST_NAME#,#PASSWORD_RESET_CODE#,#PASSWORD_RESET_LINK#'),(7,'LOGIN_OTP_NOTIFICATION',1,'2023-05-05 00:10:10.000000','Login OTP Notification','#OTP#,#DATE_TIME#'),(8,'APP_USER_PASSWORD',1,'2023-05-05 00:10:10.000000','App user password Creation','#USER_NAME#,#LINK#');

/*Table structure for table `priority` */

DROP TABLE IF EXISTS `priority`;

CREATE TABLE `priority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `priority` */

insert  into `priority`(`id`,`code`,`created_by`,`created_date`,`modified_by`,`modified_date`,`name`) values (1,'HIGH',166,'2013-09-23 17:15:08.000000',NULL,NULL,'High'),(2,'MEDIUM',166,'2013-09-23 17:15:08.000000',NULL,NULL,'Medium'),(3,'LOW',166,'2013-09-23 17:15:08.000000',NULL,NULL,'Low');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
