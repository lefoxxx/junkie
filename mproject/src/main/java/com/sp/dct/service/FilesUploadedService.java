package com.sp.dct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.dct.dao.FileUploadedDao;
import com.sp.dct.model.FileUploaded;

/**
 * @author stasb
 */
@Service("filesUploadedService")
public class FilesUploadedService {

	@Autowired
	@Qualifier("fileUploadedDao")
	private FileUploadedDao fileUploadedDao;

	
	@Transactional
	public List<FileUploaded> getFilesUploaded() {
		return fileUploadedDao.getFilesUploaded();
	}
	
}
