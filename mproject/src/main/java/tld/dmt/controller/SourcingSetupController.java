package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sp.dct.model.SourcingDocument;
import com.sp.dct.service.SourcingSetupService;

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
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @RenderMapping()
    public String defaultRender(Model model) {
        return "source/sourcing/setup/main";
    }
    
    @RenderMapping(params = "operation=showAddEditDocForm")
    public String showAddEditForm(Model model) {
        return "source/sourcing/setup/add-edit";
    }


    /**
     * Method sets default date format (for @ModelAttribute fields)
     * @param binder
     */
    @InitBinder(value = "sourcingDoc")
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @ModelAttribute("sourcingDoc")
    public SourcingDocument createModel() {
        return new SourcingDocument();
    }


    @ActionMapping(params = "operation=createOrEditDoc")
    public void createDoc(@Valid @ModelAttribute("sourcingDoc") SourcingDocument sourcingDoc,
                          BindingResult bindingResult,
                          ActionRequest request,
                          ActionResponse response,
                          SessionStatus sessionStatus) {

        if (!bindingResult.hasErrors()) {
            sourcingSetupService.save(sourcingDoc);
            response.setRenderParameter("action", "setup");
            response.setRenderParameter("operation", "readDocumentsFromDb");
        } else {
            log.error("Error during validation is occurred." + bindingResult.getFieldErrors().toString());
            response.setRenderParameter("action", "setup");
            response.setRenderParameter("operation", "showAddEditDocForm");
        }

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

    @ActionMapping(params = "operation=deleteDoc")
    public void deleteDocuments(@RequestParam(value = "docId", required = false) List<Long> docId, ActionRequest request, ActionResponse response) {
        if (docId != null) {
            log.info("Delete document(s): " + docId);
            sourcingSetupService.delete(docId);
        }
        response.setRenderParameter("action", "setup");
        response.setRenderParameter("operation", "readDocumentsFromDb");
    }



    /* FIXME Need to think how to create MainController, which will handle request common to all controllers.
       For example this method must be excluded to MainController */
    /**
     * Returns content of required page
     * @param pageAddress page address
     * @return content of page
     */
    @ResourceMapping
    public String getPageContent(@RequestParam(value = "pageAddress") String pageAddress) {
        return pageAddress;
    }
}
