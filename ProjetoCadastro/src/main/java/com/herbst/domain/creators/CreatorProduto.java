package com.herbst.domain.creators;

import com.herbst.domain.Produto;

public class CreatorProduto implements ICreatorProduto{

    @Override
    public Produto criarProduto(String nome, Integer estoque, Double valor) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setEstoque(estoque);
        produto.setValor(valor);
        return produto;
    }
}
