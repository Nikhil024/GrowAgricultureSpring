package com.grow.agriculture.daoBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UserDetails {
	
	@Id
	@SequenceGenerator(name = "user_details_id", sequenceName = "user_details_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_id")
	private int id;
	
	@NotBlank(message = "Please enter your First Name!")
	@Column(name = "first_name")
	private String fname;
	
	@NotBlank(message = "Please enter your Last Name!")
	@Column(name = "last_name")
	private String lname;
	
	private String address;
	private String city;
	
	@NotBlank(message = "Please enter your postal code!")
	@Column(name = "postal_code")
	private long postalcode;
	
	@Column(name = "about_me")
	private String aboutme;
	private String dob;
	
	@OneToOne
	private User user;
	

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", city="
				+ city + ", postalcode=" + postalcode + ", aboutme=" + aboutme + ", dob=" + dob + ", user=" + user
				+ "]";
	}
}
