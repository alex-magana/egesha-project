-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 10, 2015 at 05:19 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `paknav`
--

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots`
--

CREATE TABLE IF NOT EXISTS `parkinglots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `openinghour` varchar(30) NOT NULL,
  `closinghour` varchar(30) NOT NULL,
  `rate` int(30) NOT NULL,
  `ownership` varchar(30) NOT NULL,
  `capacity` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `parkinglots`
--

INSERT INTO `parkinglots` (`id`, `name`, `lat`, `lng`, `openinghour`, `closinghour`, `rate`, `ownership`, `capacity`, `available`, `is_active`) VALUES
(1, 'PATE BAY ROAD A', -1.2919856798690028, 36.82445526123047, '0700HRS', '1600HRS', 120, 'PRIVATE', 0, 0, 1),
(2, 'PATE BAY ROAD B', -1.2916853488132816, 36.82531356811523, '0700HRS', '2000HRS', 90, 'PRIVATE', 0, 0, 1),
(3, 'CHURCH PARKING', -1.2934444302059491, 36.82119369506836, '0600HRS', '2300HRS', 150, 'PRIVATE', 0, 0, 1),
(4, 'NENO CHURCH PARKING', -1.2928437684040126, 36.82149410247803, '0600HRS', '2100HRS', 70, 'PRIVATE', 0, 0, 1),
(5, 'NAIROBI RAILWAYS PARKING', -1.2918140621272183, 36.82638645172119, '0800HRS', '1800HRS', 50, 'PUBLIC', 0, 0, 1),
(6, 'WORKSHOP ROAD', -1.2911275910441806, 36.82587146759033, '0800HRS', '1900HRS', 100, 'PUBLIC', 0, 0, 1),
(7, 'CBD PARKING', -1.2909130687927064, 36.82260990142822, '0700HRS', '1900HRS', 100, 'PUBLIC', 0, 0, 1),
(8, 'EXCHANGE EXPRESS PARKING', -1.2898404572639062, 36.82870388031006, '0600HRS', '1600HRS', 200, 'PRIVATE', 0, 0, 1),
(9, 'GOVERNMENT PARKING', -1.2884675138473771, 36.82428359985352, '0600HRS', '1700HRS', 200, 'PRIVATE', 0, 0, 1),
(10, 'TAIFA ROAD PARKING', -1.2879955643769931, 36.82471275329591, '0700HRS', '2200HRS', 200, 'PRIVATE', 0, 0, 1),
(11, 'HARAMBEE AVE PARKING', -1.2869229516193281, 36.82522773742676, '0600HRS', '2200HRS', 200, 'PRIVATE', 0, 0, 1),
(12, 'KOINANGE PARKING', -1.2871160219490123, 36.82424068450928, '0600HRS', '2200HRS', 150, 'PUBLIC', 0, 0, 1),
(13, 'KENCOM PARKING GARAGE', -1.2863544666748439, 36.82539939880371, '0900HRS', '2100HRS', 150, 'PUBLIC', 0, 0, 1),
(14, 'GALLERIA PARKING', -1.3420975581429992, 36.76634788513184, '0900HRS', '2000HRS', 150, 'PRIVATE', 0, 0, 1),
(15, 'KAPS HOLY FAMILY BASILICA', -1.2874592580545707, 36.82001352310181, '0800HRS', '1800HRS', 180, 'PRIVATE', 0, 1, 1),
(16, 'TRAVEL HOUSE NAIROBI', -1.2858932429475631, 36.821537017822266, '0600HRS', '2100HRS', 120, 'PRIVATE', 0, 0, 1),
(17, 'KAPS PARKING NAKUMATT LIFESTYLE', -1.281688594896919, 36.81836128234863, '0600HRS', '2100HRS', 120, 'PRIVATE', 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_1`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_2`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_3`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_4`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_5`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_5` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_6`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_6` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_7`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_7` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_8`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_8` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_9`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_9` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_10`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_10` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_11`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_11` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_12`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_12` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_13`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_13` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_14`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_14` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_15`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_15` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `parkinglots_details_15`
--

INSERT INTO `parkinglots_details_15` (`id`, `mst_id`, `lat`, `lng`, `is_occupied`, `is_active`) VALUES
(1, 15, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_16`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_16` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots_details_17`
--

CREATE TABLE IF NOT EXISTS `parkinglots_details_17` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mst_id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `is_occupied` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mst_id` (`mst_id`),
  KEY `id` (`id`),
  KEY `mst_id_2` (`mst_id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `parkinglots_details_1`
--
ALTER TABLE `parkinglots_details_1`
  ADD CONSTRAINT `parkinglots_details_1_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_2`
--
ALTER TABLE `parkinglots_details_2`
  ADD CONSTRAINT `parkinglots_details_2_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_3`
--
ALTER TABLE `parkinglots_details_3`
  ADD CONSTRAINT `parkinglots_details_3_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_4`
--
ALTER TABLE `parkinglots_details_4`
  ADD CONSTRAINT `parkinglots_details_4_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_5`
--
ALTER TABLE `parkinglots_details_5`
  ADD CONSTRAINT `parkinglots_details_5_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_6`
--
ALTER TABLE `parkinglots_details_6`
  ADD CONSTRAINT `parkinglots_details_6_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_7`
--
ALTER TABLE `parkinglots_details_7`
  ADD CONSTRAINT `parkinglots_details_7_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_8`
--
ALTER TABLE `parkinglots_details_8`
  ADD CONSTRAINT `parkinglots_details_8_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_9`
--
ALTER TABLE `parkinglots_details_9`
  ADD CONSTRAINT `parkinglots_details_9_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_10`
--
ALTER TABLE `parkinglots_details_10`
  ADD CONSTRAINT `parkinglots_details_10_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_11`
--
ALTER TABLE `parkinglots_details_11`
  ADD CONSTRAINT `parkinglots_details_11_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_12`
--
ALTER TABLE `parkinglots_details_12`
  ADD CONSTRAINT `parkinglots_details_12_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_13`
--
ALTER TABLE `parkinglots_details_13`
  ADD CONSTRAINT `parkinglots_details_13_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_14`
--
ALTER TABLE `parkinglots_details_14`
  ADD CONSTRAINT `parkinglots_details_14_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_15`
--
ALTER TABLE `parkinglots_details_15`
  ADD CONSTRAINT `parkinglots_details_15_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`),
  ADD CONSTRAINT `parkinglots_details_15_ibfk_2` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_16`
--
ALTER TABLE `parkinglots_details_16`
  ADD CONSTRAINT `parkinglots_details_16_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`),
  ADD CONSTRAINT `parkinglots_details_16_ibfk_2` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

--
-- Constraints for table `parkinglots_details_17`
--
ALTER TABLE `parkinglots_details_17`
  ADD CONSTRAINT `parkinglots_details_17_ibfk_1` FOREIGN KEY (`mst_id`) REFERENCES `parkinglots` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
