CREATE TABLE dim_months(
ID INT,
Month VARCHAR(32),
PRIMARY KEY (ID)
);

INSERT INTO dim_months VALUES(1, "January");
INSERT INTO dim_months VALUES(2, "Febuary");
INSERT INTO dim_months VALUES(3, "March");
INSERT INTO dim_months VALUES(4, "April");
INSERT INTO dim_months VALUES(5, "May");
INSERT INTO dim_months VALUES(6, "June");
INSERT INTO dim_months VALUES(7, "July");
INSERT INTO dim_months VALUES(8, "August");
INSERT INTO dim_months VALUES(9, "September");
INSERT INTO dim_months VALUES(10, "October");
INSERT INTO dim_months VALUES(11, "November");
INSERT INTO dim_months VALUES(12, "December");

COMMIT;

CREATE INDEX idx_month ON dim_months (Month);

CREATE TABLE dim_dates(
ID INT NOT NULL AUTO_INCREMENT,
Month VARCHAR(32),
Day INT,
Year INT,
PRIMARY KEY (ID),
FOREIGN KEY (Month) REFERENCES dim_months(Month)
);