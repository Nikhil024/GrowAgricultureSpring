package com.grow.agriculture.daoBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class OTP {
	
	@Id
	@SequenceGenerator(name = "otp_id", sequenceName = "otp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otp_id")
	private int id ;
	private String sessionId;
	private long OTP;
	private String createdDate;
	
	@OneToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public long getOTP() {
		return OTP;
	}

	public void setOTP(long oTP) {
		OTP = oTP;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OTP [id=" + id + ", sessionId=" + sessionId + ", OTP=" + OTP + ", createdDate=" + createdDate
				+ ", user=" + user + "]";
	}
}
