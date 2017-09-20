package com.grow.agriculture.daoBean;

public class OTPDaoBean {
	private int id ;
	private String phoneNumber;
	private String sessionId;
	private String userId;
	private long OTP;
	private String createdDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public long getOTP() {
		return OTP;
	}
	public void setOTP(long oTP) {
		this.OTP = oTP;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "OTPDaoBean [id=" + id + ", phoneNumber=" + phoneNumber + ", sessionId=" + sessionId + ", userId="
				+ userId + ", OTP=" + OTP + ", createdDate=" + createdDate + "]";
	}
}
