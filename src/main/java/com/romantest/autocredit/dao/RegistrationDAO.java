package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationDAO implements DAO<Registration, Integer>{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Registration o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(o);

        session.getTransaction().commit();
    }

    @Override
    public List<Registration> getAll() {
        return null;
    }

    @Override
    public Registration getById(Integer integer) {
        return null;
    }
}
