package model;

import java.util.Map;

public class Pedido {
    Map<String, Integer> itens;
    double valorTotal = 0;

    public Pedido( Map<String, Integer> itens, double valor) {

        this.itens = itens;
        this.valorTotal = valor;
    }

    public double getValorTotal() {
        return valorTotal;
    }


}
