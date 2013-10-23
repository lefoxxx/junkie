package tld.dmt.tests;

//import static org.junit.Assert.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tld.dmt.dao.FileUploadedDao;
import tld.dmt.model.FileUploaded;
import tld.dmt.model.SourcingDocument;
import tld.dmt.service.SourcingSetupService;

public class SourcincDocumentDaoTest extends TestBase{

    @Autowired
    FileUploadedDao fileDao;
    
    @Autowired
    SourcingSetupService documentService;

    @Test
    public  void testFileLoading() {
//    	List<FileUploaded> files = fileDao.getFilesUploaded();
//    	for(FileUploaded fu : files) {
//    		System.out.println(fu.getFilename());
//    	}
//    	assertEquals(0, files.size());
    }
    
    @Test
    public void testDocumentLoading() {
    //	List<SourcingDocument> docs = documentService.getAllDocuments();
    	//assertEquals(0, docs.size());
    }
    
    @Test
    public  void testCRUD() {
    	SourcingDocument newDoc = new SourcingDocument();
    	newDoc.setDealName("SOME_DEAL_NAME");
    	List<SourcingDocument> docs = documentService.getAllDocuments();
    	int n = docs.size();

    	documentService.save(newDoc);
    	assertEquals("Save failed", n + 1,  documentService.getAllDocuments().size());
    	
    	SourcingDocument doc = documentService.get(newDoc.getId());
    	assertNotNull("Can not load saved document", doc);
    	
    	documentService.delete(doc);
    	assertEquals("Deletion failed", n, documentService.getAllDocuments().size());
    	
    }

}
