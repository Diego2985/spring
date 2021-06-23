drop database db1;
create database db1;
use db1;
drop table if exists cliente;

/*create table usuario 
(id int primary key auto_increment,
email varchar(30) not null,
password varchar(30) not null,
rol varchar(30) not null,
boolean_activo enum('0', '1'));*/
/*activo bool*/

/*insert into usuario (email, password, rol)
values('martin@mail.com', 3456, 'admin'),
      ('maria@mail.com', 2189, 'admin'),
      ('carlos@mail.com', 2906, 'admin');*/

select*from cliente;
alter table cliente drop column password;


