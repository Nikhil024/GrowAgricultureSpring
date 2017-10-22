package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.OTP;

public class OTPRowMapper implements RowMapper<OTP>{

	@Override
	public OTP mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		OTP otpBean = new OTP();
		otpBean.setId(resultSet.getInt("ID"));
		otpBean.setOTP(resultSet.getLong("VALUE"));
		otpBean.setPhoneNumber(resultSet.getString("PHONENUMBER"));
		otpBean.setSessionId(resultSet.getString("SESSION_ID"));
		otpBean.setUserId(resultSet.getString("USER_ID"));
		otpBean.setCreatedDate(String.valueOf(resultSet.getDate("CREATED_DATE")));
		return otpBean;
	}

}
