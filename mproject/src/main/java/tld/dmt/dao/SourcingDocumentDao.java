package tld.dmt.dao;

import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;

import java.util.Collection;
import java.util.List;

public interface SourcingDocumentDao {

    List<SourcingDocument> getAllDocuments();
    void save(SourcingDocument doc);
    SourcingDocument get(Long id);
    void delete(SourcingDocument doc);
    void delete(Collection<Long> ids);
    List<SourcingDocument> findByCriteria(SourcingSetupSearch search); 
   
}
