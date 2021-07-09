package br.com.agendaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaSign implements Acao {
   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {
      request.getSession().invalidate();
      return "/WEB-INF/views/sign.jsp";
   }
}
