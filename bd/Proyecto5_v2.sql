drop database if exists Proyecto5;
create database Proyecto5;
use Proyecto5;

drop table if exists Huella;
create table Huella
(
	Id_Huella int auto_increment,
    Huella blob,
    constraint pk_Id_Huella primary key(Id_Huella)
);

drop table if exists FotoCliente;
create table FotoCliente
(
	Id_Foto int auto_increment,
	Foto blob,
    constraint pk_Id_Foto primary key(Id_Foto)
);

drop table if exists Cliente;
create table Cliente
(
	Id_Cliente int auto_increment,
    Nombre varchar(35),
    Correo varchar(35),
    Telefono varchar(10),
    Genero varchar(10),
    N_Tarjeta varchar(25),
    Limite_Saldo double,
    Saldo_Dis double,
    constraint pk_Id_Cliente primary key(Id_Cliente)
);

drop table if exists Usuario;
create table Usuario
(
	Id_Usuario int auto_increment,
    Nom_Usuario varchar(35),
    Contraseña varchar(20),
    Id_Huella int,
    Id_Foto int,
    Id_Cliente int,
    constraint pk_Id_Usuario primary key(Id_Usuario),
    constraint fk_Id_Huella foreign key(Id_Huella) references Huella(Id_Huella),
    constraint fk_Id_Foto foreign key(Id_Foto) references FotoCliente(Id_Foto),
    constraint fk_Id_Cliente foreign key(Id_Cliente) references Cliente(Id_Cliente)
);

drop table if exists Producto;
create table Producto
(
	Id_Producto int,
    Nombre varchar(35),
    Marca varchar(20),
    Categoria varchar(20),
    Existencia int,
	Precio double(10,2),
    Foto varchar(100),
    constraint pk_Id_Producto primary key(Id_Producto)
);

drop table if exists Venta;
create table Venta
(
	Id_Venta int auto_increment,
    Fecha date,
    Hora time,
    Id_Cliente1 int,
    constraint pk_Id_Venta primary key(Id_Venta),
    constraint fk_Id_Cliente1 foreign key(Id_Cliente1) references Cliente(Id_Cliente)
);

drop table if exists Detalle_Venta;
create table Detalle_Venta
(
	Id_DetalleVenta int auto_increment,
    Cantidad int,
    Precio double(10,2),
    Id_Producto1 int,
    Id_Venta1 int,
    constraint pk_Id_DetalleVenta primary key(Id_DetalleVenta),
    constraint fk_Id_Producto1 foreign key(Id_Producto1) references Producto(Id_Producto),
    constraint fk_Id_Venta1 foreign key(Id_Venta1) references Venta(Id_Venta)
);

drop table if exists Promociones;
create table Promociones
(
 Id_Promocion int auto_increment,
 Precio_Promo double(10,2),
 Fecha date,
 Dias_Duracion int,
 Id_Producto2 int,
 constraint pk_Id_promocion primary key (Id_Promocion),
 constraint fk_Id_Producto2 foreign key(Id_Producto2) references Producto (Id_Producto)
);

-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
-- ------------------------------ VISTAS -------------------------------
-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------


-- Vista Clientes -----------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewCliente as
select u.Id_Usuario, c.Nombre, c.Genero, c.Telefono, c.Correo, u.Contraseña, c.N_Tarjeta, c.Limite_Saldo, c.Saldo_Dis
from Usuario u inner join Cliente c on u.Id_Cliente = c.Id_Cliente;
select * from viewCliente;
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Vista Productos-----------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewProducto as
select * from Producto;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Vista LineaVenta -------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewLineaVenta as
select p.Id_Producto, p.Nombre, p.Precio;
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista Ventas ------------------------------------------------------------------------------------------------------------------------------------------------------------------



-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
-- ------------------------- PROCEDIMIENTOS ----------------------------
-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------


-- Registrar Cliente --------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regCliente (out var_Id_Huella int, in var_Huella blob, out var_Id_Foto int, in var_Foto blob,
out var_Id_Cliente int, in var_Nombre varchar(35), in var_Correo varchar(35), in var_Telefono varchar(10), 
in var_Genero varchar(10),in var_N_Tarjeta varchar(25), in var_Limite_Saldo double,in var_Saldo_Dis double,
out var_Id_Usuario int, in var_Nom_Usuario varchar(35), in var_Contraseña varchar(20))

begin
insert into FotoCliente (Foto) values (var_Foto);
set var_Id_Foto = last_insert_id();

insert into Huella (Huella) values (var_Huella);
set var_Id_Huella = last_insert_id();

insert into Cliente (Nombre,Correo,Telefono,Genero,N_Tarjeta, Limite_Saldo, Saldo_Dis) 
values (var_Nombre,var_Correo,var_Telefono,Genero,var_N_Tarjeta, var_Limite_Saldo, var_Saldo_Dis);
set var_Id_Cliente = last_insert_id();

insert into Usuario (Nom_Usuario,Contraseña,Id_Huella, Id_Foto, Id_Cliente) 
values (var_Nom_Usuario,var_Contraseña,var_Id_Huella, var_Id_Foto, var_Id_Cliente);
set var_Id_Usuario = last_insert_id();

end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Registrar producto --------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regProducto (
out var_Id_Producto int, in var_Nombre varchar(35),in var_Marca varchar(20),
in var_Categoria varchar(20), in var_Existencia int,in var_Precio double(10,2),
in var_Foto varchar(100))
begin
insert into Producto (Nombre, marca, categoria, Existencia, Precio, Foto)
values (var_Nombre, var_Marca, var_Categoria, var_Existencia, var_Precio, var_Foto);
set var_Id_Producto = last_insert_id();
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Registrar promocion ------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regPromocion (
out var_Id_Promocion int, in var_Precio_Promo double(10,2), int var_Fecha date, in var_Dias_Duracion int, in var_Id_Producto2 int)
begin
insert into Promociones (Precio_Promo, Fecha,Dias_Duracion, id_Producto2)
values (var_Precio_Promo, var_Fecha, var_Dias_Duracion, var_id_Producto2); set var_Id_Promocion = last_insert_id();
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Registrar Venta ----------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regVenta (in var_Id_Cliente1 int, out var_Id_Venta int)                                     
begin
insert into Venta (Fecha,Hora,Id_Cliente1) values (date_format(now(),'%Y-%m-%d'),time(now()),var_Id_Cliente1);
set var_Id_Venta = last_insert_id();
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 
 -- Registrar Detalle_Venta ----------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regDetVenta (in var_Cantidad int, in var_Precio double(10,2), in var_Id_Producto1 int,in va_Id_Venta1 int, out var_Id_DetalleVenta int)
begin
insert into Detalle_Venta (Cantidad, Precio, Id_Producto1, Id_Venta1) values (var_Cantidad, var_Precio, var_Id_Producto1, var_Id_Venta1);
set var_Id_DetalleVenta=last_insert_id();
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
