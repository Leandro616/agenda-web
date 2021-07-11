package br.com.agendaweb.controller;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agendaweb.dao.ContatoDao;
import br.com.agendaweb.model.Contato;
import br.com.agendaweb.model.Telefone;
import br.com.agendaweb.model.Usuario;

public class CadastrarContato implements Acao {

   @Override
   public String executar(HttpServletRequest request, 
         HttpServletResponse response) {

      Contato contato = new Contato();

      contato.setNome(request.getParameter("nome"));
      contato.setEmail(request.getParameter("email"));
      
      Map<String, String[]> mapa = request.getParameterMap();

      List<Telefone> telefones = new ArrayList<>();
      
      for (int i = 0; i < 3; i++) {
         String parametroTel = "telefone[" + i + "]";
         String parametroTipo = "tipo[" + i + "]";
         
         if(mapa.containsKey(parametroTel)) {
            String numero = (String) Array.get(mapa.get(parametroTel), 0);
            String tipo = (String) Array.get(mapa.get(parametroTipo), 0);
            
            Telefone telefone = new Telefone();
            telefone.setNumero(retirarMaskTelefone(numero));
            telefone.setTipo(tipo);

            telefones.add(telefone);
         }
      }

      contato.setTelefones(telefones);

      Connection connection = (Connection) request.getAttribute("connection");
      Usuario usuarioLogado = (Usuario) request.getSession()
         .getAttribute("usuarioLogado");

      ContatoDao dao = new ContatoDao(connection, usuarioLogado.getIdUsuario());

      dao.cadastrar(contato);

      usuarioLogado.setContatos(dao.listarContatos());
      request.getSession().setAttribute("usuarioLogado", usuarioLogado);
      
      return "action?acao=ListarContatos";
   }

   private static String retirarMaskTelefone(String telefone) {
      return telefone.replaceAll("\\D", "");
   }
}
