package com.sp.dct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.dct.dao.SourcingDocumentDao;
import com.sp.dct.model.SortingCriteria;
import com.sp.dct.model.SourcingDocument;
import com.sp.dct.model.SourcingSetupSearch;
import com.sp.dct.service.SourcingSetupService;

import java.util.Collection;
import java.util.List;


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
	@Transactional
	public SourcingDocument get(Long id) {
		return dao.get(id);
	}

	@Override
	@Transactional
	public void delete(SourcingDocument doc) {
		dao.delete(doc);
	}

    @Override
    @Transactional
    public void delete(Collection<Long> ids) {
        dao.delete(ids);
    }

    @Override
	@Transactional
	public List<SourcingDocument> findByCriteria(SourcingSetupSearch search) {
		return dao.findByCriteria(search);
	}

    @Override
    @Transactional
    public int getDocumentsCount() {
        return dao.getDocumentsCount();
    }

    @Override
    @Transactional
    public List<SourcingDocument> getDocuments(int pageStart, int pageSize, SortingCriteria sorting) {
        return dao.getDocuments(pageStart, pageSize, sorting);
    }
	
    
    
}
