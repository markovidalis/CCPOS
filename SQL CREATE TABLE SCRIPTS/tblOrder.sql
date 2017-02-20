CREATE TABLE tblOrder (
	orderID int NOT NULL IDENTITY(1,1),
	custID int NOT NULL,
	orderDate DATE NOT NULL,
	orderAmount money NOT NULL,
	numItems int NOT NULL,
	numCompletedItems int NOT NULL,
	orderCode int NOT NULL,
	orderStatus VARCHAR(250) NOT NULL,
	PRIMARY KEY (orderID),
	FOREIGN KEY (custID) REFERENCES tblCustomer(custID)
)