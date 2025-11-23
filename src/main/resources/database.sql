create database estoque;
use estoque;

create table produtos (
    ID INT auto_increment primary key,
    nome varchar(100) not null,
    quantidade int not null
 );

insert into produtos (nome, quantidade)
values
('fruteira', 100),
('sofá', 06),
('arranjo de mesa', 90);

select * from produtos;