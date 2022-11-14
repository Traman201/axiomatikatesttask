package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Agreement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Agreement> cq = cb.createQuery(Agreement.class);
        Root<Agreement> rootEntry = cq.from(Agreement.class);
        CriteriaQuery<Agreement> all = cq.select(rootEntry);

        TypedQuery<Agreement> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Agreement getById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Agreement.class, id);
    }

    public List<Agreement> getSignedOnly(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Agreement> cq = cb.createQuery(Agreement.class);
        Root<Agreement> rootEntry = cq.from(Agreement.class);
        CriteriaQuery<Agreement> all = cq.select(rootEntry);
        all.where(cb.equal(rootEntry.get("isSigned"), true));

        TypedQuery<Agreement> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
