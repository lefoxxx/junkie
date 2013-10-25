<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ include file="../config.jspf"%>
<fmt:setBundle basename="tld.dmt.source.resource.Language"/>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="setup" type="horizontal">
		<jsp:body>
			
						
			<liferay-ui:success key="doc-created-successfully" message="Document created successfully"></liferay-ui:success>
			
			<%--<div id="setup_form_wrapper">--%>
			
			<portlet:actionURL var="createOrEditDocUrl">
			    <portlet:param name="action" value="setup"></portlet:param>
			    <portlet:param name="operation" value="deleteDoc"></portlet:param>
			</portlet:actionURL>
			
			<form:form action="${createOrEditDocUrl}" method="post" commandName="sourcingDoc">
			    <c:choose>
			        <c:when test="${not empty list}">
			            <table class='sourcing_list_table'>
			                <tr>
			                    <td> </td>
			                    <td>Document Type</td>
			                    <td>Repeat Frequency</td>
			                    <td>Start Date</td>
			                    <td>Last Received</td>
			                    <td>Next Expected</td>
			                    <td>Source Type</td>
			                    <td>Source Detail</td>
			                    <td>Default Language</td>
			                    <td>Default Unit of Measure</td>
			                    <td>Default Currency</td>
			                    <td>NLP Process</td>
			                    <td>Status</td>
			                    <td>Source History</td>
			                    <td>Upload</td>
			                </tr>
			                <c:forEach items="${list}" var="listItem">
			                    <tr>
			                        <td><input type="checkbox" name="docId" value="${listItem.id}"></td>
			                        <td>${listItem.docType}</td>
			                        <td>${listItem.sourceFrequency}</td>
			                        <td><fmt:formatDate value="${listItem.startDate}" pattern="dd/MM/yyyy" /></td>
			                            <%--TODO: where are these properties?--%>
			                        <td>n/a</td>
			                        <td>n/a</td>
			                            <%----%>
			                        <td>${listItem.sourceType}</td>
			                        <td>
			                            <portlet:renderURL var="startEditingDocumentUrl">
			                                <portlet:param name="action" value="setup"></portlet:param>
			                                <portlet:param name="operation" value="startEditingDocument"></portlet:param>
			                                <portlet:param name="docId" value="${listItem.id}"></portlet:param>
			                            </portlet:renderURL>
			                            <a href='${startEditingDocumentUrl}'>Edit</a>
			                        </td>
			                        <td>${listItem.defaultLanguage}</td>
			                        <td>${listItem.defaultUom}</td>
			                        <td>${listItem.defaultCurrency}</td>
			                        <td>${listItem.nlpProcess ? 'YES' : 'NO'}</td>
			                        <td>${listItem.status}</td>
			                        <td><a href="#">view</a></td>
			                        <td><a href="#">upload</a></td>
			                    </tr>
			                </c:forEach>
			            </table>
			        </c:when>
			        <c:otherwise>
			            List is empty<br/>
			        </c:otherwise>
			    </c:choose>
			
			    <div id="setup-btn-panel">
			        <portlet:renderURL var="addEditDocFormUrl">
			            <portlet:param name="action" value="setup"></portlet:param>
			            <portlet:param name="operation" value="showAddEditDocForm"></portlet:param>
			        </portlet:renderURL>
			        <button type="button" onClick="parent.location='${addEditDocFormUrl}'"><fmt:message key="new-doc"/></button>
			        <input type="submit" value="<fmt:message key="delete-doc"/>"/>
			        <button type="button"><fmt:message key="save"/></button>
			        <button type="button" onClick="parent.location='<portlet:renderURL/>'"><fmt:message key="cancel"/></button>
			    </div>
			</form:form>
			<%--</div>--%>
			
		</jsp:body>
	</layout:navigation>
</jsp:body>
</layout:navigation>


