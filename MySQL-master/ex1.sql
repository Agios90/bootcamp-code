DROP DATABASE salecompany;
CREATE DATABASE salecompany;
USE salecompany;

CREATE TABLE Employees (
	EmployeeID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Name varchar(30) NOT NULL,
	LastName varchar(30) NOT NULL,
	Commissioned int NOT NULL,
	City varchar(30) NOT NULL
)ENGINE=INNODB;

CREATE TABLE EmployeeFamily (
	FamilyID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Relativeof int UNSIGNED NOT NULL,
	Degree enum('1st Degree','2nd Degree','3rd Degree'),
	Name varchar(30) NOT NULL,
	DOB date,
	FOREIGN KEY (Relativeof) REFERENCES Employees(EmployeeID) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE Products (
	ProductID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	description varchar(200),
	price int NOT NULL
)ENGINE=INNODB;

CREATE TABLE customers (
	CustomerID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Name varchar(30) NOT NULL,
	LastName varchar(30) NOT NULL,
	salesman int UNSIGNED NOT NULL,
	FOREIGN KEY (salesman) REFERENCES Employees(EmployeeID) ON UPDATE CASCADE
)ENGINE=INNODB;

CREATE TABLE sales (
	SaleID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product int UNSIGNED NOT NULL,
	quantity int NOT NULL,
	price decimal(13,3) UNSIGNED NOT NULL,
	employee int UNSIGNED NOT NULL,
	customer int UNSIGNED NOT NULL,
	FOREIGN KEY (product) REFERENCES Products(ProductID) ON UPDATE CASCADE,
	FOREIGN KEY (employee) REFERENCES Employees(EmployeeID) ON UPDATE CASCADE,
	FOREIGN KEY (customer) REFERENCES customers(CustomerID) ON UPDATE CASCADE
)ENGINE=INNODB;
