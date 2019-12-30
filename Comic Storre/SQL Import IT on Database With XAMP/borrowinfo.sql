-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 15, 2018 at 06:15 PM
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
-- Table structure for table `borrowinfo`
--

CREATE TABLE IF NOT EXISTS `borrowinfo` (
  `borrowId` varchar(10) NOT NULL,
  `bookId` varchar(10) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `borrowDate` varchar(15) NOT NULL,
  `returnDate` varchar(15) NOT NULL,
  PRIMARY KEY (`borrowId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrowinfo`
--

INSERT INTO `borrowinfo` (`borrowId`, `bookId`, `userId`, `borrowDate`, `returnDate`) VALUES
('b001', 'Marvel003', 'Thanos', 'April 17,2018', 'April 23, 2018'),
('b002', 'DC002', 'Luthor', 'April 7,2018', 'April 13, 2018'),
('b003', 'Marvel002', 'Spiderman', 'August 21,2018', 'August 25,2018'),
('b004', 'DC001', 'Thanos', 'May 5,2018', 'May 10,2018'),
('b005', 'DC001', 'Thanos', 'June 2,2018', 'June 4,2018'),
('b006', 'DC001', 'Spiderman', 'May 1,2018', 'May 3,2018');
