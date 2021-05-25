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
-- Table `cinema_multisala`.`sala`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`sala` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`sala` (
  `id` INT NOT NULL,
  `numero_sala` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


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
  `immagine` MEDIUMBLOB NOT NULL,
  `regista` VARCHAR(45) NOT NULL,
  `sala` INT NOT NULL,
  PRIMARY KEY (`titolo`, `data`, `ora_inizio`),
  INDEX `fk_sala_idx` (`sala` ASC) VISIBLE,
  CONSTRAINT `fk_sala`
    FOREIGN KEY (`sala`)
    REFERENCES `cinema_multisala`.`sala` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`persona` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`persona` (
  `mail` VARCHAR(45) NOT NULL,
  `password` CHAR(68) NOT NULL,
  PRIMARY KEY (`mail`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`ruolo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`ruolo` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`ruolo` (
  `id` INT NOT NULL,
  `nome_ruolo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`persona_ruolo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`persona_ruolo` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`persona_ruolo` (
  `mail` VARCHAR(45) NOT NULL,
  `id_ruolo` INT NOT NULL,
  PRIMARY KEY (`mail`, `id_ruolo`),
  INDEX `fk_ruolo_idx` (`id_ruolo` ASC) VISIBLE,
  CONSTRAINT `fk_persona`
    FOREIGN KEY (`mail`)
    REFERENCES `cinema_multisala`.`persona` (`mail`),
  CONSTRAINT `fk_ruolo`
    FOREIGN KEY (`id_ruolo`)
    REFERENCES `cinema_multisala`.`ruolo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`posto_a_sedere`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`posto_a_sedere` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`posto_a_sedere` (
  `sala` INT NOT NULL,
  `fila` VARCHAR(45) NOT NULL,
  `numero_posto` INT NOT NULL,
  PRIMARY KEY (`sala`, `fila`, `numero_posto`),
  INDEX `fk_sala_idx` (`sala` ASC) VISIBLE,
  CONSTRAINT `fk_sala_posto`
    FOREIGN KEY (`sala`)
    REFERENCES `cinema_multisala`.`sala` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cinema_multisala`.`posti_prenotazione`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cinema_multisala`.`posti_prenotazione` ;

CREATE TABLE IF NOT EXISTS `cinema_multisala`.`posti_prenotazione` (
  `id_prenotazione` INT NOT NULL,
  `sala` INT NOT NULL,
  `fila` VARCHAR(45) NOT NULL,
  `posto` INT NOT NULL,
  PRIMARY KEY (`id_prenotazione`, `sala`, `fila`, `posto`),
  INDEX `fk_posto_idx` (`sala` ASC, `fila` ASC, `posto` ASC) VISIBLE,
  CONSTRAINT `fk_posto`
    FOREIGN KEY (`sala` , `fila` , `posto`)
    REFERENCES `cinema_multisala`.`posto_a_sedere` (`sala` , `fila` , `numero_posto`),
  CONSTRAINT `fk_prenotazione`
    FOREIGN KEY (`id_prenotazione`)
    REFERENCES `cinema_multisala`.`prenotazione` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
