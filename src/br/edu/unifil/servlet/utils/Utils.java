package br.edu.unifil.servlet.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa-lab3-aula");

    EntityManager entityManager = emf.createEntityManager();

    public EntityManager getConnection() {
        return entityManager;
    }
}
