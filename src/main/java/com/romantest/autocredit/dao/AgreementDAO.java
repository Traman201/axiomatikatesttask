package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Agreement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgreementDAO implements DAO<Agreement, Integer> {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Agreement o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(o);

        session.getTransaction().commit();
    }

    @Override
    public List<Agreement> getAll() {
        return null;
    }

    @Override
    public Agreement getById(Integer integer) {
        return null;
    }
}
