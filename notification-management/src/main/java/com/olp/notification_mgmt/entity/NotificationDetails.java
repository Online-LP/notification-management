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
@Table(name = "notification_details")
public class NotificationDetails implements java.io.Serializable {

	private Integer id;
	private Notification notification;
	private String macAddress;
	private byte emailStatus;
	private byte stbStatus;
	private byte smsStatus;
	private Integer resendCount;
	private String smsResponse;
	private int createdBy;
	private Date createdDate;
	private Integer modifiedBy;
	private Date modifiedDate;

	public NotificationDetails() {
	}

	public NotificationDetails(Notification notification, byte emailStatus, byte stbStatus, byte smsStatus,
			int createdBy, Date createdDate) {
		this.notification = notification;
		this.emailStatus = emailStatus;
		this.stbStatus = stbStatus;
		this.smsStatus = smsStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public NotificationDetails(Notification notification, String macAddress, byte emailStatus, byte stbStatus,
			byte smsStatus, Integer resendCount, String smsResponse, int createdBy, Date createdDate,
			Integer modifiedBy, Date modifiedDate) {
		this.notification = notification;
		this.macAddress = macAddress;
		this.emailStatus = emailStatus;
		this.stbStatus = stbStatus;
		this.smsStatus = smsStatus;
		this.resendCount = resendCount;
		this.smsResponse = smsResponse;
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
	@JoinColumn(name = "notification_id", nullable = false)
	public Notification getNotification() {
		return this.notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	@Column(name = "mac_address", length = 64)
	public String getMacAddress() {
		return this.macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Column(name = "email_status", nullable = false)
	public byte getEmailStatus() {
		return this.emailStatus;
	}

	public void setEmailStatus(byte emailStatus) {
		this.emailStatus = emailStatus;
	}

	@Column(name = "stb_status", nullable = false)
	public byte getStbStatus() {
		return this.stbStatus;
	}

	public void setStbStatus(byte stbStatus) {
		this.stbStatus = stbStatus;
	}

	@Column(name = "sms_status", nullable = false)
	public byte getSmsStatus() {
		return this.smsStatus;
	}

	public void setSmsStatus(byte smsStatus) {
		this.smsStatus = smsStatus;
	}

	@Column(name = "resend_count")
	public Integer getResendCount() {
		return this.resendCount;
	}

	public void setResendCount(Integer resendCount) {
		this.resendCount = resendCount;
	}

	@Column(name = "sms_response", length = 128)
	public String getSmsResponse() {
		return this.smsResponse;
	}

	public void setSmsResponse(String smsResponse) {
		this.smsResponse = smsResponse;
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

