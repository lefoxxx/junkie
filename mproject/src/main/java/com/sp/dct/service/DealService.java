package com.sp.dct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.dct.dao.DealDao;
import com.sp.dct.model.Deal;

import java.util.Collection;
import java.util.List;

@Service("dealService")
public class DealService {

    @Autowired
    private DealDao dao;

    @Transactional
    public List<Deal> getDeals() {
        return dao.findAll();
    }

    @Transactional
    public void save(Deal deal) {
        dao.saveOrUpdate(deal);
    }

    @Transactional
    public void delete(Collection<Integer> ids) {
        dao.delete(ids);
    }
}
