package tld.dmt.model;

import java.util.Date;

/**
 * @author imustafin
 */

public class SourcingDocument {

    public enum SourceType {
        MANUAL, FTP, WEB, SERVER
    }

    public enum DefaultLanguage {
        English, Spanish, Russian
    }

    public enum DefaultCurrency {
        USD, EUR, RUB
    }


    public enum Status {
        LIVE, DRAFT
    }

    public enum SourceFrequency {
        ONE_TIME, QUARTERLY, SEMI_ANNUAL, ANNUAL
    }


    public enum DocumentFormat {
        PDF, DOC, TXT, HTML
    }

    private String dealName;
    private String docType;
    private SourceType sourceType;
    private Boolean nlpProcess;
    private String contactInfo;
    private DefaultLanguage defaultLanguage;
    private DefaultCurrency defaultCurrency;
    private Status status;
    private SourceFrequency sourceFrequency;
    private Date startDate;
    private Date endDate;
    private Double defaultUom;

    // Exact location subsection
    private String exactLocation;
    private String fileName;
    private String exactLocationUserName;
    private String exactLocationPassword;

    // Primary url subsection
    private String primaryUrl;
    private Integer maxDepth;
    private Integer docYear;
    private DocumentFormat docFormat;
    private String docNameBeginsWith;
    private String docNameEndsWith;
    private String docNameContains;
    private Integer recrowlAttemptsNum;
    private String primaryUrlUserName;
    private String primaryUrlPassword;

    // Exceptions section
    private String exceptionsEmail;
    private String additionalEmainContent;


    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public Boolean getNlpProcess() {
        return nlpProcess;
    }

    public void setNlpProcess(Boolean nlpProcess) {
        this.nlpProcess = nlpProcess;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public DefaultLanguage getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(DefaultLanguage defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public DefaultCurrency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(DefaultCurrency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SourceFrequency getSourceFrequency() {
        return sourceFrequency;
    }

    public void setSourceFrequency(SourceFrequency sourceFrequency) {
        this.sourceFrequency = sourceFrequency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDefaultUom() {
        return defaultUom;
    }

    public void setDefaultUom(Double defaultUom) {
        this.defaultUom = defaultUom;
    }

    public String getExactLocation() {
        return exactLocation;
    }

    public void setExactLocation(String exactLocation) {
        this.exactLocation = exactLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExactLocationUserName() {
        return exactLocationUserName;
    }

    public void setExactLocationUserName(String exactLocationUserName) {
        this.exactLocationUserName = exactLocationUserName;
    }

    public String getExactLocationPassword() {
        return exactLocationPassword;
    }

    public void setExactLocationPassword(String exactLocationPassword) {
        this.exactLocationPassword = exactLocationPassword;
    }

    public String getPrimaryUrl() {
        return primaryUrl;
    }

    public void setPrimaryUrl(String primaryUrl) {
        this.primaryUrl = primaryUrl;
    }

    public Integer getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    public Integer getDocYear() {
        return docYear;
    }

    public void setDocYear(Integer docYear) {
        this.docYear = docYear;
    }

    public DocumentFormat getDocFormat() {
        return docFormat;
    }

    public void setDocFormat(DocumentFormat docFormat) {
        this.docFormat = docFormat;
    }

    public String getDocNameBeginsWith() {
        return docNameBeginsWith;
    }

    public void setDocNameBeginsWith(String docNameBeginsWith) {
        this.docNameBeginsWith = docNameBeginsWith;
    }

    public String getDocNameEndsWith() {
        return docNameEndsWith;
    }

    public void setDocNameEndsWith(String docNameEndsWith) {
        this.docNameEndsWith = docNameEndsWith;
    }

    public String getDocNameContains() {
        return docNameContains;
    }

    public void setDocNameContains(String docNameContains) {
        this.docNameContains = docNameContains;
    }

    public Integer getRecrowlAttemptsNum() {
        return recrowlAttemptsNum;
    }

    public void setRecrowlAttemptsNum(Integer recrowlAttemptsNum) {
        this.recrowlAttemptsNum = recrowlAttemptsNum;
    }

    public String getPrimaryUrlUserName() {
        return primaryUrlUserName;
    }

    public void setPrimaryUrlUserName(String primaryUrlUserName) {
        this.primaryUrlUserName = primaryUrlUserName;
    }

    public String getPrimaryUrlPassword() {
        return primaryUrlPassword;
    }

    public void setPrimaryUrlPassword(String primaryUrlPassword) {
        this.primaryUrlPassword = primaryUrlPassword;
    }

    public String getExceptionsEmail() {
        return exceptionsEmail;
    }

    public void setExceptionsEmail(String exceptionsEmail) {
        this.exceptionsEmail = exceptionsEmail;
    }

    public String getAdditionalEmainContent() {
        return additionalEmainContent;
    }

    public void setAdditionalEmainContent(String additionalEmainContent) {
        this.additionalEmainContent = additionalEmainContent;
    }



}
