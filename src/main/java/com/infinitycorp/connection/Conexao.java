package com.infinitycorp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
        
    public static Connection conector(){
        
        String url = "jdbc:mysql://127.0.0.1/dblistagemonline";
        String user = "root";
        String password = "1234";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver do Mysql: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão com o banco de dados: " + e.getMessage());
        }
        
        return null;
    }
    
    public static void desconector(Connection conexao){   
        
        if (conexao != null) {
            try {
                System.out.println("Desconectado com Sucesso");
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
}
