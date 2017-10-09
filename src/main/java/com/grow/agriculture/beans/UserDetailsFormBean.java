package com.grow.agriculture.beans;

public class UserDetailsFormBean {

	private int id;
	private final String company = "GrowAgriculture";
	private long phonenumber ;
	private String dob;
	private String Fname;
	private String Lname;
	private String address;
	private String city;
	private final String country = "India";
	private long postalCode;
	private String aboutMe;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
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
	public long getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getCompany() {
		return company;
	}
	public String getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		return "UserDetailsFormBean [id=" + id + ", company=" + company + ", phonenumber=" + phonenumber + ", dob="
				+ dob + ", Fname=" + Fname + ", Lname=" + Lname + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", postalCode=" + postalCode + ", aboutMe=" + aboutMe + "]";
	}
}
