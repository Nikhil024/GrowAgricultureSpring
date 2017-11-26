package com.grow.agriculture.dao;


import java.util.List;

<<<<<<< HEAD
import com.grow.agriculture.daoBean.User;

public interface UsersDao {
	
	public User get(long phonenumber);
	public List<User> list();
	public boolean createNewUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
=======
import com.grow.agriculture.daoBean.UsersDaoBean;

public interface UsersDao {
	
	public UsersDaoBean getUser(long phonenumber);
	public int getIfUserExists(long phonenumber);
	public void createNewUser(UsersDaoBean user);
	public void updateUser(String columnname, String valuename, String phonenumber);
	public void updateUser(String columnname, int valuename, String phonenumber);
	public void deleteUser(int phonenumber);
	public List<UsersDaoBean> getAllUsers();

>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
}
