package com.grow.agriculture.beans;

public class RegisterFormBean {
	private String phoneNumber;
	private String password;
	private boolean isFarmer;
	private String OTP;
	private boolean showOTP;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIsFarmer() {
		return isFarmer;
	}
	public void setIsFarmer(boolean isFarmer) {
		this.isFarmer = isFarmer;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	
	public boolean isShowOTP() {
		return showOTP;
	}
	public void setShowOTP(boolean showOTP) {
		this.showOTP = showOTP;
	}
	
	@Override
	public String toString() {
		return "RegisterFormBean [phoneNumber=" + phoneNumber + ", password=" + password + ", isFarmer=" + isFarmer
				+ ", OTP=" + OTP + ", showOTP=" + showOTP + "]";
	}
}
