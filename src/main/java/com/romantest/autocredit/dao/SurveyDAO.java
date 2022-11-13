package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Survey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class SurveyDAO implements DAO<Survey, Integer>{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Survey o) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date today = new Date();

        o.setDate(sdf.format(today));

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(o);

        session.getTransaction().commit();
    }

    @Override
    public List<Survey> getAll() {
        return null;
    }

    @Override
    public Survey getById(Integer integer) {
        return null;
    }
}
