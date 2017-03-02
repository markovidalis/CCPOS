create table tblDiscount(
	discountID int not null identity(1,1),
	discountName VARCHAR(250) NOT NULL,
	discountPercent VARCHAR(250) NOT NULL,
	PRIMARY KEY (discountID)
)
