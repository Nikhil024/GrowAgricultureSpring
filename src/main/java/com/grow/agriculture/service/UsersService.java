package com.grow.agriculture.service;


import java.util.List;

import com.grow.agriculture.daoBean.UsersDaoBean;

public interface UsersService {

	public UsersDaoBean retrive(long phonenumber);
	public int check(long phonenumber);
	public void save(UsersDaoBean user); //createNewUser
	public void update(String columnname, String valuename, String phonenumber);
	public void update(String columnname, int valuename, String phonenumber);
	public void delete(int phonenumber);
	public List<UsersDaoBean> getAllUsers();
}
