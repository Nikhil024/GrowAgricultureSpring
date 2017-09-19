package com.grow.agriculture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.helper.UsersHelper;
import com.grow.agriculture.service.UsersService;

public class UsersServiceImpl implements UsersService {

	@Autowired
    UsersDao usersDao;
	
	@Autowired
	UsersHelper usersHelper;
	
	@Override
	public UsersDaoBean retrive(long phonenumber) {
		UsersDaoBean usersDaoBean = usersDao.getUser(phonenumber);
		return usersDaoBean != null && !usersDaoBean.toString().isEmpty() ? usersDaoBean : null ;
	}

	@Override
	public void save(UsersDaoBean user) {
		usersDao.createNewUser(user);
	}

	@Override
	public void update(String columnname, String valuename, String phonenumber) {
		usersDao.updateUser(columnname, valuename , phonenumber);
	}
	
	@Override
	public void update(String columnname, int valuename, String phonenumber) {
		usersDao.updateUser(columnname, valuename , phonenumber);
	}

	@Override
	public void delete(int phonenumber) {
		usersDao.deleteUser(phonenumber);
	}

	@Override
	public int check(long phonenumber) {
		int count = usersDao.getIfUserExists(phonenumber);
		return count;
	}
}
