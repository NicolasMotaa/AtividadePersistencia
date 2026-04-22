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
        return input.nextDouble();
    }
    public int lerInt(){
        return input.nextInt();
    }

    public void listarItens(List<Item> itens){

            System.out.println("Cardápio");
            System.out.println("----------------");
            for(Item item: itens){
                System.out.println(item.getNome());
                System.out.println(item.getDescricao());
                System.out.println("R$"+item.getValor());
                System.out.println("----------------");
            }

    }
}
