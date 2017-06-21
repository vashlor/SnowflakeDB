CREATE TABLE dim_stock(
store_id INT,
car_id INT,
amount INT,
FOREIGN KEY (store_id) REFERENCES dim_stores(ID),
FOREIGN KEY (car_id) REFERENCES dim_cars(ID)
);

INSERT INTO dim_stock VALUES(1, 23, 2);
INSERT INTO dim_stock VALUES(1, 24, 4);
INSERT INTO dim_stock VALUES(1, 27, 3);
INSERT INTO dim_stock VALUES(1, 28, 2);
INSERT INTO dim_stock VALUES(1, 30, 2);
INSERT INTO dim_stock VALUES(2, 23, 4);
INSERT INTO dim_stock VALUES(2, 24, 5);
INSERT INTO dim_stock VALUES(2, 27, 7);
INSERT INTO dim_stock VALUES(3, 23, 4);
INSERT INTO dim_stock VALUES(3, 24, 6);
INSERT INTO dim_stock VALUES(3, 25, 2);
INSERT INTO dim_stock VALUES(3, 26, 3);
INSERT INTO dim_stock VALUES(3, 27, 2);
INSERT INTO dim_stock VALUES(4, 27, 4);
INSERT INTO dim_stock VALUES(4, 28, 4);
INSERT INTO dim_stock VALUES(4, 29, 5);
INSERT INTO dim_stock VALUES(4, 30, 4);
INSERT INTO dim_stock VALUES(5, 27, 6);
INSERT INTO dim_stock VALUES(5, 28, 3);
INSERT INTO dim_stock VALUES(6, 30, 4);
INSERT INTO dim_stock VALUES(6, 35, 3);
INSERT INTO dim_stock VALUES(6, 15, 2);
INSERT INTO dim_stock VALUES(7, 27, 2);
INSERT INTO dim_stock VALUES(7, 28, 3);
INSERT INTO dim_stock VALUES(7, 30, 3);
INSERT INTO dim_stock VALUES(7, 35, 2);
INSERT INTO dim_stock VALUES(7, 15, 2);
INSERT INTO dim_stock VALUES(7, 38, 1);
INSERT INTO dim_stock VALUES(7, 1, 4);
INSERT INTO dim_stock VALUES(7, 2, 1);
INSERT INTO dim_stock VALUES(7, 3, 6);
INSERT INTO dim_stock VALUES(7, 4, 3);
INSERT INTO dim_stock VALUES(7, 5, 3);
INSERT INTO dim_stock VALUES(7, 6, 5);
INSERT INTO dim_stock VALUES(8, 27, 3);
INSERT INTO dim_stock VALUES(8, 28, 4);
INSERT INTO dim_stock VALUES(8, 30, 2);
INSERT INTO dim_stock VALUES(8, 35, 1);
INSERT INTO dim_stock VALUES(8, 15, 3);
INSERT INTO dim_stock VALUES(8, 38, 3);
INSERT INTO dim_stock VALUES(8, 1, 2);
INSERT INTO dim_stock VALUES(8, 2, 4);
INSERT INTO dim_stock VALUES(8, 3, 5);
INSERT INTO dim_stock VALUES(8, 4, 6);
INSERT INTO dim_stock VALUES(8, 5, 2);
INSERT INTO dim_stock VALUES(8, 6, 4);
INSERT INTO dim_stock VALUES(8, 12, 2);
INSERT INTO dim_stock VALUES(8, 13, 3);
INSERT INTO dim_stock VALUES(9, 1, 5);
INSERT INTO dim_stock VALUES(9, 2, 3);
INSERT INTO dim_stock VALUES(9, 3, 3);
INSERT INTO dim_stock VALUES(9, 4, 1);
INSERT INTO dim_stock VALUES(9, 5, 4);
INSERT INTO dim_stock VALUES(9, 6, 4);
INSERT INTO dim_stock VALUES(9, 12, 4);
INSERT INTO dim_stock VALUES(9, 13, 2);
INSERT INTO dim_stock VALUES(10, 1, 5);
INSERT INTO dim_stock VALUES(10, 3, 3);
INSERT INTO dim_stock VALUES(10, 4, 3);
INSERT INTO dim_stock VALUES(10, 5, 1);
INSERT INTO dim_stock VALUES(10, 6, 4);
INSERT INTO dim_stock VALUES(10, 7, 3);
INSERT INTO dim_stock VALUES(10, 8, 4);
INSERT INTO dim_stock VALUES(10, 9, 2);
INSERT INTO dim_stock VALUES(10, 12, 2);
INSERT INTO dim_stock VALUES(10, 13, 2);