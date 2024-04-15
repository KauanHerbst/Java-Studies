package main.java;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SegundoTesteTest {
    @Test
    public void segundoTest(){
        SegundoTeste segundoTeste = new SegundoTeste();
        segundoTeste.setIdade(20);
        segundoTeste.setCPF("000.000.000-00");
        Assert.assertEquals(20, segundoTeste.getIdade());
        Assert.assertEquals("000.000.000-00", segundoTeste.getCPF());

    }

}