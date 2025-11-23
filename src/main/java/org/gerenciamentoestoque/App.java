package org.gerenciamentoestoque;

import org.gerenciamentoestoque.database.ConnectionFactory;

public class App {
    public static void main( String[] args ) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.getConnection();
    }
}
