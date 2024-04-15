package com.herbst.domain.creators;

import com.herbst.domain.Cliente;

public interface ICreatorCliente {
    Cliente criarCliente(String nome, Integer idade, Long cpf, String estado);
}
