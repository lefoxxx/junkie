<%@ include file="../config.jspf"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:navigation item="setup" type="vertical">
<jsp:body>

	<layout:navigation item="deal" type="horizontal">
		<jsp:body>

        <div id="setup_form_wrapper">

        <portlet:actionURL var="saveDeal">
            <portlet:param name="action" value="deal"></portlet:param>
            <portlet:param name="operation" value="save"></portlet:param>
        </portlet:actionURL>

        <form:form action="${saveDeal}" method="post" commandName="deal" id="add_edit_form">
        <div class="setup_form_section">
            <form:hidden path="id"/>
            <table class="setup_form_table">
                <tr>
                    <td>
                        <form:label path="name">
                            <fmt:message key="field-deal-name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name" value=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="surveillanceSchedule">
                            <fmt:message key="field-deal-surv-schedule"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="surveillanceSchedule" value=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="periods">
                            <fmt:message key="field-deal-periods"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="periods" value=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="initialDate">
                            <fmt:message key="field-deal-initial-date"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="initialDate" value=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="scheduledDate">
                            <fmt:message key="field-deal-scheduled-date"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="scheduledDate" value=""/>
                    </td>
                </tr>
            </table>
        </div>

        <div id="setup-btn-panel">
            <input type="submit" value="<fmt:message key="save"/>"/>
            <portlet:renderURL var="backUrl">
                <portlet:param name="action" value="deal"/>
            </portlet:renderURL>
            <a href="${backUrl}"><fmt:message key="cancel"/></a>
        </div>
        </form:form>
        </div>

		</jsp:body>
	</layout:navigation>
</jsp:body>
</layout:navigation>