package br.herbst.domain;

import br.herbst.dao.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class MatriculaTest {
    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;

    private IAlunoDao alunoDao;

    public MatriculaTest() {
        this.cursoDao = new CursoDao();
        this.matriculaDao = new MatriculaDao();
        this.alunoDao = new AlunoDao();
    }

    @Test
    public void cadastrarMatriculaTest(){
        Curso curso = new Curso();
        curso.setCodigo("EF6");
        curso.setNome("Curso Test");
        Aluno aluno = new Aluno();
        aluno.setNome("Kauan");
        aluno.setIdade(15);
        alunoDao.cadastrarAluno(aluno);
        Curso cursoRetorno = cursoDao.cadastrar(curso);
        Matricula matricula = new Matricula();
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        matricula.setData(String.valueOf(Instant.now()));
        matricula.setStatus("ATIVO");
        matricula.setCodigo("AEGG5");
        aluno.setMatricula(matricula);
        Matricula matriculaRetorno = matriculaDao.cadastrarMatricula(matricula);
        matriculaDao.remover(matriculaRetorno);
        cursoDao.remover(cursoRetorno);
        alunoDao.remover(aluno);
        Assert.assertNotNull(matriculaRetorno);
        Assert.assertNotNull(matriculaRetorno.getId());
        Assert.assertNotNull(matriculaRetorno.getAluno());

    }

    @Test
    public void buscarPorCursoTest(){
        Curso curso = new Curso();
        curso.setCodigo("EF6");
        curso.setNome("Curso Test");
        Aluno aluno = new Aluno();
        aluno.setNome("Kauan");
        aluno.setIdade(15);
        alunoDao.cadastrarAluno(aluno);
        Curso cursoRetorno = cursoDao.cadastrar(curso);
        Matricula matricula = new Matricula();
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        matricula.setData(String.valueOf(Instant.now()));
        matricula.setStatus("ATIVO");
        matricula.setCodigo("AEGG5");
        aluno.setMatricula(matricula);
        Matricula matriculaRetorno = matriculaDao.cadastrarMatricula(matricula);

        Matricula matriculaBuscada = matriculaDao.buscarPorCurso(curso);

        matriculaDao.remover(matriculaRetorno);
        cursoDao.remover(cursoRetorno);
        alunoDao.remover(aluno);

        Assert.assertNotNull(matriculaBuscada);
        Assert.assertEquals(matricula.getId(), matriculaBuscada.getId());

    }

}