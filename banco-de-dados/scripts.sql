-- criação da database
create database agenda_web;

use agenda_web;

-- criação das tabelas
create table usuarios (
   idusuario int primary key auto_increment,
   nome varchar(100) not null,
   email varchar(100) unique not null,
   senha char(100) not null
);

create table contatos (
   idcontato int primary key auto_increment,
   nome varchar(100),
   email varchar(100),
   id_usuario int
);

create table telefones (
   idtelefone int primary key auto_increment,
   tipo enum('RES', 'COM', 'CEL'),
   numero char(11),
   id_contato int
);

-- criação das constraints foreign key 
alter table contatos add constraint fk_usuario_contato
foreign key(id_usuario) references usuarios(idusuario);

alter table telefones add constraint fk_contato_telefone
foreign key(id_contato) references contatos(idcontato);

-- TESTES
-- inserção de dados 
insert into usuarios values(null, 'joao', 'joao@email.com', '1234');
insert into usuarios values(null, 'maria', 'maria@email.com', '1234');

insert into contatos values(null, 'carlos', 'carlos@email.com', 1);
insert into contatos values(null, 'carlos2', 'carlos2@email.com', 1);
insert into contatos values(null, 'carlos3', 'carlos3@email.com', 1);
insert into contatos values(null, 'carlos4', 'carlos4@email.com', 1);
insert into contatos values(null, 'carlos5', 'carlos5@email.com', 1);

insert into contatos values(null, 'rodrigo', 'rodrigo@email.com', 2);
insert into contatos values(null, 'rodrigo2', 'rodrigo2@email.com', 2);
insert into contatos values(null, 'rodrigo3', 'rodrigo3@email.com', 2);

insert into telefones values(null, 'RES', '12345678900', 1);
insert into telefones values(null, 'COM', '12345678900', 2);
insert into telefones values(null, 'RES', '12345678900', 4);
insert into telefones values(null, 'CEL', '12345678900', 4);
insert into telefones values(null, 'COM', '12345678900', 5);

select * from usuarios;
select * from contatos;
select * from telefones;

select c.nome, t.numero
from contatos c
inner join telefones t
on c.idcontato = t.id_contato
where id_usuario = 1;


