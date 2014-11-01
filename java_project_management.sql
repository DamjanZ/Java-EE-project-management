-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 02, 2014 at 04:20 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `korisnikID` int(11) NOT NULL,
  `username` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ime` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(225) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`korisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnikID`, `username`, `password`, `ime`, `prezime`, `email`, `avatar`) VALUES
(0, 'Username', 'username', 'ime', 'ime', 'ime@ime.com', NULL),
(1, 'damjan', 'damjan12', 'Damjan', 'Zamaklar', 'zdamjan90@gmail.com', NULL),
(2, 'pera', 'pera12', 'Pera', 'Peric', 'pera.peric@perice.com', NULL),
(3, 'noviKorisnik12', 'noviKorisnik12', 'Novi', 'korisnik12', 'asd@dsa.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mesto`
--

CREATE TABLE IF NOT EXISTS `mesto` (
  `ptt` int(5) NOT NULL,
  `naziv` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `mesto`
--

INSERT INTO `mesto` (`ptt`, `naziv`) VALUES
(11000, 'Beograd'),
(11070, 'Novi Beograd'),
(11080, 'Zemun'),
(18000, 'Niš'),
(21000, 'Novi Sad'),
(32000, 'Čačak'),
(34000, 'Kragujevac');

-- --------------------------------------------------------

--
-- Table structure for table `projekat`
--

CREATE TABLE IF NOT EXISTS `projekat` (
  `idProjekta` int(11) NOT NULL,
  `nazivProjekta` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `opisProjekta` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `datumPocetka` date NOT NULL,
  `datumRealizacije` date NOT NULL,
  `aktuelan` tinyint(1) NOT NULL DEFAULT '1',
  `finansijska_sredstva` decimal(19,4) NOT NULL,
  `korisnikID` int(11) NOT NULL,
  PRIMARY KEY (`idProjekta`),
  KEY `korisnikID` (`korisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `projekat`
--

INSERT INTO `projekat` (`idProjekta`, `nazivProjekta`, `opisProjekta`, `datumPocetka`, `datumRealizacije`, `aktuelan`, `finansijska_sredstva`, `korisnikID`) VALUES
(2, 'Projekat2', 'Opis2', '2013-07-28', '2013-09-13', 0, 0.0000, 2),
(3, 'Projekat3', 'Ovo je neki kratak opis projekta.', '2013-08-07', '2013-10-07', 1, 50000.0000, 2),
(4, 'Projekat(promenjen)', 'Opis projekta tralalala', '2013-05-05', '2013-06-06', 0, 0.0000, 2),
(5, 'adsasd', 'asdsdaasddsa', '2013-01-01', '2013-01-02', 0, 0.0000, 2),
(6, 'Projekat52', 'Opis projekta', '2013-05-05', '2013-10-05', 1, 0.0000, 2),
(7, 'Projekat Od Damjana', 'Damjan pravi projekat', '2013-05-05', '2013-12-05', 1, 0.0000, 1),
(8, 'Projekat1', 'Opis projekta', '2013-11-11', '2013-11-12', 0, 0.0000, 2),
(9, 'Uvoz i promocija proizvoda "Electrolux"', 'Na tržištu se pojavio novi frižider marke “Electrolux”, model “ZX 750” sa najnovijom tehnologijom “UPS” (Unlimited Power Supply), tehnologija koja omogu?ava da frižider neometano radi i nakon nestanka struje u trajanju od 24h.\nZa ovim frižiderom vlada veliko interesovanje, pa prodavnica “Centar bele tehnike” želi da ponudi potroša?ima za sebe najbolju cenu, kako bi pove?ala svoj udeo na tržištu bele tehnike.\nGlavni konkurent “Centra bele tehnike” je lanac prodavnica “Tehnomanija”, te je cilj “Centra bele tehnike” da postavi takvu cenu da ve?ina potroša?a kupi baš od njih pomenuti frižider, što bi dosta uticalo na tržišni udeo. Trenutno, “Centar bele tehnike” zauzima 40% tržišnog udela u prodaji frižidera, naspram 60% koliko drži “Tehnomanija”. S obzirom da je “Centar bele tehnike” mlada prodavnica, tj. da “Tehnomanija” uživa poverenje ve?eg broja potroša?a, treba imati u vidu da ljudi imaju ve?e poverenje u lanac prodavnica “Tehnomanija”, te ?eš?e kupuju u istom ukoliko su cena i uslovi prodaje sli?ni.\nKompanija “Electrolux” je prodava?ima je za model “ZX 750” navela cenu od 50.000rsd kao preporu?enu cenu.\nBudžet za realizaciju projekta iznosi 20.000e\n', '2013-07-20', '2013-08-29', 1, 0.0000, 2),
(10, 'Nekakav projekat', 'Neko i nesto', '2013-11-12', '2013-11-18', 1, 0.0000, 2),
(11, 'novi', 'nova', '2014-08-29', '2014-08-31', 1, 5000.0000, 3),
(12, 'Projekat 2014', 'Opis', '2014-09-03', '2014-09-17', 1, 50000.0000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sastanak`
--

CREATE TABLE IF NOT EXISTS `sastanak` (
  `idSastanka` int(11) NOT NULL,
  `datumSastanka` date DEFAULT NULL,
  `temaSastanka` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `izvestaj` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `idProjekta` int(11) NOT NULL,
  `prostorija` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idSastanka`),
  KEY `idProjekta` (`idProjekta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sastanak`
--

INSERT INTO `sastanak` (`idSastanka`, `datumSastanka`, `temaSastanka`, `izvestaj`, `idProjekta`, `prostorija`) VALUES
(1, '2014-08-20', 'ads', 'asd', 2, 'das'),
(2, '2014-09-03', 'Tema sastanka', 'Izvestaj', 2, 'a101');

-- --------------------------------------------------------

--
-- Table structure for table `ucesce`
--

CREATE TABLE IF NOT EXISTS `ucesce` (
  `idZaposlenog` int(11) NOT NULL,
  `idProjekta` int(11) NOT NULL,
  `zaduzenja` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idUcesca` int(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUcesca`),
  KEY `idZaposlenog` (`idZaposlenog`,`idProjekta`),
  KEY `idProjekta` (`idProjekta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=13 ;

--
-- Dumping data for table `ucesce`
--

INSERT INTO `ucesce` (`idZaposlenog`, `idProjekta`, `zaduzenja`, `idUcesca`) VALUES
(0, 7, 'Dodajem ti zaduzenje Maro', 1),
(1, 7, 'Dodajem ti zaduzenje Jovicu', 2),
(1, 8, 'Strategise', 3),
(2, 8, 'Istrazuje i razvija', 4),
(5, 8, 'Nosi kafu', 5),
(6, 8, 'Transport robe', 6),
(0, 9, 'Odnos sa firmama.', 7),
(1, 9, 'Plan strat. realizacije projekta.', 8),
(2, 9, 'Pronalaženje potencijalnih mušterija.', 9),
(5, 9, 'Upravljanje i kontrola svim procesima.', 10),
(7, 9, 'Kreiranje novog sajta.', 11),
(0, 12, 'PR', 12);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE IF NOT EXISTS `zaposleni` (
  `idZaposlenog` int(11) NOT NULL,
  `ime` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `zaposlen` tinyint(1) NOT NULL DEFAULT '1',
  `pol` varchar(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'M',
  `pozicija` varchar(220) COLLATE utf8_unicode_ci NOT NULL,
  `datumZaposlenja` date NOT NULL,
  `telefon` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ptt` int(5) NOT NULL,
  `datumRodjenja` date NOT NULL,
  `ulica` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brojUlice` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idZaposlenog`),
  KEY `ptt` (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`idZaposlenog`, `ime`, `prezime`, `zaposlen`, `pol`, `pozicija`, `datumZaposlenja`, `telefon`, `ptt`, `datumRodjenja`, `ulica`, `brojUlice`) VALUES
(0, 'Mara', 'Marjanovic', 1, 'M', 'PR', '2009-05-04', '11123456', 11070, '1980-08-31', 'Bulevar Zorana ÄinÄiÄa', '23'),
(1, 'Neko', 'Nasod', 1, 'Z', 'asd', '2014-08-17', '111234', 11000, '2014-08-17', 'ads', '12'),
(2, 'Milan', 'Deretić', 1, 'M', 'Menadžer I&R', '2009-05-20', '65483197', 34000, '1980-03-27', 'Banatska', '11'),
(3, 'Neda', 'Karanović', 1, 'Ž', 'Menadžer ljudskih resursa', '2012-05-22', '611234567', 11000, '1985-06-08', 'Pregrevica', '50'),
(4, 'Petar', 'Petrović', 1, 'M', 'Community menadžer', '2008-02-02', '11123456', 11000, '1990-01-29', 'Moše Pijade', '42'),
(5, 'Pera', 'Petrusić', 1, 'M', 'Menadžer kvaliteta', '2000-05-05', '113214567', 11000, '1970-11-10', 'Džona Kenedija', '4d'),
(6, 'Damir', 'Dodović', 1, 'M', 'Menadzer logistike', '2009-05-05', '18111111', 21000, '1980-11-10', 'Neka', '55'),
(7, 'Miodrag', 'Milutinović', 1, 'M', 'Programer', '2012-07-20', '113130288', 11080, '1987-05-17', 'Goce Delčeva', '71'),
(8, 'Pera', 'Peric', 0, 'M', 'Neka pozicija', '2014-09-02', '011301345', 11000, '1990-02-09', 'Ulica', '11');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `projekat`
--
ALTER TABLE `projekat`
  ADD CONSTRAINT `projekat_ibfk_1` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`) ON UPDATE CASCADE;

--
-- Constraints for table `sastanak`
--
ALTER TABLE `sastanak`
  ADD CONSTRAINT `sastanak_ibfk_1` FOREIGN KEY (`idProjekta`) REFERENCES `projekat` (`idProjekta`) ON UPDATE CASCADE;

--
-- Constraints for table `ucesce`
--
ALTER TABLE `ucesce`
  ADD CONSTRAINT `ucesce_ibfk_5` FOREIGN KEY (`idZaposlenog`) REFERENCES `zaposleni` (`idZaposlenog`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `ucesce_ibfk_6` FOREIGN KEY (`idProjekta`) REFERENCES `projekat` (`idProjekta`) ON UPDATE NO ACTION;

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `zaposleni_ibfk_1` FOREIGN KEY (`ptt`) REFERENCES `mesto` (`ptt`) ON UPDATE CASCADE;
