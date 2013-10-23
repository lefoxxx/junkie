package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import tld.dmt.model.SourcingDocument;
import tld.dmt.service.SourcingSetupService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    }

    @RenderMapping (params="action=successDocCreation")
    public String showSuccessDocCreationPage(RenderRequest request, RenderResponse response, Model model){
        return "source/sourcing/setup/success";
    }


}
