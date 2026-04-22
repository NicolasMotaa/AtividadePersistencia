package view;

import model.Item;
import service.RestauranteService;

import java.util.List;
import java.util.Scanner;

public class RestauranteView {
    private Scanner input = new Scanner(System.in);


    public void exibirMsg(String msg){
        System.out.println(msg);
    }
    public String lerTexto(){
        return input.nextLine();
    }
    public double lerValor(){
        return Double.parseDouble(input.nextLine());
    }
    public int lerInt(){
        return input.nextInt();
    }

    public void listarItens(List<Item> itens){

            System.out.println("Cardápio");
            System.out.println("----------------");
            for(Item item: itens){
                System.out.println(item.toString());
                System.out.println("----------------");
            }
    }
    public void mostrarMenu(){

        System.out.println("MENU");
        System.out.println("----------------");
        System.out.println("Digite:");
        System.out.println("1 -> Adicionar prato ou bebida ao cardapio");
        System.out.println("2 -> Fazer pedido");
        System.out.println("3 -> Ler cardápio");
        System.out.println("0 -> Fechar programa");
    }
}
