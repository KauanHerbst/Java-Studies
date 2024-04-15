package br.com;

import br.com.dao.ClienteMapDao;
import br.com.dao.IClienteDao;
import br.com.objects.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDao iClienteDao = new ClienteMapDao();

    public static void main(String[] args) {

        String opcao = JOptionPane.showInputDialog(null, "Digite |1| Cadastro, |2| Excluir, |3| Atualizar, |4| Consultar |5| Sair");

        while(!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }
            opcao = JOptionPane.showInputDialog(null, "Digite um valor valido! |1| Cadastro, |2| Excluir, |3| Atualizar, |4| Consultar |5| Sair");
        }

        while (isOpcaoValida(opcao)){
            if(isSair(opcao)){
                sair();
            } else if(isCadastro(opcao)){
                String dados_zero = JOptionPane.showInputDialog(null, "Digite os dados separado por virgulas : Nome, Idade, CPF, Cidade");
                String[] dados = dados_zero.split(",");
                Long cpf = Long.parseLong(dados[1]);
                Integer idade = Integer.parseInt(dados[2]);
                Cliente cadastro = new Cliente(dados[0], cpf, idade, dados[3]);
                if(iClienteDao.cadastrar(cadastro)){
                    JOptionPane.showMessageDialog(null,"Cliente Cadastrado");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Cliente já cadastrado");
                }
            } else if(isExcluir(opcao)){
                    opcao = JOptionPane.showInputDialog(null, "Digite o CPF para excluir: ");
                    Long cpf = Long.parseLong(opcao);
                    if(iClienteDao.excluir(cpf)){
                        JOptionPane.showMessageDialog(null, "Cadastro Excluido com Sucesso");
                    }else {
                        JOptionPane.showMessageDialog(null, "Cadastro não existe");
                    }
            } else if(isAtualizar(opcao)){
                opcao = JOptionPane.showInputDialog(null, "Digite o CPF do cadastro para atuazizar: ");
                Long cpf = Long.parseLong(opcao);
                Cliente cadastro = iClienteDao.consultar(cpf);
                if(cadastro == null){
                    JOptionPane.showMessageDialog(null, "Cliente não existe!");
                }else {
                    String[] dados = JOptionPane.showInputDialog(null, "Digite separado por virgulas, Nome, Idade, Cidade").split(",");
                    Integer idade = Integer.parseInt(dados[1]);
                    Cliente clienteAtualizado = new Cliente(dados[0], cpf, idade, dados[2]);
                    if(iClienteDao.atualizar(clienteAtualizado)){
                        JOptionPane.showMessageDialog(null, "Cliente Atualizado!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Cliente não atualizado! tente novamente");
                    }
                }
            }else if(isConsultar(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF para consultar o cadastro: ");
                Long cpf = Long.parseLong(dados);
                if(iClienteDao.verficarCadastro(cpf)){
                    Cliente cliente = iClienteDao.consultar(cpf);
                    JOptionPane.showMessageDialog(null, "Cliente: " + cliente.getNome() + ", " + cliente.getIdade());
                }else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado");
                }
            }
            opcao = JOptionPane.showInputDialog(null, "Digite |1| Cadastro, |2| Excluir, |3| Atualizar, |4| Consultar |5| Sair");
        }
    }

    private static boolean isAtualizar(String opcao) {
        if(opcao.equals("3")){
            return true;
        }
        return false;
    }

    public static Boolean isConsultar(String opcao){
        if(opcao.equals("4")){
            return true;
        }
        return false;
    }

    public static boolean isExcluir(String opcao) {
        if(opcao.equals("2")){
            return true;
        }
        return false;
    }

    public static boolean isCadastro(String opcao) {
        if(opcao.equalsIgnoreCase("1")){
            return true;
        }
        return false;
    }

    public static void sair(){
        JOptionPane.showMessageDialog(null, "Até logo");
        System.exit(0);
    }

    public static Boolean isSair(String opcao){
        if(opcao.equals("5")){
            return true;
        }
        return false;
    }


    public static Boolean isOpcaoValida(String opcao){
        if(opcao.equalsIgnoreCase("1") || opcao.equalsIgnoreCase("2") || opcao.equalsIgnoreCase("3") ||
                opcao.equalsIgnoreCase("4") || opcao.equalsIgnoreCase("5")){
            return true;
        }
        return false;
    }

}
