package tld.dmt.service;

import tld.dmt.model.SortingCriteria;
import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;

import java.util.Collection;
import java.util.List;

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
