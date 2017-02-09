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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'1100107816179','Abebe Tekle','Yalew','000-98-1201'),(2,'1100102427947','Abel Ketsela','Yitayew','000-98-1202'),(3,'1100105329857','Abreham Worku','Derso','000-98-1203'),(4,'1100109266172','Abrhaley Mesfin','Aynialem','000-98-1204'),(5,'1100106360334','Amanuel','Tekle','000-98-1205'),(6,'1100102207621','Ashutosh','Ghimire','000-98-1206'),(7,'1100104460437','Befrdu Seifu','Gebreamlack','000-98-1207'),(8,'1100105475231','Bimal','Parajuli','000-98-1208'),(9,'1100101590211','Bisrat Sisay','Asrat','000-98-1209'),(10,'1100107212854','Daniel Tesfu','Kifle','000-98-1210'),(11,'1100103493806','Duc Hien','Vo','000-98-1211'),(12,'1100107460723','Eyob Tarekegn','Woldeyohannes','000-98-1212'),(13,'1100108809975','Gebreyesus Gebrehiwet','Abraha','000-98-1213'),(14,'1100108713765','HenokTeferi','Micael','000-98-1214'),(15,'1100104927208','Hong An','Nguyen','000-98-1215'),(16,'1100106989229','Kassa Tilahun','Ayele','000-98-1216'),(17,'1100109170831','Kidist Endale','Deginetu','000-98-1217'),(18,'1100106157955','Kokeb Abera','Beyene','000-98-1218'),(19,'1100104934903','Krishna Bahadur','Bhat','000-98-1219'),(20,'1100105193192','Michael Fekadu','Kaleab','000-98-1220'),(21,'1100101995192','Mussie Kahsai','Ghebregziabher','000-98-1221'),(22,'1100106127909','Natei Kebede','Jarso','000-98-1222'),(23,'1100108486882','Nebeyou Dagnachew','Admasu','000-98-1223'),(24,'1100101445450','Nolawe Seifu','Woldesemayat','000-98-1224'),(25,'1100101525137','Robel Goitom','Woldu','000-98-1225'),(26,'1100104231715','Samuel Essiet','Gde','000-98-1226'),(27,'1100107048526','Samuel Fentahuen','Zeru','000-98-1227'),(28,'1100109785686','Thi Luong','Dinh','000-98-1228'),(29,'1100101742046','Winta Gebretnsae','Hailai','000-98-1229'),(30,'1100107714428','Yashika','Goyal','000-98-1230'),(31,'1100104846477','Yeneakal Girma','Regassa','000-98-1231');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-08 14:52:55
