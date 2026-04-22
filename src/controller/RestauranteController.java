package controller;

import model.Item;
import service.RestauranteService;
import view.RestauranteView;

import java.util.HashMap;
import java.util.Map;

public class RestauranteController {

    private RestauranteService service;
    private RestauranteView view;

    private boolean loop = true;

    public void laco() {
        while (loop) {
            view.mostrarMenu();
            switch (view.lerInt()) {
                case 1 -> criarItem();
                case 2 -> fazerPedido();
                case 3 -> listarItens();
                case 0 -> fechar();
                default -> view.exibirMsg("selecione uma opcao valida");
            }
        }
    }

    void criarItem() {
        String nome = view.lerTexto();
        String desc = view.lerTexto();
        double valor = view.lerValor();
        service.criarItem(nome, desc, valor);
    }

    void fazerPedido() {
        Map<Item, Integer> mapa = new HashMap<>();
        listarItens();
        boolean laco = true;
        while (laco) {
            view.exibirMsg("digite o nome do item que deseja");
            String nome = view.lerTexto();
            view.exibirMsg("digite a quantidade desejada");
            int quantidade = view.lerInt();
            mapa.put(service.buscarItem(nome), quantidade);
            view.exibirMsg("digite 0 para sair ou outro numero para solicitar novo item");
            if (view.lerInt() == 0) {
                laco = false;
            }

        }
        service.realizarPedido(mapa);
    }

    void listarItens() {
        view.listarItens(service.retornarCardapio());
    }

    void fechar(){
        this.loop = false;
    }
}




