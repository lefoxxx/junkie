<%@ include file="config.jspf"%>

<%@page import="java.io.PrintWriter"%>

<%-- Error page temporary stub --%>

<%
    Throwable t = (Throwable) request.getAttribute("exception");
%>
<p>
    <h1>An error occurred during the request</h1>
</p>
<p>
Error message:  <% if (t != null) t.getMessage(); %>
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