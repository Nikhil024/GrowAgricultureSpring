package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.OTPDaoBean;
import com.grow.agriculture.daoBean.UserDetailsDaoBean;

public class UserDetailsRowMapper implements RowMapper<UserDetailsDaoBean>{

	@Override
	public UserDetailsDaoBean mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDetailsDaoBean userdetails = new UserDetailsDaoBean();
		userdetails.setAboutme(resultSet.getString("ABOUTME"));
		userdetails.setAddress(resultSet.getString("ADDRESS"));
		userdetails.setCity(resultSet.getString("CITY"));
		userdetails.setFname(resultSet.getString("FNAME"));
		userdetails.setId(resultSet.getInt("ID"));
		userdetails.setLname(resultSet.getString("LNAME"));
		userdetails.setPhonenumber(resultSet.getLong("PHONENUMBER"));
		userdetails.setPostalcode(resultSet.getLong("POSTALCODE"));
		userdetails.setUserid(resultSet.getInt("USERS_ID"));
		userdetails.setDob(resultSet.getString("DOB"));
		return userdetails;
	}

}
