package com.grow.agriculture.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.grow.agriculture.dao.UserDetailsDao;

public class UserDetailsDaoImpl implements UserDetailsDao{

	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	
	
	@Override
	public void retrive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
