-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: immfly
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `channel`
--

DROP TABLE IF EXISTS `channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `language` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `subchannel_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlaj1naxqg1m74mqfmimqjsq3l` (`subchannel_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `channel`
--

LOCK TABLES `channel` WRITE;
/*!40000 ALTER TABLE `channel` DISABLE KEYS */;
INSERT INTO `channel` VALUES (1,'ESP','example.png','SERIES',NULL),(2,'ESP','example.png','RedBull',1),(3,'ESP','example.png','ALTRES',1),(4,'ESP','example.png','El Club de la comedia',3),(5,'ESP','example.png','El Objetivo',3),(6,'ESP','example.png','Channel Viaje',1),(7,'ESP','example.png','PELICULAS',NULL);
/*!40000 ALTER TABLE `channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `channel_contents`
--

DROP TABLE IF EXISTS `channel_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channel_contents` (
  `channel_id` bigint(20) NOT NULL,
  `contents_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_q1577essvwp5tfapmh23tjin4` (`contents_id`),
  KEY `FKohkqa56vpswnh51s9t9rujxpt` (`channel_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `channel_contents`
--

LOCK TABLES `channel_contents` WRITE;
/*!40000 ALTER TABLE `channel_contents` DISABLE KEYS */;
INSERT INTO `channel_contents` VALUES (4,1),(4,2),(5,3),(5,4),(5,5),(5,6),(6,7),(6,8),(6,9),(6,10),(7,11),(7,12),(7,13),(7,14);
/*!40000 ALTER TABLE `channel_contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rating` float NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `channel_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK49da5t48y0nko65y0o001vgmk` (`channel_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES ('MovieContent',1,9,'Chapter 1','Santiago Segura',NULL,NULL),('MovieContent',2,8,'Chapter 2','Santiago Segura',NULL,NULL),('MovieContent',3,8,'Chapter 1','Charles Avila',NULL,NULL),('MovieContent',4,5,'Chapter 2','Charles Avila',NULL,NULL),('MovieContent',5,9,'Chapter 2','Charles Avila',NULL,NULL),('MovieContent',6,8,'Chapter 2','Charles Avila',NULL,NULL),('MovieContent',7,8,'Chapter 1','Charles Avila',NULL,NULL),('MovieContent',8,9,'Chapter 2','Charles Avila',NULL,NULL),('MovieContent',9,9,'Chapter 2','Charles Avila',NULL,NULL),('MovieContent',10,7,'Chapter 2','Charles Avila',NULL,NULL),('MovieContent',11,7.2,'Movie 1','Quentin Tarantino',NULL,NULL),('MovieContent',12,4,'Movie 2','Quentin Tarantino',NULL,NULL),('MovieContent',13,6,'Movie 3','Quentin Tarantino',NULL,NULL),('MovieContent',14,6.5,'Movie 4','Quentin Tarantino',NULL,NULL);
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 15:12:46
