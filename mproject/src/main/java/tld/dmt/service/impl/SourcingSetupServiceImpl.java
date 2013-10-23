package tld.dmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tld.dmt.dao.SourcingDocumentDao;
import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;
import tld.dmt.service.SourcingSetupService;


/**
 * Implementation class for SourceSetup service.
 */
@Service("sourcingSetupService")
public class SourcingSetupServiceImpl implements SourcingSetupService {


	@Autowired
	@Qualifier("sourcingDocumentDao")
	private SourcingDocumentDao dao;

	
	@Transactional
	public List<SourcingDocument> getAllDocuments() {
		return dao.getAllDocuments();
	}
	
	@Transactional
	public void save(SourcingDocument doc) {
		dao.save(doc);
	}

	@Override
	public SourcingDocument get(Long id) {
		return dao.get(id);
	}

	@Override
	public void delete(SourcingDocument doc) {
		dao.delete(doc);
	}

	@Override
	public List<SourcingDocument> findByCriteria(SourcingSetupSearch search) {
		return dao.findByCriteria(search);
	}
	
}
