use ToyRNotUS;

CREATE TABLE `ToyLists` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ToyName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Age` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Brand` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `AmountInStock` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `Carts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Status` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `FullName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Address1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Address2` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `City` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Province` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PostalCode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PhoneNumber` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `CartEntries` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CartID` int(11) NOT NULL,
  `ToyID` int(11) NOT NULL,
  `OrderQuantity` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CartID` (`CartID`),
  KEY `ToyID` (`ToyID`),
  CONSTRAINT `cartentries_ibfk_1` FOREIGN KEY (`CartID`) REFERENCES `Carts` (`ID`),
  CONSTRAINT `cartentries_ibfk_2` FOREIGN KEY (`ToyID`) REFERENCES `ToyLists` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
