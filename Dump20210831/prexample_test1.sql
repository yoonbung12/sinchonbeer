-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: prexample
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `test1`
--

DROP TABLE IF EXISTS `test1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test1` (
  `tidx1` int NOT NULL AUTO_INCREMENT,
  `tdate` date NOT NULL,
  `tcurrent` int NOT NULL DEFAULT '0',
  `ttotal` int NOT NULL DEFAULT '12',
  `tprice` int NOT NULL DEFAULT '22000',
  PRIMARY KEY (`tidx1`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test1`
--

LOCK TABLES `test1` WRITE;
/*!40000 ALTER TABLE `test1` DISABLE KEYS */;
INSERT INTO `test1` VALUES (31,'2021-09-02',0,12,22000),(32,'2021-09-03',0,12,22000),(33,'2021-09-04',0,12,22000),(34,'2021-09-05',0,12,22000),(35,'2021-09-06',0,12,22000),(36,'2021-09-07',0,12,22000),(37,'2021-09-08',0,12,22000),(38,'2021-09-09',0,12,22000),(39,'2021-09-10',0,12,22000),(40,'2021-09-11',0,12,22000),(41,'2021-09-12',0,12,22000),(42,'2021-09-13',0,12,22000),(43,'2021-09-14',0,12,22000),(44,'2021-09-15',0,12,22000),(45,'2021-09-16',0,12,22000),(46,'2021-09-17',0,12,22000),(47,'2021-09-18',0,12,22000),(48,'2021-09-19',0,12,22000),(49,'2021-09-20',0,12,22000),(50,'2021-09-21',0,12,22000),(51,'2021-09-22',0,12,22000),(52,'2021-09-23',0,12,22000),(53,'2021-09-24',0,12,22000),(54,'2021-09-25',0,12,22000),(55,'2021-09-26',0,12,22000),(56,'2021-09-27',0,12,22000),(57,'2021-09-28',0,12,22000),(58,'2021-09-29',0,12,22000),(59,'2021-09-30',0,12,22000),(60,'2021-10-01',3,12,22000);
/*!40000 ALTER TABLE `test1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-31 13:31:21
