<%@ include file="../config.jspf"%>

<fmt:setBundle basename="tld.dmt.source.resource.Language"/>

<form action="${createDocument}" method="post">

    <div class="form_section">
        <table class="form_table">
            <tr>
                <td>
                    <fmt:message key="field-deal-name"/>
                </td>
                <td>
                    <span id="<portlet:namespace/>deal_name"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <fmt:message key="field-doc-type"/>
                </td>
                <td>
                    <select id="<portlet:namespace/>doc_type">
                        <option selected value="type1">Type 1</option>
                        <option value="type2">Type 2</option>
                    </select>
                </td>
                <td>
                    <fmt:message key="field-source-freq"/>
                </td>
                <td>
                    <select id="<portlet:namespace/>source_freq">
                        <option selected value="type1">Frequency 1</option>
                        <option value="type2">Frequency 2</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <fmt:message key="field-source-type"/>
                </td>
                <td>
                    <select id="<portlet:namespace/>source_type">
                        <option selected value="process1">Source 1</option>
                        <option value="process2">Source 2</option>
                    </select>
                </td>
                <td>
                    <fmt:message key="field-start-date"/>
                </td>
                <td>
                    <span>Date picker</span>
                </td>
            </tr>
            <tr>
                <td>
                    <fmt:message key="field-nlp-process"/>
                </td>
                <td>
                    <select id="<portlet:namespace/>nlp_process">
                        <option selected value="process1">process 1</option>
                        <option value="process2">process 2</option>
                    </select>
                </td>
                <td>
                    <fmt:message key="field-end-date"/>
                </td>
                <td>
                    <span>Date picker</span>
                </td>
            </tr>

            <tr>
                <td>
                    <fmt:message key="field-contact-info"/>
                </td>
                <td colspan="4">
                    <textarea rows="2" id="<portlet:namespace/>contact_info">
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <fmt:message key="field-defult-lang"/>
                </td>
                <td>
                    <select id="<portlet:namespace/>def_language">
                        <option selected value="process1">lang 1</option>
                        <option value="process2">lang 2</option>
                    </select>
                </td>
            </tr>
        </table>
    </div>

    <span class="section_title"><fmt:message key="section-title-document-sourced"/></span>
    <div class="form_section">
        <table>
            <caption>Some table</caption>
            <tr>
                <td>
                    Cell 1
                </td>
                <td>
                    Cell 2
                </td>
            </tr>
        </table>
    </div>

    <span class="section_title"><fmt:message key="section-title-exceptions"/></span>
    <div class="form_section">
        <table>
            <caption>Some table</caption>
            <tr>
                <td>
                    Cell 1
                </td>
                <td>
                    Cell 2
                </td>
            </tr>
        </table>
    </div>


</form>

