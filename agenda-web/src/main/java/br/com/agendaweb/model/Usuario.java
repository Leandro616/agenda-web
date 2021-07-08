package br.com.agendaweb.model;

import java.util.List;

public class Usuario {
   private int idUsuario;
   private String nome;
   private String email;
   private String senha;
   private List<Contato> contatos;

   public int getIdUsuario() {
      return idUsuario;
   }

   public void setIdUsuario(int idUsuario) {
      this.idUsuario = idUsuario;
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

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public List<Contato> getContatos() {
      return contatos;
   }

   public void setContatos(List<Contato> contatos) {
      this.contatos = contatos;
   }
}
