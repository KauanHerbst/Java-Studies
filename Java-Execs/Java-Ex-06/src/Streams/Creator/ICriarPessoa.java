package Streams.Creator;

import Streams.Objects.Pessoa;

public interface ICriarPessoa {
    Pessoa criarPessoa(String nome, String sobrenome, String nacionalidade, Integer idade);
}
