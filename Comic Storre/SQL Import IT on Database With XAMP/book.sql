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
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `bookId` varchar(15) NOT NULL,
  `bookTitle` varchar(50) NOT NULL,
  `authorName` varchar(50) NOT NULL,
  `publicationYear` int(4) NOT NULL,
  `availableQuantity` int(3) NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `bookTitle`, `authorName`, `publicationYear`, `availableQuantity`) VALUES
('Marvel001', 'Civil War', 'Mark Miller', 2006, 23),
('Marvel002', 'Secret Invasion', 'Brian Michael Bendis', 2008, 14),
('Marvel003', 'The Infinity Gauntlet', 'Jim Starlin', 1991, 6),
('DC001', 'Flashpoint', 'Geoff Johns', 2011, 11),
('DC002', 'The Death of Superman', 'Dan Jurgens', 1993, 28);
