package br.com.agendaweb.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agendaweb.dao.ContatoDao;
import br.com.agendaweb.model.Usuario;

public class DeletarContato implements Acao {

   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {
      
      Usuario usuarioLogado = (Usuario) request
         .getSession().getAttribute("usuarioLogado");

      Connection connection = (Connection) request.getAttribute("connection");
      ContatoDao dao = new ContatoDao(connection,
         usuarioLogado.getIdUsuario());

      int idContato = Integer.parseInt(request.getParameter("id"));

      dao.deletar(idContato);
      usuarioLogado.setContatos(dao.listarContatos());
      request.getSession().setAttribute("usuarioLogado", usuarioLogado);

      return "action?acao=ListarContatos";
   }
   
}
