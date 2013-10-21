package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import tld.dmt.model.SourcingDocument;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author imustafin
 */

@Controller
@RequestMapping("VIEW")
public class BaseController {

	private static final Log log = LogFactoryUtil.getLog(BaseController.class);

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
        log.info("Inside showMainView method.");
		return "source/sourcing/main";
	}

    @ModelAttribute("sourcingDocument")
    public SourcingDocument createModel() {
        return new SourcingDocument();
    }

    @ActionMapping(params = "action=createDoc")
    public void createDoc(@ModelAttribute SourcingDocument sourcingDocument,
                          BindingResult bindingResult,
                          ActionRequest request,
                          ActionResponse response,
                          SessionStatus sessionStatus) {

        // parsing request params and call service for saving doc
        log.info("Beginning creating document.");

        boolean isErrorOccurred = false;

        if (sourcingDocument.getAuthor() == null || sourcingDocument.getAuthor().isEmpty()) {
            isErrorOccurred = true;
            SessionErrors.add(request, "author-is-required");
        }

        if (sourcingDocument.getTitle() == null || sourcingDocument.getTitle().isEmpty()) {
            isErrorOccurred = true;
            SessionErrors.add(request, "title-is-required");
        }

        if (isErrorOccurred == false) {

            // TODO docService.createDoc(new Doc(docAuthor, docTitle));

            SessionMessages.add(request, "doc-created-successfully");
            response.setRenderParameter("action", "successDocCreation"); // going to "showSuccessDocCreationPage()" method
        }
    }

    @RenderMapping (params="action=successDocCreation")
    public String showSuccessDocCreationPage(RenderRequest request, RenderResponse response, Model model){
        return "source/sourcing/setup/success";
    }

}
