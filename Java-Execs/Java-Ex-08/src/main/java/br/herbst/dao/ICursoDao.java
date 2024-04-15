package br.herbst.dao;

import br.herbst.domain.Curso;

public interface ICursoDao {
    public Curso cadastrar(Curso curso);
    public void remover(Curso curso);
}
