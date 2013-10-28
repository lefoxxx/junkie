package tld.dmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tld.dmt.dao.DealDao;
import tld.dmt.model.Deal;

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
