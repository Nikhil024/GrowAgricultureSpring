package com.grow.agriculture.service;

import com.grow.agriculture.daoBean.OTPDaoBean;

public interface OTPService {
	public OTPDaoBean retrive(long phonenumber);
	public int check(long phonenumber);
	public void save(OTPDaoBean otpBean);
	public void update(String columnname, String valuename, String phonenumber);
	public void delete(int phonenumber);
}
