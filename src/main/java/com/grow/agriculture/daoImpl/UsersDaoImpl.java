package com.grow.agriculture.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.rowmapper.UserRowMapper;

@Repository
public class UsersDaoImpl implements UsersDao {
	private static final Logger LOG = Logger.getLogger(UsersDaoImpl.class);
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	
	private String createUserQuery = "INSERT INTO USERS (ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,OTP_VERIFIED,CREATED_DATE,LAST_UPDATE) VALUES (USERS_ID.NEXTVAL,:username,:phonenumber,:password,:email,:userType,:otp_verified,:createdDate,:lastUpdate)";
	private String deleteUserQuery = "DELETE FROM USERS WHERE PHONENUMBER=:phonenumber";
	private String selectUserQuery = "SELECT ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,OTP_VERIFIED,CREATED_DATE,LAST_UPDATE FROM USERS WHERE PHONENUMBER=:phonenumber";
	private String selectIfUserExistsQuery = "SELECT count(1) FROM USERS where PHONENUMBER=:phonenumber";
	private String UpdateUserQuery = "UPDATE USERS SET OTP_VERIFIED=:valuename where PHONENUMBER=:phonenumber";
	
	
	@Override
	public UsersDaoBean getUser(long phonenumber) {
		String query = selectUserQuery;
		 try {
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("phonenumber", phonenumber);
	            
	            SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	            UsersDaoBean user = namedParameterJdbcTemplate.queryForObject(query, namedParameters,new UserRowMapper());
	            return user;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
	
	@Override
	public int getIfUserExists(long phonenumber) {
		String query = selectIfUserExistsQuery;
			 Map<String, Object> parameters = new HashMap<String, Object>();
			 parameters.put("phonenumber", phonenumber);
			 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
			 return namedParameterJdbcTemplate.queryForObject(query, namedParameters, Integer.class);
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
		 parameters.put("otp_verified",user.getOtpVerified());
		 parameters.put("createdDate", user.getCreatedDate());
		 parameters.put("lastUpdate", user.getLastupdateDate());
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 int count = namedParameterJdbcTemplate.update(query, namedParameters);
		 if(count > 1){
			 LOG.info("Successfully Created User :: "+user.getPhonenumber());
		 }
	}

	@Override
	public void updateUser(String columnname, String valuename, String phonenumber) {
		String query = UpdateUserQuery;
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("valuename", valuename);
		 parameters.put("phonenumber", phonenumber);
		 
		 LOG.info("in Dao Users::: "+parameters.toString());
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 LOG.info("in Dao Users::: "+namedParameters);
		 namedParameterJdbcTemplate.update(query, namedParameters);
	}
	
	@Override
	public void updateUser(String columnname, int valuename, String phonenumber) {
		String query = UpdateUserQuery;
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("columnname", columnname);
		 parameters.put("valuename", valuename);
		 parameters.put("phonenumber", phonenumber);
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 namedParameterJdbcTemplate.update(query, namedParameters);
	}

	@Override
	public void deleteUser(int phonenumber) {
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("phonenumber", phonenumber);
		 namedParameterJdbcTemplate.update(deleteUserQuery, parameters);
	}
	

}
