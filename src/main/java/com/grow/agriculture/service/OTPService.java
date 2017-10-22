package com.grow.agriculture.service;

import com.grow.agriculture.daoBean.OTP;

public interface OTPService {
	public OTP retrive(long phonenumber);
	public int check(long phonenumber);
	public void save(OTP otpBean);
	public void update(String columnname, String valuename, String phonenumber);
	public void delete(int phonenumber);
}
