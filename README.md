# agenda-web
Agenda simples que armazena contatos, feita com Java usando Jsp, Servlets, JDBC e MySQL.

#### Banco de dados

O SGBD utilizado é o MySQL 5.7 e o banco de dados terá as seguintes tabelas:

* usuarios

* contatos

* telefones

Diagrama de Entidade Relacionamento:

![Diagrama ER](https://github.com/Leandro616/agenda-web/blob/main/banco-de-dados/diagrama-er.png)





O usuário poderá armazenar vários contatos e cada contato poderá ter até três telefones.

#### Back-end

##### package br.com.agendaweb.security

Usei o algoritmo Argon2 para criação e validação de senhas dos usuários.

##### package br.com.agendaweb.servlet

Será usada somente uma Servlet para executar todas as ações no servidor, de acordo com a solicitação do cliente será chamada uma das classes do pacote controller.

#### Telas
![Tela Inicial](https://github.com/Leandro616/agenda-web/blob/main/imagens/tela-inicial.jpg)
![Tela Sign](https://github.com/Leandro616/agenda-web/blob/main/imagens/tela-sign.jpg)
![Tela Login](https://github.com/Leandro616/agenda-web/blob/main/imagens/tela-login.jpg)
![Tela Contatos](https://github.com/Leandro616/agenda-web/blob/main/imagens/tela-lista-contatos.jpg)
![Tela Novo Contato](https://github.com/Leandro616/agenda-web/blob/main/imagens/tela-novo-contato.jpg)
![Tela Novo Contato](https://github.com/Leandro616/agenda-web/blob/main/imagens/tela-editar-contato.jpg)


 





