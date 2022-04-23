create table book(
   id bigint auto_increment,
   name varchar(255) not null,
   is_available boolean not null,
   author_id bigint,
   primary key(id),
   foreign key(author_id) references author(id) on delete cascade on update cascade
);