package com.grow.agriculture.dao;


import com.grow.agriculture.daoBean.UsersDaoBean;

public interface UsersDao {
	
	public UsersDaoBean getUser(long phonenumber);
	public int getIfUserExists(long phonenumber);
	public void createNewUser(UsersDaoBean user);
	public void updateUser(String columnname, String valuename, String phonenumber);
	public void updateUser(String columnname, int valuename, String phonenumber);
	public void deleteUser(int phonenumber);

}
