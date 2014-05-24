-- phpMyAdmin SQL Dump
-- version 3.5.8.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 24, 2014 at 08:53 AM
-- Server version: 5.5.37-MariaDB
-- PHP Version: 5.5.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `schka`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE IF NOT EXISTS `akun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `inisial` varchar(8) DEFAULT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `email`, `password`, `inisial`, `role`) VALUES
(1, 'admin@if.itb.ac.id', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, 'admin'),
(2, 'inge@informatika.org', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '23456789', 'dosen'),
(3, 'bayu@informatika.org', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '87654321', 'dosen'),
(4, 'yudis@informatika.org', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '45678901', 'dosen');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE IF NOT EXISTS `dosen` (
  `inisial` varchar(8) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `gelarDepan` varchar(20) DEFAULT NULL,
  `gelarBelakang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`inisial`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`inisial`, `nama`, `gelarDepan`, `gelarBelakang`) VALUES
('12345678', 'Rila Mandala', NULL, NULL),
('21098765', 'Adi Mulyanto', NULL, NULL),
('23456789', 'M.M Inggriani', NULL, NULL),
('32109876', 'Rinaldi Munir', NULL, NULL),
('34567890', 'M. Zuhri Catur Candra', NULL, NULL),
('43210987', 'Iping', NULL, NULL),
('45678901', 'Yudistira Asnar', NULL, NULL),
('54321098', 'Riza Satri Mandala', NULL, NULL),
('56789012', 'Christine Suryadi', NULL, NULL),
('65432109', 'Benhard Sitohang', NULL, NULL),
('67890123', 'Putri Saptawati', NULL, NULL),
('76543210', 'Fazat Nur Azizah', NULL, NULL),
('78901234', 'Sukrisno Mardiyanto', NULL, NULL),
('87654321', 'Bayu Hendrajaya', NULL, NULL),
('89012345', 'Hira Laksmiwati', NULL, NULL),
('90123456', 'Tricya Esterina Widagdo', NULL, NULL),
('98765432', 'Saiful Akbar', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `info` text NOT NULL,
  `duedate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `tanggal`, `info`, `duedate`) VALUES
(1, '2014-05-01', 'lhgcvhbjlnkml', '2014-05-06'),
(2, '2014-05-15', 'Daftar jadwal seminar', '2014-05-16'),
(3, '2014-05-09', 'penyerahan berkas KA', '2014-05-12');

-- --------------------------------------------------------

--
-- Table structure for table `jadwalDosen`
--

CREATE TABLE IF NOT EXISTS `jadwalDosen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inisialDosen` varchar(8) NOT NULL,
  `idJadwal` int(11) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `jam` time NOT NULL,
  `status` varchar(5) NOT NULL,
  `jenis` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `jadwalDosen`
--

INSERT INTO `jadwalDosen` (`id`, `inisialDosen`, `idJadwal`, `tanggal`, `jam`, `status`, `jenis`) VALUES
(1, '23456789', NULL, '2014-05-01', '08:00:00', 'close', NULL),
(2, '23456789', NULL, '2014-05-01', '08:30:00', 'close', NULL),
(3, '23456789', NULL, '2014-05-01', '10:00:00', 'open', NULL),
(4, '23456789', NULL, '2014-05-01', '11:00:00', 'open', NULL),
(5, '87654321', NULL, '2014-05-01', '08:00:00', 'open', NULL),
(6, '87654321', NULL, '2014-05-01', '08:30:00', 'close', NULL),
(7, '87654321', NULL, '2014-05-01', '10:00:00', 'open', NULL),
(8, '87654321', NULL, '2014-05-01', '11:00:00', 'open', NULL),
(9, '45678901', NULL, '2014-05-01', '08:00:00', 'open', NULL),
(10, '45678901', NULL, '2014-05-01', '08:30:00', 'open', NULL),
(11, '45678901', NULL, '2014-05-01', '10:00:00', 'open', NULL),
(12, '45678901', NULL, '2014-05-01', '11:00:00', 'open', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jadwalSeminar`
--

CREATE TABLE IF NOT EXISTS `jadwalSeminar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idKA` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jam` time NOT NULL,
  `ruang` varchar(4) DEFAULT NULL,
  `status` varchar(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `jadwalSeminar`
--

INSERT INTO `jadwalSeminar` (`id`, `idKA`, `tanggal`, `jam`, `ruang`, `status`) VALUES
(2, 118, '2014-05-01', '08:00:00', '3201', 'sidang');

-- --------------------------------------------------------

--
-- Table structure for table `jadwalSidang`
--

CREATE TABLE IF NOT EXISTS `jadwalSidang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSeminar` int(11) NOT NULL,
  `idKA` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jam` time NOT NULL,
  `ruang` varchar(10) DEFAULT NULL,
  `penguji1` varchar(8) NOT NULL,
  `penguji2` varchar(8) DEFAULT NULL,
  `status` varchar(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `jadwalSidang`
--

INSERT INTO `jadwalSidang` (`id`, `idSeminar`, `idKA`, `tanggal`, `jam`, `ruang`, `penguji1`, `penguji2`, `status`) VALUES
(3, 2, 118, '2014-05-01', '08:30:00', '3201', '87654321', NULL, 'close');

-- --------------------------------------------------------

--
-- Table structure for table `ka`
--

CREATE TABLE IF NOT EXISTS `ka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nim` varchar(8) NOT NULL,
  `pembimbing1` varchar(8) NOT NULL,
  `pembimbing2` varchar(8) DEFAULT NULL,
  `judul` varchar(255) NOT NULL,
  `topik` varchar(255) DEFAULT NULL,
  `bidang` varchar(255) DEFAULT NULL,
  `nilai` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=126 ;

--
-- Dumping data for table `ka`
--

INSERT INTO `ka` (`id`, `nim`, `pembimbing1`, `pembimbing2`, `judul`, `topik`, `bidang`, `nilai`) VALUES
(111, '23510001', '12345678', '23456789', 'Memprediksi Golongan Umur Pengguna Twitter', NULL, NULL, NULL),
(112, '23511001', '34567890', 'null', 'Aplikasi Learning To Rank Untuk Disposisi Otomatis Teks Keluhan Pada Pemerintah Kota Bandung', NULL, NULL, NULL),
(113, '23511002', '56789012', 'null', 'Pengenalan Emosi Berbasis Suara Dalam Bahasa Indonesia', NULL, NULL, NULL),
(114, '23511003', '78901234', 'null', 'Sistem Pensintesis Ucapan Bahasa Indonesia Berbasis Hidden Markov Model', NULL, NULL, NULL),
(115, '23511004', '89012345', 'null', 'Pembentukan Daftar Kata Kunci Untuk Pengklasifikasian Opini Pada Media Sosial Dengan Pendekatan Korpus', NULL, NULL, NULL),
(116, '23511005', '90123456', 'null', 'Perancangan  Limpbench dan Analisis Limplock Pada Apache Flume', NULL, NULL, NULL),
(117, '23511006', '12345678', 'null', 'Prediksi Tren Saham Dengan Metoda Moving Average Didukung Oleh Klasifikasi Berita', NULL, NULL, NULL),
(118, '23511007', '23456789', 'null', 'Klasifikasi Otoritas Teks Pendek Jejaring Sosial Twitter Untuk Pemerintah Kota Bandung', NULL, NULL, NULL),
(119, '23511008', '34567890', 'null', 'Aplikasi Pendukung Permintaan Layanan Dengan Memanfaatkan Metadata Proses', NULL, NULL, NULL),
(120, '23511009', '45678901', 'null', 'Metode Visualisasi Untuk Asosiasi Dokumen Berbasis Sequential Pattern', NULL, NULL, NULL),
(121, '23511010', '56789012', 'null', 'Pengembangan Visualisasi Interaktif Untuk Pembangkitan Peta  Penelitian', NULL, NULL, NULL),
(122, '23512001', '67890123', 'null', 'Web Content  Management  System  Pengelola  Proses  Bisnis', NULL, NULL, NULL),
(123, '23512002', '78901234', 'null', 'Perancangan  Sistem Pendukung Keputusan Dalam AI Game Dengan Logika Fuzzy', NULL, NULL, NULL),
(124, '23512003', '89012345', 'null', 'Decision Support System For Forex Forecasting (Sistem Pendukung Keputusan Peramalan Valuta Asing)', NULL, NULL, NULL),
(125, '23512004', '90123456', 'null', 'Integrasi Data Menggunakan Ontologi', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kalender`
--

CREATE TABLE IF NOT EXISTS `kalender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `jenis` varchar(7) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `kalender`
--

INSERT INTO `kalender` (`id`, `startDate`, `endDate`, `jenis`) VALUES
(1, '2014-01-01', '2014-04-30', ''),
(2, '2014-05-01', '2014-05-08', 'seminar'),
(3, '2014-05-01', '2014-05-21', 'seminar'),
(4, '2014-05-01', '2014-05-08', 'seminar'),
(5, '2014-05-01', '2014-05-10', 'seminar');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `nim` varchar(8) NOT NULL,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`) VALUES
('23510001', 'Zeb Rac Ross'),
('23511001', 'Fu Yung Hai'),
('23511002', 'Garfiled Tulang'),
('23511003', 'Hong Khong'),
('23511004', 'Ihjo Roklo'),
('23511005', 'Jung Kirba Lik'),
('23511006', 'Penja Hatwa Nita'),
('23511007', 'Qu adco Re'),
('23511008', 'Ra Jinpang Kalpan Dai'),
('23511009', 'Son Gongban Get'),
('23511010', 'Ten Dangantan Pabaya Ngan'),
('23512001', 'Andi Law'),
('23512002', 'Budimen'),
('23512003', 'Cangcimen'),
('23512004', 'Dangdut'),
('23512005', 'Eka Sihan D. Lo'),
('23512006', 'Untu Kemak Diru Mah'),
('23512007', 'Van Dalis Me'),
('23512008', 'Wongci Lik'),
('23512009', 'Xa Vi Er'),
('23512010', 'Yang Sa'),
('23513001', 'Kung Pao Panda'),
('23513002', 'Lemgi Laer Atban Get'),
('23513003', 'Mang Saha Limau'),
('23513004', 'Noac Tion'),
('23513005', 'Ong Koski Rim');

-- --------------------------------------------------------

--
-- Table structure for table `ruang`
--

CREATE TABLE IF NOT EXISTS `ruang` (
  `nama` varchar(15) NOT NULL,
  PRIMARY KEY (`nama`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruang`
--

INSERT INTO `ruang` (`nama`) VALUES
('3201'),
('3202'),
('5401'),
('5402'),
('6501'),
('6502'),
('7601'),
('7602'),
('7603'),
('7604'),
('7605'),
('7606'),
('7607'),
('7608'),
('7609'),
('7610'),
('7611'),
('7612'),
('8701'),
('8702'),
('8703'),
('8704'),
('9801'),
('9802');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
