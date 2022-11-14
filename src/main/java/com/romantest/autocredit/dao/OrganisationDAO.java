package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Organisation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganisationDAO  implements DAO<Organisation, String> {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Organisation o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(o);

        session.getTransaction().commit();

    }

    @Override
    public List<Organisation> getAll() {
        return null;
    }

    @Override
    public Organisation getById(String s) {
        return null;
    }
}
