package org.gerenciamentoestoque;

import org.gerenciamentoestoque.database.ConnectionFactory;
import org.gerenciamentoestoque.database.ProdutoService;
import org.gerenciamentoestoque.models.Produto;

import java.sql.Connection;
import java.util.List;

public class App {
    public static void main( String[] args ) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        ProdutoService produtoService = new ProdutoService(connection);
        produtoService.listarProdutos();
        produtoService.inserirProduto(new Produto("fruteira", 100));
        List<Produto> l2 = produtoService.listarProdutos();
        Produto ultimoProduto = l2.get(l2.size() - 1);
        produtoService.excluirProduto(ultimoProduto.getId());
        produtoService.listarProdutos();
        produtoService.atualizarProduto(2, 20);
        produtoService.listarProdutos();

        connection.close();
    }
}
