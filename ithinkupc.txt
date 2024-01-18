-- MySQL dump 10.13  Distrib 8.2.0, for macos14.0 (x86_64)
--
-- Host: localhost    Database: ithinkupc
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` mediumint NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `fecha_alta` datetime NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `UC_Person` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (2,'2222222V','JORDI','PUIG','65232326662','2023-03-01 17:39:56'),(4,'377929393N','ANA','RIVAS','6547338822','2023-03-24 10:27:53'),(5,'y8334423l','GERALDINE JHOANA','LOPEZ HUAMAN','672389896','2024-01-17 20:50:54'),(6,'3333','Madeleine','Contreras','980288718','2024-01-17 21:09:14'),(7,'y83344233','GERALDINE JHOANA','LOPEZ HUAMAN','672389896','2024-01-17 21:29:32'),(8,'33334','GERALDINE JHOANA','LOPEZ HUAMAN','672389896','2024-01-17 21:52:13'),(10,'333333V','Sergi','Lopez','6767876890','2024-01-18 01:45:44'),(13,'y83344238','Sergi','Lopez','67676897','2024-01-18 02:18:20'),(14,'5555555V','Sergi','Lopez','946248155','2024-01-18 02:56:39'),(15,'y83344299','Sergi','Lopez','6372837283','2024-01-18 02:57:19'),(16,'333xssd','gladys','Huaman','82332392','2024-01-18 03:04:45'),(17,'y83344233s','Luis','Lopez','326384238','2024-01-18 03:11:34'),(18,'ddedede','Luisa','Lopez','1236216382','2024-01-18 03:14:09'),(19,'cdsdsds','sdsddsd','ddsdds','3234234','2024-01-18 03:40:45'),(20,'333344444555','GERALDINE JHOANArrr','LOPEZ HUAMAN','672389896','2024-01-18 03:50:12'),(21,'343456752e','Mario','Moreno','33333333','2024-01-18 04:07:04'),(22,'sdsasds','Silvia','Bolanos','3232','2024-01-18 04:26:35'),(23,'22222223','Youseff','Allallouti','372327632','2024-01-18 04:36:08'),(24,'65722882','Sergi','Lopez','52662672','2024-01-18 04:45:16'),(25,'324343434','Made','Contreras','323273273','2024-01-18 04:46:51');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_direccion`
--

DROP TABLE IF EXISTS `persona_direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona_direccion` (
  `idPersonaDireccion` mediumint NOT NULL AUTO_INCREMENT,
  `idPersona` mediumint NOT NULL,
  `tipo_via` varchar(10) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  PRIMARY KEY (`idPersonaDireccion`),
  KEY `idPersona` (`idPersona`),
  CONSTRAINT `persona_direccion_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_direccion`
--

LOCK TABLES `persona_direccion` WRITE;
/*!40000 ALTER TABLE `persona_direccion` DISABLE KEYS */;
INSERT INTO `persona_direccion` VALUES (1,23,'Carrer','Vicents','Barcelona'),(2,24,'Carrer','Cristofol','Masnou'),(3,25,'Avenida','Sant','Sant Feliu');
/*!40000 ALTER TABLE `persona_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` mediumint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (2,'ADMINISTRADOR'),(3,'TECNICO');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_persona`
--

DROP TABLE IF EXISTS `rol_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_persona` (
  `idRolPersona` mediumint NOT NULL AUTO_INCREMENT,
  `idRol` mediumint NOT NULL,
  `idPersona` mediumint NOT NULL,
  PRIMARY KEY (`idRolPersona`),
  KEY `idPersona` (`idPersona`),
  KEY `idRol` (`idRol`),
  CONSTRAINT `rol_persona_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `rol_persona_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_persona`
--

LOCK TABLES `rol_persona` WRITE;
/*!40000 ALTER TABLE `rol_persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol_persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-18  7:15:00
