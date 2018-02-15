
drop DATABASE lottery;

SET foreign_key_checks = 0;

CREATE DATABASE `lottery` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lottery`;

CREATE TABLE `tickets` (
  `username` varchar(30) NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ticket_id` int AUTO_INCREMENT NOT NULL UNIQUE,
  `iswinner` boolean default false not null,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
   `privilege` boolean, 
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` ( `username`, `password`, `privilege`) VALUES
(	'admin',	'admin', true),
(	'user1',	'password1', false),
(	'user2',	'password2', false),
(	'user3',	'password3', false);

INSERT INTO `tickets` (`username`) VALUES ("user1");
INSERT INTO `tickets` (`username`) VALUES ("user1");
INSERT INTO `tickets` (`username`) VALUES ("user2");
INSERT INTO `tickets` (`username`) VALUES ("user2");


CREATE USER 'lotteryuser'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON `lottery`.* TO 'lotteryuser'@'%' IDENTIFIED BY 'admin';