-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2019 at 09:16 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `gender`, `date`, `booking`) VALUES
(2, 'joao', '9361C9A09B6AF0508D4329BED3CC4D3F', '12@hhh.cmm', 'asdad', 'platinum', 0, 'Female', 20190321, 0),
(3, 'm', '602982B94E3B2B7247D9A5303393A868', '1212@fffff.fffff', 'ffff', 'silver', 0, 'Male', 20190321, 10),
(5, 'jmaia', 'F9C9EB83CBAB9600055B116DDE4548E1', 'asd@asd.com', 'asdas', 'gold', 1, 'Male', 20190321, 0),
(6, 'dd', '602982B94E3B2B7247D9A5303393A868', 'ddd@dddd.cco', 'asd', 'platinum', 1, 'Male', 20190321, 11),
(7, 'james', '602982B94E3B2B7247D9A5303393A868', 'asdasd@asd.asd', 'AAAAAA', 'platinum', 0, 'Male', 20190321, 5),
(11, 'qw', '602982B94E3B2B7247D9A5303393A868', '222@fff.fff', 'assadd', 'silver', 2, 'Male', 20190321, 0),
(12, 'kkk', 'B9E39E73E09813BABDACB1BD04227AFF', 'kkk@jok.com', 'asdhljk', 'silver', 0, 'Male', 20190326, 0),
(13, 'czxds', 'F9C9EB83CBAB9600055B116DDE4548E1', 'asd@asd.com', 'asdd', 'gold', 0, 'Male', 20190326, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members_request`
--

INSERT INTO `members_request` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `request_date`, `gender`) VALUES
(16, 'kkkas', '5404859377A5EF6DF4F3A78D12346C3DF780D2156E7FB24243DF0678B03FD177', 'kkk@jok.com', 'asdhljk', 'silver', 0, 20190326, 'Male'),
(17, 'kkkqq', '602982B94E3B2B7247D9A5303393A868', 'kjl@sd.vo', 'fsdkm', 'silver', 0, 20190328, 'Male');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
