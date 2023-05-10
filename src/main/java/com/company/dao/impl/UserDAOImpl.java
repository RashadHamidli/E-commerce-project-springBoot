package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDAOinter;
import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAOImpl extends AbstractDAO implements UserDAOinter {

    @Override
    public User getById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, id);
        return u;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u=em.find(User.class, id);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }


    @Override
    public boolean addUser(User u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }


}
