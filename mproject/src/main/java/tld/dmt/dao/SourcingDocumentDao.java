package tld.dmt.dao;

import java.util.Collection;
import java.util.List;

import tld.dmt.model.SortingCriteria;
import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;

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
