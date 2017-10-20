package com.grow.agriculture.daoBean;

public class UserDetailsDaoBean {
	
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String city;
	private long postalcode;
	private String aboutme;
	private long phonenumber;
	private int userid;
	private String dob;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(long postalcode) {
		this.postalcode = postalcode;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "UserDetailsDaoBean [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", city=" + city + ", postalcode=" + postalcode + ", aboutme=" + aboutme + ", phonenumber="
				+ phonenumber + ", userid=" + userid + ", dob=" + dob + "]";
	}
}
