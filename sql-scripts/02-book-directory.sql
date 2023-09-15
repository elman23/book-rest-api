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
	(1,"The Lord of the Rings","J.R.R. Tolkien","A fantasy classic."),
	(2,"Harry Potter and the Philosophers stone","J.K. Rowling","A young wizard's adventures"),
	(3,"Swann's way", "Marcel Proust", "One of the masterpieces of literature.");
