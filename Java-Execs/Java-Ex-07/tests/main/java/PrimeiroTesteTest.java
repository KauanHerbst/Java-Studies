package main.java;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.PipedReader;

import static org.junit.Assert.*;

public class PrimeiroTesteTest {
    @Test
    public void primeiroTest(){
        PrimeiroTeste primeiroTeste = new PrimeiroTeste();
        primeiroTeste.outroSetNome("Kauan");
        Assert.assertEquals("Kauan", primeiroTeste.getNome());
    }

}