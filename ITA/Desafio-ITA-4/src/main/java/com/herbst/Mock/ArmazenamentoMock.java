package com.herbst.Mock;

import com.herbst.Armazenamento;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArmazenamentoMock implements Armazenamento {
    private Map<String, Map<String, Integer>> dados = new HashMap<>();

    public ArmazenamentoMock(){

    }

    @Override
    public void armazenarPonto(String usuario, String tipoPonto, int quantidade) {
        dados.computeIfAbsent(usuario, k -> new HashMap<>()).put(tipoPonto, quantidade);
    }

    @Override
    public int recuperarPontos(String usuario, String tipoPonto) {
        return dados.getOrDefault(usuario, new HashMap<>()).getOrDefault(tipoPonto, 0);
    }

    @Override
    public Set<String> recuperarUsuarios() {
        return dados.keySet();
    }

    @Override
    public Set<String> recuperarTiposPontos() {
        Set<String> tiposPontos = new HashSet<>();
        dados.values().forEach(map -> tiposPontos.addAll(map.keySet()));
        return tiposPontos;
    }
}
