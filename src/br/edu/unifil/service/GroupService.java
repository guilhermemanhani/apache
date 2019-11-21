package br.edu.unifil.service;

import br.edu.unifil.agenda.model.Groups;
import br.edu.unifil.servlet.utils.Utils;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class GroupService {

    Utils utils = new Utils();
    EntityManager entityManager = utils.getConnection();

    public void insertGroups(Groups groups) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(groups);
            entityManager.getTransaction().commit();
            System.out.println("Novo grupo persistido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Groups> findAllGroups() throws SQLException {
        return entityManager.createQuery("select g from Groups g", Groups.class).getResultList();
    }

    public void deletarGroup(String grupoRemove) throws SQLException {
        try {
            Groups grupo = entityManager.createQuery("select g from Groups g where g.descricao = :grupo", Groups.class)
                    .setParameter("grupo", grupoRemove).getResultList().get(0);
            entityManager.remove(grupo);
            System.out.println("Grupo removido");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}