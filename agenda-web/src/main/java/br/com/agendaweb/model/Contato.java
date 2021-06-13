package br.com.agendaweb.model;

public class Contato {
   private long idContato;
   private String nome;
   private String email;
   private String[] telefones;

   public long getIdContato() {
      return idContato;
   }

   public void setIdContato(long idContato) {
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

   public String[] getTelefones() {
      return telefones;
   }

   public void setTelefones(String[] telefones) {
      this.telefones = telefones;
   }

}
