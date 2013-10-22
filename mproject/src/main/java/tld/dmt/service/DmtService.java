package tld.dmt.service;

import tld.dmt.model.SourcingDoc;

/**
 * @author imustafin
 */
public interface DmtService {

    /**
     * Creates sourcing document
     * @param doc the document model
     * @return created document
     * @throws DmtException if something went wrong
     */
    SourcingDoc createSourcingDoc(SourcingDoc doc) throws DmtException;


    /**
     * Edits the sourcing document
     * @param doc the doc to be edited
     * @throws DmtException if something went wrong
     */
    void editSourcingDoc(SourcingDoc doc) throws DmtException;
}
