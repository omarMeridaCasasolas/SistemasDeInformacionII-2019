/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/09/2019 01:32:18 p.m.                     */
/*==============================================================*/

drop table if exists EmpFarmacia;

drop table if exists MEDICAMENTO;

drop table if exists PROMOCION;

drop table if exists PROMOCION_PRODUCTO;

drop table if exists MEDICAMENTO_RESERVA;

drop table if exists CLIENTE;

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


/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO
(
   IDMEDICAMENTO        varchar(50) not null,
   NOMBREMEDICAMENTO    varchar(50) not null,
   CODIGOSENASAG        varchar(20) not null,
   PREESCRIPCION        bool not null,
   PRECIO               float(8,2) not null,
   PRECIODEVENTA        float(8,2) not null,
   DOSIS                int not null,
   primary key (IDMEDICAMENTO)
);

/*==============================================================*/
/* Table: PROMOCION                                             */
/*==============================================================*/
create table PROMOCION
(
   IDPROMOCION          varchar(20) not null,
   NOMBREDEPROMOCION    varchar(30) not null,
   DESCRIPCIONPROMOCION varchar(100),
   primary key (IDPROMOCION)
);

/*==============================================================*/
/* Table: PROMOCION_PRODUCTO                                    */
/*==============================================================*/
create table PROMOCION_PRODUCTO
(
   IDMEDICAMENTO        varchar(50) not null,
   IDPROMOCION          varchar(20) not null,
   DESCUENTOMEDIACMENTO decimal,
   TIPOPROMOCION        varchar(30),
   primary key (IDMEDICAMENTO, IDPROMOCION)
);
/*==============================================================*/
/* Table: MEDICAMENTO_RESERVA                                    */
/*==============================================================*/
create table MEDICAMENTO_RESERVA 
(
   IDMEDICAMENTO        varchar(50) not null,
   IDRESERVA            varchar(25) not null,
   primary key (IDMEDICAMENTO, IDRESERVA)
);
/*==============================================================*/
/* Table: RESERVA                                               */
/*==============================================================*/
create table RESERVA
(
   IDRESERVA            varchar(25) not null,
   IDCLIENTE            varchar(25) not null,
   FECHARESERVA         date not null,
   HORARESERVA          time not null,
   primary key (IDRESERVA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   IDCLIENTE            varchar(25) not null,
   CARNETDEIDENTIDADCLIENTE varchar(25) not null,
   NOMBREPACIENTE       varchar(50) not null,
   ENFERMEDAD           varchar(200),
   LOGINEMPLEADO        varchar(15) not null,
   PASSWORD             varchar(15) not null,
   primary key (IDCLIENTE)
);


alter table PROMOCION_PRODUCTO add constraint FK_RELATIONSHIP_15 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table PROMOCION_PRODUCTO add constraint FK_RELATIONSHIP_20 foreign key (IDPROMOCION)
      references PROMOCION (IDPROMOCION) on delete restrict on update restrict;

alter table MEDICAMENTO_RESERVA add constraint FK_RELATIONSHIP_4 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table MEDICAMENTO_RESERVA add constraint FK_RELATIONSHIP_8 foreign key (IDRESERVA)
      references RESERVA (IDRESERVA) on delete restrict on update restrict;

alter table RESERVA add constraint FK_RELATIONSHIP_5 foreign key (IDCLIENTE)
      references CLIENTE (IDCLIENTE) on delete restrict on update restrict;