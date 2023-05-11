package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDAOinter;
import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class UserDAOImpl extends AbstractDAO implements UserDAOinter {
    @Override
    public List<User> getAll(String name, String surname, String email, String phone, String address, Date birthdate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
        EntityManager em = emf.createEntityManager();

        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (email != null && !email.trim().isEmpty()) {
            jpql += " and u.email=:email";
        }
        if (phone != null && !phone.trim().isEmpty()) {
            jpql += " and u.phone.id=:phone";
        }
        if (address != null && !address.trim().isEmpty()) {
            jpql += " and u.address.id=:address";
        }
        if (birthdate != null) {
            jpql += " and u.birthdate.id=:birthdate";
        }
        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (email != null && !email.trim().isEmpty() ) {
            query.setParameter("email", email);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            query.setParameter("phone", phone);
        }
        if (address != null && !address.trim().isEmpty()) {
            query.setParameter("address", address);
        }
        if (birthdate != null) {
            query.setParameter("birthdate", birthdate);
        }
        return query.getResultList();
    }


    @Override
    public User findByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from User u where u.email =:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

//    @Override
//    public User findByEmail(String email) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResumePU");
//        EntityManager em = emf.createEntityManager();
//        Query q = em.createNativeQuery("select * from User where email = ?", User.class);
//        q.setParameter(1, email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

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
        User u = em.find(User.class, id);
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
