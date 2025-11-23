package org.gerenciamentoestoque.models;

public class Produto {

    private int id;
    private String nome;
    private int quantidade;

    public Produto() {
    }

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + this.id +
                ", nome='" + this.nome + '\'' +
                ", quantidade=" + this.quantidade +
                '}';
    }
}
