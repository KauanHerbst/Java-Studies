package com.herbst;

import com.herbst.Mock.ArmazenamentoMock;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlacarTest {
    private ArmazenamentoMock armazenamentoMock;
    private Placar placar;

    @BeforeEach
    public void setUp() {
        armazenamentoMock = new ArmazenamentoMock();
        placar = new Placar(armazenamentoMock);
    }

    @Test
    void testRegistarPonto() {

        String usuario = "usuarioTeste";
        String tipoPonto = "pontoTeste";
        Integer quantidade = 10;

        placar.registarPonto(usuario, tipoPonto, quantidade);

        assertEquals(quantidade, armazenamentoMock.recuperarPontos(usuario, tipoPonto));
    }

    @Test
    void testRetornarPontosDoUsuario() {
        String usuario = "usuarioTeste";
        String tipoPonto = "pontoTeste";
        int quantidade = 15;

        armazenamentoMock.armazenarPonto(usuario, tipoPonto, quantidade);

        Map<String, Integer> resultado = placar.retornarPontosDoUsuario(usuario);

        Map<String, Integer> esperado = new HashMap<>();
        esperado.put(tipoPonto, quantidade);
        assertEquals(esperado, resultado);
    }

    @Test
    void testCalcularRanking() {

        String tipoPonto = "pontoTeste";

        armazenamentoMock.armazenarPonto("usuario1", tipoPonto, 20);
        armazenamentoMock.armazenarPonto("usuario2", tipoPonto, 15);
        armazenamentoMock.armazenarPonto("usuario3", tipoPonto, 30);

        Map<String, Integer> resultado = placar.calcularRanking(tipoPonto);

        Map<String, Integer> esperado = new HashMap<>();
        esperado.put("usuario3", 30);
        esperado.put("usuario1", 20);
        esperado.put("usuario2", 15);
        assertEquals(esperado, resultado);
    }
}