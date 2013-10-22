package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author imustafin
 */

@Controller("tagDocumentController")
@RequestMapping(value = "VIEW", params="tab=tagdoc") // specify tab name in params, so we can create multiple controller classes (for each tab one controller class)

public class TagDocumentController {
	private static final Log log = LogFactoryUtil.getLog(TagDocumentController.class);
}
