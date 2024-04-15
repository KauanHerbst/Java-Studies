package com.herbst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegracaoPlacarArmazenamentoArquivoTest {

    private static final String ARQUIVO_TESTE = "test_data_integration.txt";

    private Placar placar;
    private ArmazenamentoArquivo armazenamentoArquivo;

    @BeforeEach
    public void setUp() {
        armazenamentoArquivo = new ArmazenamentoArquivo(ARQUIVO_TESTE);
        placar = new Placar(armazenamentoArquivo);
    }


    @Test
    public void testIntegracaoPlacarArmazenamentoArquivo() {
        placar.registarPonto("user1", "tipo1", 10);
        placar.registarPonto("user2", "tipo1", 5);
        placar.registarPonto("user1", "tipo2", 20);

        Map<String, Integer> pontosUser1 = placar.retornarPontosDoUsuario("user1");
        assertEquals(Optional.of(10).get(), pontosUser1.get("tipo1"));
        assertEquals(Optional.of(20).get(), pontosUser1.get("tipo2"));

        Map<String, Integer> pontosUser2 = placar.retornarPontosDoUsuario("user2");
        assertEquals(Optional.of(5).get(), pontosUser2.get("tipo1"));

        Map<String, Integer> rankingTipo1 = placar.calcularRanking("tipo1");
        assertEquals(2, rankingTipo1.size());
        assertTrue(rankingTipo1.containsKey("user1"));
        assertTrue(rankingTipo1.containsKey("user2"));
        assertEquals(Optional.of(10).get(), rankingTipo1.get("user1"));
        assertEquals(Optional.of(5).get(), rankingTipo1.get("user2"));

        Set<String> usuarios = armazenamentoArquivo.recuperarUsuarios();
        Set<String> tiposPontos = armazenamentoArquivo.recuperarTiposPontos();

        assertTrue(usuarios.contains("user1"));
        assertTrue(usuarios.contains("user2"));

        assertTrue(tiposPontos.contains("tipo1"));
        assertTrue(tiposPontos.contains("tipo2"));
    }
    
}
