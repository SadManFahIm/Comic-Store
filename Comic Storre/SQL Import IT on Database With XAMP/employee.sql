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
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `userId` varchar(12) NOT NULL,
  `employeeName` varchar(50) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `role` varchar(10) NOT NULL,
  `salary` double(8,2) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`userId`, `employeeName`, `phoneNumber`, `role`, `salary`) VALUES
('Batman', 'Bruce Wayne', '+8801234567890', 'Manager', 50000.00),
('Superman', 'Clark Kent ', '+8801234567890', 'Manager', 50000.00),
('Captain', 'Steve Rogers', '+8801234567890', 'Manager', 50000.00),
('Ironman', 'Tony Stark', '+8801234567890', 'Manager', 50000.00),
('Widow', 'Natasha Romanoff', '+8801234567890', 'Emplolyee', 20000.00),
('Aquaman', 'Arthur Curry ', '+8801234567890', 'Emplolyee', 20000.00),
('Lantern', 'Hal Jordan', '+8801234567890', 'Emplolyee', 20000.00),
('Cyborg', 'Victor Stone', '+8801234567890', 'Emplolyee', 20000.00),
('Hawkeye', 'Clint Barton', '+8801234567890', 'Emplolyee', 20000.00),
('Thor', 'Thor Odinson', '+8801234567890', 'Emplolyee', 20000.00),
('Hulk', 'Bruce Banner ', '+8801234567890', 'Emplolyee', 20000.00),
('Flash', 'Barry Allen ', '+8801234567890', 'Emplolyee', 20000.00),
('Wonderwoman', 'Diana Prince', '+8801234567890', 'Emplolyee', 20000.00);
