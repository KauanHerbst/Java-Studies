/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import cadastrocliente.Cliente.Cliente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kauan Herbst
 * @version 1.0
 */
public class ClienteMapDAO  implements IClienteDAO{

    public static Map<Long, Cliente> clienteMAP = new HashMap<>();
    
    @Override
    public Boolean cadastrar(String[] dadosCliente) {
       if(!clienteMAP.containsKey(Long.parseLong(dadosCliente[2]))){
            Cliente clienteCadastro = new Cliente(dadosCliente[0], dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
            if(clienteCadastro != null){
                clienteMAP.put(clienteCadastro.getCpf(), clienteCadastro);
                return true;
            }
       
       }else {
           return false;
       }
       return false;
    }

    @Override
    public Boolean excluir(Long cpf) {
        if(clienteMAP.containsKey(cpf)){
            clienteMAP.remove(cpf);
            return true;
        }
        return false;
    }

    @Override
    public Boolean atualizar(Long cpf, String[] dadosCliente) {
       if(clienteMAP.containsKey(cpf)){
           Cliente clienteCadastrado = clienteMAP.get(cpf);
           clienteCadastrado.setNome(dadosCliente[0]);
           clienteCadastrado.setSobrenome(dadosCliente[1]);
           clienteCadastrado.setIdade(Integer.parseInt(dadosCliente[2]));
           clienteCadastrado.setCep(Long.parseLong(dadosCliente[3]));
           return true;
       }
       return false;
    }

    @Override
    public Boolean clienteIsExiste(Long cpf) {
       if(clienteMAP.containsKey(cpf)){
           return true;
       }
       return false;
    }

    @Override
    public Cliente consultar(Long cpf) {
        if(clienteMAP.containsKey(cpf)){
            return clienteMAP.get(cpf);
        }
        return null;
    }

   
    
}
