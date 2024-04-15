package Map.Pesquisar;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProdutos(long codigo, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(codigo, new Produto(nome, preco, quantidade));

    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotal = 0d;
        for(Produto p : estoqueProdutosMap.values()){
            valorTotal += (p.getPreco() * p.getQuantidade());
        }
        return valorTotal;
    }

    public Produto exibirProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorValor = Double.MIN_VALUE;
        for(Produto p : estoqueProdutosMap.values()){
            if(p.getPreco() > maiorValor){
                produtoMaisCaro = p;
            }
        }
        return produtoMaisCaro;

    }

}
