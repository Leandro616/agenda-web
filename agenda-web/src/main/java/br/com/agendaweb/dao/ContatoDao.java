package br.com.agendaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agendaweb.model.Contato;
import br.com.agendaweb.model.Telefone;

public class ContatoDao {
   private final Connection connection;
   private final int idUsuario;

   public ContatoDao(Connection connection, int idUsuario) {
      this.connection = connection;
      this.idUsuario = idUsuario;
   }

   public List<Contato> listarContatos() {
      String sql = "select idcontato, nome, email " 
         + "from contatos where id_usuario = ?;";

      List<Contato> lista = new ArrayList<>();

      try (PreparedStatement ps = connection.prepareStatement(sql)) {
         
         ps.setInt(1, idUsuario);

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            Contato contato = new Contato();
            contato.setIdContato(rs.getInt(1));
            contato.setNome(rs.getString(2));
            contato.setEmail(rs.getString(3));
            contato.setTelefones(listarTelefones(contato.getIdContato()));

            lista.add(contato);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return lista;
   }

   public void cadastrar(Contato contato) {
      
      // procedure cadastrar_contatos que retorna o ultimo 
      // id inserido que será usado para cadastrar os telefones
      // call cadastrar_contatos(nome, email, id_usuario);
      String sql = "call cadastrar_contatos(?, ?, ?);";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {
         ps.setString(1, contato.getNome());
         ps.setString(2, contato.getEmail());
         ps.setInt(3, idUsuario);

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            int idContato = rs.getInt(1);
            cadastrarTelefones(idContato, contato.getTelefones());
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void deletar(int idContato) {
      String sql = "delete from contatos where idcontato = ?";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {
         deletarTelefones(idContato);
         ps.setInt(1, idContato);
         ps.execute();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void atualizar(Contato contato) {
      String sql = "update contatos set nome = ?, email = ? "
         + "where idcontato = ?;";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {
         ps.setString(1, contato.getNome());
         ps.setString(2, contato.getEmail());
         ps.setInt(3, contato.getIdContato());

         ps.execute();

         atualizarTelefones(contato.getTelefones());

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private List<Telefone> listarTelefones(int idContato) {

      String sql = "select idtelefone, numero, tipo from telefones " 
         + "where id_contato = ?;";

      List<Telefone> lista = new ArrayList<>();

      try (PreparedStatement ps = connection.prepareStatement(sql)) {

         ps.setInt(1, idContato);

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            Telefone telefone = new Telefone();
            telefone.setIdTelefone(rs.getInt(1));
            telefone.setNumero(rs.getString(2));
            telefone.setTipo(rs.getString(3));

            lista.add(telefone);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return lista;
   }

   private void cadastrarTelefones(int idContato, List<Telefone> lista) {
      //insert into telefones values(null, 'RES', '12345678900', 1);

      String sql = "insert into telefones(numero, tipo, id_contato) " 
         + "values(?, ?, ?);";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {
         
         for (Telefone telefone : lista) {
            ps.setString(1, telefone.getNumero());
            ps.setString(2, telefone.getTipo());
            ps.setInt(3, idContato);

            ps.execute();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private void deletarTelefones(int idContato) {
      String sql = "delete from telefones where id_contato = ?";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {
         ps.setInt(1, idContato);

         ps.execute();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private void atualizarTelefones(List<Telefone> lista) {
      String sql = "update telefones set tipo = ?, numero = ? "
         + "where idtelefone = ?;";

      try (PreparedStatement ps = connection.prepareStatement(sql)) {

         for (Telefone telefone : lista) {
            ps.setString(1, telefone.getTipo());
            ps.setString(2, telefone.getNumero());
            ps.setInt(3, telefone.getIdTelefone());
            
            ps.execute();
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
