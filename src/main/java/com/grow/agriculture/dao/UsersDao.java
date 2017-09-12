package com.grow.agriculture.dao;


import com.grow.agriculture.daoBean.UsersDaoBean;

public interface UsersDao {
	
	public UsersDaoBean getUser(int phonenumber);
	public int getIfUserExists(int phonenumber);
	public void createNewUser(UsersDaoBean user);
	public void updateUser(UsersDaoBean user);
	public void deleteUser(int phonenumber);

}
