package br.com.agendaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
   private Connection connection;

   public Connection getConnection() {
      String url = "jdbc:mysql://localhost:3306/agenda_web";
      String user = "root";
      String password = "1234";

      try {
         connection = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return connection;
   }
}
