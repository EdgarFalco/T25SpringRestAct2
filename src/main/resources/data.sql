DROP table IF EXISTS empleado;
DROP table IF EXISTS departamento;

create table departamento(
	codigo int auto_increment primary key,
    nombre varchar(250),
    presupuesto int
    );
    
create table empleado(
    dni nvarchar(9) primary key,
    nombre nvarchar(100),
    apellidos nvarchar(255),
    departamento int,
    foreign key (departamento) references departamento (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into departamento (nombre,presupuesto) values ('I+D', 20000);
insert into departamento (nombre,presupuesto) values ('Contabilidad', 10000);
insert into departamento (nombre,presupuesto) values ('Recursos', 40000);
insert into departamento (nombre,presupuesto) values ('Produccion', 30000);
insert into departamento (nombre,presupuesto) values ('Infomatica', 70000);

insert into empleado (dni,nombre,apellidos,departamento) values ('39954871W','Edgar','Falco Queralt', 1);
insert into empleado (dni,nombre,apellidos,departamento) values ('39913331W','Raul','Montala', 1);
insert into empleado (dni,nombre,apellidos,departamento) values ('39944471W','Guido','Emmanuel', 2);
insert into empleado (dni,nombre,apellidos,departamento) values ('39955571W','Cristian','Pizarro', 2);
insert into empleado (dni,nombre,apellidos,departamento) values ('39966671W','Edu','Guitierrez', 3);
