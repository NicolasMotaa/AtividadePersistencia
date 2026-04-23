package repository;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Item;
import model.Pedido;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RestauranteRepository {
    Map<String, Item> cardapio = new HashMap<>();
    Map<Integer, Pedido> pedidos = new HashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    public Item saveItem(Item i) {
        cardapio.put(i.getNome(), i);
        return i;
    }

    public void createJSONPedidos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        Path path = Path.of("pedidos.json");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            gson.toJson(pedidos, writer);
        } catch (IOException e) {
            System.out.println("Não deu certo, querido... (erro ao salvar arquivo)");
        }
    }

    public void createJSONCardapio() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        Path path = Path.of("cardapio.json");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            gson.toJson(cardapio, writer);
        } catch (IOException e) {
            System.out.println("Não deu certo, querido... (erro ao salvar arquivo)");
        }
    }


    public void readJSONPedidos(Path path) {
        Gson gson = new Gson();

        if (Files.exists(path)) {

            try (BufferedReader reader = Files.newBufferedReader(path)) {

                Type type = new TypeToken<Map<Integer, Pedido>>() {
                }.getType();

                pedidos = gson.fromJson(reader, type);

                if (pedidos == null) {
                    pedidos = new HashMap<>();
                }

                if (!pedidos.isEmpty()) {
                    int maiorId = Collections.max(pedidos.keySet());
                    id.set(maiorId);
                }

                System.out.println("Pedidos carregados.");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            createJSONPedidos();
            System.out.println("arquivo inexistente. Novo pedidos.json criado");
        }

    }

    public void readJSONCardapio(Path path) {
        Gson gson = new Gson();
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {

                Type type = new TypeToken<Map<String, Item>>() {
                }.getType();

                cardapio = gson.fromJson(reader, type);

                System.out.println("Cardapio carregados.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            createJSONCardapio();
            System.out.println("arquivo inexistente. Novo cardapio.json criado");
        }

    }

    public List<Item> lerCardapio() {
        return new ArrayList<>(this.cardapio.values());
    }

    public Item lerItem(String nome) {
        return this.cardapio.get(nome);
    }

    public boolean deletarItem(String nome) {
        return cardapio.remove(nome) != null;
    }

    public int gerarId() {
        return id.incrementAndGet();
    }

    public Pedido save(Pedido p) {
        pedidos.put(this.gerarId(), p);

        return p;
    }


    public List<Pedido> lerPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    public boolean deletarPedido(int id) {
        return pedidos.remove(id) != null;
    }
}
