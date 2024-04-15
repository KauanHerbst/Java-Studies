package com.herbst;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArmazenamentoArquivo implements Armazenamento{

    private String nomeArquivo;

    public ArmazenamentoArquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    @Override
    public void armazenarPonto(String usuario, String tipoPonto, int quantidade) {
        Map<String, Map<String, Integer>> dados = lerDadosDoArquivo();
        dados.computeIfAbsent(usuario, k -> new HashMap<>()).put(tipoPonto, quantidade);
        escreverDadosNoArquivo(dados);
    }

    @Override
    public int recuperarPontos(String usuario, String tipoPonto) {
        Map<String, Map<String, Integer>> dados = lerDadosDoArquivo();
        return dados.getOrDefault(usuario, new HashMap<>()).getOrDefault(tipoPonto, 0);
    }

    @Override
    public Set<String> recuperarUsuarios() {
        Map<String, Map<String, Integer>> dados = lerDadosDoArquivo();
        return dados.keySet();
    }

    @Override
    public Set<String> recuperarTiposPontos() {
        Map<String, Map<String, Integer>> dados = lerDadosDoArquivo();
        Set<String> tiposPontos = new HashSet<>();
        dados.values().forEach(map -> tiposPontos.addAll(map.keySet()));
        return tiposPontos;
    }

    public Map<String, Map<String, Integer>> lerDadosDoArquivo(){
        Map<String, Map<String, Integer>> dados = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;
            while ((linha = reader.readLine()) != null){
                String[] partesString = linha.split(",");
                String usuario = partesString[0];
                String tipoPonto = partesString[1];
                Integer quantidade = Integer.parseInt(partesString[2]);

                dados.computeIfAbsent(usuario, k -> new HashMap<>()).put(tipoPonto, quantidade);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return dados;
    }

    public void escreverDadosNoArquivo(Map<String, Map<String, Integer>> dados){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))){
            for (Map.Entry<String, Map<String, Integer>> entry : dados.entrySet()) {
                String usuario = entry.getKey();
                for (Map.Entry<String, Integer> pontoEntry : entry.getValue().entrySet()) {
                    String tipoPonto = pontoEntry.getKey();
                    int quantidade = pontoEntry.getValue();

                    writer.write(usuario + "," + tipoPonto + "," + quantidade);
                    writer.newLine();
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
