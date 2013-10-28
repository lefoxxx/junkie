package tld.dmt.tests;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sp.dct.dao.FileUploadedDao;
import com.sp.dct.model.SortingCriteria;
import com.sp.dct.model.SourcingDocument;
import com.sp.dct.model.SourcingSetupSearch;
import com.sp.dct.model.SortingCriteria.OrderType;
import com.sp.dct.service.SourcingSetupService;

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
    
    @Test
    public void testPaging() {
        for(int i = 0; i < 10; ++i) {
            SourcingDocument newDoc1 = new SourcingDocument();
            documentService.save(newDoc1);
        }
        
        assertEquals(1, documentService.getDocuments(0, 1, null).size());
        assertEquals(1, documentService.getDocuments(5, 1, null).size());
        
        assertEquals(2, documentService.getDocuments(2, 2, null).size());
        assertEquals(5, documentService.getDocuments(1, 5, null).size());
        
        List<SourcingDocument> docs = documentService.getDocuments(1, 1, null);
        docs.addAll(documentService.getDocuments(1, 2, null));
        docs.addAll(documentService.getDocuments(1, 4, null));
        
        List<SourcingDocument> docs2 = documentService.getDocuments(0, 8, null);
        docs2.remove(0);
        
        assertEquals(docs, docs2);
    }
    
    private List<SourcingDocument> asList(SourcingDocument ... docs) {
        return Arrays.asList(docs);
    }
    
    private void compareOnlyFirstList(List<SourcingDocument> expected, List<SourcingDocument> actual) {
        actual.retainAll(expected);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSorting() {
        SourcingDocument newDoc1 = new SourcingDocument();
        newDoc1.setContactInfo("a1");
        newDoc1.setDealName("b1");
        documentService.save(newDoc1);
        
        SourcingDocument newDoc2 = new SourcingDocument();
        newDoc2.setContactInfo("a2");
        newDoc2.setDealName("b3");
        documentService.save(newDoc2);
        
        SourcingDocument newDoc3 = new SourcingDocument();
        newDoc3.setContactInfo("a3");
        newDoc3.setDealName("b2");
        documentService.save(newDoc3);
        
        List<SourcingDocument> docs = new ArrayList<SourcingDocument>();
        int size = documentService.getDocumentsCount();
        
        
        compareOnlyFirstList(asList(newDoc3, newDoc2, newDoc1), documentService.getDocuments(0,  size, SortingCriteria.getCriteria("contactInfo", OrderType.DESCENDING)));
        
        compareOnlyFirstList(asList(newDoc1, newDoc2, newDoc3), documentService.getDocuments(0,  size, SortingCriteria.getCriteria("contactInfo", OrderType.ASCENDING)));
        
        compareOnlyFirstList(asList(newDoc1, newDoc3, newDoc2), documentService.getDocuments(0,  size, SortingCriteria.getCriteria("dealName", OrderType.ASCENDING)));
        
        SourcingDocument newDoc4 = new SourcingDocument();
        newDoc4.setContactInfo("a1");
        newDoc4.setDealName("b3");
        documentService.save(newDoc4);
        
        SortingCriteria crit = new SortingCriteria();
        crit.addSorting("dealName", OrderType.ASCENDING);
        crit.addSorting("contactInfo", OrderType.ASCENDING);
        
        compareOnlyFirstList(asList(newDoc1, newDoc3, newDoc4, newDoc2), documentService.getDocuments(0,  size, crit));
        
        crit = new SortingCriteria();
        crit.addSorting("contactInfo", OrderType.ASCENDING);
        crit.addSorting("dealName", OrderType.ASCENDING);
        
        compareOnlyFirstList(asList(newDoc1, newDoc4, newDoc2, newDoc3), documentService.getDocuments(0,  size, crit));
        
        
        
    }
    

}
