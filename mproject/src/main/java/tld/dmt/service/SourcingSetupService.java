package tld.dmt.service;

import java.util.Collection;
import java.util.List;

import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;

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

}
