package com.romantest.autocredit.dao;


import com.romantest.autocredit.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class ClientDAO implements DAO<Client, String>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Client o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(o);

        session.getTransaction().commit();

    }

    @Override
    public List<Client> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> rootEntry = cq.from(Client.class);
        CriteriaQuery<Client> all = cq.select(rootEntry);

        TypedQuery<Client> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Client getById(String s) {
        Session session = sessionFactory.openSession();
        return session.get(Client.class, s);
    }

    public List<Client> getWithFilter(Map<String, String> filters){

        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> rootEntry = cq.from(Client.class);
        CriteriaQuery<Client> all = cq.select(rootEntry);

        filters.forEach((key, v) -> {
                    if(!v.equals("")){
                        all.where(cb.like(rootEntry.get(key), v));
                    }
                }
                );

        TypedQuery<Client> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
