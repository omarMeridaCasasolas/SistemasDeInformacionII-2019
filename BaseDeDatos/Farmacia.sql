/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/09/2019 01:32:18 p.m.                     */
/*==============================================================*/

drop table if exists EmpFarmacia;

/*==============================================================*/
/* Table: EmpFarmacia
/*==============================================================*/
create table EmpFarmacia
(
   idEmp     int not null,
   nomEmp    varchar(50) not null,
   apeEmp    varchar(50) not null,
   ciEmp     varchar(15) not null,
   fecNacEmp date not null,	
   dirEmp    varchar(50) not null,
   telEmp    int not null,
   cargoEmp  varchar(25) not null,
   primary key (idEmp)
);

