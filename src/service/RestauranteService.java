package service;

import model.Item;
import model.Pedido;
import repository.RestauranteRepository;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * um cardapioService serviria para atualizar a lista do cardápio no repositório somente;
 * iria adicionar e remover itens, alterar valores de itens existentes.
 *
 * um pedidoService registraria um pedido apenas: (seleciona item, quantos quer dele)
 *
 * → Diante dessas poucas funcionalidades,
 * faz sentido fazer um único service restauranteService com as duas coisas
 */
public class RestauranteService {
    private static RestauranteRepository repo;

    public RestauranteService(RestauranteRepository repo) {
        this.repo = repo;
    }

    public void criarItem(String nome, String desc, double valor){
        verificarNome(new Item(nome, desc, valor));
        repo.saveItem(new Item(nome, desc, valor));
    }

    public void verificarNome(Item item){
        for (Item i : retornarCardapio()){
            if (item.equals(i)){
                throw new IllegalArgumentException("Item já cadastrado");
            }
        }
    }

    public Item buscarItem(String nome){
        return repo.lerItem(nome);
    }
    public Pedido realizarPedido(Map<String, Integer> itens){
        //verificacao
        double valor = 0;
        for (String nome: itens.keySet()){
            valor += buscarItem(nome).getValor() * itens.get(nome);
        }
        return repo.save(new Pedido(itens, valor));

    }

    public static List<Item> retornarCardapio(){
        return repo.lerCardapio();
    }

    public void salvarPedidos(){
        repo.createJSONPedidos();
    }
    public void carregarPedidos(){
        repo.readJSONPedidos(Path.of("pedidos.json"));
    }
    public void salvarCardapio(){
        repo.createJSONCardapio();
    }
    public void carregarCardapio(){
        repo.readJSONCardapio(Path.of("cardapio.json"));
    }
}
