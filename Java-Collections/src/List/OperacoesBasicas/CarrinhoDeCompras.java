package List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaItems;

    public CarrinhoDeCompras() {
        this.listaItems = new ArrayList<>();
    }

    public void adicionarItem(String nome, float preco, int quantidade){
        listaItems.add(new Item(nome, preco, quantidade));
    }
    
    public void removerItem(String nome){
        List itemsParaRemover = new ArrayList<>();
        for(Item i : listaItems){
            if(i.getNome().equalsIgnoreCase(nome)){
                itemsParaRemover.add(i);
            }
        }
        listaItems.removeAll(itemsParaRemover);
    }
    
    public float calcularValorTotal(){
        float valorTotal = 0;
        for(Item i : listaItems){
            valorTotal = valorTotal + (i.getPreco() * i.getQuantidade());
        }
        return valorTotal;
    }

    public void exbirItems(){
        System.out.println(listaItems);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Batata", 10, 5);
        carrinhoDeCompras.adicionarItem("Chocolate", 15, 2);
        carrinhoDeCompras.adicionarItem("Maça", 20, 1);
        carrinhoDeCompras.exbirItems();

        System.out.println("Valor total do carrinho: " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("Maça");

        System.out.println("Valor total do carrinho: " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.exbirItems();
    }
}
