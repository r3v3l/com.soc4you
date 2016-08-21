# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  articlecategorystatus         bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_article_category_model_name unique (name),
  constraint uq_article_category_model_title unique (title),
  constraint uq_article_category_model_image unique (image),
  constraint uq_article_category_model_description unique (description),
  constraint uq_article_category_model_keywords unique (keywords),
  constraint pk_article_category_model primary key (id)
);

create table article_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_article_category_roles_model primary key (id)
);

create table article_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  articlestatus                 bigint,
  articlecontenttype            bigint,
  articlecategory               bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_article_model_name unique (name),
  constraint uq_article_model_title unique (title),
  constraint uq_article_model_small_image unique (small_image),
  constraint uq_article_model_large_image unique (large_image),
  constraint uq_article_model_description unique (description),
  constraint uq_article_model_keywords unique (keywords),
  constraint pk_article_model primary key (id)
);

create table article_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_article_roles_model primary key (id)
);

create table company_settings_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  email                         varchar(255) not null,
  phone                         varchar(255) not null,
  logo                          varchar(255) not null,
  longitude                     varchar(255) not null,
  latitude                      varchar(255) not null,
  about_us                      TEXT not null,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_company_settings_model_name unique (name),
  constraint uq_company_settings_model_email unique (email),
  constraint uq_company_settings_model_phone unique (phone),
  constraint uq_company_settings_model_logo unique (logo),
  constraint pk_company_settings_model primary key (id)
);

create table contact_model (
  id                            bigint auto_increment not null,
  username                      varchar(255) not null,
  email                         varchar(255) not null,
  message                       TEXT not null,
  creation_date                 datetime(6) not null,
  constraint pk_contact_model primary key (id)
);

create table content_type_model (
  id                            bigint auto_increment not null,
  type_name                     varchar(255) not null,
  contenttypestatus             bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_content_type_model_type_name unique (type_name),
  constraint pk_content_type_model primary key (id)
);

create table customer_model (
  id                            bigint auto_increment not null,
  telephone                     varchar(255) not null,
  company_name                  varchar(255) not null,
  address                       varchar(255) not null,
  city                          varchar(255) not null,
  country                       varchar(255) not null,
  postal_code                   varchar(255) not null,
  tax_number                    varchar(255) not null,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_customer_model_id unique (id),
  constraint uq_customer_model_telephone unique (telephone),
  constraint uq_customer_model_tax_number unique (tax_number),
  constraint pk_customer_model primary key (id)
);

create table forum_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  forumcategorystatus           bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_forum_category_model_name unique (name),
  constraint uq_forum_category_model_title unique (title),
  constraint uq_forum_category_model_image unique (image),
  constraint uq_forum_category_model_description unique (description),
  constraint uq_forum_category_model_keywords unique (keywords),
  constraint pk_forum_category_model primary key (id)
);

create table forum_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_forum_category_roles_model primary key (id)
);

create table forum_post_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  forumpoststatus               bigint,
  forumpostcategory             bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_forum_post_model_name unique (name),
  constraint uq_forum_post_model_title unique (title),
  constraint uq_forum_post_model_image unique (image),
  constraint uq_forum_post_model_description unique (description),
  constraint uq_forum_post_model_keywords unique (keywords),
  constraint pk_forum_post_model primary key (id)
);

create table forum_post_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_forum_post_roles_model primary key (id)
);

create table interview_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  interviewstatus               bigint,
  interviewcontenttype          bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_interview_model_name unique (name),
  constraint uq_interview_model_title unique (title),
  constraint uq_interview_model_small_image unique (small_image),
  constraint uq_interview_model_large_image unique (large_image),
  constraint uq_interview_model_description unique (description),
  constraint uq_interview_model_keywords unique (keywords),
  constraint pk_interview_model primary key (id)
);

create table interview_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_interview_roles_model primary key (id)
);

create table job_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  jobcategorystatus             bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_job_category_model_name unique (name),
  constraint uq_job_category_model_title unique (title),
  constraint uq_job_category_model_image unique (image),
  constraint uq_job_category_model_description unique (description),
  constraint uq_job_category_model_keywords unique (keywords),
  constraint pk_job_category_model primary key (id)
);

create table job_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_job_category_roles_model primary key (id)
);

