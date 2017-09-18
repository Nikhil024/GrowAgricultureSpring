package com.grow.agriculture.service;


import com.grow.agriculture.daoBean.UsersDaoBean;

public interface UsersService {

	public UsersDaoBean retrive(long phonenumber);
	public int check(long phonenumber);
	public void save(UsersDaoBean user); //createNewUser
	public void update(String columnname, String valuename, String phonenumber);
	public void delete(int phonenumber);
}
