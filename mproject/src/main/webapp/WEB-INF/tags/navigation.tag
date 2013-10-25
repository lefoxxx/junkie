<%-- This JSP page will be included in other JSPs for minimizing import statements--%>
<%@tag import="java.util.ResourceBundle"%>
<%@tag import="javax.portlet.ResourceURL"%>
<%@ tag import="com.liferay.portal.util.PortalUtil"%>
<%@ tag import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ tag import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ tag import="javax.portlet.PortletURL"%>
<%@ tag import="javax.portlet.WindowState"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<fmt:setBundle basename="tld.dmt.source.resource.Language" />

<%--Importing JSR-286 specific implicit variables.
Read more: https://blogs.oracle.com/deepakg/entry/jsr286_defineobjects_tag  --%>
<portlet:defineObjects />

<%--Importing LifeRay specific implicit variables (like colorScheme, user etc).
 Read more: http://www.liferay.com/community/forums/-/message_boards/message/5997940  --%>
<liferay-theme:defineObjects />

<%@ attribute name="head" fragment="true"%>
<%@ attribute name="item" required="true" type="java.lang.String"%>
<%@ attribute name="type" required="false" type="java.lang.String"%>

<head>
</head>
<body>

	<portlet:defineObjects />



	<%
		String ids[] = null;
		String keys[] = null;
		
		final String SOURCING_SETUP_TAB_ID = "sourcing-setup-tab-name";
		final String SOURCING_LIST_TAB_ID = "sourcing-list-tab-name";
		final String FILE_UPLOAD_TAB_ID = "file-upload-tab-name";
		final String TAG_DOCUMENT_TAB_ID = "tag-document-tab-name";
		final String SOURCING_SUMMARY_TAB_ID = "sourcing-summary-tab-name";
		final String SOURCING_HOMEPAGE_TAB_ID = "sourcing-homepage-tab-name";
		ResourceBundle bundle = java.util.ResourceBundle.getBundle("tld.dmt.source.resource.Language");

		if ("vertical".equals(type)) {
			ids = new String[] {"setup", "extraction", "search", "reports", "tasks", "admin", "home"};
			keys = new String[] {"sourcing-nav-key", "extraction-nav-key", "search-nav-key", "reports-nav-key", "tasks-nav-key", "admin-nav-key", "home-nav-key"};
		} else {
			ids = new String[] { "setup", "list",  "upload", "tagdoc", "summary", "homepage" };
			keys = new String[] {"sourcing-setup-tab-name", "sourcing-list-tab-name", "file-upload-tab-name", "tag-document-tab-name", "sourcing-summary-tab-name", "sourcing-homepage-tab-name"};
		}
		


		String tabData[][] = new String[ids.length][];
		String urls[] = new String[ids.length];
		for (int i = 0; i < ids.length; ++i) {
			PortletURL url = renderResponse.createRenderURL();
			url.setParameter("action", ids[i]);

			urls[i] = url.toString();
			tabData[i] = new String[] { ids[i], urls[i], bundle.getString(keys[i]) };
		}
	%>

	<c:choose>
		<c:when test='<%="vertical".equals(type)%>'>
			<table style="border: 1px">
				<tr>
					<td  >

						<table>
							<c:set var="urls" value="<%=urls%>" />
							<c:forEach var="id" items="<%=tabData%>">
								<tr >
									<td>
																		<td><a	href="${id[1]}"><button type="button" class="${id[0]==item ? 'selected-button' : 'ordinal-button'}">${id[2]}</button></a>
									</td>
								</tr>
							</c:forEach>


						</table>



					</td>
					<td class="navigation-content"><jsp:doBody /></td>
			</table>

		</c:when>
		<c:otherwise>
		<table style="border: 1px">
				<tr>
					<td>

						<table>
						  <tr >
							<c:set var="urls" value="<%=urls%>" />
							<c:forEach var="id" items="<%=tabData%>">

									<td><a	href="${id[1]}"><button type="button" style="width:130px" class="${id[0]==item ? 'selected-button' : 'ordinal-button'}">${id[2]}</button></a>
									</td>
								
							</c:forEach>
							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td  class="navigation-content"><jsp:doBody /></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>



</body>

