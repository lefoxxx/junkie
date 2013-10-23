package tld.dmt.service;

import java.util.List;

import tld.dmt.model.SourcingDocument;

/**
 * @author imustafin
 */
public interface SourcingSetupService {
	public List<SourcingDocument> getAllDocuments();
	public void save(SourcingDocument doc);

}
