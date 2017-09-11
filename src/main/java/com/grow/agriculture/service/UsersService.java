package com.grow.agriculture.service;


import java.util.List;

import com.grow.agriculture.daoBean.UsersDaoBean;

public interface UsersService {

	public UsersDaoBean getUser(int phonenumber);
	public List<UsersDaoBean> getAllUser();
	public void createNewUser(UsersDaoBean user);
	public void updateUser(UsersDaoBean user);
	public void deleteUser(int phonenumber);
}
