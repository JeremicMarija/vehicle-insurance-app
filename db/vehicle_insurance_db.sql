-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.23 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for vehicle-insurance
CREATE DATABASE IF NOT EXISTS `vehicle-insurance` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `vehicle-insurance`;

-- Dumping structure for table vehicle-insurance.damage_types
CREATE TABLE IF NOT EXISTS `damage_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table vehicle-insurance.damage_types: 10 rows
/*!40000 ALTER TABLE `damage_types` DISABLE KEYS */;
INSERT INTO `damage_types` (`id`, `name`) VALUES
	(1, 'broken left stop light'),
	(2, 'broken right stop light'),
	(3, 'broken left rearview mirror'),
	(4, 'broken glass'),
	(5, 'scratched left door'),
	(6, 'scratched right door'),
	(7, 'recessed front trap'),
	(8, 'broken front windshield'),
	(9, 'broken right rearview mirror'),
	(10, 'broken front right window');
/*!40000 ALTER TABLE `damage_types` ENABLE KEYS */;

-- Dumping structure for table vehicle-insurance.insureds
CREATE TABLE IF NOT EXISTS `insureds` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `policy_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_of_insurance` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table vehicle-insurance.insureds: 4 rows
/*!40000 ALTER TABLE `insureds` DISABLE KEYS */;
INSERT INTO `insureds` (`id`, `name`, `surname`, `date_of_birth`, `policy_number`, `type_of_insurance`) VALUES
	(1, 'Mika', 'Mikic', '2000-07-08', 'mika123', 'TOTAL_INSURANCE'),
	(2, 'Pera', 'Peric', '1999-05-05', 'pera123', 'PARCIAL_INSURANCE'),
	(3, 'Juca', 'Jucic', '2002-02-16', 'juca123', 'ADDITIONAL_INSURANCE'),
	(4, 'Test', 'Test', '1990-05-31', 'test555', 'TOTAL_INSURANCE');
/*!40000 ALTER TABLE `insureds` ENABLE KEYS */;

-- Dumping structure for table vehicle-insurance.material_damages
CREATE TABLE IF NOT EXISTS `material_damages` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `entry_date` date NOT NULL,
  `type_of_damage` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `vehicle_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle_id` (`vehicle_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table vehicle-insurance.material_damages: 7 rows
/*!40000 ALTER TABLE `material_damages` DISABLE KEYS */;
INSERT INTO `material_damages` (`id`, `entry_date`, `type_of_damage`, `vehicle_id`) VALUES
	(1, '2000-05-05', 'TOTAL_DAMAGE', 1),
	(2, '2022-07-16', 'PARTIAL_DAMAGE', 2),
	(3, '2022-07-05', 'TOTAL_DAMAGE', 1),
	(4, '2022-07-05', 'TOTAL_DAMAGE', 1),
	(5, '2022-07-05', 'TOTAL_DAMAGE', 2),
	(6, '2022-07-08', 'PARTIAL_DAMAGE', 3),
	(7, '2022-07-12', 'TOTAL_DAMAGE', 5);
/*!40000 ALTER TABLE `material_damages` ENABLE KEYS */;

-- Dumping structure for table vehicle-insurance.material_damage_items
CREATE TABLE IF NOT EXISTS `material_damage_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `estimated_price` int(11) NOT NULL,
  `damagetype_id` int(11) NOT NULL,
  `materialdamage_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `damagetype_id` (`damagetype_id`),
  KEY `materialdamage_id` (`materialdamage_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table vehicle-insurance.material_damage_items: 5 rows
/*!40000 ALTER TABLE `material_damage_items` DISABLE KEYS */;
INSERT INTO `material_damage_items` (`id`, `description`, `estimated_price`, `damagetype_id`, `materialdamage_id`) VALUES
	(1, 'traces of a broken left stop light were found', 100, 1, 1),
	(2, 'traces of a broken left rearview mirror were found', 200, 3, 1),
	(3, 'traces of a stratxhed left door were found', 150, 5, 1),
	(4, 'broken right front window', 50, 10, 2),
	(5, 'Test', 45, 10, 2);
/*!40000 ALTER TABLE `material_damage_items` ENABLE KEYS */;

-- Dumping structure for table vehicle-insurance.vehicles
CREATE TABLE IF NOT EXISTS `vehicles` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_number` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `insured_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `insured_id` (`insured_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table vehicle-insurance.vehicles: 5 rows
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` (`id`, `brand`, `model`, `registration_number`, `insured_id`) VALUES
	(1, 'Audi', 'A4', 'VA333-333', 1),
	(2, 'BMW', 'X5l', 'BG111-111', 2),
	(3, 'Renault', 'Clio', 'SP555-666', 3),
	(4, 'Test', 'Test', 'test888', 1),
	(5, 'fsfs', 'sfsf', 'sdfsf', 1);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
