package br.herbst.dao;

import br.herbst.domain.Aluno;
import br.herbst.domain.Matricula;

public interface IAlunoDao {
    public Aluno cadastrarAluno(Aluno aluno);
    public void remover(Aluno aluno);
}
