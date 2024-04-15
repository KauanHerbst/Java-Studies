package br.herbst.dao;

import br.herbst.domain.Mesa;

public interface IMesaDao {
    public Mesa cadastrar(Mesa mesa);
    public void remover(Mesa mesa);
}
