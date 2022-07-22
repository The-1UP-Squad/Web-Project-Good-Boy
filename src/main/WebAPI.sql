-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema WebAPI
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema WebAPI
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `WebAPI` DEFAULT CHARACTER SET utf8 ;
USE `WebAPI` ;

-- -----------------------------------------------------
-- Table `WebAPI`.`Employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebAPI`.`Employees` (
  `EmpID` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Email_address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`EmpID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebAPI`.`Projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebAPI`.`Projects` (
  `ProID` INT NOT NULL AUTO_INCREMENT,
  `Project` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ProID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebAPI`.`ServiceLine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebAPI`.`ServiceLine` (
  `ServID` INT NOT NULL AUTO_INCREMENT,
  `ServLine` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ServID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebAPI`.`Employees_has_Projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebAPI`.`Employees_has_Projects` (
  `Employees_EmpID` INT NOT NULL,
  `Projects_ProID` INT NOT NULL,
  `ServiceLine_ServID` INT NOT NULL,
  PRIMARY KEY (`Employees_EmpID`, `Projects_ProID`, `ServiceLine_ServID`),
  INDEX `fk_Employees_has_Projects_Projects1_idx` (`Projects_ProID` ASC) VISIBLE,
  INDEX `fk_Employees_has_Projects_Employees_idx` (`Employees_EmpID` ASC) VISIBLE,
  INDEX `fk_Employees_has_Projects_ServiceLine1_idx` (`ServiceLine_ServID` ASC) VISIBLE,
  CONSTRAINT `fk_Employees_has_Projects_Employees`
    FOREIGN KEY (`Employees_EmpID`)
    REFERENCES `WebAPI`.`Employees` (`EmpID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Employees_has_Projects_Projects1`
    FOREIGN KEY (`Projects_ProID`)
    REFERENCES `WebAPI`.`Projects` (`ProID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Employees_has_Projects_ServiceLine1`
    FOREIGN KEY (`ServiceLine_ServID`)
    REFERENCES `WebAPI`.`ServiceLine` (`ServID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE Employees AUTO_INCREMENT=11111;

insert into Employees ( First_Name, Last_Name, Email_Address)
values ( 'Dominic', 'Priest', 'Dominic@Priest.com'), ( 'Arthur', 'Gonzalez', 'Arthur@Gonzalez.com'),( 'Matthew', 'Cockram', 'Matthew@Cockram.com'),( 'Galen', 'Lalor', 'Galen@Lalor.com'),( 'Matthew', 'Thatcher', 'Matthew@Thatcher.com'),( 'Nicholas', 'Tocchetti', 'Nicholas@Tocchetti.com'),( 'Jordan', 'Wilson', 'Jordan@Wilson.com'),( 'Vincent', 'Tran', 'Vincent@Tran.com'), ( 'Matthew', 'Furlan', 'Matthew@Furlan.com');

 insert into Projects (Project)
 values ('SevenWest'), ('NAB'),('BHP'),('SRG'),('SevenWest - Support'),('ANZ'),('Woolworths - Digital');
 
 insert into ServiceLine (ServLine)
 values ('Azure'), ('Database'),('Python'),('Java'),('C#'),('People and Culture'),('Consultant'),('Client'),('IT');
 
 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT projects.project, Employees.Email_Address FROM Employees
INNER JOIN projects ON Employees.EmpID = projects.ProID;

