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

@Entity
@Table(name = "priority")
public class Priority implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private int createdBy;
	private Date createdDate;
	private Integer modifiedBy;
	private Date modifiedDate;
	private Set<NotificationTemplateDetails> notificationTemplateDetailses = new HashSet<NotificationTemplateDetails>(
			0);
	private Set<Notification> notifications = new HashSet<Notification>(0);

	public Priority() {
	}

	public Priority(String code, String name, int createdBy, Date createdDate) {
		this.code = code;
		this.name = name;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Priority(String code, String name, int createdBy, Date createdDate, Integer modifiedBy, Date modifiedDate,
			Set<NotificationTemplateDetails> notificationTemplateDetailses, Set<Notification> notifications) {
		this.code = code;
		this.name = name;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
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

	@Column(name = "code", nullable = false, length = 16)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "priority")
	public Set<NotificationTemplateDetails> getNotificationTemplateDetailses() {
		return this.notificationTemplateDetailses;
	}

	public void setNotificationTemplateDetailses(Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.notificationTemplateDetailses = notificationTemplateDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "priority")
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

}

