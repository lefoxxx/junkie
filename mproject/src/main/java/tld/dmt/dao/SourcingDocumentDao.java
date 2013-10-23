package tld.dmt.dao;

import java.util.List;

import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;

public interface SourcingDocumentDao {

    List<SourcingDocument> getAllDocuments();
    void save(SourcingDocument doc);
    SourcingDocument get(Long id);
    void delete(SourcingDocument doc);
    List<SourcingDocument> findByCriteria(SourcingSetupSearch search); 
   
}
