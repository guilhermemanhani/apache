package br.edu.unifil.service;

import br.edu.unifil.agenda.model.Contact;
import br.edu.unifil.servlet.utils.Utils;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class    ContactService {

    Utils utils = new Utils();
    EntityManager entityManager = utils.getConnection();

    public void salvarNovoContato(Contact contact) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contact);
            entityManager.getTransaction().commit();
            System.out.println("Novo contato persistido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarContato(Integer id) {
        try {
            entityManager.getTransaction().begin();
            Contact contactRecuperado = entityManager.find(Contact.class, id);
            entityManager.remove(contactRecuperado);
            entityManager.getTransaction().commit();
            System.out.println("Contact removido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Contact recuperarContato(Integer id, EntityManager entityManager) throws Exception {
        Contact contact = entityManager.find(Contact.class, id);
        if(contact != null) {
            return contact;
        } else {
            throw new Exception("Contato não existe");
        }
    }

    public void atualizarContato(Contact contatoExistente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contatoExistente);
            entityManager.getTransaction().commit();
            System.out.println("Contato atualizado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contact> findAllContatos() {
        return entityManager.createQuery("select c from Contact c", Contact.class).getResultList();
    }

    public List<Contact> findContactByName(String nome) throws SQLException {
        return entityManager.createQuery("select c from Contact c where c.firstName = :nome", Contact.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
