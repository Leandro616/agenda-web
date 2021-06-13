# agenda-web
Agenda simples que armazena contatos, feita com Java usando Jsp, Servlets, JDBC e MySQL.

#### Banco de dados

O SGBD utilizado é o MySQL 5.7 e o banco de dados terá as seguintes tabelas:

* usuarios

* contatos

* telefones

Diagrama de Entidade Relacionamento:

![Diagrama ER](https://github.com/Leandro616/agenda-web/blob/main/banco-de-dados/diagrama-er.png)





O usuário poderá armazenar vários contatos e cada contato poderá ter mais de um telefone.

#### Back-end

##### package br.com.agendaweb.security

Usei o algoritmo Argon2 para criação e validação de senhas dos usuários.



 





