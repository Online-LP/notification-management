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
@Table(name = "notification_template_master", uniqueConstraints = { @UniqueConstraint(columnNames = "code"),
		@UniqueConstraint(columnNames = "name") })
public class NotificationTemplateMaster implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private String placeHolders;
	private int createdBy;
	private Date createdDate;
	private Set<NotificationTemplateDetails> notificationTemplateDetailses = new HashSet<NotificationTemplateDetails>(
			0);

	public NotificationTemplateMaster() {
	}

	public NotificationTemplateMaster(String code, String name, int createdBy, Date createdDate) {
		this.code = code;
		this.name = name;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public NotificationTemplateMaster(String code, String name, String placeHolders, int createdBy, Date createdDate,
			Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.code = code;
		this.name = name;
		this.placeHolders = placeHolders;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.notificationTemplateDetailses = notificationTemplateDetailses;
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

	@Column(name = "code", unique = true, nullable = false, length = 128)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", unique = true, nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "place_holders", length = 256)
	public String getPlaceHolders() {
		return this.placeHolders;
	}

	public void setPlaceHolders(String placeHolders) {
		this.placeHolders = placeHolders;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationTemplateMaster")
	public Set<NotificationTemplateDetails> getNotificationTemplateDetailses() {
		return this.notificationTemplateDetailses;
	}

	public void setNotificationTemplateDetailses(Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.notificationTemplateDetailses = notificationTemplateDetailses;
	}

}
