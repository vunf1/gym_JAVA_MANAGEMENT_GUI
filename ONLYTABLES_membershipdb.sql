-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2019 at 05:58 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `id` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `membership` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `gender` varchar(20) COLLATE utf8_bin NOT NULL,
  `date` int(11) NOT NULL,
  `booking` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `username`, `password`, `email`, `address`, `membership`, `status`, `gender`, `date`, `booking`) VALUES
(2, 'joao', '9361C9A09B6AF0508D4329BED3CC4D3F', '12@hhh.cmm', 'asdad', 'platinum', 0, 'Female', 20190321, 0),
(3, 'm', '602982B94E3B2B7247D9A5303393A868', '1212@fffff.COM', 'SSS', 'gold', 0, 'Male', 20190329, 10),
(5, 'jmaia', 'F9C9EB83CBAB9600055B116DDE4548E1', 'asd@asd.com', 'asdas', 'gold', 1, 'Male', 20190321, 0),
(7, 'james', '602982B94E3B2B7247D9A5303393A868', 'asdasd@asd.asd', 'AAAAAA', 'platinum', 0, 'Male', 20190321, 5),
(12, 'qw', '602982B94E3B2B7247D9A5303393A868', 'jokass@gmail.com', 'King Richard Street', 'silver', 2, 'Male', 20190326, 3),
(14, 'joaquim', '09DA6AE0B00D95885192B547637BFE3B', 'joaquim@gmail.com', 'Street Road', 'silver', 0, 'Male', 20190329, 0);

-- --------------------------------------------------------

--
-- Table structure for table `members_request`
--

CREATE TABLE `members_request` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `membership` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `request_date` int(11) NOT NULL,
  `gender` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `members_request`
--
ALTER TABLE `members_request`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `members_request`
--
ALTER TABLE `members_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
