DROP DATABASE leftrightjoinexample;
CREATE DATABASE leftrightjoinexample;
USE leftrightjoinexample;

CREATE TABLE tableA (
id int not null,
sname varchar(30)
);

CREATE TABLE tableB (
id int not null,
sname varchar(30)
);

INSERT INTO tableA (id,sname) values (1,'angelos'),(2,'xrhstos'),(3,'agisilaos');

INSERT INTO tableB (id,sname) values (1,'angelos'),(2,'xrhstos'),(3,'pasparakis'),(4,'nikolaidi');

-- SELECT * FROM tableA LEFT OUTER JOIN tableB ON tableA.sname = tableB.sname;

-- SELECT * FROM tableA RIGHT OUTER JOIN tableB ON tableA.sname = tableB.sname;

/* 
SELECT * FROM tableA LEFT OUTER JOIN tableB ON tableA.sname = tableB.sname
UNION
SELECT * FROM tableA RIGHT OUTER JOIN tableB ON tableA.sname = tableB.sname;
*/



ALTER TABLE tableA
ADD toBeDeleted int;

ALTER TABLE tableA
DROP COLUMN toBeDeleted;

CREATE VIEW view1 AS
SELECT * FROM tableA
WHERE id BETWEEN 1 and 3;

DELIMITER //

CREATE PROCEDURE name_of_id4() 
begin

IF EXISTS (SELECT * FROM tableB WHERE id= 4) THEN
SELECT sname FROM tableB WHERE id=4;
ELSE
SELECT sname FROM tableB where id=3;
END IF;

end //

DELIMITER ;

