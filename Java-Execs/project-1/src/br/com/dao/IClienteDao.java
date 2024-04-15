package br.com.dao;

import br.com.objects.Cliente;

import java.util.Map;

public interface IClienteDao {

    public Boolean cadastrar(Cliente cliente);
    public Boolean excluir(Long cpf);
    public Boolean atualizar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public Map<Long, Cliente> retornarTodos();
    public Boolean verficarCadastro(Long cpf);


}
