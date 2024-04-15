package br.herbst.dao;

import br.herbst.domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDao implements ICursoDao{
    @Override
    public Curso cadastrar(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        if(curso.getId() == null){
            entityManager.persist(curso);
        }else {
            curso = entityManager.find(Curso.class, curso.getId());
        }
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public void remover(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(curso)? curso : entityManager.merge(curso));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
