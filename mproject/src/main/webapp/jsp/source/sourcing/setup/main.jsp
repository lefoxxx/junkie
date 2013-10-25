
<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="setup" type="horizontal">
		<jsp:body>
			<h1><fmt:message key="sourcing-setup-tab-name"/></h1>
			
			
			
			<fmt:setBundle basename="tld.dmt.source.resource.Language"/>
			
			<portlet:renderURL var="addEditDocFormUrl">
			    <portlet:param name="action" value="setup"></portlet:param>
			    <portlet:param name="operation" value="showAddEditDocForm"></portlet:param>
			</portlet:renderURL>
			
			<portlet:renderURL var="readDocumentsFromDbUrl">
			    <portlet:param name="action" value="setup"></portlet:param>
			    <portlet:param name="operation" value="readDocumentsFromDb"></portlet:param>
			</portlet:renderURL>
			
			
			<a href="${addEditDocFormUrl}"><fmt:message key="add-edit-doc"/></a>
			<a href="${readDocumentsFromDbUrl}"><fmt:message key="search-list-docs"/></a>
		</jsp:body>
	</layout:navigation>

</jsp:body>
</layout:navigation>
