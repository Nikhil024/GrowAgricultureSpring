package com.grow.agriculture.dao;

import com.grow.agriculture.daoBean.OTP;

public interface OTPDao {

	public void save(OTP formBean);
	public int check(long phoneNumber);
	public OTP retrive(long phoneNumber);
	public void update(String columnname, String valuename, String phonenumber);
	public void delete(long phoneNumber);
}
