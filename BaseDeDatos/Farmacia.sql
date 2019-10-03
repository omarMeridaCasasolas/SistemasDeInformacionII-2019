/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/09/2019 01:32:18 p.m.                     */
/*==============================================================*/

drop table if exists AdmFarmacia;

drop table if exists AdmAlmacen;

drop table if exists Vendedor;

/*==============================================================*/
/* Table: AdmFarmacia                               */
/*==============================================================*/
create table AdmFarmacia
(
   idAdmFarmacia varchar(25) not null,
   nomAdmFarmacia varchar(50) not null,
   ciAdmFarmacia varchar(15) not null,
   telAdmFarmacia varchar(15) not null,
   primary key (idAdmFarmacia)
);

/*==============================================================*/
/* Table: AdmAlmacen                                */
/*==============================================================*/
create table AdmAlmacen
(
   idAdmAlmacen varchar(20) not null,
   ciAdmAlmacen varchar(15) not null,
   nomAdmAlmacen varchar(50) not null,
   dirAdmAlmacen varchar(50) not null,
   telAdmAlmacen varchar(10),
   primary key (idAdmAlmacen)
);

/*==============================================================*/
/* Table: Vendedor                                         */
/*==============================================================*/
create table Vendedor
(
   idVendedor       varchar(25) not null,
   ciVendedor       varchar(25) not null,
   nomVendedor   varchar(50) not null,
   dirVendedor varchar(50) not null,
   telVendedor  varchar(10),
   primary key (idVendedor)
);

