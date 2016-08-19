# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact_model (
  id                            bigint auto_increment not null,
  username                      varchar(255) not null,
  email                         varchar(255) not null,
  message                       TEXT not null,
  creation_date                 datetime(6) not null,
  constraint pk_contact_model primary key (id)
);

create table newsletter_model (
  id                            bigint auto_increment not null,
  email                         varchar(255) not null,
  creation_date                 datetime(6) not null,
  constraint uq_newsletter_model_email unique (email),
  constraint pk_newsletter_model primary key (id)
);


# --- !Downs

drop table if exists contact_model;

drop table if exists newsletter_model;

