package tld.dmt.dao;

import tld.dmt.dao.hibernate.CommonDaoHibernate;

/**
 * User: ejolos
 * Date: 10/21/13
 */
public class DaoHelper {

    public static CommonDao getCommonDaoInstance() {
        return new CommonDaoHibernate();
    }
}
