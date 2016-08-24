# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table common_role_model (
  id                            bigint auto_increment not null,
  role_name                     varchar(255) not null,
  rolestatus                    bigint,
  creation_date                 datetime(6) not null,
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

create table common_user_model (
  id                            bigint auto_increment not null,
  username                      varchar(255) not null,
  email                         varchar(255) not null,
  sha_password                  varbinary(64) not null,
  userstatus                    bigint,
  userrole                      bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_common_user_model_username unique (username),
  constraint uq_common_user_model_email unique (email),
  constraint pk_common_user_model primary key (id)
);

alter table common_role_model add constraint fk_common_role_model_rolestatus foreign key (rolestatus) references common_status_model (id) on delete restrict on update restrict;
create index ix_common_role_model_rolestatus on common_role_model (rolestatus);

alter table common_user_model add constraint fk_common_user_model_userstatus foreign key (userstatus) references common_status_model (id) on delete restrict on update restrict;
create index ix_common_user_model_userstatus on common_user_model (userstatus);

alter table common_user_model add constraint fk_common_user_model_userrole foreign key (userrole) references common_role_model (id) on delete restrict on update restrict;
create index ix_common_user_model_userrole on common_user_model (userrole);


# --- !Downs

alter table common_role_model drop foreign key fk_common_role_model_rolestatus;
drop index ix_common_role_model_rolestatus on common_role_model;

alter table common_user_model drop foreign key fk_common_user_model_userstatus;
drop index ix_common_user_model_userstatus on common_user_model;

alter table common_user_model drop foreign key fk_common_user_model_userrole;
drop index ix_common_user_model_userrole on common_user_model;

drop table if exists common_role_model;

drop table if exists common_status_model;

drop table if exists common_user_model;

