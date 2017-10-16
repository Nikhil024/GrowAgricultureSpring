package com.grow.agriculture.service;

import com.grow.agriculture.daoBean.UserDetailsDaoBean;

public interface UserDetailsService {
	
	public UserDetailsDaoBean retrive(int userid);
	public UserDetailsDaoBean retrive(long phonenumber);
	public int update(UserDetailsDaoBean userdetails);
	public void delete(int userid);
	public void save(UserDetailsDaoBean userdetails);
	public int check(int userid);
	public long check(long phonenumber);
}
