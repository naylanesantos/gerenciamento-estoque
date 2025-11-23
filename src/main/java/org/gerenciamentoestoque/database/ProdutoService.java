package org.gerenciamentoestoque.database;

import org.gerenciamentoestoque.models.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private final Connection conexao;

    public ProdutoService(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirProduto(Produto produto) {
        try {
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate(
                    String.format("insert into produtos (nome, quantidade) values ('%s', %d)",
                            produto.getNome(), produto.getQuantidade())
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List< Produto > listarProdutos() {
        List<Produto> retorno;
        try {
            Statement statement = this.conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, nome, quantidade from produtos");
            retorno = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("nome");
                int quantidade = resultSet.getInt("quantidade");

                Produto produtinho = new Produto(id, nome, quantidade);
                retorno.add(produtinho);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }


}
