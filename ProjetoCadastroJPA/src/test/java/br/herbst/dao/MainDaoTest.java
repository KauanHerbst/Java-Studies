package br.herbst.dao;

import br.herbst.domain.Cliente;
import br.herbst.domain.Produto;
import br.herbst.domain.creators.CreatorCliente;
import br.herbst.domain.creators.CreatorProduto;
import br.herbst.domain.creators.ICreatorCliente;
import br.herbst.domain.creators.ICreatorProduto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MainDaoTest {
    private ICreatorCliente creatorCliente;
    private ICreatorProduto creatorProduto;
    private IMainDao mainDao;

    public MainDaoTest() {
        this.creatorCliente = new CreatorCliente();
        this.creatorProduto = new CreatorProduto();
        this.mainDao = new MainDao();
    }

    @Test
    public void MainDaoClienteTest(){
        Cliente cliente = creatorCliente.criarCliente("Kauan", 20, 20200l, "Maranhão");
        cliente = (Cliente) mainDao.cadastrar(cliente);
        mainDao.remover(cliente);
        Assert.assertNotNull(cliente.getId());
    }

    @Test
    public void MainDaoProdutoTest(){
        Produto produto = creatorProduto.criarProduto("A43", 50, 1000D);
        produto = (Produto) mainDao.cadastrar(produto);
        mainDao.remover(produto);
        Assert.assertNotNull(produto.getId());
    }

    @Test
    public void MainDaoBuscarTest(){
        Produto produtoCad = creatorProduto.criarProduto("A43", 50, 1000D);
        produtoCad = (Produto) mainDao.cadastrar(produtoCad);

        Produto produtoRet = (Produto) mainDao.buscar(produtoCad);
        mainDao.remover(produtoCad);
        Assert.assertEquals(produtoCad.getId(), produtoRet.getId());
    }

    @Test
    public void MainDaoBuscarTodosTest(){
        Produto produto1 = creatorProduto.criarProduto("A43", 50, 1000D);
        Produto produto2 = creatorProduto.criarProduto("S34", 70, 5030D);
        produto1 = (Produto) mainDao.cadastrar(produto1);
        produto2 = (Produto) mainDao.cadastrar(produto2);

        List<Produto> produtoList = mainDao.buscarTodos(produto2);
        produtoList.forEach((produto)-> {
            System.out.println(produto.getNome());
        });
        mainDao.remover(produto1);
        mainDao.remover(produto2);
        Assert.assertNotNull(produtoList);
    }

    @Test
    public void MainDaoAtualizarTest(){
        Cliente cliente = creatorCliente.criarCliente("Kauan", 20, 20200l, "Maranhão");
        cliente = (Cliente) mainDao.cadastrar(cliente);
        Cliente clienteNovo = creatorCliente.criarCliente("Herbst", 20, 20200l, "Rio de Janeiro");
        clienteNovo.setId(cliente.getId());
        Cliente clienteAtualizado = (Cliente) mainDao.atualizar(clienteNovo);
        mainDao.remover(clienteAtualizado);
        Assert.assertNotEquals(clienteAtualizado.getNome(), cliente.getNome());
    }


}