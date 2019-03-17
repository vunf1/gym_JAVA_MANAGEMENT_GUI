-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2019 at 10:07 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `membershipdb`
--
CREATE DATABASE IF NOT EXISTS `membershipdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `membershipdb`;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `membership` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `gender` varchar(20) COLLATE utf8_bin NOT NULL,
  `date` int(11) NOT NULL,
  `booking` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `gender`, `date`, `booking`) VALUES
(1, 'm', '35C92AC0288173706E2748EA251436CD', 'jokass.workplace@gma', 'street ok', 'silver', 1, '', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `members_request`
--

CREATE TABLE IF NOT EXISTS `members_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `membership` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `request_date` int(11) NOT NULL,
  `gender` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members_request`
--

INSERT INTO `members_request` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `request_date`, `gender`) VALUES
(1, 'vunf1', '6A7DDADDDF21907285421E0850F0BBEB', '1', '1', 'silver', 0, 0, ''),
(2, 'vunf2', '6A7DDADDDF21907285421E0850F0BBEB', '1', '1', 'silver', 0, 0, ''),
(3, '1', '6A7DDADDDF21907285421E0850F0BBEB', '1', '1', 'silver', 0, 0, ''),
(4, '12', '12', '12', '12', 'silver', 0, 12, ''),
(5, 'rasca@sbcglobal.net ', '28958F2B261830ACC6BBFAC30F09B3059F7B91A6724A97AC0245B3DAF9A9D147', 'rasca@sbcglobal.net ', 'rasca@sbcglobal.net ', 'silver', 0, 20190310, ''),
(6, '555', 'A5B47ADA0CECCDE5EC999DAF91267EC2', 'rasca@sbcglobal.net ', 'f', 'silver', 0, 20190310, ''),
(8, 'asdf', 'BAC7A6428E97F62748E17111D1857341', 'ssss@vlll.com ', 'sdad', 'silver', 0, 20190310, ''),
(9, 'heine@live.com ', 'C5B0AF00CE2F40BD43C7DE0A4E6299BA', 'heine@live.com', 'heine@live.com ', 'silver', 0, 20190310, '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
