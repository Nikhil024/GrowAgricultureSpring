package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.UsersDaoBean;

public class UserRowMapper implements RowMapper<UsersDaoBean>{
	
	 public UsersDaoBean mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		 	UsersDaoBean user = new UsersDaoBean();
		 	user.setId(resultSet.getInt("ID"));
		 	user.setUsername(resultSet.getString("NAME"));
		 	user.setPassword(resultSet.getString("PASSWORD"));
		 	user.setUserType(resultSet.getString("USER_TYPE"));
		 	user.setCreatedDate(resultSet.getString("CREATED_DATE"));
		 	user.setLastupdateDate(resultSet.getString("LAST_UPDATE"));
		 	return user;
	    }

}
