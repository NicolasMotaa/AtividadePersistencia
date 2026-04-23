package model;

import java.util.Objects;

/**
 * pratos, bebidas do cardápio
 */
public class Item {
    String nome;
    String descricao;
    double valor;

    public Item(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor= R$" + valor +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Item item = (Item) object;
        return Objects.equals(nome, item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
