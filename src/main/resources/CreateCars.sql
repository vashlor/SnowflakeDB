CREATE TABLE dim_cars(
ID INT NOT NULL AUTO_INCREMENT,
Make VARCHAR(32),
Model VARCHAR(32),
Trim VARCHAR(8),
PRIMARY KEY (ID)
);

INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Corolla', 'Base');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Corolla', 'XRS');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Corolla', 'LE');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Corolla', 'S');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Camry', 'LE');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Camry', 'SE');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Camry', 'XSE');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Camry', 'XLE');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Camry', 'XSE V6');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', 'Camry', 'XLE V6');
INSERT INTO dim_cars(Make, Model) VALUES('Toyota', 'Supra');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', '86', 'Base');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Toyota', '86', 'SE');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'BRZ', 'Premium');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'BRZ', 'Limited');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'BRZ', 'Series Yellow');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'WRX', 'Base');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'WRX', 'Premium');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'WRX', 'STI');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Subaru', 'WRX', 'STI Limited');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Mitsubishi', 'Lancer Evolution', 'GSR');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Mitsubishi', 'Lancer Evolution', 'MR');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'Civic', 'LX');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'Civic', 'EX');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'Civic', 'EX-T');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'Civic', 'EX-L');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'Civic', 'Si');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'Civic', 'Type R');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'S2000', 'Base');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Honda', 'S2000', 'CR');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Lexus', 'IS 250', 'RWD');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Lexus', 'IS 250', 'AWD');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Lexus', 'RC', 'F');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Lexus', 'IS Turbo', 'F Sport');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Nissan', 'GTR', 'Premium');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Nissan', 'GTR', 'NISMO');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Mazda', 'MX-5', 'Club');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Mazda', 'MX-5', 'GT');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Jaguar', 'F-Type', 'R');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Porsche', '911', 'S');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Aston Martin', 'Vanquish', 'S');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Aston Martin', 'Vantage', 'S');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Aston Martin', 'Vantage V12', 'S');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Aston Martin', 'Rapide', 'S');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Dodge', 'Viper', 'SRT');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Dodge', 'Viper', 'GT');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Dodge', 'Viper', 'GTS-R');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Dodge', 'Viper', 'TA');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Dodge', 'Viper', 'ACR');
INSERT INTO dim_cars(Make, Model, Trim) VALUES('Tesla', 'Model S', 'P100D');
INSERT INTO dim_cars(Make, Model) VALUES('McLaren', '650S');

COMMIT;