/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/09/2019 01:32:18 p.m.                     */
/*==============================================================*/


drop table if exists ADMINISTRADORDEFARMACIA;

drop table if exists ADMINISTRATORDEALMACEN;

drop table if exists CLIENTE;

drop table if exists CONTRATO;

drop table if exists FARMAUCEUTICO;

drop table if exists LOGINEMPLEADO;

drop table if exists MEDICAMENTO;

drop table if exists PROMOCION;

drop table if exists PROVEEDOR;

drop table if exists RELATIONSHIP_1;

drop table if exists RELATIONSHIP_15;

drop table if exists RELATIONSHIP_4;

drop table if exists RESERVA;

drop table if exists VENTA;

/*==============================================================*/
/* Table: ADMINISTRADORDEFARMACIA                               */
/*==============================================================*/
create table ADMINISTRADORDEFARMACIA
(
   IDADMINISTRADORFARMACIA varchar(25) not null,
   NOMBREADMINISTRADODEFARMACIA varchar(50) not null,
   CIADMINISTRADORDEFARMACIA varchar(15) not null,
   CELULARADMINISTRADORDEFARMACIA varchar(15) not null,
   DIRECCIONFARMACEUTICO varchar(50) not null,
   primary key (IDADMINISTRADORFARMACIA)
);

/*==============================================================*/
/* Table: ADMINISTRATORDEALMACEN                                */
/*==============================================================*/
create table ADMINISTRATORDEALMACEN
(
   IDADMINISTRADORDEALMACEN varchar(20) not null,
   CIADMINISTRADORDEALMACEN varchar(15) not null,
   NOMBREADMINISTRADORDELAMLACEN varchar(50) not null,
   DIRECCIONADMINISTRADORDELALMACEN varchar(50) not null,
   CELULARDEADMINISTRADORDEALMACEN varchar(10),
   primary key (IDADMINISTRADORDEALMACEN)
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

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO
(
   IDCONTRATO           varchar(25) not null,
   IDFARMACEUTICO       varchar(25) not null,
   IDADMINISTRADORDEALMACEN varchar(20) not null,
   PAGOMENSUAL          float(8,2) not null,
   primary key (IDCONTRATO)
);

/*==============================================================*/
/* Table: FARMAUCEUTICO                                         */
/*==============================================================*/
create table FARMAUCEUTICO
(
   IDFARMACEUTICO       varchar(25) not null,
   CIFARMACEUTICO       varchar(25) not null,
   NOMBREFARMACEUTICO   varchar(50) not null,
   DIRECCIONFARMACEUTICO varchar(50) not null,
   CELULARFARMACEUTICO  varchar(10),
   primary key (IDFARMACEUTICO)
);

/*==============================================================*/
/* Table: LOGINEMPLEADO                                         */
/*==============================================================*/
create table LOGINEMPLEADO
(
   IDLOGINEMPLEADO      varchar(25) not null,
   IDADMINISTRADORFARMACIA varchar(25) not null,
   IDFARMACEUTICO       varchar(25) not null,
   IDADMINISTRADORDEALMACEN varchar(20) not null,
   LOGINEMPLEADO        varchar(15) not null,
   PASSEMPLEADO         varchar(15) not null,
   CARGO                varchar(25) not null,
   primary key (IDLOGINEMPLEADO)
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
   TIPODEPROMOCION      varchar(20) not null,
   primary key (IDPROMOCION)
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR
(
   IDPROVEEDOR          varchar(20) not null,
   IDMEDICAMENTO        varchar(50) not null,
   TIPODEPROVEEDDOR     varchar(20) not null,
   CORREOELECTRONICOPROVEEDOR varchar(40) not null,
   primary key (IDPROVEEDOR)
);

/*==============================================================*/
/* Table: RELATIONSHIP_1                                        */
/*==============================================================*/
create table RELATIONSHIP_1
(
   IDVENTA              varchar(30) not null,
   IDMEDICAMENTO        varchar(50) not null,
   primary key (IDVENTA, IDMEDICAMENTO)
);

/*==============================================================*/
/* Table: RELATIONSHIP_15                                       */
/*==============================================================*/
create table RELATIONSHIP_15
(
   IDMEDICAMENTO        varchar(50) not null,
   IDPROMOCION          varchar(20) not null,
   primary key (IDMEDICAMENTO, IDPROMOCION)
);

/*==============================================================*/
/* Table: RELATIONSHIP_4                                        */
/*==============================================================*/
create table RELATIONSHIP_4
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
/* Table: VENTA                                                 */
/*==============================================================*/
create table VENTA
(
   IDVENTA              varchar(30) not null,
   IDFARMACEUTICO       varchar(25) not null,
   IDCLIENTE            varchar(25) not null,
   HORADEVENTA          time not null,
   FECHADEVENTA         date not null,
   TOTAL                float(8,2) not null,
   primary key (IDVENTA)
);

alter table CONTRATO add constraint FK_RELATIONSHIP_10 foreign key (IDADMINISTRADORDEALMACEN)
      references ADMINISTRATORDEALMACEN (IDADMINISTRADORDEALMACEN) on delete restrict on update restrict;

alter table CONTRATO add constraint FK_RELATIONSHIP_9 foreign key (IDFARMACEUTICO)
      references FARMAUCEUTICO (IDFARMACEUTICO) on delete restrict on update restrict;

alter table LOGINEMPLEADO add constraint FK_RELATIONSHIP_17 foreign key (IDADMINISTRADORFARMACIA)
      references ADMINISTRADORDEFARMACIA (IDADMINISTRADORFARMACIA) on delete restrict on update restrict;

alter table LOGINEMPLEADO add constraint FK_RELATIONSHIP_18 foreign key (IDFARMACEUTICO)
      references FARMAUCEUTICO (IDFARMACEUTICO) on delete restrict on update restrict;

alter table LOGINEMPLEADO add constraint FK_RELATIONSHIP_19 foreign key (IDADMINISTRADORDEALMACEN)
      references ADMINISTRATORDEALMACEN (IDADMINISTRADORDEALMACEN) on delete restrict on update restrict;

alter table PROVEEDOR add constraint FK_RELATIONSHIP_6 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table RELATIONSHIP_1 add constraint FK_RELATIONSHIP_1 foreign key (IDVENTA)
      references VENTA (IDVENTA) on delete restrict on update restrict;

alter table RELATIONSHIP_1 add constraint FK_RELATIONSHIP_7 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table RELATIONSHIP_15 add constraint FK_RELATIONSHIP_15 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table RELATIONSHIP_15 add constraint FK_RELATIONSHIP_20 foreign key (IDPROMOCION)
      references PROMOCION (IDPROMOCION) on delete restrict on update restrict;

alter table RELATIONSHIP_4 add constraint FK_RELATIONSHIP_4 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table RELATIONSHIP_4 add constraint FK_RELATIONSHIP_8 foreign key (IDRESERVA)
      references RESERVA (IDRESERVA) on delete restrict on update restrict;

alter table RESERVA add constraint FK_RELATIONSHIP_5 foreign key (IDCLIENTE)
      references CLIENTE (IDCLIENTE) on delete restrict on update restrict;

alter table VENTA add constraint FK_RELATIONSHIP_2 foreign key (IDFARMACEUTICO)
      references FARMAUCEUTICO (IDFARMACEUTICO) on delete restrict on update restrict;

alter table VENTA add constraint FK_RELATIONSHIP_3 foreign key (IDCLIENTE)
      references CLIENTE (IDCLIENTE) on delete restrict on update restrict;

