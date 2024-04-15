package br.herbst.dao;

import br.herbst.domain.BaseEntity;

import java.util.List;

public interface IMainDao<T extends BaseEntity>{
    public T cadastrar(T t);
    public void remover(T t);
    public T buscar(T t);
    public List<T> buscarTodos(T t);

    public T atualizar(T t);

}
