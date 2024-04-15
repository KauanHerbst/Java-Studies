package Set.Ordeenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProduto {
    private Set<Produto> produtosSet;

    public CadastroProduto() {
        produtosSet = new HashSet<>();
    }

    public void adicionarProduto(String nome, long code, double preco, int quantidade ){
        produtosSet.add(new Produto(nome, code, preco, quantidade));
    }
    
    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(produtosSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new comparePorPreco());
        produtosPorPreco.addAll(produtosSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        
    }
    
}
