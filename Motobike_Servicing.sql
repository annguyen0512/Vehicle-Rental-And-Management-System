IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'Motobike_Servicing')
DROP DATABASE [Motobike_Servicing]
GO
CREATE DATABASE Motobike_Servicing 
GO

USE [Motobike_Servicing]
GO


CREATE TABLE Staff (
    Staff_ID varchar(225) NOT NULL,
    Staff_Name varchar(225),
    Address varchar(225),
    Phone_number varchar(225),
    DateOfBirth date,
    PRIMARY KEY (Staff_ID)
);

CREATE TABLE Account (
    User_Name varchar(225) NOT NULL,
    Password varchar(225),
    Staff_ID varchar(225),
    PRIMARY KEY (User_Name),
    FOREIGN KEY (Staff_ID) REFERENCES Staff(Staff_ID)
);

CREATE TABLE Customer (
    Customer_ID varchar(225) NOT NULL,
    Customer_Name varchar(225),
    Address varchar(225),
    Phone_number varchar(225),
    Class varchar(225),
    PRIMARY KEY (Customer_ID)
);

CREATE TABLE Orders (
    Order_ID int IDENTITY(1,1) NOT NULL,
    Start_Date date,
    End_Date date,
    Order_Status varchar(225),
    Customer_ID varchar(225),
    Staff_ID varchar(225),
    PRIMARY KEY (Order_ID),
    FOREIGN KEY (Customer_ID) REFERENCES Customer(Customer_ID),
    FOREIGN KEY (Staff_ID) REFERENCES Staff(Staff_ID)
);

CREATE TABLE Vehicle (
    Plate_Number varchar(225) NOT NULL,
    Brand varchar(225),
    Model varchar(225),
    Color varchar(225),
    Vehicle_Status varchar(225),
    Rent_Cost decimal(9,2),
    Order_ID int,
	Staff_ID varchar(225),
    PRIMARY KEY (Plate_Number),
    FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
	FOREIGN KEY (Staff_ID) REFERENCES Staff(Staff_ID)
)
GO

CREATE FUNCTION login(@username varchar(225), @pass varchar(225)) RETURNS int
AS
BEGIN
    IF (SELECT COUNT(*) FROM Account WHERE User_Name = @username AND Password = @pass) = 1
        RETURN 1;
    RETURN 0;
END
GO

CREATE FUNCTION CheckCustomer(@cmnd varchar(225)) RETURNS int
AS
BEGIN
    IF (SELECT COUNT(*) FROM Customer WHERE Customer_ID = @cmnd) = 1
        RETURN 1;
    RETURN 0;
END
GO

CREATE FUNCTION CheckOrder(@startDate date, @endDate date, @status varchar(225), @customer int) RETURNS int
AS
BEGIN
    DECLARE @temp int;
    SET @temp = 1;
    WHILE EXISTS (SELECT * FROM Orders WHERE Order_ID = @temp)
    BEGIN
        IF (SELECT COUNT(*) FROM Orders WHERE Order_ID = @temp AND Start_Date = @startDate AND
                End_Date = @endDate AND Order_Status = @status AND Customer_ID = @customer) = 1
            RETURN @temp;
        SET @temp = @temp + 1;
    END;
    RETURN -1;
END
GO

CREATE PROCEDURE CustomerNormal
AS
BEGIN
    SELECT * FROM Customer WHERE Class LIKE 'normal';
END
GO

CREATE PROCEDURE CustomerVip
AS
BEGIN
    SELECT * FROM Customer WHERE Class LIKE 'vip';
END
GO

CREATE PROCEDURE CustomerName(@keyword varchar(225))
AS
BEGIN
    SELECT * FROM Customer WHERE Customer_Name LIKE '%' + LOWER(@keyword) + '%';
END
GO

CREATE PROCEDURE CustomerCity(@city varchar(225))
AS
BEGIN
    SELECT * FROM Customer WHERE Address LIKE '%' + LOWER(@city) + '%';
END
GO

CREATE PROCEDURE CustomerPhoneNumber(@phone varchar(225))
AS
BEGIN
    SELECT * FROM Customer WHERE Phone_number LIKE '%' + @phone;
END
GO

CREATE PROCEDURE ViewCustomer
AS
BEGIN
    SELECT * FROM Customer;
END
GO

CREATE PROCEDURE ViewVehicle
AS
BEGIN
    SELECT * FROM Vehicle;
END
GO

CREATE PROCEDURE ViewOrder
AS
BEGIN
    SELECT * FROM Orders;
END
GO

CREATE PROCEDURE InsertCustomer(@cmnd varchar(225), @name varchar(225), @address varchar(225), @phone varchar(225), @class varchar(225))
AS
BEGIN
    INSERT INTO Customer (Customer_ID, Customer_Name, Address, Phone_number, Class)
    VALUES (@cmnd, @name, @address, @phone, @class);
END
GO

CREATE PROCEDURE InsertOrder(@startDate date, @endDate date, @status varchar(225), @customer int, @staff int)
AS
BEGIN
    INSERT INTO Orders (Start_Date, End_Date, Order_Status, Customer_ID, Staff_ID)
    VALUES (@startDate, @endDate, @status, @customer, @staff);
END
GO

CREATE PROCEDURE InsertVehicle(@plate varchar(225), @brand varchar(225), @color varchar(225), @model varchar(225), @rent decimal(9,2), @status varchar(225), @orders int)
AS
BEGIN
    INSERT INTO Vehicle (Plate_Number, Brand, Color, Model, Rent_Cost, Vehicle_Status, Order_ID)
    VALUES (@plate, @brand, @color, @model, @rent, @status, @orders);
END
GO

CREATE PROCEDURE DeleteCustomer(@cmnd varchar(225))
AS
BEGIN
    DELETE FROM Customer
    WHERE Customer_ID = @cmnd;
END
GO

CREATE PROCEDURE DeleteOrder(@startDate date, @endDate date, @status varchar(225), @customer int, @staff int)
AS
BEGIN
    DELETE FROM Orders
    WHERE Start_Date = @startDate and End_Date = @endDate and Order_Status = @status and Customer_ID = @customer and Staff_ID = @staff;
END
GO

CREATE PROCEDURE DeleteVehicle(@plate varchar(225))
AS
BEGIN
    DELETE FROM Vehicle
    WHERE Plate_Number = @plate;
END
GO