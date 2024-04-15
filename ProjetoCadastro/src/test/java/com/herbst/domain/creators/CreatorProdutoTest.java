package com.herbst.domain.creators;

import com.herbst.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatorProdutoTest {
    @Test
    public void creatorProdutoTest(){
        ICreatorProduto creatorProduto = new CreatorProduto();
        Produto produto = creatorProduto.criarProduto("S25", 205, 2500.00d);
        Assert.assertTrue(produto != null);
        Assert.assertEquals("S25", produto.getNome());
    }

}