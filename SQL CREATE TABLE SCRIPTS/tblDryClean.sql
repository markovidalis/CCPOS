CREATE TABLE tblDryCleanPrices(
	dryCleanID int NOT NULL IDENTITY(1,1),
	dryCleanName VARCHAR(250) NOT NULL,
	dryCleanPrice money NOT NULL
)