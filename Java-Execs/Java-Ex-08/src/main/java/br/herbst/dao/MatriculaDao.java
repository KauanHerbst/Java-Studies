package br.herbst.dao;

import br.herbst.domain.Curso;
import br.herbst.domain.Matricula;
import org.geolatte.geom.M;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.Instant;

public class MatriculaDao implements IMatriculaDao{
    @Override
    public Matricula cadastrarMatricula(Matricula matricula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        if (matricula.getId() == null){
            entityManager.persist(matricula);
        }else {
            matricula = entityManager.find(Matricula.class, matricula.getId());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public void remover(Matricula matricula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(matricula)? matricula : entityManager.merge(matricula));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Matricula buscarPorCurso(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c ON c = m.curso ");
        sb.append("WHERE c.codigo = :codigoCurso");

        entityManager.getTransaction().begin();
        TypedQuery<Matricula> querry = entityManager.createQuery(sb.toString(), Matricula.class);
        querry.setParameter("codigoCurso", curso.getCodigo());
        Matricula matricula = querry.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }


}
