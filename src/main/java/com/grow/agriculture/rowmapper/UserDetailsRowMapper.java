package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.OTP;
import com.grow.agriculture.daoBean.UserDetails;

public class UserDetailsRowMapper implements RowMapper<UserDetails>{

	@Override
	public UserDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDetails userdetails = new UserDetails();
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
