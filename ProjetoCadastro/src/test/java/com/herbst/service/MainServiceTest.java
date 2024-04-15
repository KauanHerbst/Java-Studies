package com.herbst.service;

import com.herbst.dao.ConnectDB;
import com.herbst.domain.Cliente;
import com.herbst.domain.Produto;
import com.herbst.domain.creators.CreatorCliente;
import com.herbst.domain.creators.CreatorProduto;
import com.herbst.domain.creators.ICreatorCliente;
import com.herbst.domain.creators.ICreatorProduto;
import com.sun.tools.javac.Main;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainServiceTest {
    @Test
    public void retornarClientesTest(){
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = iCreatorCliente.criarCliente("Kauan", 20, 304050l, "Maranhão");
        Cliente cliente2 = iCreatorCliente.criarCliente("João", 35, 201030l, "Rio De Janeiro");
        Cliente cliente3 = iCreatorCliente.criarCliente("Felipe", 20, 705080l, "São Paulo");
        MainService.cadastrarCliente(cliente);
        MainService.cadastrarCliente(cliente2);
        MainService.cadastrarCliente(cliente3);

        ArrayList<Cliente> clienteArrayList = MainService.retornarClientes();
        clienteArrayList.forEach((Cliente cli) -> {
            System.out.println(cli.getNome());
            MainService.excluirClienteCPF(cli.getCpf());
        });
        Assert.assertTrue(!clienteArrayList.isEmpty());
    }

    @Test
    public void buscarClienteTest(){
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = iCreatorCliente.criarCliente("Kauan", 20, 304050l, "Maranhão");
        MainService.cadastrarCliente(cliente);
        Cliente clienteRetorno = MainService.buscarClienteCPF(304050l);
        MainService.excluirClienteCPF(clienteRetorno.getCpf());
        Assert.assertEquals(cliente.getCpf(), clienteRetorno.getCpf());
    }

    @Test
    public void cadastrarClienteTest(){
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = iCreatorCliente.criarCliente("Kauan", 20, 304050l, "Maranhão");
        MainService.cadastrarCliente(cliente);

        String querrySQL = "select * from tb_clientes";
        Connection connectionDB = ConnectDB.getConnection();
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            ResultSet result = stm.executeQuery();
            String nome = "";
            while (result.next()){
               nome = result.getString("nome");
            }
            MainService.excluirClienteCPF(304050l);
            Assert.assertEquals("Kauan", nome);
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

    @Test
    public void exlcuirClienteTest(){
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = iCreatorCliente.criarCliente("Kauan", 20, 304050l, "Maranhão");
        MainService.cadastrarCliente(cliente);
        String querrySQL = "select * from tb_clientes";
        Connection connectionDB = ConnectDB.getConnection();
        try {
            PreparedStatement stm = connectionDB.prepareStatement(querrySQL);
            ResultSet result = stm.executeQuery();
            Long cpf = 0l;
            while (result.next()){
                cpf = result.getLong("cpf");
            }
            MainService.excluirClienteCPF(cpf);
            ArrayList<Cliente> clienteArrayList = MainService.retornarClientes();
            Assert.assertTrue(clienteArrayList.isEmpty());
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

    @Test
    public void atualizarClienteTest(){
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = iCreatorCliente.criarCliente("Kauan", 20, 304050l, "Maranhão");
        MainService.cadastrarCliente(cliente);
        Cliente newCliente = iCreatorCliente.criarCliente("Herbst", 26, 101010l, "Pará");
        MainService.atualizarCliente(newCliente, cliente.getCpf());
        Cliente clienteRetorno = MainService.buscarClienteCPF(newCliente.getCpf());
        MainService.excluirClienteCPF(newCliente.getCpf());
        Assert.assertEquals(clienteRetorno.getCpf(), newCliente.getCpf());
    }

    @Test
    public void cadastrarProdutoTest(){
        ICreatorProduto iCreatorProduto = new CreatorProduto();
        Produto produto = iCreatorProduto.criarProduto("S24", 50, 1000d);
        MainService.cadastrarProduto(produto);
        Produto produtoRetorno = MainService.buscarProduto(produto.getNome());
        MainService.excluirProduto(produto.getNome());
        Assert.assertEquals(produto.getNome(), produtoRetorno.getNome());
    }

    @Test
    public void retornarProdutosTest(){
        ICreatorProduto iCreatorProduto = new CreatorProduto();
        Produto produto = iCreatorProduto.criarProduto("S24", 50, 1000d);
        Produto produto2 = iCreatorProduto.criarProduto("A4", 80, 700d);
        Produto produto3 = iCreatorProduto.criarProduto("M01", 20, 1900d);
        MainService.cadastrarProduto(produto);
        MainService.cadastrarProduto(produto2);
        MainService.cadastrarProduto(produto3);

        ArrayList<Produto> produtoArrayList = new ArrayList<>();
        produtoArrayList = MainService.retornarProdutos();
        produtoArrayList.forEach((Produto pro) -> {
            System.out.println(pro.getNome());
            MainService.excluirProduto(pro.getNome());
        });
        Assert.assertTrue(!produtoArrayList.isEmpty());
    }

    @Test
    public void atualizarProdutoTest(){
        ICreatorProduto iCreatorProduto = new CreatorProduto();
        Produto produto = iCreatorProduto.criarProduto("S24", 50, 1000d);
        Produto newProduto = iCreatorProduto.criarProduto("S30", 5, 9300.40d);
        MainService.cadastrarProduto(produto);
        MainService.atualizarProduto(newProduto, produto.getNome());
        Produto produtoRetorno = MainService.buscarProduto(newProduto.getNome());
        MainService.excluirProduto(produtoRetorno.getNome());
        Assert.assertEquals(newProduto.getNome(), produtoRetorno.getNome());
    }

}