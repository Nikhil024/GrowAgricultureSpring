package com.grow.agriculture.daoBean;

import java.io.Serializable;

public class UsersDaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private int phonenumber;
	private String password;
	private String email;
	private String userType;
	private String createdDate;
	private String lastupdateDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastupdateDate() {
		return lastupdateDate;
	}
	public void setLastupdateDate(String lastupdateDate) {
		this.lastupdateDate = lastupdateDate;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UsersDaoBean [id=" + id + ", username=" + username + ", phonenumber=" + phonenumber + ", password="
				+ password + ", email=" + email + ", userType=" + userType + ", createdDate=" + createdDate
				+ ", lastupdateDate=" + lastupdateDate + "]";
	}
}