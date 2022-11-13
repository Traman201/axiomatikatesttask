package com.romantest.autocredit.dao;

import com.romantest.autocredit.entity.Survey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Survey> cq = cb.createQuery(Survey.class);
        Root<Survey> rootEntry = cq.from(Survey.class);
        CriteriaQuery<Survey> all = cq.select(rootEntry);

        TypedQuery<Survey> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Survey getById(Integer id) {
        Session session = sessionFactory.openSession();
        return session.get(Survey.class, id);
    }

    public Survey getByAgreementId(int agreementId){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Survey> cq = cb.createQuery(Survey.class);
        Root<Survey> root = cq.from(Survey.class);
        cq.select(root);
        cq.where(cb.equal(root.get("agreement"), agreementId));
        TypedQuery<Survey> res = session.createQuery(cq);
        return res.getSingleResult();

    }
}
