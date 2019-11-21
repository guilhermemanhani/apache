package br.edu.unifil.service;

import br.edu.unifil.agenda.model.Phone;
import br.edu.unifil.servlet.utils.Utils;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class PhoneService {

    Utils utils = new Utils();
    EntityManager entityManager = utils.getConnection();

    public void insertPhones(Phone phone) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(phone);
            entityManager.getTransaction().commit();
            System.out.println("Novo telefone persistido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Phone> findAllPhone() throws SQLException {
        return entityManager.createQuery("select p from Phone p", Phone.class).getResultList();
    }
}
