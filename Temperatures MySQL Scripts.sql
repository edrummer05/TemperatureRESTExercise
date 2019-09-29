CREATE TABLE `temperature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `temperature` float DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `temperature_fahrenheit` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Temperature Table';

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllTemperatures`()
BEGIN
	select id, temperature, ((temperature * (9.0/5.0)) + 32.0) as 'temperature_fahrenheit', create_date, update_date
    from temperature;
END$$
DELIMITER ;

--created but not used due to errors in Spring JPA/REST

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertTemperature`(
	IN `@temperature` float
)
BEGIN
	insert into temperature(temperature, create_date)
    values (@temperature, NOW());
    
    select last_insert_id();
    
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateTemperature`(
	IN `@id` INT(11),
    IN `@temperature` FLOAT
)
BEGIN
	update temperature
    set temperature = @temperature, update_date = NOW()
    where id = @id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteTemperature`(
	IN `@id` int(11)
)
BEGIN
	delete from temperature
    where id = @id;
END$$
DELIMITER ;



