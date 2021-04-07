-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CinemaMultisala
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CinemaMultisala
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CinemaMultisala` DEFAULT CHARACTER SET utf8 ;
USE `CinemaMultisala` ;

-- -----------------------------------------------------
-- Table `CinemaMultisala`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaMultisala`.`Persona` (
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `ruolo` ENUM('UTENTE', 'DIPENDENTE', 'ADMIN') NOT NULL,
  PRIMARY KEY (`mail`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaMultisala`.`Film`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaMultisala`.`Film` (
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
-- Table `CinemaMultisala`.`Posto_a_sedere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaMultisala`.`Posto_a_sedere` (
  `numero_fila` INT NOT NULL,
  `numero_posto` INT NOT NULL,
  `numero_sala` INT NOT NULL,
  PRIMARY KEY (`numero_fila`, `numero_posto`, `numero_sala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaMultisala`.`Prenotazione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaMultisala`.`Prenotazione` (
  `id` INT NOT NULL,
  `nome_prenotazione` VARCHAR(45) NULL,
  `film` VARCHAR(45) NULL,
  `data` DATE NULL,
  `orario` TIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mail_prenotazione_idx` (`nome_prenotazione` ASC) VISIBLE,
  INDEX `fk_film_idx` (`film` ASC) VISIBLE,
  INDEX `fk_data_idx` (`data` ASC) VISIBLE,
  INDEX `fk_ora_idx` (`orario` ASC) VISIBLE,
  CONSTRAINT `fk_mail_prenotazione`
    FOREIGN KEY (`nome_prenotazione`)
    REFERENCES `CinemaMultisala`.`Persona` (`mail`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_film`
    FOREIGN KEY (`film`)
    REFERENCES `CinemaMultisala`.`Film` (`titolo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_data`
    FOREIGN KEY (`data`)
    REFERENCES `CinemaMultisala`.`Film` (`data`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ora`
    FOREIGN KEY (`orario`)
    REFERENCES `CinemaMultisala`.`Film` (`ora_inizio`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaMultisala`.`Posti_prenotazione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaMultisala`.`Posti_prenotazione` (
  `id_prenotazione` INT NOT NULL,
  `fila` INT NULL,
  `posto` INT NULL,
  `sala` INT NULL,
  PRIMARY KEY (`id_prenotazione`),
  INDEX `fk_fila_idx` (`fila` ASC) VISIBLE,
  INDEX `fk_sala_idx` (`sala` ASC) VISIBLE,
  INDEX `fk_posto_idx` (`posto` ASC) VISIBLE,
  CONSTRAINT `fk_prenotazione`
    FOREIGN KEY (`id_prenotazione`)
    REFERENCES `CinemaMultisala`.`Prenotazione` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_fila`
    FOREIGN KEY (`fila`)
    REFERENCES `CinemaMultisala`.`Posto_a_sedere` (`numero_fila`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_posto`
    FOREIGN KEY (`posto`)
    REFERENCES `CinemaMultisala`.`Posto_a_sedere` (`numero_posto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sala`
    FOREIGN KEY (`sala`)
    REFERENCES `CinemaMultisala`.`Posto_a_sedere` (`numero_sala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
