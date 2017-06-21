DELIMITER $
CREATE PROCEDURE make (IN Make VARCHAR(32))
BEGIN
	SELECT DISTINCT (Name), Street, City, State, ZIP
	FROM dim_stores
	WHERE Make = dim_stores.Specialty;
END
$
DELIMITER ;