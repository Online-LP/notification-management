package com.olp.notification_mgmt.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notification_template_details")
public class NotificationTemplateDetails implements java.io.Serializable {

	private Integer id;
	private Language language;
	private MessageType messageType;
	private NotificationCategory notificationCategory;
	private NotificationTemplateMaster notificationTemplateMaster;
	private Priority priority;
	private String emailSubject;
	private String emailContent;
	private String smsContent;
	private int isEmailEnabled;
	private int isSmsEnabled;
	private String extSmsTemplateId;
	private int createdBy;
	private Date createdDate;
	private Integer modifiedBy;
	private Date modifiedDate;

	public NotificationTemplateDetails() {
	}

	public NotificationTemplateDetails(Language language, NotificationTemplateMaster notificationTemplateMaster,
			String emailSubject, String emailContent, String smsContent, int isEmailEnabled, int isSmsEnabled,
			int createdBy, Date createdDate) {
		this.language = language;
		this.notificationTemplateMaster = notificationTemplateMaster;
		this.emailSubject = emailSubject;
		this.emailContent = emailContent;
		this.smsContent = smsContent;
		this.isEmailEnabled = isEmailEnabled;
		this.isSmsEnabled = isSmsEnabled;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public NotificationTemplateDetails(Language language, MessageType messageType,
			NotificationCategory notificationCategory, NotificationTemplateMaster notificationTemplateMaster,
			Priority priority, String emailSubject, String emailContent, String smsContent, int isEmailEnabled,
			int isSmsEnabled, String extSmsTemplateId, int createdBy, Date createdDate, Integer modifiedBy,
			Date modifiedDate) {
		this.language = language;
		this.messageType = messageType;
		this.notificationCategory = notificationCategory;
		this.notificationTemplateMaster = notificationTemplateMaster;
		this.priority = priority;
		this.emailSubject = emailSubject;
		this.emailContent = emailContent;
		this.smsContent = smsContent;
		this.isEmailEnabled = isEmailEnabled;
		this.isSmsEnabled = isSmsEnabled;
		this.extSmsTemplateId = extSmsTemplateId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", nullable = false)
	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_type_id")
	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "notification_cat_id")
	public NotificationCategory getNotificationCategory() {
		return this.notificationCategory;
	}

	public void setNotificationCategory(NotificationCategory notificationCategory) {
		this.notificationCategory = notificationCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "notification_template_master_id", nullable = false)
	public NotificationTemplateMaster getNotificationTemplateMaster() {
		return this.notificationTemplateMaster;
	}

	public void setNotificationTemplateMaster(NotificationTemplateMaster notificationTemplateMaster) {
		this.notificationTemplateMaster = notificationTemplateMaster;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priority_type_id")
	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Column(name = "email_subject", nullable = false, length = 256)
	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	@Column(name = "email_content", nullable = false, length = 256)
	public String getEmailContent() {
		return this.emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	@Column(name = "sms_content", nullable = false, length = 256)
	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	@Column(name = "is_email_enabled", nullable = false)
	public int getIsEmailEnabled() {
		return this.isEmailEnabled;
	}

	public void setIsEmailEnabled(int isEmailEnabled) {
		this.isEmailEnabled = isEmailEnabled;
	}

	@Column(name = "is_sms_enabled", nullable = false)
	public int getIsSmsEnabled() {
		return this.isSmsEnabled;
	}

	public void setIsSmsEnabled(int isSmsEnabled) {
		this.isSmsEnabled = isSmsEnabled;
	}

	@Column(name = "ext_sms_template_id", length = 32)
	public String getExtSmsTemplateId() {
		return this.extSmsTemplateId;
	}

	public void setExtSmsTemplateId(String extSmsTemplateId) {
		this.extSmsTemplateId = extSmsTemplateId;
	}

	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "modified_by")
	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", length = 19)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
