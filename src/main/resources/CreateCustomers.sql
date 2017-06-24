CREATE TABLE dim_cust(
Id INT NOT NULL AUTO_INCREMENT,
Name VARCHAR(32),
Street VARCHAR(32),
City VARCHAR(32),
State VARCHAR(2),
PRIMARY KEY(id)
);

INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Null', '0000 Nada Lane', 'Null', 'NO');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Al', '1337 Leet Lane', 'Elite', 'LT');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Jasmine', '726 Palace Street', 'Disney', 'CA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Steve', '6000 J Street', 'Sacramento', 'CA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Samantha', '3601 Pacific Ave', 'Stockton', 'CA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Rob', '127 Thomas Road', 'Lake City', 'SC');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Freddy', '1428 Elm Street', 'Los Angeles', 'CA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Fibonacci', '1123 Sequence Street', 'Math', 'NM');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Bart', '742 Evergreen Terrace', 'Springfield', 'OR');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Clementine', '235 TellTale Road', 'Athens', 'GA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Howard', '721 Yodeling Way', 'Lodi', 'CA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Jason', '2218 Dream Lane', 'Seattle', 'WA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Arya', '851 Stark Street', 'The North', 'WT');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('James', '007 Bond Ave', 'England', 'OH');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Porsche', '911 Carrera Road', 'Las Vegas', 'NV');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Hachiroku', '86 Corolla Street', 'Sacramento', 'CA');
INSERT INTO dim_cust(Name, Street, City, State) VALUES ('Nora', '1662 Jones Road', 'Brooklyn', 'NY');

COMMIT;