create table job_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  company_name                  varchar(255) not null,
  location                      varchar(255) not null,
  job_price                     varchar(255) not null,
  delivery_time                 varchar(255) not null,
  overview                      TEXT not null,
  benefits                      TEXT not null,
  qualifications                TEXT not null,
  jobstatus                     bigint,
  jobcategory                   bigint,
  jobtype                       bigint,
  jobcontenttype                bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_job_model_name unique (name),
  constraint uq_job_model_title unique (title),
  constraint uq_job_model_small_image unique (small_image),
  constraint uq_job_model_large_image unique (large_image),
  constraint uq_job_model_description unique (description),
  constraint uq_job_model_keywords unique (keywords),
  constraint pk_job_model primary key (id)
);

create table job_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_job_roles_model primary key (id)
);

create table job_type_model (
  id                            bigint auto_increment not null,
  type_name                     varchar(255) not null,
  jobtypestatus                 bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_job_type_model_type_name unique (type_name),
  constraint pk_job_type_model primary key (id)
);

create table news_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  newscategorystatus            bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_news_category_model_name unique (name),
  constraint uq_news_category_model_title unique (title),
  constraint uq_news_category_model_image unique (image),
  constraint uq_news_category_model_description unique (description),
  constraint uq_news_category_model_keywords unique (keywords),
  constraint pk_news_category_model primary key (id)
);

create table news_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_news_category_roles_model primary key (id)
);

create table news_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  newsstatus                    bigint,
  newscontenttype               bigint,
  newscategory                  bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_news_model_name unique (name),
  constraint uq_news_model_title unique (title),
  constraint uq_news_model_small_image unique (small_image),
  constraint uq_news_model_large_image unique (large_image),
  constraint uq_news_model_description unique (description),
  constraint uq_news_model_keywords unique (keywords),
  constraint pk_news_model primary key (id)
);

create table news_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_news_roles_model primary key (id)
);

create table newsletter_model (
  id                            bigint auto_increment not null,
  email                         varchar(255) not null,
  creation_date                 datetime(6) not null,
  constraint uq_newsletter_model_email unique (email),
  constraint pk_newsletter_model primary key (id)
);

create table opening_hours_model (
  id                            bigint auto_increment not null,
  week                          varchar(255),
  saturday                      varchar(255),
  sunday                        varchar(255),
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint pk_opening_hours_model primary key (id)
);

create table page_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  pagestatus                    bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_page_model_name unique (name),
  constraint uq_page_model_title unique (title),
  constraint uq_page_model_image unique (image),
  constraint uq_page_model_description unique (description),
  constraint uq_page_model_keywords unique (keywords),
  constraint pk_page_model primary key (id)
);

create table page_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_page_roles_model primary key (id)
);

create table partner_logo_model (
  id                            bigint auto_increment not null,
  partner_name                  varchar(255) not null,
  partner_image                 varchar(255) not null,
  partner_alt                   varchar(255) not null,
  partner_title                 varchar(255) not null,
  partnerlogostatus             bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_partner_logo_model_partner_name unique (partner_name),
  constraint uq_partner_logo_model_partner_image unique (partner_image),
  constraint uq_partner_logo_model_partner_alt unique (partner_alt),
  constraint uq_partner_logo_model_partner_title unique (partner_title),
  constraint pk_partner_logo_model primary key (id)
);

create table partner_review_model (
  id                            bigint auto_increment not null,
  partner_name                  varchar(255) not null,
  partner_image                 varchar(255) not null,
  partner_alt                   varchar(255) not null,
  partner_title                 varchar(255) not null,
  partner_review                TEXT not null,
  partnerreviewstatus           bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_partner_review_model_partner_name unique (partner_name),
  constraint uq_partner_review_model_partner_image unique (partner_image),
  constraint uq_partner_review_model_partner_alt unique (partner_alt),
  constraint uq_partner_review_model_partner_title unique (partner_title),
  constraint pk_partner_review_model primary key (id)
);

create table portfolio_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  portfolioncategorystatus      bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_portfolio_category_model_name unique (name),
  constraint uq_portfolio_category_model_title unique (title),
  constraint uq_portfolio_category_model_image unique (image),
  constraint uq_portfolio_category_model_description unique (description),
  constraint uq_portfolio_category_model_keywords unique (keywords),
  constraint pk_portfolio_category_model primary key (id)
);

