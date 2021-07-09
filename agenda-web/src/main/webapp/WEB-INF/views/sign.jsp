<!DOCTYPE html>
<html lang="pt-br">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="resources/css/bootstrap.min.css">
   <link rel="stylesheet" href="resources/css/login.css">
   <title>Agenda Web - Inscreva-se</title>
</head>

<body class="text-center">
   <header>
      <nav class="navbar navbar-light bg-light">
         <div class="container-sm">
            <div class="navbar-brand">
               <img src="resources/img/livro-de-contato.png" 
                  alt="icone livro-de-contato">
               <a href="index.jsp" class="h5 text-decoration-none text-dark">Agenda Web</a>
            </div>
            <div class="d-flex">
               <a class="me-3 btn btn-outline-purple" href="action?acao=TelaLogin">Entrar</a>
            </div>
         </div>
      </nav>
   </header>

   <main class="form-signin">
      <form action="action?" method="POST" autocomplete="off">
         <h1 class="h3 mb-5 fw-normal">Crie sua conta</h1>

         <input type="hidden" name="acao" value="RealizarInscricao">

         <p style="color: darkred;">${mensagemSign}</p>
         <div class="form-floating">
            <input type="text" class="form-control" name="nome" id="nome" 
               placeholder="Nome" required>
            <label for="nome">Nome</label>
         </div>
         <div class="form-floating">
            <input type="email" class="form-control" name="email" id="email" 
               placeholder="E-mail" required>
            <label for="email">E-mail</label>
         </div>
         <div class="form-floating">
            <input type="password" class="form-control" name="senha" id="senha" 
               placeholder="Senha" required>
            <label for="senha">Senha</label>
         </div>
         <button class="btn w-100 btn-lg btn-purple" type="submit">Inscrever-se</button>
      </form>
   </main>

</body>

</html>