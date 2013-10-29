<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="deal" type="horizontal">
		<jsp:body>
			<h1><fmt:message key="deal-tab-name"/></h1>
            <portlet:renderURL var="editUrl">
                <portlet:param name="action" value="deal"/>
                <portlet:param name="operation" value="edit"/>
            </portlet:renderURL>
            <a href="${editUrl}"><fmt:message key="new-deal"/></a>
        </jsp:body>
	</layout:navigation>
</jsp:body>
</layout:navigation>