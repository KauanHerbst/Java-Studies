package com.herbst.service;

import com.herbst.dao.ConnectDB;
import com.herbst.domain.Cliente;
import com.herbst.domain.Produto;
import com.herbst.domain.creators.CreatorCliente;
import com.herbst.domain.creators.CreatorProduto;
import com.herbst.domain.creators.ICreatorCliente;
import com.herbst.domain.creators.ICreatorProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainService {
    private static Connection connectionDB;
    public static void cadastrarCliente(Cliente cliente){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "insert into tb_clientes (id, nome, idade, cpf, estado) values(nextval('sq_cliente'), ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setString(1, cliente.getNome());
            stm.setInt(2, cliente.getIdade());
            stm.setLong(3, cliente.getCpf());
            stm.setString(4, cliente.getEstado());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    public static void excluirClienteCPF(Long cpf){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "delete from tb_clientes where cpf = ?";
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setLong(1, cpf);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO: "  + e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }


    public static Cliente buscarClienteCPF(Long cpf){
        String querrySQL = "select * from tb_clientes where cpf = ?";
        connectionDB = ConnectDB.getConnection();
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = null;
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setLong(1, cpf);
            ResultSet result = stm.executeQuery();
            while (result.next()){
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");
                String estado = result.getString("estado");
                cliente = iCreatorCliente.criarCliente(nome, idade, cpf, estado);
                cliente.setId(result.getLong("id"));
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return cliente;
    }

    public static ArrayList<Cliente> retornarClientes(){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "select * from tb_clientes";
        ArrayList<Cliente> arrayClientes = new ArrayList<>();
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");
                Long cpf = result.getLong("cpf");
                String estado = result.getString("estado");
                Cliente cliente = iCreatorCliente.criarCliente(nome, idade, cpf, estado);
                cliente.setId(result.getLong("id"));
                arrayClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        return arrayClientes;
    }

    public static void atualizarCliente(Cliente newCliente, Long cpf){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "update tb_clientes set nome = ?, idade = ?, cpf = ?, estado = ? where cpf = ?";
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setString(1, newCliente.getNome());
            stm.setInt(2, newCliente.getIdade());
            stm.setLong(3, newCliente.getCpf());
            stm.setString(4, newCliente.getEstado());
            stm.setLong(5, cpf);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO: "+ e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    public static void cadastrarProduto(Produto produto){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "insert into tb_produtos (id, nome, estoque, preco) values(nextval('sq_produtos'), ?, ?, ?)";
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getEstoque());
            stm.setDouble(3, produto.getValor());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    public static void excluirProduto(String nome){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "delete from tb_produtos where nome = ?";
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setString(1, nome);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO: "  + e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    public static Produto buscarProduto(String nome){
        String querrySQL = "select * from tb_produtos where nome = ?";
        connectionDB = ConnectDB.getConnection();
        ICreatorProduto iCreatorProduto = new CreatorProduto();
        Produto produto = null;
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setString(1, nome);
            ResultSet result = stm.executeQuery();
            while (result.next()){
                String nomeP = result.getString("nome");
                Integer estoque = result.getInt("estoque");
                Double preco = result.getDouble("preco");
                produto = iCreatorProduto.criarProduto(nomeP, estoque, preco );
                produto.setId(result.getLong("id"));
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return produto;
    }

    public static ArrayList<Produto> retornarProdutos(){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "select * from tb_produtos";
        ArrayList<Produto> arrayProdutos = new ArrayList<>();
        ICreatorProduto iCreatorProduto = new CreatorProduto();
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                String nome = result.getString("nome");
                Integer estoque = result.getInt("estoque");
                Double preco = result.getDouble("preco");
                Produto produto = iCreatorProduto.criarProduto(nome, estoque, preco);
                produto.setId(result.getLong("id"));
                arrayProdutos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        return arrayProdutos;
    }

    public static void atualizarProduto(Produto newProduto, String nome){
        connectionDB = ConnectDB.getConnection();
        String querrySQL = "update tb_produtos set nome = ?, estoque = ?, preco = ? where nome = ?";
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            stm.setString(1, newProduto.getNome());
            stm.setInt(2, newProduto.getEstoque());
            stm.setDouble(3, newProduto.getValor());
            stm.setString(4, nome);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO: "+ e.getMessage());
        }finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

}
