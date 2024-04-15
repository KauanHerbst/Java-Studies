package com.herbst.domain.creators;

import com.herbst.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatorClienteTest {
    @Test
    public void creatorClienteTest(){
        ICreatorCliente creatorCliente = new CreatorCliente();
        Cliente cliente = creatorCliente.criarCliente("Kauan", 20, 100000l, "maranhao");
        Assert.assertTrue(cliente != null);
        Assert.assertEquals("Kauan", cliente.getNome());
    }

}