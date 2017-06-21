CREATE VIEW view_stock AS
  SELECT stores.Name, cars.Make, cars.Model, cars.Trim, stock.amount
  FROM dim_stores AS stores, dim_cars AS cars, dim_stock AS stock
  WHERE stock.store_id = stores.id AND stock.car_id = cars.id
  ORDER BY stores.Name;