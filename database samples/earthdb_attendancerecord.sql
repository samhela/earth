-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: earthdb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendancerecord`
--

DROP TABLE IF EXISTS `attendancerecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendancerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `timeslot_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_irri7va45lf4t99q479hjh9qm` (`location_id`),
  KEY `FK_47itaa1ps5qxeh36s6n51uibi` (`student_id`),
  KEY `FK_rwd21r1mms5blga33xbpcexwc` (`timeslot_id`),
  CONSTRAINT `FK_47itaa1ps5qxeh36s6n51uibi` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_irri7va45lf4t99q479hjh9qm` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK_rwd21r1mms5blga33xbpcexwc` FOREIGN KEY (`timeslot_id`) REFERENCES `timeslot` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendancerecord`
--

LOCK TABLES `attendancerecord` WRITE;
/*!40000 ALTER TABLE `attendancerecord` DISABLE KEYS */;
INSERT INTO `attendancerecord` VALUES (1,'2016-01-01 00:00:00',1,1,1),(2,'2016-01-01 00:00:00',1,1,2),(3,'2016-01-01 00:00:00',1,2,1),(4,'2016-01-01 00:00:00',1,2,2),(5,'2016-01-01 00:00:00',1,3,1),(6,'2016-01-01 00:00:00',1,3,2);
/*!40000 ALTER TABLE `attendancerecord` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-08 14:52:54
