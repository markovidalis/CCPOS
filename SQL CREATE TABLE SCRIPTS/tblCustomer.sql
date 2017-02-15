CREATE TABLE tblCustomer (
	custID int NOT NULL IDENTITY (1,1),
	custName VARCHAR(250) NOT NULL,
	custSurname VARCHAR(250) NOT NULL,
	custContact VARCHAR(250) NOT NULL,
	custEmail VARCHAR(250) NOT NULL,
	custAddress1 VARCHAR(250) NOT NULL,
	custAddress2 VARCHAR(250),
	custAddress3 VARCHAR(250),
	PRIMARY KEY (custID)
)