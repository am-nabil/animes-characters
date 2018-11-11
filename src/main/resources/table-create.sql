-- auto-generated definition
create table characters
(
  id         integer not null
    constraint characters_pkey
    primary key,
  firstname  varchar(50),
  lastname   varchar(50),
  anime      varchar(50),
  image_href varchar(500)
);

alter table characters
  owner to postgres;