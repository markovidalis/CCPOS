CREATE TABLE tblEmployee (
	empID int not null identity(1,1),
	empName VARCHAR(250) NOT NULL,
	empSurname VARCHAR(250) NOT NULL,
	empUsername VARCHAR(250) NOT NULL,
	empPassword VARCHAR(250) NOT NULL,
	empContact VARCHAR(250) NOT NULL,
	empEmail VARCHAR(250) NOT NULL,
	empAddress1 VARCHAR(250) NOT NULL,
	empAddress2 VARCHAR(250) NOT NULL,
	empAddress3 VARCHAR(250) NOT NULL,
	empRate money NOT NULL,
	PRIMARY KEY (empID)
)