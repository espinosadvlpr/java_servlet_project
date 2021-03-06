-- DROP DATABASE `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb`;
USE `mydb`;

-- Se crea la tabla de usuarios
CREATE TABLE IF NOT EXISTS `mydb`.`USER` (
  `ID_USER` INT NOT NULL,
  `USER_NAME` VARCHAR(100) NOT NULL,
  `USER_EMAIL` VARCHAR(100) NOT NULL,
  `USER_PASSWORD` VARCHAR(100) NOT NULL,
  `USER_ADDRESS` VARCHAR(100) NOT NULL,
  `ADMIN` INT NOT NULL,
PRIMARY KEY (`ID_USER`));

-- Se crea la tabla de productos
CREATE TABLE IF NOT EXISTS `mydb`.`PRODUCT` (
  `ID_PRODUCT` INT NOT NULL,
  `PRODUCT_NAME` VARCHAR(100) NOT NULL,
  `PRODUCT_PRICE` INT NOT NULL,
  `PRODUCT_QUANTITY` INT NOT NULL,
  `PRODUCT_PRESENTATION` VARCHAR(100) NOT NULL,
PRIMARY KEY (`ID_PRODUCT`));

-- Se agrega el usuario administrador del sistema
INSERT INTO USER VALUES (1,'David','david@u.com','1234','Calle 1 #2-3',1);
INSERT INTO USER VALUES (2,'Lorena','lorena@u.com','1234','Calle 2 #3-4',0);

-- Se agregan productos
INSERT INTO PRODUCT VALUES (1,'Detergente',1000,25,'125 gramos');
INSERT INTO PRODUCT VALUES (2,'Papas Margarita',1300,15,'50 gramos');
INSERT INTO PRODUCT VALUES (3,'Doritos',1500,35,'50 gramos');
INSERT INTO PRODUCT VALUES (4,'Jabon Rexona',2000,20,'50 gramos');
INSERT INTO PRODUCT VALUES (5,'Escoba',4500,4,'Por unidad');
INSERT INTO PRODUCT VALUES (6,'Detodito',1600,18,'60 gramos');
INSERT INTO PRODUCT VALUES (7,'Galletas',800,13,'30 gramos');
INSERT INTO PRODUCT VALUES (8,'Gomitas',100,250,'Por unidad');
INSERT INTO PRODUCT VALUES (9,'Arroz',1600,40,'250 gramos');
INSERT INTO PRODUCT VALUES (10,'Azucar',3000,15,'1 kilogramo');

select * from product;
