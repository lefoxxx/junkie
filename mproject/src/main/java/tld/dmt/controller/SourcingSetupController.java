package tld.dmt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import tld.dmt.model.SourcingDocument;
import tld.dmt.service.SourcingSetupService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author imustafin
 */

@Controller("sourcingSetupController")
@RequestMapping(value = "VIEW", params="action=setup")

public class SourcingSetupController {

    private static final Log log = LogFactoryUtil.getLog(SourcingSetupController.class);

    @Autowired
    @Qualifier("sourcingSetupService")
    private SourcingSetupService sourcingSetupService;

    @RenderMapping(params = "operation=showAddEditDocForm")
    public String showAddEditForm(Model model) {
        return "source/sourcing/setup/add-edit";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @ModelAttribute("sourcingDoc")
    public SourcingDocument createModel() {
        return new SourcingDocument();
    }


    @ActionMapping(params = "operation=createOrEditDoc")
    public void createDoc(@ModelAttribute("sourcingDoc") SourcingDocument sourcingDoc,
                          BindingResult bindingResult,
                          ActionRequest request,
                          ActionResponse response,
                          SessionStatus sessionStatus) {

        log.info("NLP Process value: " + sourcingDoc.getNlpProcess());
        log.info("Start date value: " + sourcingDoc.getStartDate());
        
        sourcingSetupService.save(sourcingDoc);
        
        response.setRenderParameter("action", "setup");
        response.setRenderParameter("operation", "readDocumentsFromDb");
    }

    @RenderMapping (params="operation=readDocumentsFromDb")
    public ModelAndView readDocumentsFromDb(RenderRequest request, RenderResponse response, Model model){
        final List<SourcingDocument> list = sourcingSetupService.getAllDocuments();
        final ModelAndView mav = new ModelAndView("source/sourcing/setup/success" );
        mav.addObject("list", list);
        return mav;
    }
    
    
    @RenderMapping (params="operation=startEditingDocument")
    public ModelAndView startEditingDocument(@RequestParam("docId") Long docId, RenderRequest request, RenderResponse response){
        final SourcingDocument doc = sourcingSetupService.get(docId);
        log.info( "Read document: " + doc );
        final ModelAndView mav = new ModelAndView("source/sourcing/setup/add-edit" );
        mav.addObject("sourcingDoc", doc);
        return mav;
    }    

}
