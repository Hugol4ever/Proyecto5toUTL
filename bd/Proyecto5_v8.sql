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
    Contrasenia varchar(20),
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
    Promocion boolean default false,
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

drop table if exists Promocion;
create table Promocion
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


-- Vista Detalle Ventas ------------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewDetaVenta as
 select v.Id_Venta, d.Id_DetalleVenta,p.Nombre, d.Cantidad, d.Precio as preciodv, p.Precio, v.Fecha, v.Hora from Detalle_Venta d inner join Producto p on p.Id_Producto = d.Id_Producto1
 inner join Venta v on v.Id_Venta = d.Id_Venta1;
 select * from viewDetaVenta;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista Ventas ------------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewVenta as
select v.Id_Cliente1, v.Id_Venta, v.Fecha, v.Hora, (select sum(preciodv) from viewDetaVenta where Id_Venta = v.Id_Venta) as total 
from Venta as v;
 select * from viewVenta;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista Clientes -----------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewCliente as
select c.Id_Cliente, u.Id_Usuario, c.Nombre, c.Genero, c.Telefono, c.Correo, u.Contrasenia, c.N_Tarjeta, c.Limite_Saldo, c.Saldo_Dis
from Usuario u inner join Cliente c on u.Id_Cliente = c.Id_Cliente;
select * from viewCliente;
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista Productos-----------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewProducto as
select Id_Producto, Nombre, Marca, Categoria, Existencia, Precio, Foto from Producto;
select * from viewProducto;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista Promociones---------------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewPromos as
 select pro.Id_Promocion, pro.Precio_Promo, pro.Fecha, pro.Dias_Duracion,p.Nombre,p.Precio, p.Marca, p.Categoria, p.Foto from Promocion pro 
 inner join Producto p on p.Id_Producto = pro.Id_Producto2;
 select * from viewPromos;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista PromocionesReducida-------------------------------------------------------------------------------------------------------------------------------------------------------
create view viewPromosRed as
select pro.Id_Promocion, pro.Id_Producto2, p.Nombre, p.Precio, pro.Precio_Promo, pro.Dias_Duracion, pro.Fecha
from Promocion pro inner join Producto p on p.Id_Producto = pro.Id_Producto2;
select * from viewPromosRed;
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Vista LineaVenta -------------------------------------------------------------------------------------------------------------------------------------------------------------
-- create view viewLineaVenta as
-- select p.Id_Producto, p.Nombre, p.Precio;
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




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
values (var_Nombre,var_Correo,var_Telefono, var_Genero,var_N_Tarjeta, var_Limite_Saldo, var_Saldo_Dis);
set var_Id_Cliente = last_insert_id();

insert into Usuario (Nom_Usuario,Contrasenia,Id_Huella, Id_Foto, Id_Cliente) 
values (var_Nom_Usuario,var_Contraseña,var_Id_Huella, var_Id_Foto, var_Id_Cliente);
set var_Id_Usuario = last_insert_id();

end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Actualizar foto --------------------------------------------------------------------------------------------------------------------------------------------------------------

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Modificar cliente --------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure modCliente (
out var_Id_Huella int, in var_Huella blob,
in var_Id_Cliente int, in var_Nombre varchar(35), in var_Telefono varchar(10),
in var_Genero varchar(10), in var_N_Tarjeta varchar(25), in var_Limite_Saldo double,
in var_Saldo_Dis double, in var_Id_Usuario varchar(35), in var_Contrasenia varchar(20), in var_Id_Huella blob)
begin
insert into Huella (Huella) values (var_Huella);
set var_Id_Huella = last_insert_id();

update Cliente set Nombre = var_Nombre, Telefono = var_Telefono, Genereo = var_Genero,
N_Trajeta = var_N_Tarjeta, Limite_Saldo = var_Limite_Saldo, Saldo_Dis = var_Saldo_Dis
where Id_Cliente = var_Id_Cliente;

