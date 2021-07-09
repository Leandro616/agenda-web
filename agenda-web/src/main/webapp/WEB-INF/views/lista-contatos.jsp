<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="resources/css/bootstrap.min.css">
   <link rel="stylesheet" href="resources/css/header.css">
   
   <script src="resources/js/jquery-3.6.0.min.js"></script>
   <script src="resources/js/bootstrap.bundle.min.js"></script>
   <script src="resources/js/contatos.js" defer></script>
   <script src="resources/js/jquery.mask.min.js"></script>
   <title>Agenda Web - Contatos</title>

</head>

<body>
   <header>
      <nav class="navbar navbar-light bg-light">
         <div class="container-xl">
            <div class="navbar-brand">
               <img src="resources/img/livro-de-contato.png" alt="icone">
               <span class="h5">Agenda Web</span>
            </div>
            <div class="d-flex">
               <a class="me-3 btn btn-purple" href="action?acao=RealizarLogout">Sair</a>
            </div>
         </div>
      </nav>
   </header>

   <!-- Lista de Contatos -->
   <main class="container-sm mt-5">
      <header class="my-4">
         <h5 class="ms-3">${usuarioLogado.nome}</h5>
         <nav class="navbar">
            <div class="container-sm">
               <h2 class="navbar-text">Meus Contatos</h2>

               <div class="d-flex">
                  <a class="me-3 btn btn-success" href="#novo-contato">Novo+</a>
               </div>
            </div>
         </nav>
      </header>

      <table class="table table-striped">
         <thead>
            <tr>
               <th scope="col" class="col-4">Nome</th>
               <th scope="col" class="col-5">E-mail</th>
               <th scope="col" class="col-3">Telefone</th>
               <th scope="col" class="col-1"></th>
               <th scope="col" class="col-1"></th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${usuarioLogado.contatos}" var="contato">
               <tr>
                  <td title="Mensagem!">${contato.nome}</td>
                  <td>${contato.email}</td>
                  <td>
                     <select class="form-select">
                        <c:forEach items="${contato.telefones}" var="telefone">
                           <option>${telefone.numeroFormatado()}  ${telefone.tipo}</option>
                        </c:forEach>
                     </select>
                  </td>
                  <td>
                     <a href="#" 
                        class="btn btn-warning btn-sm">
                           <img src="resources/img/lapis.png" alt="editar">
                     </a>
                  </td>
                  <td>
                     <a href="action?acao=DeletarContato&id=${contato.idContato}" 
                        class="btn btn-danger btn-sm">
                        <img src="resources/img/lixeira.png" alt="apagar">
                     </a>
                  </td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </main>

   <!-- Formulario de Novo Contato -->
   <section style="margin-top: 800px; margin-bottom: 400px;" id="novo-contato" class="container-sm">
      <div class="card">
         <div class="card-header">
            <h2 class="card-title">Novo contato</h2>
         </div>
         <form action="/" method="GET" class="card-body" id="formulario">
            <!-- 1° linha Nome e email -->
            <div class="row">
               <div class="col-5">
                  <input type="text" name="nome" class="form-control" placeholder="Nome" required>
               </div>
               <div class="col-7">
                  <input type="email" name="email" class="form-control" placeholder="E-mail">
               </div>
            </div>

            <!-- 2° linha telefone e tipo -->
            <div id="telefone-tipo">
               <div class="row mt-3">
                  <div class="col-6">
                     <input type="tel" name="telefone[0]" class="form-control telefone" 
                        placeholder="Telefone">
                  </div>
                  <div class="col-6">
                     <select class="form-select" name="tipo[0]">
                        <option selected value="1">Celular</option>
                        <option value="2">Comercial</option>
                        <option value="3">Residencial</option>
                     </select>
                  </div>
               </div>
            </div>

            <!-- Botões de +telefones e Salvar -->
            <div class="row mt-3 justify-content-center">
               <div class="col-2">
                  <button type="button" class="btn btn-warning" id="add-telefone">+telefones</button>
               </div>
               <div class="col-2">
                  <button type="submit" class="btn btn-success">Salvar</button>
               </div>
            </div>
         </form>
      </div>
   </section>
   
</body>

</html>
