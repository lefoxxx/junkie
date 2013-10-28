package com.sp.dct.dao;

import java.util.Collection;
import java.util.List;

import com.sp.dct.model.Deal;

public interface DealDao {

    public void saveOrUpdate(Deal deal);

    public Deal get(Integer id);

    public List<Deal> findAll();

    public void delete(Deal deal);

    public int delete(Collection<Integer> ids);

}
