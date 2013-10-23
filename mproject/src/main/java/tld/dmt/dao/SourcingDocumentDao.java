package tld.dmt.dao;

import java.util.List;

import tld.dmt.model.SourcingDocument;

public interface SourcingDocumentDao {

    List<SourcingDocument> getAllDocuments();
    void save(SourcingDocument doc);
    SourcingDocument get(Long id);
    void delete(SourcingDocument doc);

}
