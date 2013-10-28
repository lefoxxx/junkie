package com.sp.dct.service;

import java.util.Collection;
import java.util.List;

import com.sp.dct.model.SortingCriteria;
import com.sp.dct.model.SourcingDocument;
import com.sp.dct.model.SourcingSetupSearch;

/**
 * @author imustafin
 */
public interface SourcingSetupService {
	public List<SourcingDocument> getAllDocuments();
	public void save(SourcingDocument doc);
	public SourcingDocument get(Long id);
	public void delete(SourcingDocument doc);
    public void delete(Collection<Long> ids);

	public List<SourcingDocument> findByCriteria(SourcingSetupSearch search);
	
    int getDocumentsCount();
    List<SourcingDocument> getDocuments(int pageStart, int pageSize, SortingCriteria sorting);


}
