package com.olp.notification_mgmt.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notification")
public class Notification implements java.io.Serializable {

	private Integer id;
	private MessageType messageType;
	private NotificationCategory notificationCategory;
	private Priority priority;
	private String refKey;
	private String refValue;
	private Boolean hasAttachment;
	private String attachmentPath;
	private String subject;
	private String message;
	private String smsMessage;
	private int createdBy;
	private Date createdDate;
	private Integer modifiedBy;
	private Date modifiedDate;
	private Set<NotificationDetails> notificationDetailses = new HashSet<NotificationDetails>(0);

	public Notification() {
	}

	public Notification(MessageType messageType, NotificationCategory notificationCategory, Priority priority,
			String refKey, String refValue, String subject, String message, int createdBy, Date createdDate) {
		this.messageType = messageType;
		this.notificationCategory = notificationCategory;
		this.priority = priority;
		this.refKey = refKey;
		this.refValue = refValue;
		this.subject = subject;
		this.message = message;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Notification(MessageType messageType, NotificationCategory notificationCategory, Priority priority,
			String refKey, String refValue, Boolean hasAttachment, String attachmentPath, String subject,
			String message, String smsMessage, int createdBy, Date createdDate, Integer modifiedBy, Date modifiedDate,
			Set<NotificationDetails> notificationDetailses) {
		this.messageType = messageType;
		this.notificationCategory = notificationCategory;
		this.priority = priority;
		this.refKey = refKey;
		this.refValue = refValue;
		this.hasAttachment = hasAttachment;
		this.attachmentPath = attachmentPath;
		this.subject = subject;
		this.message = message;
		this.smsMessage = smsMessage;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.notificationDetailses = notificationDetailses;
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
	@JoinColumn(name = "message_type_id", nullable = false)
	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "notification_sms_cat_id", nullable = false)
	public NotificationCategory getNotificationCategory() {
		return this.notificationCategory;
	}

	public void setNotificationCategory(NotificationCategory notificationCategory) {
		this.notificationCategory = notificationCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priority_id", nullable = false)
	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Column(name = "ref_key", nullable = false, length = 32)
	public String getRefKey() {
		return this.refKey;
	}

	public void setRefKey(String refKey) {
		this.refKey = refKey;
	}

	@Column(name = "ref_value", nullable = false, length = 32)
	public String getRefValue() {
		return this.refValue;
	}

	public void setRefValue(String refValue) {
		this.refValue = refValue;
	}

	@Column(name = "has_attachment")
	public Boolean getHasAttachment() {
		return this.hasAttachment;
	}

	public void setHasAttachment(Boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	@Column(name = "attachment_path", length = 128)
	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	@Column(name = "subject", nullable = false, length = 256)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "message", nullable = false, length = 256)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "sms_message", length = 256)
	public String getSmsMessage() {
		return this.smsMessage;
	}

	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notification")
	public Set<NotificationDetails> getNotificationDetailses() {
		return this.notificationDetailses;
	}

	public void setNotificationDetailses(Set<NotificationDetails> notificationDetailses) {
		this.notificationDetailses = notificationDetailses;
	}

}