update Usuario set Contrasenia = var_Contrasenia, Id_Huella=var_Id_Huella where Id_Usuario = var_Id_Usuario;
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Registrar producto --------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regProducto (
in var_Id_Producto int, in var_Nombre varchar(35),in var_Marca varchar(20),
in var_Categoria varchar(20), in var_Existencia int,in var_Precio double(10,2),
in var_Foto varchar(100))
begin
insert into Producto (Id_Producto, Nombre, marca, categoria, Existencia, Precio, Foto)
values (var_Id_Producto, var_Nombre, var_Marca, var_Categoria, var_Existencia, var_Precio, var_Foto);
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Modificar producto --------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure modProducto (
in var_Id_Producto int, in var_Nombre varchar(35),in var_Marca varchar(20),
in var_Categoria varchar(20), in var_Existencia int,in var_Precio double(10,2),
in var_Foto varchar(100))
begin
update Producto set Nombre = var_Nombre, marca = var_Marca, categoria = var_Categoria, 
Existencia = var_Existencia, Precio = var_Precio, Foto = var_Foto
where Id_Producto = var_Id_Producto;
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Registrar promocion ------------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure regPromocion (
out var_Id_Promocion int, in var_Precio_Promo double(10,2), in var_Dias_Duracion int, in var_Id_Producto2 int)
begin
insert into Promocion (Precio_Promo, Fecha,Dias_Duracion, id_Producto2)
values (var_Precio_Promo, date_format(now(),'%Y-%m-%d'), var_Dias_Duracion, var_id_Producto2);
set var_Id_Promocion = last_insert_id();

update Producto set Promocion = true where Id_Producto = var_id_Producto2;
end $$
Delimiter ;
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Modificar promocion ----------------------------------------------------------------------------------------------------------------------------------------------------------
Delimiter $$
create procedure modPromocion(
in var_Id_Promocion int, in var_Precio_Promo double(10,2), in var_Dias_Duracion int)
begin
update Promocion set Precio_Promo = var_Precio_Promo, Dias_Duracion = var_Dias_Duracion where Id_Promocion = var_Id_Promocion;
end $$
Delimiter ;
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
create procedure regDetVenta (in var_Cantidad int, in var_Precio double(10,2), in var_Id_Producto1 int,in var_Id_Venta1 int, out var_Id_DetalleVenta int)
begin
insert into Detalle_Venta (Cantidad, Precio, Id_Producto1, Id_Venta1) values (var_Cantidad, var_Precio, var_Id_Producto1, var_Id_Venta1);
set var_Id_DetalleVenta=last_insert_id();
end $$
Delimiter ;
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
-- --------------------------- EVENTO ----------------------------------
-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
/*
Delimiter //
CREATE EVENT eventosMysqlTutorial
    ON SCHEDULE EVERY 1 DAY STARTS NOW()
	COMMENT 'Se ha rebajado un día a las promociones'
    DO 
		Begin
        
        update Promocion set Dias_Duracion 
        
        end//

delimiter ;
*/
-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------
-- -------------------------- PRUEBAS ----------------------------------
-- ---------------------------------------------------------------------
-- ---------------------------------------------------------------------

call regCliente(@out_idH,
null,
@out_idF, 
null,
@out_idC, 
'Hugo', 
'panchito_rso@hotmail.com', 
'4773395375', 
'masculino',
'1234-5678-9123',
7000,
7000,
@out_idU, 
'hugol4ever', 
'laslavanderas12');
select * from viewCliente;

call regProducto(123, 'Sopa instantanea Maruchan', 'Maruchan', 'Alimentos', 10, 7.00, './/src/productos/maruchan.jpg');
select * from viewProducto;
select * from Producto;

call regPromocion(@idPromo, 5, now(), 2, 123);
select * from viewPromos;

call regVenta(1, @idV);
select * from viewVenta;

call regDetVenta(2, 60, 126, @idV, @idDV);
select * from viewDetaVenta;
