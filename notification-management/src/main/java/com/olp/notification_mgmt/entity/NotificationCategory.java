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
@Table(name = "notification_category", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class NotificationCategory implements java.io.Serializable {

	private Integer id;
	private String code;
	private String description;
	private int createdBy;
	private Date createdDate;
	private Set<NotificationTemplateDetails> notificationTemplateDetailses = new HashSet<NotificationTemplateDetails>(
			0);
	private Set<Notification> notifications = new HashSet<Notification>(0);

	public NotificationCategory() {
	}

	public NotificationCategory(String code, int createdBy, Date createdDate) {
		this.code = code;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public NotificationCategory(String code, String description, int createdBy, Date createdDate,
			Set<NotificationTemplateDetails> notificationTemplateDetailses, Set<Notification> notifications) {
		this.code = code;
		this.description = description;
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

	@Column(name = "code", unique = true, nullable = false, length = 64)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description", length = 64)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationCategory")
	public Set<NotificationTemplateDetails> getNotificationTemplateDetailses() {
		return this.notificationTemplateDetailses;
	}

	public void setNotificationTemplateDetailses(Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.notificationTemplateDetailses = notificationTemplateDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationCategory")
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
}
