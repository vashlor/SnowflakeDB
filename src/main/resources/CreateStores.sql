CREATE TABLE dim_stores(
ID INT NOT NULL AUTO_INCREMENT,
Name VARCHAR(64),
Street VARCHAR(64),
City VARCHAR(32),
State VARCHAR(2),
ZIP INT,
Specialty VARCHAR(32),
StockID INT,
PRIMARY KEY(id)
);

INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Elk Grove Honda", "8550 Laguna Grove Dr", "Elk Grove", "CA", 95757, "Honda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("University Honda", "4343 Chiles Rd", "Davis", "CA", 95618, "Honda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("AutoNation Honda Roseville", "230 Automall Dr", "Roseville", "CA", 95661, "Honda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Folsom Lake Honda", "12505 Automall Pkwy", "Rancho Cordova", "CA", 95742, "Honda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Elk Grove Acura", "8585 Laguna Grove Dr", "Elk Grove", "CA", 95757, "Acura");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Niello Acura", "150 Automall Dr", "Roseville", "CA", 95661, "Acura");
INSERT INTO dim_stores(Name, Street, City, State, ZIP) VALUES ("CarMax", "1450 Eureka Rd", "Roseville", "CA", 95661);
INSERT INTO dim_stores(Name, Street, City, State, ZIP) VALUES ("CarMax", "8185 E Stockton Blvd", "Sacramento", "CA", 95828);
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Elk Grove Toyota", "9640 W Stockton Blvd", "Elk Grove", "CA", 95757, "Toyota");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Maita Toyota of Sacramento", "2500 Auburn Blvd", "Sacramento", "CA", 95821, "Toyota");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Folsom Lake Toyota", "12747 Folsom Blvd", "Folsom", "CA", 95630, "Toyota");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Roseville Toyota", "700 Automall Dr", "Roseville", "CA", 95661, "Toyota");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Lexus of Sacramento", "2600 Fulton Ave", "Sacramento", "CA", 95821, "Lexus");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Lexus of Roseville", "300 Automall Dr", "Roseville", "CA", 95661, "Lexus");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Concord Mitsubishi", "2199 Meridian Park Blvd", "Concord", "CA", 94520, "Mitsubishi");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Hayward Mitsubishi", "25601 Mission Blvd", "Hayward", "CA", 94544, "Mitsubishi");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("San Francisco Mitsubishi Fuso", "595 Newhall St", "San Francisco", "CA", 94124, "Mitsubishi");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Elk Grove Subaru", "8581 Laguna Grove Dr", "Elk Grove", "CA", 95757, "Subaru");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Fairfield Subaru", "2525 Martin Rd", "Fairfield", "CA", 94534, "Subaru");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("AutoNation Subaru Roseville", "100 Automall Dr", "Roseville", "CA", 95661, "Subaru");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Maita Subaru", "2912 Auburn Blvd", "Sacramento", "CA", 95821, "Subaru");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Nissan of Yuba City", "1340 Bridge St", "Yuba City", "CA", 95993, "Nissan");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Premier Nissan of San Jose", "1120 W Capitol Expy", "San Jose", "CA", 95136, "Nissan");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Nissan of Stockton", "3077 E Hammer Ln", "Stockton", "CA", 95212, "Nissan");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Dublin Mazda", "6363 Scarlett Ct", "Dublin", "CA", 94568, "Mazda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("AutoNation Mazda Roseville", "100 Automall Dr #1", "Roseville", "CA", 95661, "Mazda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Tracy Mazda", "2680 Auto Plaza Dr", "Tracy", "CA", 95304, "Mazda");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Elk Grove Dodge Chrysler Jeep", "8575 Laguna Grove Dr", "Elk Grove", "CA", 95757, "Dodge");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("AutoNation Chrysler Dodge Jeep Ram Roseville", "200 Automall Dr", "Elk Grove", "CA", 95661, "Dodge");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Viper Exchange", "23777 Tomball Parkway", "Tomball", "TX", 77375, "Dodge");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Niello Maserati", "2535 Arden Way", "Sacramento", "CA", 95825, "Ferrari");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Ferrari of San Francisco", "595 Redwood Hwy", "Mill Valley", "CA", 94941, "Ferrari");
INSERT INTO dim_stores(Name, Street, City, State, ZIP) VALUES ("Diamond Autosport", "4445 Granite Dr", "Rocklin", "CA", 95677);
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Niello Porsche", "4525 Granite Dr", "Rocklin", "CA", 95677, "Prosche");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Porsche of Livermore", "3100 Las Positas Rd", "Livermore", "CA", 94551, "Prosche");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Porsche of Stevens Creek", "4155 Stevens Creek Blvd", "Santa Clara", "CA", 95051, "Prosche");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("San Francisco Bentley Lamborghini Lotus and Pagani", "901 Van Ness Ave", "San Francisco", "CA", 94109, "Lamborghini");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Jaguar Sacramento", "2052 Fulton Ave", "Sacramento", "CA", 95825, "Jaguar");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Cole European", "2103 N Main St", "Walnut Creek", "CA", 94596, "Jaguar");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Tesla Dealership", "4361 Granite Dr", "Rocklin", "CA", 95677, "Tesla");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Tesla Supercharger", "6701 Amador Plaza Rd", "Dublin", "CA", 94568, "Tesla");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("McLaren San Francisco", "4192 El Camino Real", "Palo Alto", "CA", 94306, "McLaren");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("McLaren Auto Gallery Beverly Hills", "9022 Wilshire Blvd", "Beverly Hills", "CA", 90210, "McLaren");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Aston Martin Walnut Creek", "1425 Parkside Dr", "Walnut Creek", "CA", 94596, "Aston Martin");
INSERT INTO dim_stores(Name, Street, City, State, ZIP, Specialty) VALUES ("Aston Martin San Diego", "7820 Balboa Ave", "San Diego", "CA", 92111, "Aston Martin");

COMMIT;