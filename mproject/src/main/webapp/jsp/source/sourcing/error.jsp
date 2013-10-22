<%@ include file="config.jspf"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.io.PrintWriter"%>

<%-- Error page temporary stub --%>

<%
    String portletTitle = PortalUtil.getPortletTitle(renderResponse);
    if (portletTitle == null) {
        portletTitle = LanguageUtil.get(pageContext, "portlet");
    }
    Throwable t = (Throwable) request.getAttribute("exception");
%>
<p>
    <h1>An error occurred during the request</h1>
</p>
<p>
    Error message: <%= t.getMessage() %>
</p>

<hr/>
<div>
    <textarea style="width: 700px; height: 200px;" readonly="yes" wrap="off">
        <%
            if (t != null) {
                t.printStackTrace(new PrintWriter(out));
            }
        %>
    </textarea>
</div>


<a href="<portlet:renderURL/>"> Back to application</a>