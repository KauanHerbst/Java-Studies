/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import cadastrocliente.Cliente.Cliente;

/**
 *
 * @author Kauan Herbst
 * @version 1.0
 */
public interface IClienteDAO {
     public Boolean cadastrar(String[] dadosCliente);
     public Boolean excluir(Long cpf);
     public Boolean atualizar(Long cpf, String[] dadosCliente);
     public Boolean clienteIsExiste(Long cpf);
     public Cliente consultar(Long cpf);
}
