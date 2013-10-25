
<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="setup" type="horizontal">
		<jsp:body>
			<h1><fmt:message key="sourcing-setup-tab-name"/></h1>

			<fmt:setBundle basename="tld.dmt.source.resource.Language"/>
			
			<portlet:renderURL var="readDocumentsFromDbUrl">
			    <portlet:param name="action" value="setup"></portlet:param>
			    <portlet:param name="operation" value="readDocumentsFromDb"></portlet:param>
			</portlet:renderURL>

            <portlet:resourceURL var="addEditJspUrl">
                <portlet:param name="action" value="setup"/>
                <portlet:param name="pageAddress" value="source/sourcing/setup/add-edit" />
            </portlet:resourceURL>

            <button id="popup_add_edit"><fmt:message key="add-edit-doc"/></button>
            <a href="${readDocumentsFromDbUrl}"><fmt:message key="search-list-docs"/></a>

            <script>
                AUI().use('aui-dialog', 'aui-io', 'event',
                    function (A) {
                        A.one('#popup_add_edit').on('click', function() {
                            var dialog = new A.Dialog({
                                title: '<fmt:message key="add-edit-doc"/>',
                                centered: true,
                                draggable: true,
                                modal: true
                            }).plug(A.Plugin.IO, {uri: '${addEditJspUrl}'}).render();

                            dialog.show();
                        });
                    }
                );
            </script>

		</jsp:body>
	</layout:navigation>

</jsp:body>
</layout:navigation>
