-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fitness
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping events for database 'fitness'
--

--
-- Dumping routines for database 'fitness'
--
/*!50003 DROP FUNCTION IF EXISTS `getTotCalBurnt` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getTotCalBurnt`(uname VARCHAR(45), dat date) RETURNS int(11)
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE tot INT;
    DECLARE cal INT;
    DECLARE cals CURSOR FOR
		SELECT cal_burnt FROM burn
        WHERE username = uname
        AND e_date = dat;
	  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET tot = 0;
    OPEN cals;
    get_cal: LOOP
		FETCH cals INTO cal;
        IF done THEN
			LEAVE get_cal;
		END IF;
        SET tot = tot + cal;
	END LOOP get_cal;
RETURN tot;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getTotCalCons` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getTotCalCons`(uname VARCHAR(45), dat date) RETURNS int(11)
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE tot INT;
    DECLARE cal INT;
    DECLARE cals CURSOR FOR
		SELECT cal_cons FROM consume
        WHERE username = uname
        AND f_date = dat;
	  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET tot = 0;
    OPEN cals;
    get_cal: LOOP
		FETCH cals INTO cal;
        IF done THEN
			LEAVE get_cal;
		END IF;
        SET tot = tot + cal;
	END LOOP get_cal;
RETURN tot;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getTotCalNet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getTotCalNet`(uname VARCHAR(45), dat date) RETURNS int(11)
BEGIN
	RETURN getTotCalCons(uname, dat) - getTotCalBurnt(uname, dat);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `test` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `test`(dat date) RETURNS date
BEGIN
	DECLARE i INT;
    SET i = 0;
    WHILE i<7 DO
		SET i = i+1;
	END WHILE;
RETURN date_sub(dat, interval i day);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addActivity` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addActivity`(IN uname1 varchar(45), IN e_name1 varchar(45), IN duration1 int, IN cal_burnt1 int, IN e_date1 date)
BEGIN
	DECLARE cnt int default 0;
	set cnt = (SELECT count(*)
    from burn
    where username = uname1
    and e_name = e_name1
    and e_date = e_date1);
    IF cnt>=1 THEN
		set duration1 = (SELECT duration
			from burn
			where username = uname1
			and e_name = e_name1
			and e_date = e_date1)
			+ duration1;
        set cal_burnt1 = (SELECT cal_burnt
			from burn
			where username = uname1
			and e_name = e_name1
			and e_date = e_date1)
			+ cal_burnt1;
		UPDATE `fitness`.`burn` SET `duration` = duration1, `cal_burnt` = cal_burnt1
			WHERE (`e_name` = e_name1) and (`username` = uname1) and (`e_date` = e_date1);

	ELSE
		INSERT INTO `fitness`.`burn`
			(`e_name`, `username`, `e_date`, `duration`, `cal_burnt`) 
			VALUES (e_name1, uname1, e_date1, duration1, cal_burnt1);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addFood` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFood`(IN uname1 varchar(45), IN f_name1 varchar(45), IN quantity1 int, IN cal_cons1 int, IN f_date1 date)
BEGIN
	DECLARE cnt int default 0;
	set cnt = (SELECT count(*)
    from consume
    where username = uname1
    and f_name = f_name1
    and f_date = f_date1);
    IF cnt>=1 THEN
		set quantity1 = (SELECT quantity
			from consume
			where username = uname1
			and f_name = f_name1
			and f_date = f_date1)
			+ quantity1;
        set cal_cons1 = (SELECT cal_cons
			from consume
			where username = uname1
			and f_name = f_name1
			and f_date = f_date1)
			+ cal_cons1;
		UPDATE `fitness`.`consume` SET `quantity` = quantity1, `cal_cons` = cal_cons1
			WHERE (`f_name` = f_name1) and (`username` = uname1) and (`f_date` = f_date1);

	ELSE
		INSERT INTO `fitness`.`consume`
			(`f_name`, `username`, `f_date`, `quantity`, `cal_cons`) 
			VALUES (f_name1, uname1, f_date1, quantity1, cal_cons1);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trackBMI` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trackBMI`(uname VARCHAR(45), dat DATE)
BEGIN
	DECLARE i INT DEFAULT 0;
    DECLARE cal INT;
    DECLARE h INT;
    DECLARE w INT;
    DECLARE cnt INT;
    DECLARE curr DATE;
    CREATE TABLE `fitness`.`tmp` (
		`height` INT NOT NULL, `weight` INT NOT NULL, `date` VARCHAR(2) NOT NULL);
	SET h = (SELECT height FROM user WHERE user.username = uname);
    SET w = (SELECT weight FROM user WHERE user.username = uname);
    WHILE i<7 DO
		SET curr = date_sub(dat, interval i day);
		SET cnt = (SELECT count(*) from track where track.username = uname and track.date = curr and height is NOT NULL);
        IF cnt>0 THEN
			SET h = (SELECT height from track where track.username = uname and track.date = curr and height is NOT NULL);
		END IF;
        SET cnt = (SELECT count(*) from track where track.username = uname and track.date = curr and weight is NOT NULL);
        IF cnt>0 THEN
			SET w = (SELECT weight from track where track.username = uname and track.date = curr and weight is NOT NULL);
		END IF;
        INSERT INTO `fitness`.`tmp`
			(`height`, `weight`, `date`) VALUES (h, w, extract(DAY FROM curr));
        SET i = i+1;
	END WHILE;
    SELECT * FROM tmp;
    DROP TABLE `fitness`.`tmp`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trackCalBurnt` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trackCalBurnt`(uname VARCHAR(45), dat DATE)
BEGIN
	DECLARE i INT DEFAULT 6;
    DECLARE cal INT;
    CREATE TABLE `fitness`.`tmp` (
		`cals` INT NOT NULL, `c_date` VARCHAR(2) NOT NULL);
    WHILE i>=0 DO
		SET cal = getTotCalBurnt(uname, date_sub(dat, interval i day));
        INSERT INTO `fitness`.`tmp`
			(`cals`, `c_date`) VALUES (cal, extract(DAY FROM date_sub(dat, interval i day)));
        SET i = i-1;
	END WHILE;
    SELECT * FROM tmp;
    DROP TABLE `fitness`.`tmp`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trackCalCons` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trackCalCons`(uname VARCHAR(45), dat DATE)
BEGIN
	DECLARE i INT DEFAULT 6;
    DECLARE cal INT;
    CREATE TABLE `fitness`.`tmp` (
		`cals` INT NOT NULL, `c_date` VARCHAR(2) NOT NULL);
    WHILE i>=0 DO
		SET cal = getTotCalCons(uname, date_sub(dat, interval i day));
        INSERT INTO `fitness`.`tmp`
			(`cals`, `c_date`) VALUES (cal, extract(DAY FROM date_sub(dat, interval i day)));
        SET i = i-1;
	END WHILE;
    SELECT * FROM tmp;
    DROP TABLE `fitness`.`tmp`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trackCalNet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trackCalNet`(uname VARCHAR(45), dat DATE)
BEGIN
	DECLARE i INT DEFAULT 6;
    DECLARE cal INT;
    CREATE TABLE `fitness`.`tmp` (
		`cals` INT NOT NULL, `c_date` VARCHAR(2) NOT NULL);
    WHILE i>=0 DO
		SET cal = getTotCalNet(uname, date_sub(dat, interval i day));
        INSERT INTO `fitness`.`tmp`
			(`cals`, `c_date`) VALUES (cal, extract(DAY FROM date_sub(dat, interval i day)));
        SET i = i-1;
	END WHILE;
    SELECT * FROM tmp;
    DROP TABLE `fitness`.`tmp`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-07 17:41:23
