package com.grow.agriculture.daoBean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "user_id", sequenceName = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
	private int id;
 
	@NotBlank(message = "Please enter the number!")
	@Column(name = "phone_number" , nullable = false , unique = true)
	private long phonenumber;
	
	@NotBlank(message = "Please enter the password!")
	@Column(name = "password" , nullable = false)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name = "role" , nullable = false)
	private String role;
	
	@Column(name = "otp_verified")
	private int otpVerified;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "last_updated")
	private String lastupdateDate;
	
	@Column(name = "is_active")
	private int isActive;
	
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private UserDetails details;
	
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private OTP otp;
	
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private Images images;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getOtpVerified() {
		return otpVerified;
	}

	public void setOtpVerified(int otpVerified) {
		this.otpVerified = otpVerified;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

	public OTP getOtp() {
		return otp;
	}

	public void setOtp(OTP otp) {
		this.otp = otp;
	}

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", phonenumber=" + phonenumber + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", role=" + role + ", otpVerified=" + otpVerified + ", createdDate=" + createdDate
				+ ", lastupdateDate=" + lastupdateDate + ", isActive=" + isActive + ", details=" + details + ", otp="
				+ otp + ", images=" + images + "]";
	}
}
