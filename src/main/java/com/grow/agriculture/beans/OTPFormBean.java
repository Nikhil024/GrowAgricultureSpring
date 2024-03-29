package com.grow.agriculture.beans;

public class OTPFormBean {

	private int id;
	private String OTP;
	private String phoneNumber;
	private String sessionId;
	private String userId;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
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

	@Override
	public String toString() {
		return "OTPFormBean [id=" + id + ", OTP=" + OTP + ", phoneNumber=" + phoneNumber + ", sessionId=" + sessionId
				+ ", userId=" + userId + "]";
	}
}
