CREATE DATABASE  IF NOT EXISTS `sistemaanimales` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistemaanimales`;
-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemaanimales
-- ------------------------------------------------------
-- Server version	8.0.14

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
-- Table structure for table `tipoanimalcaracteristicasanimal`
--

DROP TABLE IF EXISTS `tipoanimalcaracteristicasanimal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipoanimalcaracteristicasanimal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCaracteristicasAnimal` int(11) NOT NULL,
  `idAnimal` int(11) NOT NULL,
  `valor` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_TipoAnimal_has_CaracteristicasAnimal_CaracteristicasAnim_idx` (`idCaracteristicasAnimal`),
  CONSTRAINT `fk_TipoAnimal_has_CaracteristicasAnimal_CaracteristicasAnimal1` FOREIGN KEY (`idCaracteristicasAnimal`) REFERENCES `caracteristicasanimal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoanimalcaracteristicasanimal`
--

LOCK TABLES `tipoanimalcaracteristicasanimal` WRITE;
/*!40000 ALTER TABLE `tipoanimalcaracteristicasanimal` DISABLE KEYS */;
INSERT INTO `tipoanimalcaracteristicasanimal` VALUES (1,1,4,'4'),(2,2,4,'0'),(3,3,4,'0'),(4,7,4,'true'),(5,1,1,'4'),(6,2,1,'0'),(7,3,1,'0'),(8,1,2,'2'),(9,2,2,'2'),(10,3,2,'0'),(11,1,3,'0'),(12,3,3,'6'),(13,1,5,'0'),(14,3,5,'0'),(15,5,5,'true');
/*!40000 ALTER TABLE `tipoanimalcaracteristicasanimal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-04 18:57:48
