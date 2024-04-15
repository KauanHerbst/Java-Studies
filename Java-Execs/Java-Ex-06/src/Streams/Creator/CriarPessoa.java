package Streams.Creator;

import Streams.Objects.Pessoa;

public class CriarPessoa implements ICriarPessoa{
    @Override
    public Pessoa criarPessoa(String nome, String sobrenome, String nacionalidade, Integer idade) {
        Pessoa pessoa = new Pessoa(nome, sobrenome, nacionalidade, idade);
        return pessoa;
    }
}
