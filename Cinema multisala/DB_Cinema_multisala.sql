-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cinema_multisala
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cinema_multisala` ;

-- -----------------------------------------------------
-- Schema cinema_multisala
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinema_multisala` DEFAULT CHARACTER SET utf8 ;
USE `cinema_multisala` ;

-- -----------------------------------------------------
-- Table `cinema_multisala`.`film`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`film` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`film` (
  `titolo` VARCHAR(45) NOT NULL,
  `data` TIMESTAMP NOT NULL,
  `ora_inizio` TIME NOT NULL,
  `descrizione` VARCHAR(450) NOT NULL,
  `cast` VARCHAR(450) NOT NULL,
  `immagine` MEDIUMBLOB,
  `regista` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`titolo`, `data`, `ora_inizio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`persona` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`persona` (
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `ruolo` ENUM('UTENTE', 'DIPENDENTE', 'ADMIN') NOT NULL,
  PRIMARY KEY (`mail`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`posto_a_sedere`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`posto_a_sedere` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`posto_a_sedere` (
  `numero_posto` INT NOT NULL,
  `numero_fila` INT NOT NULL,
  `numero_sala` INT NOT NULL,
  PRIMARY KEY (`numero_fila`, `numero_posto`, `numero_sala`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`prenotazione`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`prenotazione` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`prenotazione` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mail_prenotazione` VARCHAR(45) NOT NULL,
  `film` VARCHAR(45) NOT NULL,
  `data` TIMESTAMP NOT NULL,
  `orario` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mail_prenotazione_idx` (`mail_prenotazione` ASC) VISIBLE,
  INDEX `fk_film_idx` (`film` ASC, `data` ASC, `orario` ASC) VISIBLE,
  CONSTRAINT `fk_film`
    FOREIGN KEY (`film` , `data` , `orario`)
    REFERENCES `cinema_multisala`.`film` (`titolo` , `data` , `ora_inizio`),
  CONSTRAINT `fk_mail_prenotazione`
    FOREIGN KEY (`mail_prenotazione`)
    REFERENCES `cinema_multisala`.`persona` (`mail`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`posti_prenotazione`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`posti_prenotazione` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`posti_prenotazione` (
  `id_prenotazione` INT NOT NULL,
  `fila` INT NOT NULL,
  `posto` INT NOT NULL,
  `sala` INT NOT NULL,
  PRIMARY KEY (`id_prenotazione`),
  INDEX `fk_posto_idx` (`posto` ASC, `fila` ASC, `sala` ASC) VISIBLE,
  INDEX `fk_posto` (`fila` ASC, `posto` ASC, `sala` ASC) VISIBLE,
  CONSTRAINT `fk_posto`
    FOREIGN KEY (`fila` , `posto` , `sala`)
    REFERENCES `cinema_multisala`.`posto_a_sedere` (`numero_fila` , `numero_posto` , `numero_sala`),
  CONSTRAINT `fk_prenotazione`
    FOREIGN KEY (`id_prenotazione`)
    REFERENCES `cinema_multisala`.`prenotazione` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
