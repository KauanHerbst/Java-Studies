package com.herbst.dao;

import com.herbst.domain.Cliente;
import com.herbst.domain.creators.CreatorCliente;
import com.herbst.domain.creators.ICreatorCliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectDBTest {
    @Test
    public void connectTest(){
        Connection connection = ConnectDB.getConnection();
        Assert.assertTrue(connection != null);
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insertTest(){
        ICreatorCliente iCreatorCliente = new CreatorCliente();
        Cliente cliente = iCreatorCliente.criarCliente("Kauan", 20, 200000l, "maranhão");

        Connection connection = ConnectDB.getConnection();
        String querrySQL = "insert into tb_clientes (id, nome, idade, cpf, estado) values(nextval('sq_cliente'), ?, ?, ?, ?)";
        String querrySQL2 = "select * from tb_clientes";
        try {
            PreparedStatement stm = connection.prepareStatement(querrySQL);
            stm.setString(1, cliente.getNome());
            stm.setInt(2, cliente.getIdade());
            stm.setLong(3, cliente.getCpf());
            stm.setString(4, cliente.getEstado());
            PreparedStatement stm2 = connection.prepareStatement(querrySQL2);
            stm.executeUpdate();
            ResultSet result = stm2.executeQuery();
            String nome = "";
            while (result.next()){
                nome = result.getString("nome");
            }
            String querrySQL3 = "truncate table tb_clientes";
            PreparedStatement stm3 = connection.prepareStatement(querrySQL3);
            stm3.executeUpdate();
            Assert.assertEquals("Kauan", nome);
        }catch (SQLException e){
            System.out.println("ERRO: "+ e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void truncateTableTest(){
        String querrySQL = "truncate table tb_clientes";
        String querrySQL2 = "select * from tb_clientes";
        Connection connection = ConnectDB.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(querrySQL);
            stm.executeUpdate();

            PreparedStatement stm2 = connection.prepareStatement(querrySQL2);
            ResultSet result = stm2.executeQuery();
            String nome = "";
            while (result.next()){
                nome = result.getString("nome");
            }
            System.out.println(nome);
            Assert.assertTrue(nome == "");
        } catch (SQLException e) {
            System.out.println("ERRO: "+ e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERRO: "+ e.getMessage());
            }
        }
    }
}