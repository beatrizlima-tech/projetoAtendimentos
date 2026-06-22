package factories;

/*
    Classe para fazer a conexão com o banco de dados
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

   // Atributos
   private String host = "jdbc:postgresql://localhost:5432/bdaula04";
   private String user = "postgres";
   private String pass = "coti";

   // Método para abrir a conexão com o banco de dados
    public Connection getConnection() throws Exception{
        return DriverManager.getConnection(host, user, pass);
    }

}
