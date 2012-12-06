/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     06.12.2012 22:15:25                          */
/*==============================================================*/

set foreign_key_checks = 0;

drop table if exists Distance;

drop table if exists Route;

drop table if exists RouteToStation;

drop table if exists Station;

drop table if exists StationToType;

drop table if exists TransportStop;

drop table if exists TransportType;

drop table if exists TransportUnit;

drop table if exists User;

/*==============================================================*/
/* Table: Distance                                              */
/*==============================================================*/
create table Distance
(
   Id                   integer not null auto_increment,
   StationFrom          integer,
   StationTo            integer,
   Distance             integer,
   primary key (Id)
);

/*==============================================================*/
/* Table: Route                                                 */
/*==============================================================*/
create table Route
(
   Id                   integer not null auto_increment,
   Name                 varchar(50),
   primary key (Id)
);

/*==============================================================*/
/* Table: RouteToStation                                        */
/*==============================================================*/
create table RouteToStation
(
   Id                   integer not null auto_increment,
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
   Id                   integer not null auto_increment,
   Name                 varchar(50),
   Lattitude            float,
   Longitude            float,
   primary key (Id)
);

/*==============================================================*/
/* Table: StationToType                                         */
/*==============================================================*/
create table StationToType
(
   Id                   integer not null auto_increment,
   StationId            integer,
   TransportTypeId      integer,
   primary key (Id)
);

/*==============================================================*/
/* Table: TransportStop                                         */
/*==============================================================*/
create table TransportStop
(
   Id                   integer not null auto_increment,
   TransportUnitId      integer,
   StationId            integer not null,
   Number               integer,
   RaceNumber           integer,
   StopTime             datetime,
   primary key (Id)
);

/*==============================================================*/
/* Table: TransportType                                         */
/*==============================================================*/
create table TransportType
(
   Id                   integer not null auto_increment,
   Name                 varchar(25),
   primary key (Id)
);

/*==============================================================*/
/* Table: TransportUnit                                         */
/*==============================================================*/
create table TransportUnit
(
   Id                   integer not null auto_increment,
   RegNumber            varchar(8),
   RouteId              integer,
   TransportTypeId      integer not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   Id                   integer not null auto_increment,
   Login                varchar(50),
   Password             varchar(64),
   primary key (Id)
);

alter table Distance add constraint FK_Reference_10 foreign key (StationTo)
      references Station (Id) on delete restrict on update restrict;

alter table Distance add constraint FK_Reference_9 foreign key (StationFrom)
      references Station (Id) on delete restrict on update restrict;

alter table RouteToStation add constraint FK_Reference_4 foreign key (RouteId)
      references Route (Id) on delete restrict on update restrict;

alter table RouteToStation add constraint FK_Reference_5 foreign key (StationId)
      references Station (Id) on delete restrict on update restrict;

alter table StationToType add constraint FK_Reference_2 foreign key (TransportTypeId)
      references TransportType (Id) on delete restrict on update restrict;

alter table StationToType add constraint FK_Reference_3 foreign key (StationId)
      references Station (Id) on delete restrict on update restrict;

alter table TransportStop add constraint FK_Reference_11 foreign key (StationId)
      references Station (Id) on delete restrict on update restrict;

alter table TransportStop add constraint FK_Reference_7 foreign key (TransportUnitId)
      references TransportUnit (Id) on delete restrict on update restrict;

alter table TransportUnit add constraint FK_Reference_1 foreign key (TransportTypeId)
      references TransportType (Id) on delete restrict on update restrict;

alter table TransportUnit add constraint FK_Reference_6 foreign key (RouteId)
      references Route (Id) on delete restrict on update restrict;

set foreign_key_checks = 1;
