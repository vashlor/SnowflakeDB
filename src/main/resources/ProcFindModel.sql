DELIMITER $
CREATE PROCEDURE model (IN model VARCHAR(32))
BEGIN
	SELECT DISTINCT (stores.Name), stores.Street, stores.City, stores.State, stores.ZIP
	FROM dim_stores AS stores, dim_cars as cars
	WHERE model = cars.model AND stores.specialty = cars.make;
END
$
DELIMITER ;