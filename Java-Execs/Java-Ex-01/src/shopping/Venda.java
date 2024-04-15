package shopping;

/**
 * @author Kauan-Herbst
 * @version 1.0
 * 
 */

public class Venda {
    
    
    public static void main(String[] args) {
        Cliente joaoCliente = new Cliente(1, "João");
        Produtos carro = new Produtos(1, "Carro");
        carro.setQuantidadeDisponivel(8);
        Vendedor claudioVendedor = new Vendedor(1, "Claudio");



        joaoCliente.comprarProduto(carro, claudioVendedor, 5);
        System.out.println("Produtos comprados pelo cliente: " + joaoCliente.getProdutosComprados());
        System.out.println("Quantidade de " + carro.getNome() + " vendidos: " + carro.getQuantidadeVendida());
        System.out.println("Quantidade de vendas realizadas pelo vendedor " + claudioVendedor.getNome() + ": " + claudioVendedor.getVendasRealizadas());

    }
}
