package br.com.agendaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarContatos implements Acao {

   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {
      
      return "/WEB-INF/views/lista-contatos.jsp";
   }
}
