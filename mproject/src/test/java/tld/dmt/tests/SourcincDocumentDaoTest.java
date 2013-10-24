package tld.dmt.tests;

//import static org.junit.Assert.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tld.dmt.dao.FileUploadedDao;
import tld.dmt.model.FileUploaded;
import tld.dmt.model.SourcingDocument;
import tld.dmt.model.SourcingSetupSearch;
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
    	newDoc.setDealName("DEAL_NAME");

    	documentService.save(newDoc);
    	assertEquals("Save failed", n + 1,  documentService.getAllDocuments().size());
    	
    	SourcingDocument doc = documentService.get(newDoc.getId());
    	assertNotNull("Can not load saved document", doc);
    	assertEquals("Incorrectly saved", "DEAL_NAME", doc.getDealName());
    	
    	documentService.delete(doc);
    	assertEquals("Deletion failed", n, documentService.getAllDocuments().size());
    	
    }
    
    @Test
    public void testSearch() {
 
    	String randomPart = UUID.randomUUID().toString();
    	SourcingDocument newDoc1 = new SourcingDocument();
    	newDoc1.setDealName("deal1_"+ randomPart);
    	
    	SourcingDocument newDoc2 = new SourcingDocument();
    	newDoc2.setContactInfo("contact2_" + randomPart);
    	
    	SourcingDocument newDoc3 = new SourcingDocument();
    	newDoc3.setDealName("deal3_" + randomPart);
    	newDoc3.setContactInfo("contact3_" + randomPart);
    	
    	documentService.save(newDoc1);
    	documentService.save(newDoc2);
    	documentService.save(newDoc3);

    	int n = documentService.getAllDocuments().size();
    	SourcingSetupSearch search = new SourcingSetupSearch();
    	
    	assertEquals(n, documentService.findByCriteria(search).size());
    	
    	search.setDealName("eal1_" + randomPart);
    	assertEquals("test1", 1, documentService.findByCriteria(search).size());
    	
    	search.setDealName("eal2_" + randomPart);
    	assertEquals("test2",0, documentService.findByCriteria(search).size());
    	
    	search.setDealName("eal3_" + randomPart);
    	search.setContactInfo("ontact3_" + randomPart);
    	assertEquals("test3", 1, documentService.findByCriteria(search).size());
    	
    	search.setDealName(null);
    	search.setContactInfo(randomPart);
    	assertEquals("test4", 2, documentService.findByCriteria(search).size());
    	
    }

}
