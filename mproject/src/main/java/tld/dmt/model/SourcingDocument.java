package tld.dmt.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author imustafin
 */
@Entity
@Table(name = "sourcing_document")
@NamedQueries(
        {
                @NamedQuery(name = SourcingDocument.ALL, query = "SELECT u FROM SourcingDocument u"),
                @NamedQuery(name = SourcingDocument.DELETE_BY_IDS, query = "DELETE FROM SourcingDocument where id in (:ids)")
        }
)
public class SourcingDocument {
    public static final String ALL = "SourcingDocument.ALL";
    public static final String DELETE_BY_IDS = "SourcingDocument.DELETE_BY_IDS";

    public enum SourceType {
		MANUAL, FTP, WEB, SERVER
	}

	public enum DefaultLanguage {
		ENGLISH, SPANISH, RUSSIAN
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

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank
	@Column(name = "dealName")
	private String dealName;

    @NotBlank
    @Column(name = "docType")
	private String docType;

    @NotNull
	@Column(name = "sourceType")
	private SourceType sourceType;

    @NotNull
	@Column(name = "nlpProcess")
	private Boolean nlpProcess;

    @Column(name = "contactInfo")
	private String contactInfo;

    @Column(name = "defaultLanguage")
	private DefaultLanguage defaultLanguage;

    @Column(name = "defaultCurrency")
	private DefaultCurrency defaultCurrency;

    @Column(name = "status")
	private Status status;

    @NotNull
	@Column(name = "sourceFrequency")
	private SourceFrequency sourceFrequency;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "startDate")
	private Date startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "endDate")
	private Date endDate;

    @Column(name = "defaultUom")
	private Double defaultUom;

	// Exact location subsection

    @URL
    @Column(name = "exactLocation")
	private String exactLocation;

    @Column(name = "fileName")
	private String fileName;

    @Column(name = "exactLocationUserName")
	private String exactLocationUserName;

    @Column(name = "exactLocationPassword")
	private String exactLocationPassword;

	// Primary url subsection
    @URL
	@Column(name = "primaryUrl")
	private String primaryUrl;

    @Column(name = "maxDepth")
	private Integer maxDepth;

    @Column(name = "docYear")
	private Integer docYear;

    @Column(name = "docFormat")
	private DocumentFormat docFormat;

    @Column(name = "docNameBeginsWith")
	private String docNameBeginsWith;

    @Column(name = "docNameEndsWith")
	private String docNameEndsWith;

    @Column(name = "docNameContains")
	private String docNameContains;

    @Column(name = "recrowlAttemptsNum")
	private Integer recrowlAttemptsNum;

    @Column(name = "primaryUrlUserName")
	private String primaryUrlUserName;

    @Column(name = "primaryUrlPassword")
	private String primaryUrlPassword;

	// Exceptions section
    @Email
	@Column(name = "exceptionsEmail")
	private String exceptionsEmail;

    @Column(name = "additionalEmailContent")
	private String additionalEmailContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getAdditionalEmailContent() {
		return additionalEmailContent;
	}

	public void setAdditionalEmailContent(String additionalEmailContent) {
		this.additionalEmailContent = additionalEmailContent;
	}
	

	@Override
	public String toString() {
		return "SourcingDocument [id=" + id + ", dealName=" + dealName
				+ ", docType=" + docType + ", sourceType=" + sourceType
				+ ", nlpProcess=" + nlpProcess + ", contactInfo=" + contactInfo
				+ ", defaultLanguage=" + defaultLanguage + ", defaultCurrency="
				+ defaultCurrency + ", status=" + status + ", sourceFrequency="
				+ sourceFrequency + ", startDate=" + startDate + ", endDate="
				+ endDate + ", defaultUom=" + defaultUom + ", exactLocation="
				+ exactLocation + ", fileName=" + fileName
				+ ", exactLocationUserName=" + exactLocationUserName
				+ ", exactLocationPassword=" + exactLocationPassword
				+ ", primaryUrl=" + primaryUrl + ", maxDepth=" + maxDepth
				+ ", docYear=" + docYear + ", docFormat=" + docFormat
				+ ", docNameBeginsWith=" + docNameBeginsWith
				+ ", docNameEndsWith=" + docNameEndsWith + ", docNameContains="
				+ docNameContains + ", recrowlAttemptsNum="
				+ recrowlAttemptsNum + ", primaryUrlUserName="
				+ primaryUrlUserName + ", primaryUrlPassword="
				+ primaryUrlPassword + ", exceptionsEmail=" + exceptionsEmail
				+ ", additionalEmailContent=" + additionalEmailContent + "]";
	}
}
