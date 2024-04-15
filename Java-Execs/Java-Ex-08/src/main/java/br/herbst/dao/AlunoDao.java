package br.herbst.dao;

import br.herbst.domain.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoDao implements IAlunoDao{
    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        if (aluno.getId() == null){
            entityManager.persist(aluno);
        }else {
            aluno = entityManager.find(Aluno.class, aluno.getId());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return aluno;
    }


    @Override
    public void remover(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(aluno)? aluno : entityManager.merge(aluno));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
