package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import tld.dmt.service.SourcingSetupService;


/**
 * @author nur
 */

@Controller("sourcingListController")
@RequestMapping(value = "VIEW", params="action=list")

public class SourcingListController {

    private static final Log log = LogFactoryUtil.getLog(SourcingListController.class);

    @Autowired
    @Qualifier("sourcingSetupService")
    private SourcingSetupService sourcingSetupService;
    
    @RenderMapping()
    public String defaultRender(Model model) {
        return "source/sourcing/list/main";
    }
    
    @RenderMapping(params = "operation=showList")
    public String showAddEditForm(Model model) {
    	model.addAttribute("listDocs", sourcingSetupService.getAllDocuments());
    	model.addAttribute("count", sourcingSetupService.getAllDocuments().size());
        return "source/sourcing/list/list";
    }

    
}

