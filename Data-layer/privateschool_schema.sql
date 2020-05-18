-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: privateschool
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT 'DESCRIPTION NOT AVAILABLE!',
  `subdatetime` datetime NOT NULL,
  `courseID` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `COMP_UNIQUE__title_subdatetime_courseID` (`title`,`subdatetime`,`courseID`),
  KEY `FK__Courses_id__assignments_courseID_idx` (`courseID`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK__Courses_id__Assignments_courseID` FOREIGN KEY (`courseID`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,'ASSIGNMENT 1','PROJECT IN JAVA','2020-06-30 00:00:00',3),(2,'ASSIGNMENT 2','PROJECT IN PYTHON','2020-03-15 00:00:00',2),(4,'ASSIGNMENT 3','','2020-06-30 00:00:00',3),(6,'ASSIGNMENT 4',NULL,'2020-06-30 12:00:00',1),(7,'ASSIGNMENT 5','PROJECT IN SCALA','2020-04-10 18:00:00',6),(8,'SEMESTER ASSIGNMENT','','2020-06-14 00:00:00',5),(9,'WINTER SEMESTER ASSIGNMENT','ALL CURICULUM','2020-03-24 00:00:00',1),(10,'FULL SSIGNMENT','DESCRIPTION NOT AVAILABLE!','2020-06-30 12:00:00',8),(11,'FIRST ASSIGNMENT','THE FIRST ASSIGNMENT','2020-06-30 00:00:00',4);
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `stream` varchar(45) NOT NULL,
  `type` varchar(20) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `COMP_UNIQUE_title_stream_type_startdate_enddate` (`title`,`stream`,`type`,`start_date`,`end_date`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'CB1','C++','FT','2020-02-01','2020-04-30'),(2,'CB2','PYTHON','PT','2020-01-01','2020-03-30'),(3,'CB3','JAVA','FT','2020-05-15','2020-07-30'),(4,'CB4','JAVASCRIPT','FT','2020-03-01','2020-06-30'),(5,'CB5','SQL','PT','2020-04-01','2020-05-30'),(6,'CB6','SCALA','PT','2020-04-01','2020-05-30'),(7,'CB7','JAVA','FT','2020-03-15','2020-06-15'),(8,'CB8','C','PT','2020-01-01','2020-08-30'),(11,'GM1','PHYSICS','FT','2020-06-15','2020-09-30'),(13,'GM3','JAVASCRIPT','PT','2020-05-15','2020-07-30'),(12,'GN2','MATHEMATICS','FT','2020-03-25','2020-04-15');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_students`
--

DROP TABLE IF EXISTS `courses_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses_students` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `courseID` int NOT NULL,
  `studentID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `COMP_UNIQUE__courseID_studentID` (`courseID`,`studentID`) /*!80000 INVISIBLE */,
  KEY `FK__Students_id courses_students_studentID_idx` (`studentID`),
  CONSTRAINT `FK__Courses_id__courses_students_courseID` FOREIGN KEY (`courseID`) REFERENCES `courses` (`id`),
  CONSTRAINT `FK__Students_id courses_students_studentID` FOREIGN KEY (`studentID`) REFERENCES `students` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_students`
--

LOCK TABLES `courses_students` WRITE;
/*!40000 ALTER TABLE `courses_students` DISABLE KEYS */;
INSERT INTO `courses_students` VALUES (1,1,2),(2,3,1),(4,2,2),(7,1,3),(8,5,8),(36,4,5),(37,5,6),(38,6,8),(39,7,10),(40,5,11),(41,5,3),(42,5,1),(43,8,4),(44,2,6),(45,5,12),(46,3,7);
/*!40000 ALTER TABLE `courses_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_trainers`
--

DROP TABLE IF EXISTS `courses_trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses_trainers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CourseID` int NOT NULL,
  `TrainerID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `COMP_UNIQUE_courseID_trainerID` (`CourseID`,`TrainerID`),
  KEY `FK__Trainers_id__courses_trainers_trainerID_idx` (`TrainerID`),
  CONSTRAINT `FK__Courses_id__courses_trainers_courseID` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`id`),
  CONSTRAINT `FK__Trainers_id__courses_trainers_trainerID` FOREIGN KEY (`TrainerID`) REFERENCES `trainers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_trainers`
--

LOCK TABLES `courses_trainers` WRITE;
/*!40000 ALTER TABLE `courses_trainers` DISABLE KEYS */;
INSERT INTO `courses_trainers` VALUES (3,1,2),(1,2,3),(2,3,1),(11,4,4),(9,5,10),(7,6,6),(12,7,1),(13,8,5),(10,11,9),(6,12,8),(8,13,4);
/*!40000 ALTER TABLE `courses_trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `dateofbirth` date NOT NULL,
  `tuitionfees` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `COMP_UNIQUE_firstname_lastname_dateofbirth` (`firstname`,`lastname`,`dateofbirth`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'KOSTAS','MICHAILIDIS','1980-02-18',5000),(2,'CHRISTOS','PAPADOPOYLOS','1990-05-16',5000),(3,'NICK','GEORGIOY','2000-01-01',3000),(4,'MARIA','NIKOLAOY','1998-04-06',3500),(5,'BASILIS','BASILOVIC','1995-02-06',4000),(6,'SPYROS','SPYROY','2001-06-18',3500),(7,'ELENI','NIKOLAOY','1997-04-13',3500),(8,'GEORGIA','LAKAS','1989-03-19',4000),(9,'JULIA','PAYLOPOYLOY','1990-01-01',3000),(10,'MARIOS','STATHOPOYLOS','1995-02-03',4500),(11,'EIRINI','FOYNTA','1978-05-28',3500),(12,'ANGELA','MERKEL','1990-02-19',5000),(13,'ANGELA','PAPAS','1980-12-19',5000),(14,'LILA','MARTAKOVA','1998-02-19',3000),(15,'CHRISTOS','MIXAILOY','1986-02-25',3500);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_assignments`
--

DROP TABLE IF EXISTS `students_assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_assignments` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int NOT NULL,
  `assignmentID` int NOT NULL,
  `totalmark` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `COMP_UNIQUE_studentID_assignmentID` (`studentID`,`assignmentID`),
  KEY `FK__Assignments_id__students_assignments_assignmentID` (`assignmentID`),
  CONSTRAINT `FK__Assignments_id__students_assignments_assignmentID` FOREIGN KEY (`assignmentID`) REFERENCES `assignments` (`id`),
  CONSTRAINT `FK__Students_id__students_assignments_studentID` FOREIGN KEY (`studentID`) REFERENCES `students` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_assignments`
--

LOCK TABLES `students_assignments` WRITE;
/*!40000 ALTER TABLE `students_assignments` DISABLE KEYS */;
INSERT INTO `students_assignments` VALUES (1,1,1,100),(2,1,2,65),(3,3,6,90),(4,12,8,80),(5,8,7,100),(6,4,10,60),(7,5,11,85),(8,6,8,80),(9,7,1,90),(10,7,4,100);
/*!40000 ALTER TABLE `students_assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `COMPOSITE__firstname_lastname_subject` (`firstname`,`lastname`,`subject`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (4,'ALAN','IVIC','JAVASCRIPT'),(2,'GEORGE','SMITH','C++'),(10,'ILIAS','ANDERSON','RUBY'),(6,'MAKIS','MAKAROPOULOS','SCALA'),(9,'MARIOS','POULOPOULOS','PHYSICS'),(1,'NICK','PAPAS','JAVA'),(8,'PAUL','ANDERSON','MATHEMATICS'),(11,'PAULA','MIKELSEN','MATHEMATICS'),(5,'PAYLOS','KOUKOLAS','C'),(3,'PETROS','PETROY','PYTHON');
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'privateschool'
--

--
-- Dumping routines for database 'privateschool'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-14 22:12:49
