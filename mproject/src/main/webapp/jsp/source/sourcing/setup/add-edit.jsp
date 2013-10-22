<%@ include file="../config.jspf"%>

<fmt:setBundle basename="tld.dmt.source.resource.Language"/>

<div id="setup_form_wrapper">
    <form:form action="${createOrEditDocUrl}" method="post" commandName="sourcingDoc">
        <div class="setup_form_section">
            <table class="setup_form_table">
                <tr>
                    <td>
                        <form:label path="dealName">
                            <fmt:message key="field-deal-name"/>
                        </form:label>
                    </td>
                    <td>
                        <fmt:message key="field-deal-name-value" var="dealNameLbl"/>
                        <form:input path="dealName" readonly="true" value="${dealNameLbl}"/> <%--For now set it as ReadOnly --%>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="docType">
                            <fmt:message key="field-doc-type"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="docType"/>
                    </td>
                    <td>
                        <form:label path="sourceFrequency">
                            <fmt:message key="field-source-freq"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="sourceFrequency">
                            <form:options/>"
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="sourceType">
                            <fmt:message key="field-source-type"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="sourceType">
                            <form:options/>"
                        </form:select>
                    </td>
                    <td>
                        <form:label path="startDate">
                            <fmt:message key="field-start-date"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="startDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="nlpProcess">
                            <fmt:message key="field-nlp-process"/>
                        </form:label>
                    </td>
                    <td>
                        <fmt:message key="yes" var="lblYes"/>
                        <fmt:message key="no" var="lblNo"/>

                        <form:select path="nlpProcess">
                            <form:option value="true" label="${lblYes}"/>
                            <form:option value="false" label="${lblNo}"/>
                        </form:select>
                    </td>
                    <td>
                        <form:label path="endDate">
                            <fmt:message key="field-end-date"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="endDate"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="contactInfo">
                            <fmt:message key="field-contact-info"/>
                        </form:label>
                    </td>
                    <td colspan="3">
                        <form:textarea cssClass="setup_max_width" path="contactInfo" rows="2" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="defaultLanguage">
                            <fmt:message key="field-default-lang"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="defaultLanguage">
                            <form:options/>"
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="defaultCurrency">
                            <fmt:message key="field-default-currency"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="defaultCurrency">
                            <form:options/>"
                        </form:select>
                    </td>
                    <td>
                        <form:label path="defaultUom">
                            <fmt:message key="field-default-uom"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="defaultUom">  <%-- TODO delete hardcoded values --%>
                            <form:option value="1000" label="1,000"/>"
                            <form:option value="2000" label="2,000"/>"
                            <form:option value="3000" label="3,000"/>"
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="status">
                            <fmt:message key="field-status"/>
                        </form:label>
                    </td>
                    <td>
                        <form:select path="status">
                            <form:options/>"
                        </form:select>
                    </td>
                </tr>
            </table>
        </div>

        <span class="setup_section_title">
            <fmt:message key="section-title-document-sourced"/>
        </span>
        <div class="setup_form_section">
            <table class="setup_form_table">
                <tr>
                    <td>
                        <form:label path="exactLocation">
                            <fmt:message key="field-exact-location"/>
                        </form:label>
                    </td>
                    <td colspan="3">
                        <fmt:message key="field-exact-location-hint" var="exactLocationHint"/>
                        <form:input path="exactLocation" placeholder="${exactLocationHint}" cssClass="setup_max_width"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="fileName">
                            <fmt:message key="field-file-name"/>
                        </form:label>
                    </td>
                    <td colspan="3">
                        <fmt:message key="field-file-name-hint" var="fileNameHint"/>
                        <form:input path="exactLocation" placeholder="${fileNameHint}" cssClass="setup_max_width"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="exactLocationUserName">
                            <fmt:message key="field-user-name"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="exactLocationUserName"/>
                    </td>
                    <td>
                        <form:label path="exactLocationPassword">
                            <fmt:message key="field-password"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="exactLocationPassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="primaryUrl">
                            <fmt:message key="field-primary-url"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="primaryUrl" cssClass="setup_max_width"/>
                    </td>
                    <td>
                        <form:label path="maxDepth">
                            <fmt:message key="field-max-depth"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="maxDepth"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="docYear">
                            <fmt:message key="field-doc-year-to-search"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="docYear"/>
                    </td>
                    <td>
                        <form:label path="docFormat">
                            <fmt:message key="field-doc-format"/>
                        </form:label>
                    </td>
                    <td >
                        <form:select path="docFormat">
                            <form:options/>"
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="docNameBeginsWith">
                            <fmt:message key="field-doc-name-begins"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="docNameBeginsWith"/>
                    </td>
                    <td>
                        <form:label path="docNameEndsWith">
                            <fmt:message key="field-doc-name-ends"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="docNameEndsWith"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="docNameContains">
                            <fmt:message key="field-doc-name-contains"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="docNameContains"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="recrowlAttemptsNum">
                            <fmt:message key="field-recrawl-attempts-num"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="recrowlAttemptsNum"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="primaryUrlUserName">
                            <fmt:message key="field-user-name"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="primaryUrlUserName"/>
                    </td>
                    <td>
                        <form:label path="primaryUrlPassword">
                            <fmt:message key="field-password"/>
                        </form:label>
                    </td>
                    <td >
                        <form:input path="primaryUrlPassword"/>
                    </td>
                </tr>


            </table>
        </div>

        <span class="setup_section_title">
            <fmt:message key="section-title-exceptions"/>
        </span>
        <div class="setup_form_section">
            <table >
                <tr>
                    <td>
                        <form:label path="exceptionsEmail">
                            <fmt:message key="field-exception-email-address"/>
                        </form:label>
                    </td>
                    <td colspan="3">
                        <form:input path="exceptionsEmail"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="additionalEmailContent">
                            <fmt:message key="field-additional-email-content"/>
                        </form:label>
                    </td>
                    <td colspan="3">
                        <form:input path="additionalEmailContent"/>
                    </td>
                </tr>
            </table>
        </div>

        <portlet:actionURL var="createOrEditDocUrl">
            <portlet:param name="action" value="setup"></portlet:param>
            <portlet:param name="operation" value="createOrEditDoc"></portlet:param>
        </portlet:actionURL>

        <portlet:renderURL var="baseViewUrl"/>

        <div id="setup-btn-panel">
            <input type="submit" value="<fmt:message key="save"/>"/>
            <a href="${baseViewUrl}"><fmt:message key="cancel"/></a>
        </div>

    </form:form>
</div>

