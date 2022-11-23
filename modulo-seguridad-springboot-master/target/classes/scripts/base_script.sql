show tables;


create table  USERS(

	id int,
	name varchar(255),
	lastname varchar(255),
	username varchar(20),
	pass varchar(100),
	tipDoc char(5),
	nroDoc varchar(20),
	enable int

)


alter table USERS add primary key(id);

ALTER TABLE moduloseg.users MODIFY COLUMN id int auto_increment NOT NULL;


/*insert Data */
insert into USERS (name,
lastname,
username,
pass,
tipDoc,
nroDoc,
enable) values ('Jesus','Zuniga','DNI71234267','123456','DNI','73267572',1);

insert into USERS (name,
lastname,
username,
pass,
tipDoc,
nroDoc,
enable) values ('Maria','Martinez','DNI71234263','123426','DNI','74267572',1);

/* Actualizar */

update users set name='Mariana' where username='DNI71234263';

/*Eliminar*/

delete  from users where username='DNI71234267';



select * from users
