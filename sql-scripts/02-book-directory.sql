CREATE DATABASE  IF NOT EXISTS `book_directory`;
USE `book_directory`;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(250) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `book`
--

INSERT INTO `book` VALUES 
	(1,'asd','Aasd asdasd','asd asdasd asd asdasd'),
	(2,'fghh','fgh fghfgh','fgh fghfgh fghfgh fghfghfgh'),
	(3,'ert','ert ertert ert','ert ertert ertertert ertert');
