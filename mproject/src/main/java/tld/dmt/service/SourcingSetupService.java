package tld.dmt.service;

import tld.dmt.model.SourcingDocument;

/**
 * @author imustafin
 */
public interface SourcingSetupService {

    /**
     * Creates sourcing document
     * @param doc the document model
     * @return created document
     * @throws DmtException if something went wrong
     */
    SourcingDocument createSourcingDoc(SourcingDocument doc) throws DmtException;


    /**
     * Edits the sourcing document
     * @param doc the doc to be edited
     * @throws DmtException if something went wrong
     */
    void editSourcingDoc(SourcingDocument doc) throws DmtException;
}
