package com.grow.agriculture.beans;


public class LoginFormBean {
	
	private String phoneNumber;
	private String password;
	private boolean isFarmer;
	
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
	
	public boolean isFarmer() {
		return isFarmer;
	}
	public void setIsFarmer(boolean isFarmer) {
		this.isFarmer = isFarmer;
	}
	
	@Override
	public String toString() {
		return "LoginFormBean [phoneNumber=" + phoneNumber + ", password=" + password + ", isFarmer=" + isFarmer + "]";
	}



}
