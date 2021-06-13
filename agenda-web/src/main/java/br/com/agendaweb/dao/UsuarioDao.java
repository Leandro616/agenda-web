package br.com.agendaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.agendaweb.model.Usuario;
import br.com.agendaweb.security.ValidadorArgon2;

public class UsuarioDao {
   private Connection connection;

   public UsuarioDao(Connection connection) {
      this.connection = connection;
   }

   public void cadastrar(Usuario usuario) {
      String sql = "insert into usuarios(nome, email, senha) values(?, ?, ?);";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {

         String senha = new ValidadorArgon2().criarHash(usuario.getSenha());

         ps.setString(1, usuario.getNome());
         ps.setString(2, usuario.getEmail());
         ps.setString(3, senha);

         ps.execute();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public Usuario pesquisarPorEmail(String email) {

      String sql = "select idusuario, nome, senha "  
         + "from usuarios where email = ?;";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {

         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();

         Usuario usuario = new Usuario();

         if (rs.next()) {
            usuario.setIdUsuario(rs.getInt("idusuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setEmail(email);

            return usuario;
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }   
}
