package com.grow.agriculture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.dao.UserDetailsDao;
import com.grow.agriculture.daoBean.UserDetails;
import com.grow.agriculture.service.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	UserDetailsDao userDetailsDao;

	@Override
	public UserDetails retrive(int userid) {
		UserDetails userDetails = userDetailsDao.retrive(userid);
		return userDetails;
	}
	
	@Override
	public UserDetails retrive(long phonenumber) {
		UserDetails userDetails = userDetailsDao.retrive(phonenumber);
		return userDetails;
	}

	@Override
	public int update(UserDetails userdetails) {
		return userDetailsDao.update(userdetails);
	}

	@Override
	public void delete(int userid) {
		userDetailsDao.delete(userid);
	}

	@Override
	public void save(UserDetails userdetails) {
		 userDetailsDao.save(userdetails);
	}

	@Override
	public int check(int userid) {
		return userDetailsDao.check(userid);
	}

	@Override
	public long check(long phonenumber) {
		return userDetailsDao.check(phonenumber);
	}

}
