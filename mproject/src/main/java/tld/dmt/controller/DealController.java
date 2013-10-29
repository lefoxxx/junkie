package tld.dmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("dealPageController")
@RequestMapping(value = "VIEW", params="action=deal")
public class DealController {

    @RenderMapping()
    public String defaultRender(Model model) {
        return "source/sourcing/deal/main";
    }
}
