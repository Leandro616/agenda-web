package br.com.agendaweb.model;

import java.util.List;

public class Contato {
   private int idContato;
   private String nome;
   private String email;
   private List<Telefone> telefones;

   public int getIdContato() {
      return idContato;
   }

   public void setIdContato(int idContato) {
      this.idContato = idContato;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public List<Telefone> getTelefones() {
      return telefones;
   }

   public void setTelefones(List<Telefone> telefones) {
      this.telefones = telefones;
   }

   public String getNumeros() {
      StringBuilder numeros = new StringBuilder("[");

      for (Telefone tel : telefones) {
         if (tel.getNumero() != null) {
            numeros.append("'");
            numeros.append(tel.getNumero());
            numeros.append("'");
            numeros.append(",");
         }
      }
      if (!telefones.isEmpty()) {
         numeros.deleteCharAt(numeros.length() - 1);
      }
      numeros.append("]");

      return numeros.toString();
   }

   public String getTipos() {
      StringBuilder tipos = new StringBuilder("[");

      for (Telefone tel : telefones) {
         if (tel.getTipo() != null) {
            tipos.append("'");
            tipos.append(tel.getTipo());
            tipos.append("'");
            tipos.append(",");
         }
      }
      if (!telefones.isEmpty()) {
         tipos.deleteCharAt(tipos.length() - 1);
      }

      tipos.append("]");
      
      return tipos.toString();
   }

   public String getIdsTelefone() {
      StringBuilder ids = new StringBuilder("[");

      for (Telefone tel : telefones) {
         if (tel.getIdTelefone() != 0) {
            ids.append("'");
            ids.append(tel.getIdTelefone());
            ids.append("'");
            ids.append(",");
         }
      }
      if (!telefones.isEmpty()) {
         ids.deleteCharAt(ids.length() - 1);
      }

      ids.append("]");
      
      return ids.toString();
   }
}
