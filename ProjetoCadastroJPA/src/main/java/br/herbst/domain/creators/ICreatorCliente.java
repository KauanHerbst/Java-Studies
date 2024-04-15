package br.herbst.domain.creators;

import br.herbst.domain.Cliente;

public interface ICreatorCliente {
    Cliente criarCliente(String nome, Integer idade, Long cpf, String estado);
}
