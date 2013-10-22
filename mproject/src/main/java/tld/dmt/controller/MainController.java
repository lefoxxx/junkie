package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import tld.dmt.model.SourcingDoc;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author imustafin
 */

@Controller("mainController")
@RequestMapping(value = "VIEW")
public class MainController {

	private static final Log log = LogFactoryUtil.getLog(MainController.class);

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
        log.info("Inside showMainView method. ");
		return "source/sourcing/main";
	}


    @ModelAttribute("sourcingDoc")
    public SourcingDoc createModel() {
        return new SourcingDoc();
    }
}
