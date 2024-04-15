package br.herbst.dao;

import br.herbst.domain.Mesa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MesaDao implements  IMesaDao{
    @Override
    public Mesa cadastrar(Mesa mesa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        if(mesa.getId() == null){
            entityManager.persist(mesa);
        }else {
            mesa = entityManager.find(Mesa.class, mesa.getId());
        }
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return mesa;

    }

    @Override
    public void remover(Mesa mesa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entityManager.contains(mesa)? mesa : entityManager.merge(mesa));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
