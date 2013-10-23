package tld.dmt.dao.hibernate;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tld.dmt.dao.SourcingDocumentDao;
import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<SourcingDocument> findByCriteria(SourcingSetupSearch search) {
		org.hibernate.Criteria crit = sessionFactory.getCurrentSession().createCriteria(SourcingDocument.class);
		
		for(Field field : search.getClass().getDeclaredFields()) {
			Object obj = null;
			try {
				obj = field.get(search);
			} catch (Exception ignored) {
			} 
			if (obj != null) {
				crit.add(Restrictions.like(field.getName(), "%" + obj.toString() + "%"));
			}
		}
		System.err.println("DFDDF!!!!!!!!!!!!!!!!!");
		return crit.list();

	}
}
