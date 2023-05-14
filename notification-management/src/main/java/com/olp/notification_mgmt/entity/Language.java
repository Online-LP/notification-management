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
@Table(name = "language")
public class Language implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private String isoCode;
	private String iso2;
	private int createdBy;
	private Date createdDate;
	private Integer modifiedBy;
	private Date modifiedDate;
	private Set<LabelText> labelTexts = new HashSet<LabelText>(0);
	private Set<NotificationTemplateDetails> notificationTemplateDetailses = new HashSet<NotificationTemplateDetails>(
			0);

	public Language() {
	}

	public Language(String code, String name, String isoCode, int createdBy, Date createdDate) {
		this.code = code;
		this.name = name;
		this.isoCode = isoCode;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Language(String code, String name, String isoCode, String iso2, int createdBy, Date createdDate,
			Integer modifiedBy, Date modifiedDate, Set<LabelText> labelTexts,
			Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.code = code;
		this.name = name;
		this.isoCode = isoCode;
		this.iso2 = iso2;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.labelTexts = labelTexts;
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

	@Column(name = "code", nullable = false, length = 36)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 36)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "iso_code", nullable = false, length = 32)
	public String getIsoCode() {
		return this.isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	@Column(name = "iso2", length = 2)
	public String getIso2() {
		return this.iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	public Set<LabelText> getLabelTexts() {
		return this.labelTexts;
	}

	public void setLabelTexts(Set<LabelText> labelTexts) {
		this.labelTexts = labelTexts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	public Set<NotificationTemplateDetails> getNotificationTemplateDetailses() {
		return this.notificationTemplateDetailses;
	}

	public void setNotificationTemplateDetailses(Set<NotificationTemplateDetails> notificationTemplateDetailses) {
		this.notificationTemplateDetailses = notificationTemplateDetailses;
	}
	

}
