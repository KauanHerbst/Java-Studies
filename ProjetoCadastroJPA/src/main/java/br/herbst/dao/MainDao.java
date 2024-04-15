package br.herbst.dao;

import br.herbst.domain.BaseEntity;
import br.herbst.domain.Cliente;
import br.herbst.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainDao<T extends BaseEntity> implements IMainDao<T>{
    @Override
    public T cadastrar(T t) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_cadastro_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();

        t = (T) entityManager.find(t.getClass(), t.getId());

        entityManager.close();
        entityManagerFactory.close();

        return t;
    }

    @Override
    public void remover(T t) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_cadastro_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(t)? t : entityManager.merge(t));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public T buscar(T t) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_cadastro_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        t = (T) entityManager.find(t.getClass(), t.getId());
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return t;

    }

    @Override
    public List<T> buscarTodos(T t) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_cadastro_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        StringBuilder sb = new StringBuilder();
        if(t.getClass().equals(Cliente.class)){
            sb.append("SELECT c From Cliente c");
        }else{ sb.append("SELECT p From Produto p"); }


        entityManager.getTransaction().begin();
        TypedQuery<T> querry = (TypedQuery<T>) entityManager.createQuery(sb.toString(), t.getClass());
        List<T> list = querry.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return list;
    }

    @Override
    public T atualizar(T t) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_cadastro_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(t);
        t = (T) entityManager.find(t.getClass(), t.getId());
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return t;
    }
}
