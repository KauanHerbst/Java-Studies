package br.herbst.domain.creators;

import br.herbst.domain.Produto;


public interface ICreatorProduto {
    Produto criarProduto(String nome, Integer estoque, Double valor);
}
