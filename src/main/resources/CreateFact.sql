CREATE TABLE fact_sales(
cust_id INT,
car_id INT,
store_id INT,
date_id INT,
FOREIGN KEY (cust_id) REFERENCES dim_cust(id),
FOREIGN KEY (car_id) REFERENCES dim_cars(id),
FOREIGN KEY (store_id) REFERENCES dim_stores(id),
FOREIGN KEY (date_id) REFERENCES dim_dates(id)
);

COMMIT;