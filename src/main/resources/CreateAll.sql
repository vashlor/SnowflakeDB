
DROP VIEW IF EXISTS view_stock;
DROP TABLE IF EXISTS fact_sales;
DROP TABLE IF EXISTS dim_dates;
DROP TABLE IF EXISTS dim_months;
DROP TABLE IF EXISTS dim_stock;
DROP TABLE IF EXISTS dim_stores;
DROP TABLE IF EXISTS dim_cust;
DROP TABLE IF EXISTS dim_cars;
DROP PROCEDURE IF EXISTS make;
DROP PROCEDURE IF EXISTS model;

select 'Done dropping tables.' AS '';

select 'Creating cars' AS '';
source C:/Workspace/StarDB/CreateCars.sql;
select 'Creating customers' AS '';
source C:/Workspace/StarDB/CreateCustomers.sql;
select 'Creating stores' AS '';
source C:/Workspace/StarDB/CreateStores.sql;
source C:/Workspace/StarDB/CreateStock.sql;
source C:/Workspace/StarDB/CreateDates.sql;
select 'Creating fact table' AS '';
source C:/Workspace/StarDB/CreateFact.sql;
select 'Creating stock view' AS '';
source C:/Workspace/StarDB/ViewStock.sql;

source C:/Workspace/StarDB/ProcDealerSpecialty.sql;
source C:/Workspace/StarDB/ProcFindModel.sql;

COMMIT;