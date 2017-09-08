package com.grow.agriculture.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.rowmapper.UserRowMapper;

@Repository
public class UsersDaoImpl extends NamedParameterJdbcDaoSupport implements UsersDao {

	private String createUserQuery = "INSERT INTO USERS VALUES(ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,CREATED_DATE,LAST_UPDATE) VALUES (USERS_ID.NEXTVAL,:username,:phonenumber,:password,:email,:userType,:createdDate,:lastupdate)";
	private String deleteUserQuery = "DELETE FROM USERS WHERE PHONENUMBER=:phonenumber";
	private String selectUserQuery = "SELECT ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,CREATED_DATE,LAST_UPDATE FROM USERS WHERE PHONENUMBER=:phonenumber;";

	@Override
	public UsersDaoBean getUser(int phonenumber) {
		String query = selectUserQuery;
		 try {
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("phonenumber", phonenumber);
	            
	            SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	            UsersDaoBean user = getNamedParameterJdbcTemplate().queryForObject(query, namedParameters,new UserRowMapper());
	            return user;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}

	@Override
	public void createNewUser(UsersDaoBean user) {
		String query = createUserQuery;
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("username", user.getUsername());
		 parameters.put("phonenumber", user.getPhonenumber());
		 parameters.put("password", user.getPassword());
		 parameters.put("email", user.getEmail());
		 parameters.put("userType", user.getUserType());
		 parameters.put("createdDate", user.getCreatedDate());
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	        getNamedParameterJdbcTemplate().update(query, namedParameters);
	}

	@Override
	public void updateUser(UsersDaoBean user) {
		String query = createUserQuery;
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("username", user.getUsername());
		 parameters.put("phonenumber", user.getPhonenumber());
		 parameters.put("password", user.getPassword());
		 parameters.put("email", user.getEmail());
		 parameters.put("userType", user.getUserType());
		 parameters.put("createdDate", user.getCreatedDate());
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	        getNamedParameterJdbcTemplate().update(query, namedParameters);
	}

	@Override
	public void deleteUser(int phonenumber) {
		 Object[] params = new Object[] { phonenumber };
	        getJdbcTemplate().update(deleteUserQuery, params);
	}
	

}
