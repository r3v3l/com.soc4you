# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table common_role_model (
  id                            bigint auto_increment not null,
  role_name                     varchar(255) not null,
  creation_date                 datetime(6) not null,
  rolestatus                    bigint,
  update_date                   datetime(6) not null,
  constraint uq_common_role_model_role_name unique (role_name),
  constraint pk_common_role_model primary key (id)
);

create table common_status_model (
  id                            bigint auto_increment not null,
  status_name                   varchar(255) not null,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_common_status_model_status_name unique (status_name),
  constraint pk_common_status_model primary key (id)
);

alter table common_role_model add constraint fk_common_role_model_rolestatus foreign key (rolestatus) references common_status_model (id) on delete restrict on update restrict;
create index ix_common_role_model_rolestatus on common_role_model (rolestatus);


# --- !Downs

alter table common_role_model drop foreign key fk_common_role_model_rolestatus;
drop index ix_common_role_model_rolestatus on common_role_model;

drop table if exists common_role_model;

drop table if exists common_status_model;

