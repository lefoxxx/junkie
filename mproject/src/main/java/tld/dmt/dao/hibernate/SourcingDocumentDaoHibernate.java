package tld.dmt.dao.hibernate;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
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
		try {
			for(PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(SourcingSetupSearch.class).getPropertyDescriptors()){
				String name = propertyDescriptor.getName();
				if (!"class".equals(name)) {
					Object obj = propertyDescriptor.getReadMethod().invoke(search);
					if (obj != null) {
						crit.add(Restrictions.like(name, "%"+obj.toString()+"%"));
					}
				}
			}
		} catch (Exception  ignored) {
		}
		return crit.list();

	}
}
