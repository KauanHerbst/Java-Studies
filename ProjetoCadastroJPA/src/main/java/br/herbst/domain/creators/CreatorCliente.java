package br.herbst.domain.creators;

import br.herbst.domain.Cliente;

public class CreatorCliente implements ICreatorCliente {
    @Override
    public Cliente criarCliente(String nome, Integer idade, Long cpf, String estado) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setIdade(idade);
        cliente.setCpf(cpf);
        cliente.setEstado(estado);
        return cliente;
    }
}
