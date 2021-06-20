package br.com.agendaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agendaweb.controller.Acao;

@WebServlet("/action")
public class ServletController extends HttpServlet {

   @Override
   protected void service(HttpServletRequest request, 
         HttpServletResponse response) 
         throws ServletException, IOException {
      
      String nomeDaClasse = "br.com.agendaweb.controller."
         + request.getParameter("acao");

      try {

         Class classe = Class.forName(nomeDaClasse);

         Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
         String pagina = acao.executar(request, response);

         request.getRequestDispatcher(pagina).forward(request, response);

      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      
   }
}
