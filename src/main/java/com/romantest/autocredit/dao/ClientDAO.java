package com.romantest.autocredit.dao;


import com.romantest.autocredit.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClientDAO implements DAO<Client, String>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Client o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(o);

        session.getTransaction().commit();
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Client getById(String s) {
        return null;
    }
}
