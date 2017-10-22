package com.grow.agriculture.dao;


import java.util.List;

import com.grow.agriculture.daoBean.User;

public interface UsersDao {
	
	public User get(long phonenumber);
	public List<User> list();
	public boolean createNewUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}
