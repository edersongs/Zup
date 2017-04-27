CREATE TABLE COORDENADA (
	codigo INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	coordenadaX INT NOT NULL,
	coordenadaY INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(1,'Lanchonete',27,12);
insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(2,'Posto',31,18);
insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(3,'Joalheria',15,12);
insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(4,'Floricultura',19,21);
insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(5,'Pub',12,8);
insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(6,'Supermercado',23,6);
insert into COORDENADA (codigo,nome,coordenadaX,coordenadaY) values(7,'Churrascaria',28,2);