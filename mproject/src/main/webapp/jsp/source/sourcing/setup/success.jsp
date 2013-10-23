<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<h1><%= LanguageUtil.get(pageContext, "tag-document-tab-name") %></h1>

<%@ include file="../config.jspf"%>

<liferay-ui:success key="doc-created-successfully" message="Document created successfully"></liferay-ui:success>

<c:choose>
    <c:when test="${not empty list}">
        <style type="text/css">
           table.setup_form_table td { padding: 2 5 2 5; }
           table.setup_form_table tr.odd td { background-color: #C5CBCE; }
           table.setup_form_table tr.even td { background-color: #BFDBDE; }
        </style>
        <table class='setup_form_table'>
            <c:forEach items="${list}" var="listItem" varStatus="listItemStatus">
                <tr class='${listItemStatus.index % 2 == 1 ? "odd" : "even"}'>
                    <td>${listItem.id}</td>
                    <td>${listItem.docType}</td>
                    <td>${listItem.nlpProcess ? 'YES' : 'NO'}</td>
                    <td>${listItem.contactInfo}</td>
                    <td>${listItem.sourceType}</td>
                    <td>${listItem.defaultLanguage}</td>
                    <td>${listItem.defaultUom}</td>
                    <td>${listItem.defaultCurrency}</td>
                    <td>
                       <portlet:renderURL var="startEditingDocumentUrl">
                          <portlet:param name="action" value="setup"></portlet:param>
                          <portlet:param name="operation" value="startEditingDocument"></portlet:param>
                          <portlet:param name="docId" value="${listItem.id}"></portlet:param>
                       </portlet:renderURL>
                       <a href='${startEditingDocumentUrl}'>Edit</a>
                    </td>
                </tr> 
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        List is empty<br/>
    </c:otherwise>
</c:choose>
<br/>

<div id='setup-btn-panel'>
   <a href='<portlet:renderURL/>'>Return</a>
</div>
