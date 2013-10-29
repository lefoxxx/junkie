package com.sp.dct.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.dct.dao.FileUploadedDao;
import com.sp.dct.model.FileUploaded;

/**
 * Author: ejolos
 */
@Repository("fileUploadedDao")
public class FileUploadedDaoHibernate implements FileUploadedDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<FileUploaded> getFilesUploaded() {
		Query query = sessionFactory.getCurrentSession().createQuery("from FileUploaded fu");
		@SuppressWarnings("unchecked") List<FileUploaded> raw = query.list();
		return raw;
	}
	
}
