package tld.dmt.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tld.dmt.dao.SourcingDocumentDao;
import tld.dmt.model.SourcingDocument;

@Repository("sourcingDocumentDao")
public class SourcingDocumentDaoHibernate implements SourcingDocumentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SourcingDocument> getAllDocuments() {
		return sessionFactory.getCurrentSession().getNamedQuery(SourcingDocument.ALL).list();
	}

	@Override
	public void save(SourcingDocument doc) {
		sessionFactory.getCurrentSession().saveOrUpdate(doc);
	}

	@Override
	public SourcingDocument get(Long id) {
		return (SourcingDocument)sessionFactory.getCurrentSession().load(SourcingDocument.class, id);
	}

	@Override
	public void delete(SourcingDocument doc) {
		sessionFactory.getCurrentSession().delete(doc);
		
	}
	
	
}
