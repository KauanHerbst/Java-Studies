package br.herbst.dao;

import br.herbst.domain.Curso;
import br.herbst.domain.Matricula;

public interface IMatriculaDao {
    public Matricula cadastrarMatricula(Matricula matricula);
    public void remover(Matricula matricula);

    public Matricula buscarPorCurso(Curso curso);
}
