<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="resources/css/bootstrap.min.css">
   <link rel="stylesheet" href="resources/css/login.css">
   <title>Document</title>
</head>

<body class="text-center">
   <header>
      <nav class="navbar navbar-light bg-light">
         <div class="container-sm">
            <div class="navbar-brand">
               <img src="resources/img/livro-de-contato.png" 
                  alt="icone">
               <a href="index.jsp" class="h5 text-decoration-none text-dark">Agenda Web</a>
            </div>
            <div class="d-flex">
               <a class="me-3 btn btn-outline-purple" href="action?acao=TelaSign">Inscrever-se</a>
            </div>
         </div>
      </nav>
   </header>

   <main class="form-signin">
      <form action="action?" method="POST">
         <h1 class="h3 mb-5 fw-normal">Faça seu login</h1>

         <input type="hidden" name="acao" value="RealizarLogin">
         
         <p style="color: darkred;">${mensagemLogin}</p>
         <div class="form-floating">
            <input type="email" class="form-control" name="email" id="email" 
               placeholder="E-mail" autocomplete="none" required>
            <label for="email">E-mail</label>
         </div>
         <div class="form-floating">
            <input type="password" class="form-control" name="senha" id="senha" 
               placeholder="Senha" required>
            <label for="senha">Senha</label>
         </div>
         <button class="btn w-100 btn-lg btn-purple" type="submit">Entrar</button>
      </form>
   </main>

</body>

</html>