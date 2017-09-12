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
	public UsersDaoBean getUser(int phonenumber) {
		UsersDaoBean usersDaoBean = usersDao.getUser(phonenumber);
		return usersDaoBean != null && !usersDaoBean.toString().isEmpty() ? usersDaoBean : null ;
	}

	@Override
	public void createNewUser(UsersDaoBean user) {
		usersDao.createNewUser(user);
	}

	@Override
	public void updateUser(UsersDaoBean user) {
		usersDao.updateUser(user);
	}

	@Override
	public void deleteUser(int phonenumber) {
		usersDao.deleteUser(phonenumber);
	}

	@Override
	public int getIfUserExists(int phonenumber) {
		int count = usersDao.getIfUserExists(phonenumber);
		return count;
	}
	
	

}
