package com.grow.agriculture.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.beans.OTPFormBean;
import com.grow.agriculture.controllers.GrowAgricultureRequest;
import com.grow.agriculture.daoBean.OTP;

public class OTPHelper {
	
	@Autowired
	GrowAgricultureRequest request;
	
	public OTP getOtpBean(OTPFormBean formBean){
		OTP OTPBean = new OTP();
		OTPBean.setPhoneNumber(formBean.getPhoneNumber());
		OTPBean.setSessionId(formBean.getSessionId());
		OTPBean.setUserId(formBean.getUserId());
		OTPBean.setOTP(Long.parseLong(formBean.getOTP()));
		OTPBean.setCreatedDate(request.getCurrentSystemDate());
		return OTPBean;
		
	}

}
