package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import tld.dmt.model.SourcingDocument;

/**
 * @author imustafin
 */

@Controller("mainController")
@RequestMapping(value = "VIEW")
public class MainController {

	private static final Log log = LogFactoryUtil.getLog(MainController.class);



    @ModelAttribute("sourcingDoc")
    public SourcingDocument createModel() {
        return new SourcingDocument();
    }
}
