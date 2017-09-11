package com.grow.agriculture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.helper.UsersHelper;
import com.grow.agriculture.service.UsersService;

@Transactional
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
	public List<UsersDaoBean> getAllUser() {
		List<UsersDaoBean> users = usersDao.getAllUser();
		return users != null && !users.isEmpty() ? users : null;
	}
	
	

}