-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 15, 2018 at 06:16 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `m1`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(5) NOT NULL,
  `status` int(1) NOT NULL,
  UNIQUE KEY `userId` (`userId`),
  UNIQUE KEY `userId_5` (`userId`),
  KEY `userId_2` (`userId`),
  KEY `userId_3` (`userId`),
  KEY `userId_4` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('Batman', '12345', 0),
('Superman', '12345', 0),
('Captain', '12345', 0),
('Ironman', '12345', 0),
('Widow', '12345', 0),
('Aquaman', '12345', 0),
('Lantern', '12345', 0),
('Cyborg', '12345', 0),
('Hawkeye', '12345', 0),
('Thor', '12345', 0),
('Hulk', '12345', 0),
('Flash', '12345', 0),
('Wonderwoman', '12345', 0),
('Dr_Strange', '12345', 1),
('Antman', '12345', 1),
('Starlord', '12345', 1),
('Whitewolf', '12345', 1),
('Wasp', '12345', 1),
('Deadpool', '12345', 1),
('Wolverine', '12345', 1),
('Daredevil', '12345', 1),
('Powerman', '12345', 1),
('Ironfist', '12345', 1),
('Punisher', '12345', 1),
('Thanos', '12345', 1),
('Shazam', '12345', 1),
('Luthor', '12345', 1),
('Joker', '12345', 1),
('Spiderman', '12345', 1);
