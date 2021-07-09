package br.com.agendaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealizarLogout implements Acao {
   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {
      
      request.getSession().invalidate();
      return "/index.jsp";
   }
}
