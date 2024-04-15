package com.herbst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArmazenamentoArquivoTest {
    private static final String ARQUIVO_TESTE = "test_data.txt";

    private ArmazenamentoArquivo armazenamentoArquivo;

    @BeforeEach
    public void setUp() {
        armazenamentoArquivo = new ArmazenamentoArquivo(ARQUIVO_TESTE);
    }

    @Test
    public void testArmazenarPonto() {
        armazenamentoArquivo.armazenarPonto("usuario1", "tipo1", 10);

        Map<String, Map<String, Integer>> dados = armazenamentoArquivo.lerDadosDoArquivo();
        assertTrue(dados.containsKey("usuario1"));
        assertEquals(10, dados.get("usuario1").get("tipo1"));
    }

    @Test
    public void testRecuperarPontos() {
        armazenamentoArquivo.armazenarPonto("usuario2", "tipo2", 20);

        int pontos = armazenamentoArquivo.recuperarPontos("usuario2", "tipo2");
        assertEquals(20, pontos);
    }

    @Test
    public void testRecuperarUsuarios() {
        armazenamentoArquivo.armazenarPonto("usuario3", "tipo3", 30);

        assertTrue(armazenamentoArquivo.recuperarUsuarios().contains("usuario3"));
    }

    @Test
    public void testRecuperarTiposPontos() {
        armazenamentoArquivo.armazenarPonto("usuario4", "tipo4", 40);

        assertTrue(armazenamentoArquivo.recuperarTiposPontos().contains("tipo4"));
    }

}