package tld.dmt;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import tld.dmt.model.FileUploaded;
import tld.dmt.service.FilesUploadedService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author imustafin
 */

@Controller
@RequestMapping("VIEW")
public class BaseController {

	private static final Log log = LogFactoryUtil.getLog(BaseController.class);
	
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
        log.info("Inside showMainView method.");
		return "source/sourcing/main";
	}


    @ActionMapping(params = "action=createDoc")
    public void createDoc(ActionRequest request, ActionResponse response) {
        // parsing request params and call service for saving doc
        log.info("Beginning creating document.");
        String docAuthor = ParamUtil.get(request, "docAuthor", "");

        String docTitle = ParamUtil.get(request, "docTitle", "");

        boolean isErrorOccurred = false;

        if (docAuthor == null || docAuthor.isEmpty()) {
            isErrorOccurred = true;
            SessionErrors.add(request, "author-is-required");
        }

        if (docTitle == null || docTitle.isEmpty()) {
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
