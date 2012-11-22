/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     19.11.2012 17:44:34                          */
/*==============================================================*/

SET foreign_key_checks = 0;

drop table if exists Distance;

drop table if exists Route;

drop table if exists RouteToStation;

drop table if exists Station;

drop table if exists StationToType;

drop table if exists TransportStop;

drop table if exists TransportType;

drop table if exists TransportUnit;

/*==============================================================*/
/* Table: Distance                                              */
/*==============================================================*/
create table Distance
(
   Id                   integer not null,
   Station1             integer,
   Station2             integer,
   Distance             integer,
   primary key (Id)
);

/*==============================================================*/
/* Table: Route                                                 */
/*==============================================================*/
create table Route
(
   Id                   integer not null,
   Name                 varchar(0),
   primary key (Id)
);

/*==============================================================*/
/* Table: RouteToStation                                        */
/*==============================================================*/
create table RouteToStation
(
   Id                   integer not null,
   RouteId              integer,
   StationId            integer,
   StationNum           integer,
   primary key (Id)
);

/*==============================================================*/
/* Table: Station                                               */
/*==============================================================*/
create table Station
(
   Id                   integer not null,
   Name                 varchar(0),
   Longitude            float,
   Lattitude            float,
   primary key (Id)
);

/*==============================================================*/
/* Table: StationToType                                         */
/*==============================================================*/
create table StationToType
(
   Id                   integer not null,
   StationId            integer,
   TransportTypeId      integer,
   primary key (Id)
);

/*==============================================================*/
/* Table: TransportStop                                         */
/*==============================================================*/
create table TransportStop
(
   Id                   integer not null,
   RouteToStationId     integer,
   TransportUnitId      integer,
   Number               integer,
   Time                 datetime,
   primary key (Id)
);

/*==============================================================*/
/* Table: TransportType                                         */
/*==============================================================*/
create table TransportType
(
   Name                 varchar(0),
   Id                   integer not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: TransportUnit                                         */
/*==============================================================*/
create table TransportUnit
(
   Id                   integer not null,
   RegNumber            varchar(0),
   RouteId              integer,
   TransportTypeId      integer not null,
   primary key (Id)
);

alter table Distance add constraint FK_Reference_10 foreign key (Station2)
      references Station (Id) on delete restrict on update restrict;

alter table Distance add constraint FK_Reference_9 foreign key (Station1)
      references Station (Id) on delete restrict on update restrict;

alter table RouteToStation add constraint FK_Reference_4 foreign key (RouteId)
      references Route (Id) on delete restrict on update restrict;

alter table RouteToStation add constraint FK_Reference_5 foreign key (StationId)
      references Station (Id) on delete restrict on update restrict;

alter table StationToType add constraint FK_Reference_2 foreign key (TransportTypeId)
      references TransportType (Id) on delete restrict on update restrict;

alter table StationToType add constraint FK_Reference_3 foreign key (StationId)
      references Station (Id) on delete restrict on update restrict;

alter table TransportStop add constraint FK_Reference_7 foreign key (TransportUnitId)
      references TransportUnit (Id) on delete restrict on update restrict;

alter table TransportStop add constraint FK_Reference_8 foreign key (RouteToStationId)
      references RouteToStation (Id) on delete restrict on update restrict;

alter table TransportUnit add constraint FK_Reference_1 foreign key (TransportTypeId)
      references TransportType (Id) on delete restrict on update restrict;

alter table TransportUnit add constraint FK_Reference_6 foreign key (RouteId)
      references Route (Id) on delete restrict on update restrict;

SET foreign_key_checks = 1;