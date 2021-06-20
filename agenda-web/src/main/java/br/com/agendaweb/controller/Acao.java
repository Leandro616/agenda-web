package br.com.agendaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
   String executar(HttpServletRequest request, 
      HttpServletResponse response);
}
