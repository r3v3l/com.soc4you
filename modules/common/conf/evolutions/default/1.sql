# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table common_status_model (
  id                            bigint auto_increment not null,
  status_name                   varchar(255) not null,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_common_status_model_status_name unique (status_name),
  constraint pk_common_status_model primary key (id)
);


# --- !Downs

drop table if exists common_status_model;