create table portfolio_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_portfolio_category_roles_model primary key (id)
);

create table portfolio_item_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  portfolioitemstatus           bigint,
  poertfoliocategory            bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_portfolio_item_model_name unique (name),
  constraint uq_portfolio_item_model_title unique (title),
  constraint uq_portfolio_item_model_small_image unique (small_image),
  constraint uq_portfolio_item_model_large_image unique (large_image),
  constraint uq_portfolio_item_model_description unique (description),
  constraint uq_portfolio_item_model_keywords unique (keywords),
  constraint pk_portfolio_item_model primary key (id)
);

create table portfolio_item_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_portfolio_item_roles_model primary key (id)
);

create table profile_model (
  id                            bigint auto_increment not null,
  firstname                     varchar(255) not null,
  lastname                      varchar(255) not null,
  profile_image                 varchar(255) not null,
  biography                     TEXT not null,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_profile_model_id unique (id),
  constraint uq_profile_model_firstname unique (firstname),
  constraint uq_profile_model_lastname unique (lastname),
  constraint uq_profile_model_profile_image unique (profile_image),
  constraint pk_profile_model primary key (id)
);

create table review_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  reviewcategorystatus          bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_review_category_model_name unique (name),
  constraint uq_review_category_model_title unique (title),
  constraint uq_review_category_model_image unique (image),
  constraint uq_review_category_model_description unique (description),
  constraint uq_review_category_model_keywords unique (keywords),
  constraint pk_review_category_model primary key (id)
);

create table review_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_review_category_roles_model primary key (id)
);

create table review_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  reviewstatus                  bigint,
  reviewcontenttype             bigint,
  reviewcategory                bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_review_model_name unique (name),
  constraint uq_review_model_title unique (title),
  constraint uq_review_model_small_image unique (small_image),
  constraint uq_review_model_large_image unique (large_image),
  constraint uq_review_model_description unique (description),
  constraint uq_review_model_keywords unique (keywords),
  constraint pk_review_model primary key (id)
);

create table review_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_review_roles_model primary key (id)
);

create table role_model (
  id                            bigint auto_increment not null,
  role_name                     varchar(255) not null,
  rolestatus                    bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_role_model_role_name unique (role_name),
  constraint pk_role_model primary key (id)
);

create table service_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  servicestatus                 bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_service_model_name unique (name),
  constraint uq_service_model_title unique (title),
  constraint uq_service_model_small_image unique (small_image),
  constraint uq_service_model_large_image unique (large_image),
  constraint uq_service_model_description unique (description),
  constraint uq_service_model_keywords unique (keywords),
  constraint pk_service_model primary key (id)
);

create table shop_category_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  image                         varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  shopcategorystatus            bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_shop_category_model_name unique (name),
  constraint uq_shop_category_model_title unique (title),
  constraint uq_shop_category_model_image unique (image),
  constraint uq_shop_category_model_description unique (description),
  constraint uq_shop_category_model_keywords unique (keywords),
  constraint pk_shop_category_model primary key (id)
);

create table shop_category_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_shop_category_roles_model primary key (id)
);

create table shop_item_model (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  title                         varchar(255) not null,
  small_image                   varchar(255) not null,
  large_image                   varchar(255) not null,
  description                   varchar(255) not null,
  keywords                      varchar(255) not null,
  content                       TEXT not null,
  shopitemstatus                bigint,
  shopitemcontenttype           bigint,
  shopitemcategory              bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_shop_item_model_name unique (name),
  constraint uq_shop_item_model_title unique (title),
  constraint uq_shop_item_model_small_image unique (small_image),
  constraint uq_shop_item_model_large_image unique (large_image),
  constraint uq_shop_item_model_description unique (description),
  constraint uq_shop_item_model_keywords unique (keywords),
  constraint pk_shop_item_model primary key (id)
);

create table shop_item_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_shop_item_roles_model primary key (id)
);

create table social_settings_model (
  id                            bigint auto_increment not null,
  facebook_url                  varchar(255),
  twitter_url                   varchar(255),
  google_url                    varchar(255),
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint pk_social_settings_model primary key (id)
);

create table status_model (
  id                            bigint auto_increment not null,
  status_name                   varchar(255) not null,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_status_model_status_name unique (status_name),
  constraint pk_status_model primary key (id)
);

