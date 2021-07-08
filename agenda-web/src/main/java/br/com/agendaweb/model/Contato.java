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
}
