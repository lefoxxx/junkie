package com.sp.dct.dao;

import java.util.Collection;
import java.util.List;

import com.sp.dct.model.SortingCriteria;
import com.sp.dct.model.SourcingDocument;
import com.sp.dct.model.SourcingSetupSearch;

public interface SourcingDocumentDao {

    List<SourcingDocument> getAllDocuments();
    void save(SourcingDocument doc);
    SourcingDocument get(Long id);
    void delete(SourcingDocument doc);
    void delete(Collection<Long> ids);
    
    int getDocumentsCount();
    List<SourcingDocument> getDocuments(int pageStart, int pageSize, SortingCriteria sorting);
    List<SourcingDocument> findByCriteria(SourcingSetupSearch search); 
   
}