create table team_member_model (
  id                            bigint auto_increment not null,
  member_name                   varchar(255) not null,
  member_image                  varchar(255) not null,
  member_facebook               varchar(255) not null,
  member_twitter                varchar(255) not null,
  member_skype                  varchar(255) not null,
  member_linked_in              varchar(255) not null,
  member_description            TEXT not null,
  teammemberstatus              bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_team_member_model_member_name unique (member_name),
  constraint uq_team_member_model_member_image unique (member_image),
  constraint uq_team_member_model_member_facebook unique (member_facebook),
  constraint uq_team_member_model_member_twitter unique (member_twitter),
  constraint uq_team_member_model_member_skype unique (member_skype),
  constraint uq_team_member_model_member_linked_in unique (member_linked_in),
  constraint pk_team_member_model primary key (id)
);

create table user_model (
  id                            bigint auto_increment not null,
  username                      varchar(255) not null,
  email                         varchar(255) not null,
  sha_password                  varbinary(64) not null,
  userstatus                    bigint,
  creation_date                 datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint uq_user_model_username unique (username),
  constraint uq_user_model_email unique (email),
  constraint pk_user_model primary key (id)
);

create table user_roles_model (
  id                            bigint auto_increment not null,
  creation_date                 datetime(6) not null,
  constraint pk_user_roles_model primary key (id)
);

