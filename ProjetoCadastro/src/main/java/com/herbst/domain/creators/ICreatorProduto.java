package com.herbst.domain.creators;

import com.herbst.domain.Produto;

public interface ICreatorProduto {
    Produto criarProduto(String nome, Integer estoque, Double valor);
}
