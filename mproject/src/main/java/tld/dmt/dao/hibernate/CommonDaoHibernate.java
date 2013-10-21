package tld.dmt.dao.hibernate;

import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import tld.dmt.dao.CommonDao;

/**
 * Author: ejolos
 */
public class CommonDaoHibernate extends HibernateDaoSupport implements CommonDao {

    public List getFilesUploaded(/*final */) {
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("select fu from FileUploaded");
                //query.setInteger("report_typ_c", report_typ_c);
                List raw = query.list();
                //log.debug("resultset " + raw.size());
                //log.debug(raw.isEmpty() ? "list is empty " : "raw.get(0) " + raw.get(0));
                return raw;
            }
        });
    }
}
