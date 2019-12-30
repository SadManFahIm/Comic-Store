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
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `userId` varchar(12) NOT NULL,
  `customerName` varchar(30) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`userId`, `customerName`, `phoneNumber`, `address`) VALUES
('Dr_Strange', 'Stephen Vincent Strange', '+8801234567890', '177a Bleecker Street'),
('Antman', 'Scott Lang', '+8801234567890', 'Atlanta'),
('Starlord', 'Peter Quill', '+8801234567890', 'Missouri'),
('Whitewolf', 'Bucky Barnes', '+8801234567890', 'Wakanda'),
('Wasp', 'Janet van Dyne', '+8801234567890', 'Atlanta'),
('Deadpool', 'Wade Wilson', '+8801234567890', 'Dhaka'),
('Wolverine', 'Logan', '+8801234567890', 'Japan'),
('Daredevil', 'Matt Murdock', '+8801234567890', 'Hell''s Kitchen '),
('Powerman', 'Luke Cage', '+8801234567890', 'Harlem'),
('Ironfist', 'Danny Rand', '+8801234567890', 'K''un-Lun'),
('Punisher', 'Frank Castle', '+8801234567890', 'New York'),
('Thanos', 'Dione', '+8801234567890', 'Saturn '),
('Shazam', 'Billy Batson', '+8801234567890', 'Fawcett City'),
('Luthor', 'Alexander Luthor', '+8801234567890', 'Metropolis '),
('Joker', 'Jerome Valeska', '+8801234567890', 'Gotham'),
('Spiderman', 'Peter Parker', '+8801234567890', 'Queens');
