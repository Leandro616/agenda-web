package br.com.agendaweb.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agendaweb.dao.UsuarioDao;
import br.com.agendaweb.model.Usuario;
import br.com.agendaweb.security.ValidadorArgon2;

public class RealizarInscricao implements Acao{
   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {
      
      Connection connection = (Connection) request.getAttribute("connection");
      UsuarioDao dao = new UsuarioDao(connection);
      Usuario usuario = new Usuario();

      usuario.setEmail(request.getParameter("email"));

      if (dao.pesquisarPorEmail(usuario.getEmail()) == null) {
         ValidadorArgon2 validador = new ValidadorArgon2();
         String hash = validador.criarHash(request.getParameter("senha"));

         usuario.setNome(request.getParameter("nome"));
         usuario.setSenha(hash);

         dao.cadastrar(usuario);
         
         request.getSession().setAttribute("usuarioLogado", usuario);

         return "action?acao=ListarContatos";
      }
      else {
         request.setAttribute("mensagemSign", "Email já cadastrado!");
         return "/WEB-INF/views/sign.jsp";
      }
   }
}
