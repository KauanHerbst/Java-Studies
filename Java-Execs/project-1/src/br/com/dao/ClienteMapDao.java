package br.com.dao;

import br.com.objects.Cliente;

import java.util.*;

public class ClienteMapDao implements IClienteDao{

    Map<Long, Cliente> clienteMap = new HashMap();

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(clienteMap.containsKey(cliente.getCpf())){
            return false;
        }
        clienteMap.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Boolean excluir(Long cpf) {
        if(clienteMap.containsKey(cpf)){
            clienteMap.remove(cpf);
            return true;
        }
        return false;
    }

    @Override
    public Boolean atualizar(Cliente cliente) {
        if(clienteMap.containsKey(cliente.getCpf())){
            Cliente clienteSistema = clienteMap.get(cliente.getCpf());
            clienteSistema.setNome(cliente.getNome());
            clienteSistema.setIdade(cliente.getIdade());
            clienteSistema.setCidade(cliente.getCidade());
            return true;
        }
        return false;
    }

    @Override
    public Cliente consultar(Long cpf) {
        if(clienteMap.containsKey(cpf)){
            return clienteMap.get(cpf);
        }
        return null;
    }

    @Override
    public Map<Long, Cliente> retornarTodos() {
        return clienteMap;
    }

    @Override
    public Boolean verficarCadastro(Long cpf) {
        if(clienteMap.containsKey(cpf)){
            return true;
        }
        return false;
    }
}
