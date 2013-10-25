<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="list" type="vertical">
<jsp:body>

	<layout:navigation item="list" type="horizontal">
		<jsp:body>

			<h1><fmt:message key="sourcing-list-tab-name"/></h1>
			
			<fmt:setBundle basename="tld.dmt.source.resource.Language"/>
			
			<portlet:renderURL var="showListUrl">
			    <portlet:param name="action" value="list"></portlet:param>
			    <portlet:param name="operation" value="showList"></portlet:param>
			</portlet:renderURL>
			
			<a href="${showListUrl}"><fmt:message key="sourcing-list-tab-name"/></a>
			
			
			<aui:form name="form1" action="#" method="post"> 
			    <aui:input inlineField="true" inlineLabel="left" label="Customer Name" showRequiredLabel="false"
			        name="custName" type="text">
			        <aui:validator name="required" />    
			    </aui:input> 
			    <aui:button type="submit" value="Add" /> 
			</aui:form>

		</jsp:body>
	</layout:navigation>

</jsp:body>
</layout:navigation>
