////////////// hsqldb
Create table Movie(
	id identity primary key,
	name varchar(50),
	points int
);
/////////////////////

///////////////////mysql
Create table Movie(
	id int(9) auto_increment,
	name varchar(50),
	points int(9)
);
///////////////////////



INSERT INTO Movie (id,name,points) VALUES (2,'Underworld',52);
INSERT INTO Movie (id,name,points) VALUES (3,'Revenge',88);
INSERT INTO Movie (id,name,points) VALUES (4,'House',20);
INSERT INTO Movie (id,name,points) VALUES (5,'Lula, O filho do Brasil',14);
INSERT INTO Movie(id,name,points) VALUES (6,'Dragon Ball Z. The Movie',88);
