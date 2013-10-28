package tld.dmt.dao;

import tld.dmt.model.Deal;

import java.util.Collection;
import java.util.List;

public interface DealDao {

    public void saveOrUpdate(Deal deal);

    public Deal get(Integer id);

    public List<Deal> findAll();

    public void delete(Deal deal);

    public int delete(Collection<Integer> ids);

}
