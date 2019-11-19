package br.edu.unifil.servlet;

import br.edu.unifil.agenda.model.Groups;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class groupservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Groups group = new Groups(req.getParameter("groups_id"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lab3-aula");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();

        //resp.send
    }
}
