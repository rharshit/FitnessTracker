-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fitness
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consume`
--

DROP TABLE IF EXISTS `consume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consume` (
  `f_name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `f_date` date NOT NULL,
  `quantity` int(11) NOT NULL,
  `cal_cons` int(11) NOT NULL,
  PRIMARY KEY (`f_name`,`username`,`f_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consume`
--

LOCK TABLES `consume` WRITE;
/*!40000 ALTER TABLE `consume` DISABLE KEYS */;
INSERT INTO `consume` VALUES ('Almonds','1','2018-10-27',17,138),('Almonds','1','2018-11-02',23,184),('Almonds','1','2018-11-06',30,240),('Apple','rharshit','2018-10-25',10,880),('Apple','rharshit','2018-10-27',0,0),('Apple','rharshit','2018-11-06',7,616),('Chapati','1','2018-10-27',4,276),('Cornflakes','1','2018-10-27',2,224),('Cornflakes','1','2018-11-06',2,224),('Daal','1','2018-10-27',2,182),('Double Toned Milk','1','2018-10-27',1,120),('Egg(Boiled)','1','2018-11-06',3,465),('Watermelon','1','2018-11-02',0,0);
/*!40000 ALTER TABLE `consume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-07 17:41:21
