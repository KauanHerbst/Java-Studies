
import cadastrocliente.Cliente.Cliente;
import dao.ClienteMapDAO;
import dao.IClienteDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kauan Herbst
 */
public class Test {
    public static void main(String[] args) {
        String[] dados = new String[5];
        dados[0] = "Kauan";
        dados[1] = "Herbst";
        dados[2] = "20";
        dados[3] = "19";
        dados[4] = "1000";
        Cliente clienteTeste = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4]);
        IClienteDAO clienteMap = new ClienteMapDAO();
        clienteMap.cadastrar(dados);
        System.out.println(clienteTeste.getNome());
        System.out.println(clienteTeste.getSobrenome());
        System.out.println(clienteTeste.getCpf());
        System.out.println(clienteTeste.getIdade());
        System.out.println(clienteTeste.getCep());
        
        
    }
}
