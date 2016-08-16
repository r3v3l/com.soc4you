# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact_model (
  id                            bigint not null,
  username                      varchar(255) not null,
  email                         varchar(255) not null,
  message                       TEXT not null,
  creation_date                 timestamp not null,
  constraint uq_contact_model_username unique (username),
  constraint uq_contact_model_email unique (email),
  constraint pk_contact_model primary key (id)
);
create sequence contact_model_seq;

create table newsletter_model (
  id                            bigint not null,
  email                         varchar(255) not null,
  creation_date                 timestamp not null,
  constraint uq_newsletter_model_email unique (email),
  constraint pk_newsletter_model primary key (id)
);
create sequence newsletter_model_seq;


# --- !Downs

drop table if exists contact_model;
drop sequence if exists contact_model_seq;

drop table if exists newsletter_model;
drop sequence if exists newsletter_model_seq;

