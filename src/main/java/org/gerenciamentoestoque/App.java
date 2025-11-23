package org.gerenciamentoestoque;

import org.gerenciamentoestoque.database.ConnectionFactory;
import org.gerenciamentoestoque.database.ProdutoService;
import org.gerenciamentoestoque.models.Produto;

import java.sql.Connection;

public class App {
    public static void main( String[] args ) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        ProdutoService produtoService = new ProdutoService(connection);
        produtoService.listarProdutos();
    }
}
