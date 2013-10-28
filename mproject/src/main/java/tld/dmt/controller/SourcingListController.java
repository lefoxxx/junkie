package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tld.dmt.model.SortingCriteria;
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
    public String showAddEditForm(@RequestParam(value = "cur", required = false) Integer pageStart,
    		@RequestParam(value = "delta", required = false) Integer pageSize,
    		Model model) {
    	   	
    	model.addAttribute("listDocs", sourcingSetupService.getDocuments(pageStart == null ? 0 : (pageStart.intValue() - 1), pageSize == null ? 20 : pageSize.intValue(), null));
    	model.addAttribute("count", sourcingSetupService.getDocumentsCount());
        return "source/sourcing/list/list";
    }

    
}

