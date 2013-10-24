package tld.dmt.tests;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import tld.dmt.dao.FileUploadedDao;
import tld.dmt.dao.SourcingDocumentDao;
import tld.dmt.model.FileUploaded;
import tld.dmt.model.SourcingDocument;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration({"classpath:hibernate.cfg.xml", "file:src/main/webapp/WEB-INF/root-context.xml", "file:src/main/webapp/WEB-INF/app-context.xml"})
@TransactionConfiguration(transactionManager="txManager")
@Transactional
public abstract class TestBase {

}
