-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: certant_app
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inspection`
--

DROP TABLE IF EXISTS `inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inspection` (
  `id` varchar(255) NOT NULL,
  `is_exempt` bit(1) DEFAULT NULL,
  `measurement` bit(1) DEFAULT NULL,
  `nro_inspection` int(11) NOT NULL,
  `observation` bit(1) DEFAULT NULL,
  `soft_delete` bit(1) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `timestamps` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `inspector_id` varchar(255) DEFAULT NULL,
  `vehicle_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl9f72aehgxsw7t34eh81f9x0e` (`inspector_id`),
  KEY `FK1rl7djyb4l3x0sgpfigr99b1y` (`vehicle_id`),
  CONSTRAINT `FK1rl7djyb4l3x0sgpfigr99b1y` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
  CONSTRAINT `FKl9f72aehgxsw7t34eh81f9x0e` FOREIGN KEY (`inspector_id`) REFERENCES `inspector` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspection`
--

LOCK TABLES `inspection` WRITE;
/*!40000 ALTER TABLE `inspection` DISABLE KEYS */;
INSERT INTO `inspection` VALUES ('0e45fbcf-c079-40ed-883e-8f464066ac67',NULL,_binary '',0,_binary '',_binary '\0','APPROVED','2023-03-10 20:02:13','3ade97ef-27a4-4d09-8462-1c81a2024286','927fb78b-a965-4282-b572-157b8f739981'),('5ef355eb-acf5-4c75-926f-748436edbfc9',NULL,_binary '',1,_binary '\0',_binary '\0','CONDITIONAL','2023-03-10 20:03:47','05ca2723-d313-498e-b932-02569218e82d','bf105540-7645-4b04-91fd-eb8c84046590'),('65fd38d9-94ba-4216-a74c-e2c5da4ccfed',NULL,_binary '',2,_binary '\0',_binary '\0','CONDITIONAL','2023-03-10 20:03:47','3ade97ef-27a4-4d09-8462-1c81a2024286','b3907e56-2770-4be1-bc71-27f587285b74'),('744ff3a0-9956-4b51-9e81-4e7c744ee6bc',NULL,_binary '\0',9,_binary '\0',_binary '\0','REJECTED','2023-03-10 20:10:44','3ade97ef-27a4-4d09-8462-1c81a2024286','c4edc494-c7cb-47a5-891a-36a3298d0e0f'),('89652dab-019f-4886-8193-70ccfd613e03',NULL,_binary '',3,_binary '',_binary '\0','REJECTED','2023-03-10 20:03:47','af84523a-b217-46ed-9b1c-4ac59fbe9f7f','46a377df-4a85-4b08-b161-1162ad733405'),('921a81f4-a767-45b5-bf60-ed1a2bbb4969',NULL,_binary '',4,_binary '',_binary '\0','APPROVED','2023-03-10 20:03:47','af84523a-b217-46ed-9b1c-4ac59fbe9f7f','46a377df-4a85-4b08-b161-1162ad733405'),('9f4e03c5-8136-4f78-8738-5c0e43a06027',NULL,_binary '',5,_binary '',_binary '\0','APPROVED','2023-03-10 20:03:48','af84523a-b217-46ed-9b1c-4ac59fbe9f7f','8c5cd412-864b-4765-9047-e77434eaa2f5'),('a43eb826-d11e-4a4b-92ef-9b6987c772bb',NULL,_binary '\0',8,_binary '\0',_binary '\0','REJECTED','2023-03-10 20:10:44','3ade97ef-27a4-4d09-8462-1c81a2024286','a839fbd5-b55b-4c2f-86ac-94703774a403'),('d78cf9cb-9ab3-4ea7-a744-5e4e9e089217',NULL,_binary '\0',6,_binary '\0',_binary '\0','REJECTED','2023-03-10 20:03:48','05ca2723-d313-498e-b932-02569218e82d','c2c1b5a8-888c-4165-9349-751f4e1e90a0'),('f9b2f67f-1648-4212-958e-84b95d1b7301',NULL,_binary '',7,_binary '\0',_binary '\0','CONDITIONAL','2023-03-10 20:03:48','af84523a-b217-46ed-9b1c-4ac59fbe9f7f','01a8a377-6c62-4665-ad9f-cff457d962a4');
/*!40000 ALTER TABLE `inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inspector`
--

DROP TABLE IF EXISTS `inspector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inspector` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `soft_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspector`
--

LOCK TABLES `inspector` WRITE;
/*!40000 ALTER TABLE `inspector` DISABLE KEYS */;
INSERT INTO `inspector` VALUES ('05ca2723-d313-498e-b932-02569218e82d','Juan Spattera',_binary '\0'),('3ade97ef-27a4-4d09-8462-1c81a2024286','Claudio Spattera',_binary '\0'),('af84523a-b217-46ed-9b1c-4ac59fbe9f7f','Miguel Gonzales',_binary '\0'),('c06a56ae-99a8-4e11-8783-32ca8d2a3a85','JuanCRUz',_binary '\0');
/*!40000 ALTER TABLE `inspector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sticker`
--

DROP TABLE IF EXISTS `sticker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sticker` (
  `id` varchar(255) NOT NULL,
  `expiration` datetime(6) DEFAULT NULL,
  `registration_number` int(11) DEFAULT NULL,
  `vehicle_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9mvf6nvwc7jnmu8u85f5egf28` (`vehicle_id`),
  CONSTRAINT `FK9mvf6nvwc7jnmu8u85f5egf28` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sticker`
--

LOCK TABLES `sticker` WRITE;
/*!40000 ALTER TABLE `sticker` DISABLE KEYS */;
/*!40000 ALTER TABLE `sticker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `is_exempt` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `soft_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('01fd7615-0f07-4cf5-bfda-7a250a7187a9',_binary '\0','Roberto',_binary '\0'),('2c995c4d-c3f6-47ef-9416-dd5e6a068e59',_binary '','Roberto',_binary '\0'),('2ea9a2c5-f943-4460-8beb-4cf4edc8c338',_binary '','Juan Carlos',_binary '\0'),('340b2b5c-02ec-44ae-b0ff-5e31ab87f9da',_binary '\0','Pedro',_binary '\0'),('4d8bd257-b45d-4359-9230-cc778db657d2',_binary '','Luis',_binary '\0'),('cfd69800-06af-4b9c-9cbe-89e161b7d913',_binary '','Juan Cruz',_binary '\0'),('d799e3db-0e87-4a9e-ac7c-6835c5717a1c',_binary '\0','Cristian',_binary '\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `domain` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `soft_delete` bit(1) DEFAULT NULL,
  `owner_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2l3ygnjxunr1d74aril4ogtcy` (`owner_id`),
  CONSTRAINT `FK2l3ygnjxunr1d74aril4ogtcy` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('01a8a377-6c62-4665-ad9f-cff457d962a4','FIAT','23125665','2000',_binary '\0','2c995c4d-c3f6-47ef-9416-dd5e6a068e59'),('1d7702a8-1b51-4a78-82bd-49b45b4f2451','MERCEDES','9000232','2020',_binary '\0','4d8bd257-b45d-4359-9230-cc778db657d2'),('46a377df-4a85-4b08-b161-1162ad733405','MERCEDES','1266654','2022',_binary '\0','cfd69800-06af-4b9c-9cbe-89e161b7d913'),('8c5cd412-864b-4765-9047-e77434eaa2f5','RENAULT','1110532','2021',_binary '\0','cfd69800-06af-4b9c-9cbe-89e161b7d913'),('927fb78b-a965-4282-b572-157b8f739981','BMW','9000532','2021',_binary '\0','cfd69800-06af-4b9c-9cbe-89e161b7d913'),('a839fbd5-b55b-4c2f-86ac-94703774a403','BMW','5606064','2018',_binary '\0','01fd7615-0f07-4cf5-bfda-7a250a7187a9'),('b3907e56-2770-4be1-bc71-27f587285b74','FORD','231256215','2023',_binary '\0','2ea9a2c5-f943-4460-8beb-4cf4edc8c338'),('bdd33eab-12eb-4d5e-a9fb-bcec2ce7558d','123','asd12312312d','a23123213',_binary '','01fd7615-0f07-4cf5-bfda-7a250a7187a9'),('bf105540-7645-4b04-91fd-eb8c84046590','FORD','122ASD2','2018',_binary '\0','2ea9a2c5-f943-4460-8beb-4cf4edc8c338'),('c2c1b5a8-888c-4165-9349-751f4e1e90a0','MERCEDES','23123229','2020',_binary '\0','340b2b5c-02ec-44ae-b0ff-5e31ab87f9da'),('c4edc494-c7cb-47a5-891a-36a3298d0e0f','FIAT','5606214','1997',_binary '\0','01fd7615-0f07-4cf5-bfda-7a250a7187a9');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'certant_app'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-10 17:53:44
