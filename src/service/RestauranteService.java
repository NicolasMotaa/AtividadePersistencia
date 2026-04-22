package service;

import model.Item;
import model.Pedido;
import repository.RestauranteRepository;

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
        //fazer verificação (nome)
        repo.saveItem(new Item(nome, desc, valor));
    }
    public Item buscarItem(String nome){
        return repo.lerItem(nome);
    }
    public Pedido realizarPedido(Map<Item, Integer> itens){
        //verificacao
        return repo.save(new Pedido(repo.gerarId(), itens));
    }

    public static List<Item> retornarCardapio(){
        return repo.lerCardapio();
    }
}
