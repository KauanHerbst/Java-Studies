package br.herbst.domain;

import br.herbst.dao.CursoDao;
import br.herbst.dao.ICursoDao;
import org.junit.Assert;
import org.junit.Test;

public class CursoTest {
    private ICursoDao cursoDao;

    public CursoTest() {
        this.cursoDao =  new CursoDao();
    }

    @Test
    public void cadastrarCursoTest(){
        Curso curso = new Curso();
        curso.setCodigo("EF6");
        curso.setNome("Curso Test");
        Curso cursoRetorno = cursoDao.cadastrar(curso);
        cursoDao.remover(cursoRetorno);
        Assert.assertNotNull(cursoRetorno);
        Assert.assertNotNull(cursoRetorno.getId());
    }


}