<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="upload" type="horizontal">
		<jsp:body>
			<h1><fmt:message key="file-upload-tab-name"/></h1>
			
			
			<c:if test="${not empty list}">
			    <table>
			        <c:forEach items="${list}" var="listItem">
			            <tr>
			                <td>${listItem.id}</td>
			                <td>${listItem.filename}</td>
			                <td>${listItem.filesize}</td>
			            </tr> 
			        </c:forEach>
			    </table>
			</c:if>
			
			<portlet:actionURL var="getFilesUploaded">
			    <portlet:param name="action" value="showFiles"></portlet:param>
			</portlet:actionURL>
			
			<br/>
			
			<form action="${getFilesUploaded}" method="post">
			    <input type="submit" value="show files">
			</form>
		</jsp:body>
	</layout:navigation>
</jsp:body>
</layout:navigation>


