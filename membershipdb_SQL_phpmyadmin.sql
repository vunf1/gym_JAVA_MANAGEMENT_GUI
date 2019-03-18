-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2019 at 04:14 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

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

DROP TABLE IF EXISTS `members`;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `gender`, `date`, `booking`) VALUES
(1, 'm', '35C92AC0288173706E2748EA251436CD', 'jokass.workplace@gma', 'street ok', 'silver', 1, '', 0, NULL),
(2, 'mm', '602982B94E3B2B7247D9A5303393A868', 'stefano@outlook.com', '2323wew', 'silver', 1, 'Male', 20190318, NULL),
(3, 'ola', '602982B94E3B2B7247D9A5303393A868', 'stefano@outlook.com', 'DSASS', 'gold', 1, 'Male', 20190318, 0);

-- --------------------------------------------------------

--
-- Table structure for table `members_request`
--

DROP TABLE IF EXISTS `members_request`;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members_request`
--

INSERT INTO `members_request` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `request_date`, `gender`) VALUES
(10, 'ddd', '0175B116507C40A403B131FFB822F7FC', 'stefano@outlook.com', '333', 'silver', 0, 20190318, 'Male');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
