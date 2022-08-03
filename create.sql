create table app_user (id bigint not null, name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table app_user_roles (app_user_id bigint not null, roles_id bigint not null) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table role (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB;
create table todo (id integer not null auto_increment, todoitem varchar(255), primary key (id)) engine=InnoDB;
alter table app_user_roles add constraint FK23e7b5jyl3ql41rk3566gywdd foreign key (roles_id) references role (id);
alter table app_user_roles add constraint FKkwxexnudtp5gmt82j0qtytnoe foreign key (app_user_id) references app_user (id);
create table app_user (id bigint not null, name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table app_user_roles (app_user_id bigint not null, roles_id bigint not null) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table role (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB;
create table todo (id integer not null auto_increment, todoitem varchar(255), primary key (id)) engine=InnoDB;
alter table app_user_roles add constraint FK23e7b5jyl3ql41rk3566gywdd foreign key (roles_id) references role (id);
alter table app_user_roles add constraint FKkwxexnudtp5gmt82j0qtytnoe foreign key (app_user_id) references app_user (id);
