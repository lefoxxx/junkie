package com.sp.dct.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.dct.dao.DealDao;
import com.sp.dct.model.Deal;

import java.util.Collection;
import java.util.List;

@Repository("dealHibernateDao")
public class DealHibernateDao implements DealDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(Deal deal) {
        sessionFactory.getCurrentSession().saveOrUpdate(deal);
    }

    @Override
    public Deal get(Integer id) {
        return (Deal) sessionFactory.getCurrentSession().get(Deal.class, id);
    }

    @Override
    public List<Deal> findAll() {
        return sessionFactory.getCurrentSession().getNamedQuery(Deal.ALL).list();
    }

    @Override
    public void delete(Deal deal) {
        sessionFactory.getCurrentSession().delete(deal);
    }

    @Override
    public int delete(Collection<Integer> ids) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery(Deal.DELETE_BY_IDS);
        query.setParameterList("ids", ids);
        return query.executeUpdate();
    }
}
