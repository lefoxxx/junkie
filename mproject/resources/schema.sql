DROP TABLE IF EXISTS `DEAL`;

CREATE TABLE `DEAL` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `initial_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `periods` int(11) DEFAULT NULL,
  `scheduled_date` datetime DEFAULT NULL,
  `surv_schedule` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `FILE_UPLOADED`;

CREATE TABLE `FILE_UPLOADED` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) NOT NULL,
  `filesize` int(11) NOT NULL DEFAULT '0',
  `updated_on` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `sourcing_document`;
CREATE TABLE `sourcing_document` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `additionalEmailContent` varchar(255) DEFAULT NULL,
  `contactInfo` varchar(255) DEFAULT NULL,
  `dealName` varchar(255) DEFAULT NULL,
  `defaultCurrency` int(11) DEFAULT NULL,
  `defaultLanguage` int(11) DEFAULT NULL,
  `defaultUom` double DEFAULT NULL,
  `docFormat` int(11) DEFAULT NULL,
  `docNameBeginsWith` varchar(255) DEFAULT NULL,
  `docNameContains` varchar(255) DEFAULT NULL,
  `docNameEndsWith` varchar(255) DEFAULT NULL,
  `docType` varchar(255) DEFAULT NULL,
  `docYear` int(11) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `exactLocation` varchar(255) DEFAULT NULL,
  `exactLocationPassword` varchar(255) DEFAULT NULL,
  `exactLocationUserName` varchar(255) DEFAULT NULL,
  `exceptionsEmail` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `maxDepth` int(11) DEFAULT NULL,
  `nlpProcess` bit(1) DEFAULT NULL,
  `primaryUrl` varchar(255) DEFAULT NULL,
  `primaryUrlPassword` varchar(255) DEFAULT NULL,
  `primaryUrlUserName` varchar(255) DEFAULT NULL,
  `recrowlAttemptsNum` int(11) DEFAULT NULL,
  `sourceFrequency` int(11) DEFAULT NULL,
  `sourceType` int(11) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;
