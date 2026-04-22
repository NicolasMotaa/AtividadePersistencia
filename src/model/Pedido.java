package model;

import java.util.Map;

public class Pedido {
    int id;
    Map<Item, Integer> itens;
    double valorTotal = 0;

    public Pedido(int id, Map<Item, Integer> itens) {
        this.id = id;
        this.itens = itens;
        calcularValor();
    }

    public void calcularValor() {
        this.itens.forEach((chave, valor) ->
                this.valorTotal += chave.getValor() * valor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Item, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Item, Integer> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }


}
