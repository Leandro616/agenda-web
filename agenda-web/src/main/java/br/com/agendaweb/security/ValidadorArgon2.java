package br.com.agendaweb.security;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class ValidadorArgon2 {
   private Argon2 argon2;

   public ValidadorArgon2() {
      this.argon2 = Argon2Factory.create();
   }

   public String criarHash(String senha) {

      // hash(iterações, memória, paralelismo, char[])
      String hash = argon2.hash(25, 65536, 1, senha.toCharArray());

      return hash;
   }

   public boolean validarSenha(String hash, String senha) {
      char[] senhaChar = senha.toCharArray();

      return argon2.verify(hash, senhaChar);
   }
}

