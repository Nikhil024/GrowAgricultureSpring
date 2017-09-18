package com.grow.agriculture.dao;

import com.grow.agriculture.daoBean.OTPDaoBean;

public interface OTPDao {

	public void save(OTPDaoBean formBean);
	public int check(long phoneNumber);
	public OTPDaoBean retrive(long phoneNumber);
	public void update(String columnname, String valuename, String phonenumber);
	public void delete(long phoneNumber);
}
