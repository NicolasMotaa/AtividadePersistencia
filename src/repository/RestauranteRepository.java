package repository;

import model.Item;
import model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RestauranteRepository {
    Map<String, Item> cardapio = new HashMap<>();
    Map<Integer, Pedido> pedidos = new HashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    public Item saveItem(Item i){
        cardapio.put(i.getNome(), i);
        return i;
    }

    public List<Item> lerCardapio (){
        return new ArrayList<>(this.cardapio.values());
    }

    public Item lerItem(String nome){
        return this.cardapio.get(nome);
    }

    public boolean deletarItem(String nome){
        return cardapio.remove(nome) != null;
    }

    public int gerarId() {
        return id.incrementAndGet();
    }

        public Pedido save(Pedido p) {
        pedidos.put(p.getId(), p);
        return p;
    }


    public List<Pedido> lerPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    public boolean deletarPedido(int id) {
        return pedidos.remove(id) != null;
    }
}
