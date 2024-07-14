-- Active: 1720821933023@@localhost@3306@forohub
create table usuarios(

    id bigint not null auto_increment,
    email varchar(200) not null unique,
    clave varchar(300) not null,
    

    primary key(id)

);