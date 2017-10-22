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

import com.grow.agriculture.dao.OTPDao;
import com.grow.agriculture.daoBean.OTP;
import com.grow.agriculture.rowmapper.OTPRowMapper;

public class OTPDaoImpl implements OTPDao{
	private static final Logger LOG = Logger.getLogger(OTPDaoImpl.class);
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	private String createOTPQuery = "INSERT INTO OTP (ID,VALUE,PHONENUMBER,SESSION_ID,USER_ID,CREATED_DATE) VALUES (OTP_ID.NEXTVAL,:value,:phonenumber,:sessionid,:userid,:createddate)";
	private String deleteOTPQuery = "DELETE FROM OTP WHERE PHONENUMBER=:phonenumber";
	private String updateOTPQuery = "UPDATE OTP SET :columnname=:value where PHONENUMBER=:phonenumber";
	private String selectOTPQuery = "SELECT ID,VALUE,PHONENUMBER,SESSION_ID,USER_ID FROM OTP WHERE PHONENUMBER=:phonenumber"; 
	private String ifOTPExistsQuery = "SELECT count(1) FROM OTP WHERE PHONENUMBER=:phonenumber";
	@Override
	public void save(OTP otpBean) {
		String query = createOTPQuery;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("value",otpBean.getOTP());
		parameters.put("phonenumber",otpBean.getPhoneNumber());
		parameters.put("sessionid",otpBean.getSessionId());
		parameters.put("userid",otpBean.getUserId());
		parameters.put("createddate", otpBean.getCreatedDate());
		SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 int count = namedParameterJdbcTemplate.update(query, namedParameters);
		 if(count > 1){
			 LOG.info("Successfully Created OTP :: "+otpBean.getPhoneNumber());
		 }
		
	}

	@Override
	public int check(long phoneNumber) {
		String query = ifOTPExistsQuery;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("phonenumber",phoneNumber);
		
		SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 return namedParameterJdbcTemplate.queryForObject(query, namedParameters, Integer.class);
	}

	@Override
	public OTP retrive(long phoneNumber) {
		String query = selectOTPQuery;
		 try {
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("phonenumber", phoneNumber);
	            
	            SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	            OTP otp = namedParameterJdbcTemplate.queryForObject(query, namedParameters,new OTPRowMapper());
	            return otp;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}

	@Override
	public void update(String columnname, String valuename, String phonenumber) {
		String query = updateOTPQuery;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("columnname", columnname);
		 parameters.put("valuename", valuename);
		 parameters.put("phonenumber", phonenumber);
		 
		 SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 namedParameterJdbcTemplate.update(query, namedParameters);
		
	}

	@Override
	public void delete(long phoneNumber) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("phonenumber", phoneNumber);
		 namedParameterJdbcTemplate.update(deleteOTPQuery, parameters);
		
	}

}
