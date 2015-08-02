-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.33a-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for chargendb
DROP DATABASE IF EXISTS `chargendb`;
CREATE DATABASE IF NOT EXISTS `chargendb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chargendb`;


-- Dumping structure for table chargendb.character
DROP TABLE IF EXISTS `character`;
CREATE TABLE IF NOT EXISTS `character` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterId` varchar(45) DEFAULT NULL,
  `characterName` varchar(45) DEFAULT NULL,
  `characterLevel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `characterId` (`characterId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table chargendb.player
DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `playerId` varchar(45) DEFAULT NULL,
  `playerName` varchar(45) DEFAULT NULL,
  `playerEmail` varchar(45) DEFAULT NULL,
  `playerPassword` varchar(45) DEFAULT NULL,
  `playerStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `playerId` (`playerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table chargendb.player_character
DROP TABLE IF EXISTS `player_character`;
CREATE TABLE IF NOT EXISTS `player_character` (
  `player_id` int(11) NOT NULL,
  `character_id` int(11) NOT NULL,
  PRIMARY KEY (`player_id`,`character_id`),
  KEY `FK_CHARACTER` (`character_id`),
  CONSTRAINT `FK_CHARACTER` FOREIGN KEY (`character_id`) REFERENCES `character` (`id`),
  CONSTRAINT `FK_PLAYER` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
