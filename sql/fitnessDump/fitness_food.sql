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
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food` (
  `f_name` varchar(45) NOT NULL,
  `f_calories` int(11) NOT NULL,
  `f_unit` varchar(45) NOT NULL,
  PRIMARY KEY (`f_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES ('Almonds',8,'1 Unit'),('Aloo Paratha',23,'1 Unit'),('Apple',88,'1 Unit'),('Brown Rice',167,'1 Plate'),('Chapati',69,'1 Unit'),('Cornflakes',112,'1 Bowl'),('Curd',93,'1 Bowl'),('Daal',91,'1 Bowl'),('Double Toned Milk',120,'1 Glass'),('Egg(Boiled)',155,'1 Unit'),('Green Salad',37,'1 Bowl'),('Grilled Sandwich',179,'1 Unit'),('Guava',48,'1 Unit'),('Idli',55,'1 Unit'),('Masala Dosa',181,'1 Unit'),('Muesli',119,'1 Bowl'),('Orange',63,'1 Unit'),('Paneer Paratha',224,'1 Unit'),('Paneer Tikka Masala',80,'1 Plate'),('Paneer(Toned Milk)',12,'28 g'),('Pastry',268,'1 Unit'),('Plain Rice',115,'1 Bowl'),('Plain Toast',58,'1 Unit'),('Poha',216,'1 Plate'),('Pomegranates',144,'1 Unit'),('Protein Shake',130,'1 Glass'),('Raita',62,'1 Bowl'),('Roti',85,'1 Unit'),('Samosa',268,'1 Unit'),('Soya Yogurt',81,'1 Bowl'),('Upma',139,'1 Plate'),('Uttapam',226,'1 Unit'),('Veg Puff',137,'1 Unit'),('Walnut',14,'1 Unit'),('Watermelon',46,'1 Slice');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
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
