create table app_user(
    id bigint auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    app_user_role varchar(255) not null,
    primary key(id)
);