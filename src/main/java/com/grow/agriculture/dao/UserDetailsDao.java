package com.grow.agriculture.dao;

import com.grow.agriculture.daoBean.UserDetails;

public interface UserDetailsDao {
	
	public UserDetails retrive(int userid);
	public UserDetails retrive(long phonenumber);
	public int update(UserDetails userdetails);
	public void delete(int userid);
	public void save(UserDetails userdetails);
	public int check(int userid);
	public long check(long phonenumber);

}
