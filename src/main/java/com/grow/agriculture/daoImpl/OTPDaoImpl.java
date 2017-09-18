package com.grow.agriculture.daoImpl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.grow.agriculture.dao.OTPDao;
import com.grow.agriculture.daoBean.OTPDaoBean;

public class OTPDaoImpl implements OTPDao{
	private static final Logger LOG = Logger.getLogger(OTPDaoImpl.class);
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	private String createOTPQuery = "INSERT INTO OTP (ID,VALUE,PHONENUMBER,SESSION_ID,USER_ID) VALUES (OTP_ID.NEXTVAL,:value,:phonenumber,:sessionid,:userid)";
	private String deleteOTPQuery = "DELETE FROM OTP WHERE PHONENUMBER=:phonenumber";
	@Override
	public void save(OTPDaoBean otpBean) {
		String query = createOTPQuery;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("value",otpBean.getOTP());
		parameters.put("phonenumber",otpBean.getPhoneNumber());
		parameters.put("sessionid",otpBean.getSessionId());
		parameters.put("userid",otpBean.getUserId());
		
		SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 int count = namedParameterJdbcTemplate.update(query, namedParameters);
		 if(count > 1){
			 LOG.info("Successfully Created OTP :: "+otpBean.getPhoneNumber());
		 }
		
	}

	@Override
	public int check(long phoneNumber) {
		return 0;
	}

	@Override
	public OTPDaoBean retrive(long phoneNumber) {
		return null;
	}

	@Override
	public void update(String columnname, String valuename, String phonenumber) {
		
	}

	@Override
	public void delete(long phoneNumber) {
		
	}

}
