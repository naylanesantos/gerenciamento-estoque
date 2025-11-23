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

    public Produto inserirProduto(Produto produto) {
        try {
            Statement statement = this.conexao.createStatement();
            ResultSet resultSet = statement.executeUpdate("insert into produtos (nome, quantidade)");
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
        return null;
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
