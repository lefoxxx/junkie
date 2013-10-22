package tld.dmt.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author imustafin
 */

/**
 * Specify tab name in params, so we can create multiple controller classes (for each tab one controller class).
 * The parameter name should be "action"
 */
@Controller("tagDocumentController")
@RequestMapping(value = "VIEW", params="action=tagdoc")
public class TagDocumentController {
	private static final Log log = LogFactoryUtil.getLog(TagDocumentController.class);
}
