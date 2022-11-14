package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDAO implements DAO<Position, Integer>{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Position o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(o);

        session.getTransaction().commit();
    }

    @Override
    public List<Position> getAll() {
        return null;
    }

    @Override
    public Position getById(Integer o) {
        return null;
    }
}
