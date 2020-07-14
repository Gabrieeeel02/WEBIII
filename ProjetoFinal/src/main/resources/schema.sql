drop table if exists client;

create table client(
    id_client bigint auto_increment,
    cpf varchar(20) not null,
    nome varchar(100) not null,
    email varchar(50) not null,
    endereco varchar(100) not null,
    telefone varchar(50) not null,
    primary key(id_client);

create table product(
    id_product bigint auto_increment,
    nome varchar(50) not null,
    valor double not null,
    setor varchar(20) not null,
    primary key(id_product);




