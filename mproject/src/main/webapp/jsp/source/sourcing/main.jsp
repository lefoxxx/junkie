<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%! // Need for renderResponse access %>
<portlet:defineObjects />

<%
	String currentURL = PortalUtil.getCurrentURL(request);
	String redirect = ParamUtil.getString(request, "redirect", currentURL);
	
	/* Tabs */
	
	final String SOURCING_SETUP_TAB_NAME = LanguageUtil.get(pageContext, "sourcing-setup-tab-name");
	final String FILE_UPLOAD_TAB_NAME = LanguageUtil.get(pageContext, "file-upload-tab-name");
	final String TAG_DOCUMENT_TAB_NAME = LanguageUtil.get(pageContext, "tag-document-tab-name");
	final String SOURCING_SUMMARY_TAB_NAME = LanguageUtil.get(pageContext, "sourcing-summary-tab-name");
	final String SOURCING_HOMEPAGE_TAB_NAME = LanguageUtil.get(pageContext, "sourcing-homepage-tab-name");
	
	final String tabNames = 
			SOURCING_SETUP_TAB_NAME + "," +
			FILE_UPLOAD_TAB_NAME + "," +
			TAG_DOCUMENT_TAB_NAME + "," +
			SOURCING_SUMMARY_TAB_NAME + "," +
			SOURCING_HOMEPAGE_TAB_NAME
			;
	
	final String SOURCING_SETUP_TAB_ID = "sourcing-setup-tab-name";
	final String FILE_UPLOAD_TAB_ID = "file-upload-tab-name";
	final String TAG_DOCUMENT_TAB_ID = "tag-document-tab-name";
	final String SOURCING_SUMMARY_TAB_ID = "sourcing-summary-tab-name";
	final String SOURCING_HOMEPAGE_TAB_ID = "sourcing-homepage-tab-name";
	
	final String tabIds = 
			SOURCING_SETUP_TAB_ID + "," +
			FILE_UPLOAD_TAB_ID + "," +
			TAG_DOCUMENT_TAB_ID + "," +
			SOURCING_SUMMARY_TAB_ID + "," +
			SOURCING_HOMEPAGE_TAB_ID
			;
	
	String tabs1 = ParamUtil.getString(request, "tabs1", SOURCING_SETUP_TAB_ID);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tabs1", tabs1);
%>

<liferay-ui:tabs
   names="<%= tabNames %>"
   tabsValues="<%= tabIds %>"
   url="<%= portletURL.toString() %>"
/>

<% if (SOURCING_SETUP_TAB_ID.equals(tabs1)) { %>
	<%@ include file="/jsp/source/sourcing/setup/main.jspf" %>
<% } %>

<% if (FILE_UPLOAD_TAB_ID.equals(tabs1)) { %>
	<%@ include file="/jsp/source/sourcing/upload/main.jspf" %>
<% } %>

<% if (TAG_DOCUMENT_TAB_ID.equals(tabs1)) { %>
	<%@ include file="/jsp/source/sourcing/document/main.jspf" %>
<% } %>

<% if (SOURCING_SUMMARY_TAB_ID.equals(tabs1)) { %>
	<%@ include file="/jsp/source/sourcing/summary/main.jspf" %>
<% } %>

<% if (SOURCING_HOMEPAGE_TAB_ID.equals(tabs1)) { %>
	<%@ include file="/jsp/source/sourcing/homepage/main.jspf" %>
<% } %>
