CREATE TABLE tblArchiveCustomer (
	archCustID int NOT NULL IDENTITY (1,1),
	archCustName VARCHAR(250) NOT NULL,
	archCustSurname VARCHAR(250) NOT NULL,
	archCustContact VARCHAR(250) NOT NULL,
	archCustEmail VARCHAR(250) NOT NULL,
	archCustAddress1 VARCHAR(250) NOT NULL,
	archCustAddress2 VARCHAR(250),
	archCustAddress3 VARCHAR(250),
	PRIMARY KEY (archCustID)
)