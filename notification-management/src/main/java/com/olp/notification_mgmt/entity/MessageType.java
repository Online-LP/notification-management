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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "message_type", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class MessageType implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private byte status;
	private int createdBy;
	private Date createdDate;
	private Set<NotificationTemplateDetails> notificationTemplateDetailses = new HashSet<NotificationTemplateDetails>(
			0);
	private Set<Notification> notifications = new HashSet<Notification>(0);

	public MessageType() {
	}

	public MessageType(String code, String name, byte status, int createdBy) {
		this.code = code;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
	}

	public MessageType(String code, String name, byte status, int createdBy, Date createdDate,
			Set<NotificationTemplateDetails> notificationTemplateDetailses, Set<Notification> notifications) {
		this.code = code;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.notificationTemplateDetailses = notificationTemplateDetailses;
		this.notifications = notifications;
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

	@Column(name = "code", unique = true, nullable = false, length = 16)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "messageType")
	public Set<NotificationTemplateDetails> getNotificationTemplateDetailses() {
		return this.notificationTemplateDetailses;
	}

	public void setNotificationTemplateDetailses(Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.notificationTemplateDetailses = notificationTemplateDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "messageType")
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

}

