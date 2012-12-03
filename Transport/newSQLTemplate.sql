SET foreign_key_checks = 0;

/*==============================================================*/
/* Table: TransportType                                         */
/*==============================================================*/
create table TransportType
(
   Name                 varchar(30),
   Id                   integer not null auto_increment,
   primary key (Id)
);


drop table if exists TransportType;
