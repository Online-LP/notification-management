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
@Table(name = "label_text")
public class LabelText implements java.io.Serializable {

	private Integer id;
	private Language language;
	private String labeltext;
	private int createdby;
	private Date createddate;

	public LabelText() {
	}

	public LabelText(Language language, int createdby, Date createddate) {
		this.language = language;
		this.createdby = createdby;
		this.createddate = createddate;
	}

	public LabelText(Language language, String labeltext, int createdby, Date createddate) {
		this.language = language;
		this.labeltext = labeltext;
		this.createdby = createdby;
		this.createddate = createddate;
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

	@Column(name = "labeltext", length = 30)
	public String getLabeltext() {
		return this.labeltext;
	}

	public void setLabeltext(String labeltext) {
		this.labeltext = labeltext;
	}

	@Column(name = "createdby", nullable = false)
	public int getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = false, length = 19)
	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

}
