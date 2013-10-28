package tld.dmt.dao.hibernate;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tld.dmt.dao.SourcingDocumentDao;
import tld.dmt.model.SortingCriteria;
import tld.dmt.model.SortingCriteria.OrderType;
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
		Session session = sessionFactory.getCurrentSession();
		if( session == null )
			session = sessionFactory.openSession();
		final SourcingDocument doc = (SourcingDocument)session.load(SourcingDocument.class, id);
		Hibernate.initialize(doc);
		return doc;
	}

	@Override
	public void delete(SourcingDocument doc) {
		sessionFactory.getCurrentSession().delete(doc);
	}

    @Override
    public void delete(Collection<Long> ids) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery(SourcingDocument.DELETE_BY_IDS);
        query.setParameterList("ids", ids);
        query.executeUpdate();
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

	@Override
	public int getDocumentsCount() {
	    Query query = sessionFactory.getCurrentSession().getNamedQuery(SourcingDocument.GET_COUNT);
	    Object data = query.list().get(0);
	    Number count = (Number)(data);
        return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SourcingDocument> getDocuments(int pageStart, int pageSize,	SortingCriteria sorting) {
	    org.hibernate.Criteria crit = sessionFactory.getCurrentSession().createCriteria(SourcingDocument.class);
	    
	    if (sorting != null) {
	        for(SortingCriteria.SortField sort : sorting.getFields()) {
	            Order order = OrderType.ASCENDING.equals(sort.getOrder()) ? Order.asc(sort.getFieldName()) : Order.desc(sort.getFieldName());
	            crit.addOrder(order);
	        }
	    }
	    
	    crit.setFirstResult(pageStart * pageSize);
	    crit.setMaxResults(pageSize);
	    return crit.list();
	}
}
