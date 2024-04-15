package main.java.ClientSerivce;

import main.java.ClienteDao.ClienteDao;
import main.java.ClienteDao.ClienteDaoMock;
import main.java.ClienteDao.IClienteDao;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteServiceTest {
    @Test
    public void testClienteService(){
        IClienteDao iClienteDao = new ClienteDaoMock();
        ClienteService clienteService = new ClienteService(iClienteDao);
        String retorno = clienteService.salvarDados();
        Assert.assertEquals("Dados Salvos", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void erroTestClienteService(){
        IClienteDao iClienteDao = new ClienteDao();
        ClienteService clienteService = new ClienteService(iClienteDao);
        String retorno = clienteService.salvarDados();
        Assert.assertNotEquals("Dados Salvos", retorno);
    }

}