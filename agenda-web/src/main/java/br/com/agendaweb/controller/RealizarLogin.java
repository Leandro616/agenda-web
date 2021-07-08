package br.com.agendaweb.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agendaweb.dao.UsuarioDao;
import br.com.agendaweb.model.Usuario;
import br.com.agendaweb.security.ValidadorArgon2;

public class RealizarLogin implements Acao{
   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {
      
      Connection connection = (Connection) request.getAttribute("connection");
      UsuarioDao dao = new UsuarioDao(connection);
      Usuario usuario = new Usuario();

      usuario = dao.pesquisarPorEmail(request.getParameter("email"));

      if (usuario == null) {
         request.setAttribute("mensagemLogin", "Email ou senha incorretos!");
         return "/WEB-INF/views/login.jsp";
         
      } else {
         String senha = request.getParameter("senha");
         ValidadorArgon2 validador = new ValidadorArgon2();
         String hash = usuario.getSenha();
         
         if (validador.validarSenha(hash, senha)){
            request.getSession().setAttribute("usuarioLogado", usuario);
            return "action?acao=ListarContatos";
         }
         else {
            request.setAttribute("mensagemLogin", "Email ou senha incorretos!");
            return "/WEB-INF/views/login.jsp";
         }
      }
   }
}