alter table article_category_model add constraint fk_article_category_model_articlecategorystatus foreign key (articlecategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_article_category_model_articlecategorystatus on article_category_model (articlecategorystatus);

alter table article_model add constraint fk_article_model_articlestatus foreign key (articlestatus) references status_model (id) on delete restrict on update restrict;
create index ix_article_model_articlestatus on article_model (articlestatus);

alter table article_model add constraint fk_article_model_articlecontenttype foreign key (articlecontenttype) references content_type_model (id) on delete restrict on update restrict;
create index ix_article_model_articlecontenttype on article_model (articlecontenttype);

alter table article_model add constraint fk_article_model_articlecategory foreign key (articlecategory) references article_category_model (id) on delete restrict on update restrict;
create index ix_article_model_articlecategory on article_model (articlecategory);

alter table content_type_model add constraint fk_content_type_model_contenttypestatus foreign key (contenttypestatus) references status_model (id) on delete restrict on update restrict;
create index ix_content_type_model_contenttypestatus on content_type_model (contenttypestatus);

alter table customer_model add constraint fk_customer_model_id foreign key (id) references user_model (id) on delete restrict on update restrict;

alter table forum_category_model add constraint fk_forum_category_model_forumcategorystatus foreign key (forumcategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_forum_category_model_forumcategorystatus on forum_category_model (forumcategorystatus);

alter table forum_post_model add constraint fk_forum_post_model_forumpoststatus foreign key (forumpoststatus) references content_type_model (id) on delete restrict on update restrict;
create index ix_forum_post_model_forumpoststatus on forum_post_model (forumpoststatus);

alter table forum_post_model add constraint fk_forum_post_model_forumpostcategory foreign key (forumpostcategory) references forum_category_model (id) on delete restrict on update restrict;
create index ix_forum_post_model_forumpostcategory on forum_post_model (forumpostcategory);

alter table interview_model add constraint fk_interview_model_interviewstatus foreign key (interviewstatus) references status_model (id) on delete restrict on update restrict;
create index ix_interview_model_interviewstatus on interview_model (interviewstatus);

alter table interview_model add constraint fk_interview_model_interviewcontenttype foreign key (interviewcontenttype) references content_type_model (id) on delete restrict on update restrict;
create index ix_interview_model_interviewcontenttype on interview_model (interviewcontenttype);

alter table job_category_model add constraint fk_job_category_model_jobcategorystatus foreign key (jobcategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_job_category_model_jobcategorystatus on job_category_model (jobcategorystatus);

alter table job_model add constraint fk_job_model_jobstatus foreign key (jobstatus) references status_model (id) on delete restrict on update restrict;
create index ix_job_model_jobstatus on job_model (jobstatus);

alter table job_model add constraint fk_job_model_jobcategory foreign key (jobcategory) references job_category_model (id) on delete restrict on update restrict;
create index ix_job_model_jobcategory on job_model (jobcategory);

alter table job_model add constraint fk_job_model_jobtype foreign key (jobtype) references job_type_model (id) on delete restrict on update restrict;
create index ix_job_model_jobtype on job_model (jobtype);

alter table job_model add constraint fk_job_model_jobcontenttype foreign key (jobcontenttype) references status_model (id) on delete restrict on update restrict;
create index ix_job_model_jobcontenttype on job_model (jobcontenttype);

alter table job_type_model add constraint fk_job_type_model_jobtypestatus foreign key (jobtypestatus) references status_model (id) on delete restrict on update restrict;
create index ix_job_type_model_jobtypestatus on job_type_model (jobtypestatus);

alter table news_category_model add constraint fk_news_category_model_newscategorystatus foreign key (newscategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_news_category_model_newscategorystatus on news_category_model (newscategorystatus);

alter table news_model add constraint fk_news_model_newsstatus foreign key (newsstatus) references status_model (id) on delete restrict on update restrict;
create index ix_news_model_newsstatus on news_model (newsstatus);

alter table news_model add constraint fk_news_model_newscontenttype foreign key (newscontenttype) references content_type_model (id) on delete restrict on update restrict;
create index ix_news_model_newscontenttype on news_model (newscontenttype);

alter table news_model add constraint fk_news_model_newscategory foreign key (newscategory) references news_category_model (id) on delete restrict on update restrict;
create index ix_news_model_newscategory on news_model (newscategory);

alter table page_model add constraint fk_page_model_pagestatus foreign key (pagestatus) references status_model (id) on delete restrict on update restrict;
create index ix_page_model_pagestatus on page_model (pagestatus);

alter table partner_logo_model add constraint fk_partner_logo_model_partnerlogostatus foreign key (partnerlogostatus) references status_model (id) on delete restrict on update restrict;
create index ix_partner_logo_model_partnerlogostatus on partner_logo_model (partnerlogostatus);

alter table partner_review_model add constraint fk_partner_review_model_partnerreviewstatus foreign key (partnerreviewstatus) references status_model (id) on delete restrict on update restrict;
create index ix_partner_review_model_partnerreviewstatus on partner_review_model (partnerreviewstatus);

alter table portfolio_category_model add constraint fk_portfolio_category_model_portfolioncategorystatus foreign key (portfolioncategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_portfolio_category_model_portfolioncategorystatus on portfolio_category_model (portfolioncategorystatus);

alter table portfolio_item_model add constraint fk_portfolio_item_model_portfolioitemstatus foreign key (portfolioitemstatus) references status_model (id) on delete restrict on update restrict;
create index ix_portfolio_item_model_portfolioitemstatus on portfolio_item_model (portfolioitemstatus);

alter table portfolio_item_model add constraint fk_portfolio_item_model_poertfoliocategory foreign key (poertfoliocategory) references portfolio_category_model (id) on delete restrict on update restrict;
create index ix_portfolio_item_model_poertfoliocategory on portfolio_item_model (poertfoliocategory);

alter table profile_model add constraint fk_profile_model_id foreign key (id) references user_model (id) on delete restrict on update restrict;

alter table review_category_model add constraint fk_review_category_model_reviewcategorystatus foreign key (reviewcategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_review_category_model_reviewcategorystatus on review_category_model (reviewcategorystatus);

alter table review_model add constraint fk_review_model_reviewstatus foreign key (reviewstatus) references status_model (id) on delete restrict on update restrict;
create index ix_review_model_reviewstatus on review_model (reviewstatus);

alter table review_model add constraint fk_review_model_reviewcontenttype foreign key (reviewcontenttype) references content_type_model (id) on delete restrict on update restrict;
create index ix_review_model_reviewcontenttype on review_model (reviewcontenttype);

alter table review_model add constraint fk_review_model_reviewcategory foreign key (reviewcategory) references review_category_model (id) on delete restrict on update restrict;
create index ix_review_model_reviewcategory on review_model (reviewcategory);

alter table role_model add constraint fk_role_model_rolestatus foreign key (rolestatus) references status_model (id) on delete restrict on update restrict;
create index ix_role_model_rolestatus on role_model (rolestatus);

alter table service_model add constraint fk_service_model_servicestatus foreign key (servicestatus) references status_model (id) on delete restrict on update restrict;
create index ix_service_model_servicestatus on service_model (servicestatus);

alter table shop_category_model add constraint fk_shop_category_model_shopcategorystatus foreign key (shopcategorystatus) references status_model (id) on delete restrict on update restrict;
create index ix_shop_category_model_shopcategorystatus on shop_category_model (shopcategorystatus);

alter table shop_item_model add constraint fk_shop_item_model_shopitemstatus foreign key (shopitemstatus) references status_model (id) on delete restrict on update restrict;
create index ix_shop_item_model_shopitemstatus on shop_item_model (shopitemstatus);

alter table shop_item_model add constraint fk_shop_item_model_shopitemcontenttype foreign key (shopitemcontenttype) references content_type_model (id) on delete restrict on update restrict;
create index ix_shop_item_model_shopitemcontenttype on shop_item_model (shopitemcontenttype);

alter table shop_item_model add constraint fk_shop_item_model_shopitemcategory foreign key (shopitemcategory) references review_category_model (id) on delete restrict on update restrict;
create index ix_shop_item_model_shopitemcategory on shop_item_model (shopitemcategory);

alter table team_member_model add constraint fk_team_member_model_teammemberstatus foreign key (teammemberstatus) references status_model (id) on delete restrict on update restrict;
create index ix_team_member_model_teammemberstatus on team_member_model (teammemberstatus);

alter table user_model add constraint fk_user_model_userstatus foreign key (userstatus) references status_model (id) on delete restrict on update restrict;
create index ix_user_model_userstatus on user_model (userstatus);


# --- !Downs

alter table article_category_model drop foreign key fk_article_category_model_articlecategorystatus;
drop index ix_article_category_model_articlecategorystatus on article_category_model;

alter table article_model drop foreign key fk_article_model_articlestatus;
drop index ix_article_model_articlestatus on article_model;

alter table article_model drop foreign key fk_article_model_articlecontenttype;
drop index ix_article_model_articlecontenttype on article_model;

alter table article_model drop foreign key fk_article_model_articlecategory;
drop index ix_article_model_articlecategory on article_model;

alter table content_type_model drop foreign key fk_content_type_model_contenttypestatus;
drop index ix_content_type_model_contenttypestatus on content_type_model;

alter table customer_model drop foreign key fk_customer_model_id;

alter table forum_category_model drop foreign key fk_forum_category_model_forumcategorystatus;
drop index ix_forum_category_model_forumcategorystatus on forum_category_model;

alter table forum_post_model drop foreign key fk_forum_post_model_forumpoststatus;
drop index ix_forum_post_model_forumpoststatus on forum_post_model;

alter table forum_post_model drop foreign key fk_forum_post_model_forumpostcategory;
drop index ix_forum_post_model_forumpostcategory on forum_post_model;

alter table interview_model drop foreign key fk_interview_model_interviewstatus;
drop index ix_interview_model_interviewstatus on interview_model;

alter table interview_model drop foreign key fk_interview_model_interviewcontenttype;
drop index ix_interview_model_interviewcontenttype on interview_model;

alter table job_category_model drop foreign key fk_job_category_model_jobcategorystatus;
drop index ix_job_category_model_jobcategorystatus on job_category_model;

alter table job_model drop foreign key fk_job_model_jobstatus;
drop index ix_job_model_jobstatus on job_model;

alter table job_model drop foreign key fk_job_model_jobcategory;
drop index ix_job_model_jobcategory on job_model;

alter table job_model drop foreign key fk_job_model_jobtype;
drop index ix_job_model_jobtype on job_model;

alter table job_model drop foreign key fk_job_model_jobcontenttype;
drop index ix_job_model_jobcontenttype on job_model;

alter table job_type_model drop foreign key fk_job_type_model_jobtypestatus;
drop index ix_job_type_model_jobtypestatus on job_type_model;

alter table news_category_model drop foreign key fk_news_category_model_newscategorystatus;
drop index ix_news_category_model_newscategorystatus on news_category_model;

alter table news_model drop foreign key fk_news_model_newsstatus;
drop index ix_news_model_newsstatus on news_model;

alter table news_model drop foreign key fk_news_model_newscontenttype;
drop index ix_news_model_newscontenttype on news_model;

alter table news_model drop foreign key fk_news_model_newscategory;
drop index ix_news_model_newscategory on news_model;

alter table page_model drop foreign key fk_page_model_pagestatus;
drop index ix_page_model_pagestatus on page_model;

alter table partner_logo_model drop foreign key fk_partner_logo_model_partnerlogostatus;
drop index ix_partner_logo_model_partnerlogostatus on partner_logo_model;

alter table partner_review_model drop foreign key fk_partner_review_model_partnerreviewstatus;
drop index ix_partner_review_model_partnerreviewstatus on partner_review_model;

alter table portfolio_category_model drop foreign key fk_portfolio_category_model_portfolioncategorystatus;
drop index ix_portfolio_category_model_portfolioncategorystatus on portfolio_category_model;

alter table portfolio_item_model drop foreign key fk_portfolio_item_model_portfolioitemstatus;
drop index ix_portfolio_item_model_portfolioitemstatus on portfolio_item_model;

alter table portfolio_item_model drop foreign key fk_portfolio_item_model_poertfoliocategory;
drop index ix_portfolio_item_model_poertfoliocategory on portfolio_item_model;

alter table profile_model drop foreign key fk_profile_model_id;

alter table review_category_model drop foreign key fk_review_category_model_reviewcategorystatus;
drop index ix_review_category_model_reviewcategorystatus on review_category_model;

alter table review_model drop foreign key fk_review_model_reviewstatus;
drop index ix_review_model_reviewstatus on review_model;

alter table review_model drop foreign key fk_review_model_reviewcontenttype;
drop index ix_review_model_reviewcontenttype on review_model;

alter table review_model drop foreign key fk_review_model_reviewcategory;
drop index ix_review_model_reviewcategory on review_model;

alter table role_model drop foreign key fk_role_model_rolestatus;
drop index ix_role_model_rolestatus on role_model;

alter table service_model drop foreign key fk_service_model_servicestatus;
drop index ix_service_model_servicestatus on service_model;

alter table shop_category_model drop foreign key fk_shop_category_model_shopcategorystatus;
drop index ix_shop_category_model_shopcategorystatus on shop_category_model;

alter table shop_item_model drop foreign key fk_shop_item_model_shopitemstatus;
drop index ix_shop_item_model_shopitemstatus on shop_item_model;

alter table shop_item_model drop foreign key fk_shop_item_model_shopitemcontenttype;
drop index ix_shop_item_model_shopitemcontenttype on shop_item_model;

alter table shop_item_model drop foreign key fk_shop_item_model_shopitemcategory;
drop index ix_shop_item_model_shopitemcategory on shop_item_model;

alter table team_member_model drop foreign key fk_team_member_model_teammemberstatus;
drop index ix_team_member_model_teammemberstatus on team_member_model;

alter table user_model drop foreign key fk_user_model_userstatus;
drop index ix_user_model_userstatus on user_model;

drop table if exists article_category_model;

drop table if exists article_category_roles_model;

drop table if exists article_model;

drop table if exists article_roles_model;

drop table if exists company_settings_model;

drop table if exists contact_model;

drop table if exists content_type_model;

drop table if exists customer_model;

drop table if exists forum_category_model;

drop table if exists forum_category_roles_model;

drop table if exists forum_post_model;

drop table if exists forum_post_roles_model;

drop table if exists interview_model;

drop table if exists interview_roles_model;

drop table if exists job_category_model;

drop table if exists job_category_roles_model;

drop table if exists job_model;

drop table if exists job_roles_model;

drop table if exists job_type_model;

drop table if exists news_category_model;

drop table if exists news_category_roles_model;

drop table if exists news_model;

drop table if exists news_roles_model;

drop table if exists newsletter_model;

drop table if exists opening_hours_model;

drop table if exists page_model;

drop table if exists page_roles_model;

drop table if exists partner_logo_model;

drop table if exists partner_review_model;

drop table if exists portfolio_category_model;

drop table if exists portfolio_category_roles_model;

drop table if exists portfolio_item_model;

drop table if exists portfolio_item_roles_model;

drop table if exists profile_model;

drop table if exists review_category_model;

drop table if exists review_category_roles_model;

drop table if exists review_model;

drop table if exists review_roles_model;

drop table if exists role_model;

drop table if exists service_model;

drop table if exists shop_category_model;

drop table if exists shop_category_roles_model;

drop table if exists shop_item_model;

drop table if exists shop_item_roles_model;

drop table if exists social_settings_model;

drop table if exists status_model;

drop table if exists team_member_model;

drop table if exists user_model;

drop table if exists user_roles_model;

