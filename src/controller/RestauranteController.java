package controller;

import service.RestauranteService;
import view.RestauranteView;

import java.util.HashMap;
import java.util.Map;

public class RestauranteController {

    private final RestauranteService service;
    private final RestauranteView view;

    public RestauranteController(RestauranteService service, RestauranteView view) {
        this.service = service;
        this.view = view;
    }

    private boolean loop = true;

    public void laco() {
        service.carregarCardapio();
        service.carregarPedidos();
        while (loop) {
            view.mostrarMenu();
            switch (view.lerInt()) {
                case 1 -> criarItem();
                case 2 -> fazerPedido(); //ler pedido ao realizar
                case 3 -> listarItens();
                //case 4 -> listarPedidos();
                case 0 -> fechar();
                default -> view.exibirMsg("selecione uma opcao valida");
            }
        }
    }

    void criarItem() {
        view.lerTexto();
        view.exibirMsg("insira o nome do prato ou bebida");
        String nome = view.lerTexto();
        view.exibirMsg("insira a descrição: ");
        String desc = view.lerTexto();
        view.exibirMsg("insira o valor do item");
        double valor = view.lerValor();
        service.criarItem(nome, desc, valor);
    }

    void fazerPedido() {
        Map<String, Integer> mapa = new HashMap<>();
        listarItens();
        boolean laco = true;
        while (laco) {
            view.lerTexto();
            view.exibirMsg("digite o nome do item que deseja");
            String nome = view.lerTexto();
            view.exibirMsg("digite a quantidade desejada");
            int quantidade = view.lerInt();
            mapa.put(nome, quantidade);
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
        service.salvarPedidos();
        service.salvarCardapio();
        view.exibirMsg("Adeus...");
    }
}




