package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.OTPDaoBean;

public class OTPRowMapper implements RowMapper<OTPDaoBean>{

	@Override
	public OTPDaoBean mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		OTPDaoBean otpBean = new OTPDaoBean();
		otpBean.setId(resultSet.getInt("ID"));
		otpBean.setOTP(resultSet.getLong("VALUE"));
		otpBean.setPhoneNumber(resultSet.getString("PHONENUMBER"));
		otpBean.setSessionId(resultSet.getString("SESSION_ID"));
		otpBean.setUserId(resultSet.getString("USER_ID"));
		otpBean.setCreatedDate(String.valueOf(resultSet.getDate("CREATED_DATE")));
		return otpBean;
	}

}
