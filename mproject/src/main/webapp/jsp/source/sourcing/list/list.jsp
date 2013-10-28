<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="tld.dmt.model.SourcingDocument"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>



<h1><%= LanguageUtil.get(pageContext, "sourcing-list-tab-name") %></h1>

<%@ include file="../config.jspf"%>

<portlet:renderURL var="baseViewUrl">
</portlet:renderURL>



<%

    PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("action", "list");
	portletURL.setParameter("operation", "showList");
    SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, null);
    
    
    Integer count = (Integer)request.getAttribute("count");
    //String keywords = (String)request.getAttribute("keywords");
    List<SourcingDocument> list = (List<SourcingDocument>) request.getAttribute("listDocs");
    searchContainer.setResults(list);
    if(count != null)
       searchContainer.setTotal(count);
    List<String> headerNames = new ArrayList<String>();
    headerNames.add("DEAL");
    headerNames.add("CONTACT INFO");
    headerNames.add("DOCUMENT NAME CONTAINS");
    headerNames.add("VIEW");
    headerNames.add("DELETE");
    searchContainer.setHeaderNames(headerNames);
    List resultRows = searchContainer.getResultRows();
    for(int i=0; i<list.size(); i++){
    	SourcingDocument sdoc = (SourcingDocument)list.get(i);
        ResultRow row = new ResultRow(sdoc, sdoc.getDealName(), i);
        row.addText(sdoc.getDealName());
        row.addText(sdoc.getContactInfo());
        row.addText(sdoc.getDocNameContains());
        row.addText("VIEW");
        row.addText("DELETE");
        resultRows.add(row);
    }    


%>

<c:if test="${listDocs != null}" >

    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="true" />


</c:if>
<a href="${baseViewUrl}">Return</a>
