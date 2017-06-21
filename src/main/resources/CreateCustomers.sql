CREATE TABLE dim_cust(
Id INT NOT NULL AUTO_INCREMENT,
Name VARCHAR(32),
Address VARCHAR(32),
PRIMARY KEY(id)
);

INSERT INTO dim_cust(Name, Address) VALUES ('Null', '0000 Nada Lane');
INSERT INTO dim_cust(Name, Address) VALUES ('Al', '1337 Leet Lane');
INSERT INTO dim_cust(Name, Address) VALUES ('Jasmine', '726 Palace Street');
INSERT INTO dim_cust(Name, Address) VALUES ('Steve', '6000 J Street');
INSERT INTO dim_cust(Name, Address) VALUES ('Samantha', '3601 Pacific Ave');
INSERT INTO dim_cust(Name, Address) VALUES ('Rob', '127 Thomas Road');
INSERT INTO dim_cust(Name, Address) VALUES ('Freddy', '1428 Elm Street');
INSERT INTO dim_cust(Name, Address) VALUES ('Fibonacci', '2134 Sequence Street');
INSERT INTO dim_cust(Name, Address) VALUES ('Bart', '742 Evergreen Terrace');
INSERT INTO dim_cust(Name, Address) VALUES ('Clementine', '235 TellTale Road');
INSERT INTO dim_cust(Name, Address) VALUES ('Howard', '721 Yodeling Way');
INSERT INTO dim_cust(Name, Address) VALUES ('Jason', '2218 Dream Lane');
INSERT INTO dim_cust(Name, Address) VALUES ('Arya', '851 Stark Street');
INSERT INTO dim_cust(Name, Address) VALUES ('James', '007 Bond Ave');
INSERT INTO dim_cust(Name, Address) VALUES ('Porsche', '911 Carrera Road');
INSERT INTO dim_cust(Name, Address) VALUES ('Hachiroku', '86 Corolla Street');
INSERT INTO dim_cust(Name, Address) VALUES ('Nora', '1662 Jones Road');

COMMIT;