package com.grow.agriculture.daoImpl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.grow.agriculture.dao.UserDetailsDao;
import com.grow.agriculture.daoBean.UserDetailsDaoBean;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.rowmapper.UserDetailsRowMapper;
import com.grow.agriculture.rowmapper.UserRowMapper;

public class UserDetailsDaoImpl implements UserDetailsDao{
	private static final Logger LOG = Logger.getLogger(UserDetailsDaoImpl.class);

	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	private String retriveQuery = "SELECT ID,PHONENUMBER,USERS_ID,FNAME,LNAME,ADDRESS,CITY,POSTALCODE,ABOUTME FROM USER_DETAILS WHERE USERS_ID=:userid";
	private String retriveUsingPhoneQuery = "SELECT ID,PHONENUMBER,USERS_ID,FNAME,LNAME,ADDRESS,CITY,POSTALCODE,ABOUTME FROM USER_DETAILS WHERE PHONENUMBER=:phonenumber";
	private String updateQuery = "UPDATE USER_DSTAILS SET PHONENUMBER=:phonenumber,FNAME=:fname,LNAME=:lname,ADDRESS=:address,CITY=:city,POSTALCODE=:postalcode,ABOUTME=:aboutme where USERS_ID=:userid";
	private String deleteQuery = "DELETE FROM USER_DETAILS WHERE USERS_ID=:userid";
	private String saveQuery = "INSERT INTO USER_DETAILS (ID,PHONENUMBER,USERS_ID,FNAME,LNAME,ADDRESS,CITY,POSTALCODE,ABOUTME) VALUES (UserDetails_ID.NEXTVAL,:phonenumber,:userid,:fname,:lname,:address,:city,:postalcode,:aboutme)";
	
	@Override
	public UserDetailsDaoBean retrive(int userid) {
		String query = retriveQuery;
		 try {
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("userid", userid);
	            
	            SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	            UserDetailsDaoBean userdetails = namedParameterJdbcTemplate.queryForObject(query, namedParameters,new UserDetailsRowMapper());
	            return userdetails;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
	
	@Override
	public UserDetailsDaoBean retrive(long phonenumber) {
		String query = retriveUsingPhoneQuery;
		 try {
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("phonenumber", phonenumber);
	            
	            SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	            UserDetailsDaoBean userdetails = namedParameterJdbcTemplate.queryForObject(query, namedParameters,new UserDetailsRowMapper());
	            return userdetails;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}

	@Override
	public int update(UserDetailsDaoBean userdetails) {
		String query = updateQuery;
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("phonenumber", userdetails.getPhonenumber());
		 parameters.put("fname", userdetails.getFname());
		 parameters.put("lname", userdetails.getLname());
		 parameters.put("address", userdetails.getAddress());
		 parameters.put("city", userdetails.getCity());
		 parameters.put("postalcode", userdetails.getPostalcode());
		 parameters.put("aboutme", userdetails.getAboutme());
		 
		 parameters.put("userid", userdetails.getUserid());
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 return namedParameterJdbcTemplate.queryForObject(query, namedParameters, Integer.class);
	}

	@Override
	public void delete(int userid) {
		String query = deleteQuery;
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("userid", userid);
		 namedParameterJdbcTemplate.update(query, parameters);
	}

	@Override
	public void save(UserDetailsDaoBean userdetails) {
		String query = saveQuery;
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 
		 parameters.put("phonenumber", userdetails.getPhonenumber());
		 parameters.put("fname", userdetails.getFname());
		 parameters.put("lname", userdetails.getLname());
		 parameters.put("address", userdetails.getAddress());
		 parameters.put("city", userdetails.getCity());
		 parameters.put("postalcode", userdetails.getPostalcode());
		 parameters.put("aboutme", userdetails.getAboutme());
		 parameters.put("userid", userdetails.getUserid());
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 
		 int count = namedParameterJdbcTemplate.update(query, namedParameters);
		 
		 if(count > 1){
			 LOG.info("Successfully Created user details :: "+userdetails.getPhonenumber());
		 }
		
	}

}
