package com.herbst;

import java.util.*;

public class Placar {
    private Armazenamento armazenamento;

    public Placar (Armazenamento armazenamento){
        this.armazenamento = armazenamento;
    }

    public void registarPonto(String usuario, String tipoPonto, int quantidade) {
        armazenamento.armazenarPonto(usuario, tipoPonto, quantidade);
    }

    public Map<String, Integer> retornarPontosDoUsuario(String usuario) {
        Set<String> tiposPontos = armazenamento.recuperarTiposPontos();
        Map<String, Integer> pontosUsuario = new HashMap<>();

        for (String tipoPonto : tiposPontos) {
            int quantidade = armazenamento.recuperarPontos(usuario, tipoPonto);
            pontosUsuario.put(tipoPonto, quantidade);
        }

        return pontosUsuario;
    }

    public Map<String, Integer> calcularRanking(String tipoPonto) {
        Set<String> usuarios = armazenamento.recuperarUsuarios();
        Map<String, Integer> ranking = new HashMap<>();

        for (String usuario : usuarios) {
            int quantidade = armazenamento.recuperarPontos(usuario, tipoPonto);
            if (quantidade > 0) {
                ranking.put(usuario, quantidade);
            }
        }

        return sortByValueDescending(ranking);
    }

    private Map<String, Integer> sortByValueDescending(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
