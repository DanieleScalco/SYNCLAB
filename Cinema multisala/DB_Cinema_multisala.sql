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
-- Table `cinema_multisala`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`persona` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`persona` (
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `ruolo` ENUM('UTENTE', 'DIPENDENTE', 'ADMIN') NOT NULL,
  PRIMARY KEY (`mail`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`film`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`film` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`film` (
  `titolo` VARCHAR(45) NOT NULL,
  `data` DATE NOT NULL,
  `ora_inizio` TIME NOT NULL,
  `descrizione` VARCHAR(45) NULL,
  `cast` VARCHAR(45) NULL,
  `immagine` VARCHAR(45) NULL,
  `regista` VARCHAR(45) NULL,
  PRIMARY KEY (`titolo`, `data`, `ora_inizio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`posto_a_sedere`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`posto_a_sedere` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`posto_a_sedere` (
  `numero_fila` INT NOT NULL,
  `numero_posto` INT NOT NULL,
  `numero_sala` INT NOT NULL,
  PRIMARY KEY (`numero_fila`, `numero_posto`, `numero_sala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`prenotazione`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`prenotazione` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`prenotazione` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome_prenotazione` VARCHAR(45) NOT NULL,
  `film` VARCHAR(45) NOT NULL,
  `data` DATE NOT NULL,
  `orario` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mail_prenotazione_idx` (`nome_prenotazione` ASC) VISIBLE,
  INDEX `fk_film_idx` (`film` ASC, `data` ASC, `orario` ASC) VISIBLE,
  CONSTRAINT `fk_mail_prenotazione`
    FOREIGN KEY (`nome_prenotazione`)
    REFERENCES `cinema_multisala`.`persona` (`mail`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_film`
    FOREIGN KEY (`film` , `data` , `orario`)
    REFERENCES `cinema_multisala`.`film` (`titolo` , `data` , `ora_inizio`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


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
  CONSTRAINT `fk_prenotazione`
    FOREIGN KEY (`id_prenotazione`)
    REFERENCES `cinema_multisala`.`prenotazione` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_posto`
    FOREIGN KEY (`fila` , `posto` , `sala`)
    REFERENCES `cinema_multisala`.`posto_a_sedere` (`numero_fila` , `numero_posto` , `numero_sala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;