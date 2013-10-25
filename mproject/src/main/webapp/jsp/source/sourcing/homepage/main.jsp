<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="homepage" type="horizontal">
		<jsp:body>
			<h1><fmt:message key="sourcing-homepage-tab-name"/></h1>
		</jsp:body>
	</layout:navigation>
</jsp:body>
</layout:navigation>

