package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sp.dct.model.Deal;
import com.sp.dct.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.validation.Valid;

@Controller("dealPageController")
@RequestMapping(value = "VIEW", params = "action=deal")
public class DealController {

    private static final Log log = LogFactoryUtil.getLog(DealController.class);

    @Autowired
    private DealService service;

    @RenderMapping()
    public String defaultRender() {
        return "source/sourcing/deal/main";
    }

    @ModelAttribute("deal")
    public Deal getDeal(@RequestParam(value = "id", required = false) Integer id) {
        if (id == null) {
            return new Deal();
        } else {
            return service.getDeal(id);
        }
    }

    @ActionMapping(params = "operation=save")
    public void saveDeal(@ModelAttribute("deal") Deal deal,
                         BindingResult bindingResult,
                         ActionRequest request,
                         ActionResponse response,
                         SessionStatus sessionStatus) {

        if (!bindingResult.hasErrors()) {
            service.save(deal);
            response.setRenderParameter("action", "deal");
            log.info("created deal: " + deal);
        } else {
            log.error("validation error: " + bindingResult.getFieldErrors().toString());
            response.setRenderParameter("action", "deal");
            response.setRenderParameter("operation", "edit");
        }

    }

    @RenderMapping(params = "operation=edit")
    public String editDeal(Model model) {
        return "source/sourcing/deal/add-edit";
    }


}
