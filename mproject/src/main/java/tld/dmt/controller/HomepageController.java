package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


/**
 * Specify tab name in params, so we can create multiple controller classes (for each tab one controller class).
 * The parameter name should be "action"
 */
@Controller("homepageController")
@RequestMapping(value = "VIEW", params="action=homepage")
public class HomepageController {
	private static final Log log = LogFactoryUtil.getLog(HomepageController.class);
	
    @RenderMapping()
    public String defaultRender(Model model) {
        return "source/sourcing/homepage/main";
    }
	
}
