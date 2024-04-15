package br.herbst.domain;

import br.herbst.dao.*;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.geolatte.geom.M;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class MesaTest {

    private IMesaDao mesaDao;
    private IAlunoDao alunoDao;
    private ICursoDao cursoDao;
    private IMatriculaDao matriculaDao;

    public MesaTest() {
        this.alunoDao = new AlunoDao();
        this.cursoDao = new CursoDao();
        this.mesaDao = new MesaDao();
        this.matriculaDao = new MatriculaDao();
    }

    @Test
    public void mesaTest(){
        Curso curso = new Curso();
        curso.setNome("curso backend Test");
        curso.setCodigo("AEFT2");
        curso = cursoDao.cadastrar(curso);
        Matricula matricula = new Matricula();
        matricula.setCurso(curso);
        matricula.setStatus("ATIVA");
        matricula.setData(String.valueOf(Instant.now()));
        matricula.setCodigo("FJGIH12");
        Aluno aluno = new Aluno();
        aluno.setNome("Kauan");
        aluno.setIdade(19);
        Mesa mesa = new Mesa();
        mesa.setNumber(1);
        mesa.addAlunoMesa(aluno);
        aluno.setMatricula(matricula);
        mesa = mesaDao.cadastrar(mesa);
        matricula.setAluno(aluno);
        matricula = matriculaDao.cadastrarMatricula(matricula);
        Assert.assertNotNull(mesa.getId());
    }

    @Test
    public void mesaTestSingle(){
        Aluno aluno = new Aluno();
        aluno.setNome("Kauan");
        aluno.setIdade(20);
        Mesa mesa = new Mesa();
        mesa.setNumber(5);
        mesa.addAlunoMesa(aluno);
        //aluno = alunoDao.cadastrarAluno(aluno);
        //Assert.assertNotNull(aluno.getId());
        mesa = mesaDao.cadastrar(mesa);
        Assert.assertNotNull(mesa.getId());
    }



}