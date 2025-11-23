package org.gerenciamentoestoque.database;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=UTC",
                "root",
                "root"
        );

        System.out.println("Conexão com o banco de dados estabelecida!");
        return conn;
    }
}