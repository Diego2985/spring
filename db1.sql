drop database db1;
create database db1;
use db1;
drop table if exists gato;
id
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

select*from articulo;
alter table cliente drop column password;

insert into servicio(nombre, precio)
values("corte de pelo", 300.00),
      ("corte de uñas", 100.00),
      ("baño", 250.00);
insert into articulo(descripcion, precio, tituloArticulo)
values("superman", 1500.00, "disfraz"),
      ("pirata", 1200.00, "disfraz"),
      ("pijama", 2400.00, "enterizo"),
      ("chaleco militar", 3000.00, "chaleco");