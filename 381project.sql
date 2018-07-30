-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2016 at 12:54 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `381project`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `ID` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `book` text NOT NULL,
  `year` year(4) NOT NULL,
  `EndReceiveReqDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`ID`, `name`, `description`, `book`, `year`, `EndReceiveReqDate`) VALUES
(102, 'slm', 'des1', 'book1', 2017, '2016-12-31'),
(212, 'csc', 'des1', 'book1', 2017, '0000-00-00'),
(554, 'jk', 'gh', 'sa', 2017, '2016-12-19'),
(888, 'sjamhn', 'trfgh', 'vbnmn', 2017, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `coursestudentid`
--

CREATE TABLE `coursestudentid` (
  `courseID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coursestudentid`
--

INSERT INTO `coursestudentid` (`courseID`, `studentID`) VALUES
(102, 435201094);

-- --------------------------------------------------------

--
-- Table structure for table `homework`
--

CREATE TABLE `homework` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `file` varchar(1000) NOT NULL,
  `file_size` int(10) NOT NULL,
  `file_type` varchar(300) NOT NULL,
  `description` text NOT NULL,
  `deadline` date NOT NULL,
  `courseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `homework`
--

INSERT INTO `homework` (`ID`, `Name`, `file`, `file_size`, `file_type`, `description`, `deadline`, `courseID`) VALUES
(1, 'hw1csc', '64050-icon-2.pdf', 466, 'application/pdf', 'g', '2016-12-17', 212),
(2, 'ljh', '15305-icon-3.pdf', 375, 'application/pdf', 'llk', '2016-12-07', 212),
(3, 'lka', '43708-icon-2.pdf', 466, 'application/pdf', '894', '2016-12-20', 102),
(4, 'hgdh', '52872-planner.pdf', 804, 'application/pdf', '009', '2016-12-13', 102);

-- --------------------------------------------------------

--
-- Table structure for table `requests`
--

CREATE TABLE `requests` (
  `ReqID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `teacherID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Firstname` text NOT NULL,
  `Lastname` text NOT NULL,
  `ID` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Firstname`, `Lastname`, `ID`, `email`, `password`) VALUES
('afnan', 's', 222333222, 'rrr@gmail.com', 'qqqqqqqqq'),
('noon', 'k', 435201094, 'roorooroory@gmail.com', 'rooony100');

-- --------------------------------------------------------

--
-- Table structure for table `submittedhomeworks`
--

CREATE TABLE `submittedhomeworks` (
  `file` varchar(1000) NOT NULL,
  `submittedHWID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `HWID` int(11) NOT NULL,
  `teacherID` int(11) NOT NULL,
  `studentsubmitdate` date NOT NULL,
  `grade` double NOT NULL,
  `file_type` varchar(200) NOT NULL,
  `size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `submittedhomeworks`
--

INSERT INTO `submittedhomeworks` (`file`, `submittedHWID`, `studentID`, `HWID`, `teacherID`, `studentsubmitdate`, `grade`, `file_type`, `size`) VALUES
('icon.pdf', 1, 222333222, 0, 435203893, '2016-12-15', 8, 'pdf', 2);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `Firstname` text NOT NULL,
  `LastName` text NOT NULL,
  `ID` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`Firstname`, `LastName`, `ID`, `email`, `password`) VALUES
('sara', 'alsaif', 435201099, 'sara96alsaif@gmail.com', 'sara1416'),
('rawan', 'alsagheer', 435203893, 'tr.rawanalsagheer@hotmail.com', 'rrrrrrrrr');

-- --------------------------------------------------------

--
-- Table structure for table `teachercourseid`
--

CREATE TABLE `teachercourseid` (
  `teacherID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teachercourseid`
--

INSERT INTO `teachercourseid` (`teacherID`, `courseID`) VALUES
(435203893, 102),
(435203893, 212),
(435203893, 554),
(435203893, 888);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `coursestudentid`
--
ALTER TABLE `coursestudentid`
  ADD PRIMARY KEY (`courseID`,`studentID`);

--
-- Indexes for table `homework`
--
ALTER TABLE `homework`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `courseID` (`courseID`);

--
-- Indexes for table `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`ReqID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `submittedhomeworks`
--
ALTER TABLE `submittedhomeworks`
  ADD PRIMARY KEY (`submittedHWID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `teachercourseid`
--
ALTER TABLE `teachercourseid`
  ADD PRIMARY KEY (`teacherID`,`courseID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `homework`
--
ALTER TABLE `homework`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `requests`
--
ALTER TABLE `requests`
  MODIFY `ReqID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `submittedhomeworks`
--
ALTER TABLE `submittedhomeworks`
  MODIFY `submittedHWID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
