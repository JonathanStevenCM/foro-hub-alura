-- Active: 1720821933023@@localhost@3306@forohub
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha datetime not null,
    activo tinyint(100) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)

);