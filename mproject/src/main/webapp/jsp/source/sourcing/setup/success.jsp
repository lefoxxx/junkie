<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<h1><%= LanguageUtil.get(pageContext, "tag-document-tab-name") %></h1>

<%@ include file="../config.jspf"%>

<portlet:renderURL var="baseViewUrl">
</portlet:renderURL>

<liferay-ui:success key="doc-created-successfully" message="Document created successfully"></liferay-ui:success>

<a href="${baseViewUrl}">Return</a>
