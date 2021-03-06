<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="upload" type="horizontal">
		<jsp:body>
		
			
			<h1><fmt:message key="file-upload-tab-name"/></h1>
			
			<c:choose>
			<c:when test="${not empty list}">
			    <table border='1'>
			        <c:forEach items="${list}" var="listItem">
			            <tr>
			                <td>${listItem.id}</td>
			                <td>${listItem.filename}</td>
			                <td>${listItem.filesize}</td>
			            </tr> 
			        </c:forEach>
			    </table>
			</c:when>
			<c:otherwise>
			    List is empty<br/>
			</c:otherwise>
			</c:choose>
			<br/>
			
			<portlet:renderURL var="baseViewUrl"/>
			<a href="${baseViewUrl}">Return</a>
		</jsp:body>
	</layout:navigation>
</jsp:body>
</layout:navigation>

