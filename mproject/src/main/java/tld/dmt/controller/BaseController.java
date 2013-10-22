package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import tld.dmt.model.FileUploaded;
import tld.dmt.model.SourcingDocument;
import tld.dmt.service.FilesUploadedService;
import tld.dmt.service.SourcingSetupService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author imustafin
 */

@Controller("baseController")
@RequestMapping(value = "VIEW")

public class BaseController {

    private static final Log log = LogFactoryUtil.getLog(BaseController.class);

    @Autowired
    @Qualifier("sourcingSetupService")
    private SourcingSetupService sourcingSetupService;

    @Autowired
    @Qualifier("filesUploadedService")
    FilesUploadedService filesUploadedService;


    /**
     * This is default render method for portlet.
     * The view, returned by this method, will be used as default portlet view.
     * @param request the http request
     * @param response the http response
     * @param model the model
     * @return name of default .jsp page to show
     */
    @RenderMapping
    public String showMainView(RenderRequest request, RenderResponse response, Model model) {
        return "source/sourcing/main";
    }


    @ModelAttribute("sourcingDoc")
    public SourcingDocument createModel() {
        return new SourcingDocument();
    }


    /**
     * Call to this method must be finished with redirecting to error page
     */
    @ActionMapping(params = "action=error")
    public void generateError() {
        if (true == true)
            throw new RuntimeException("Some error message.");
    }

    @ActionMapping(params = "action=createDoc")
    public void createDoc(@ModelAttribute("sourcingDoc") SourcingDocument sourcingDoc,
                          BindingResult bindingResult,
                          ActionRequest request,
                          ActionResponse response,
                          SessionStatus sessionStatus) {

        boolean isErrorOccurred = false;
/*

        if (sourcingDoc.getAuthor() == null || sourcingDoc.getAuthor().isEmpty()) {
            isErrorOccurred = true;
            SessionErrors.add(request, "author-is-required");
        }

        if (sourcingDoc.getTitle() == null || sourcingDoc.getTitle().isEmpty()) {
            isErrorOccurred = true;
            SessionErrors.add(request, "title-is-required");
        }

        if (isErrorOccurred == false) {
            SessionMessages.add(request, "doc-created-successfully");
            response.setRenderParameter("action", "successDocCreation");
            response.setRenderParameter("tab", "setup");// going to "showSuccessDocCreationPage()" method
        }
*/
    }

    @RenderMapping (params="action=successDocCreation")
    public String showSuccessDocCreationPage(RenderRequest request, RenderResponse response, Model model){
        return "source/sourcing/setup/success";
    }

    @ActionMapping(params = "action=showFiles")
    public void getDocs(ActionRequest request, ActionResponse response) {
        response.setRenderParameter("action", "readFilesFromDb");
    }


    @RenderMapping (params="action=readFilesFromDb")
    public ModelAndView showDocuments(RenderRequest request, RenderResponse response, Model model){
        final List<FileUploaded> list = filesUploadedService.getFilesUploaded();
        final ModelAndView mav = new ModelAndView( "source/sourcing/upload/list" );
        mav.addObject("list", list);
        return mav;
    }


}
