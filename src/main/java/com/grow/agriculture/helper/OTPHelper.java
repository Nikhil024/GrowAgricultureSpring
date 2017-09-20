package com.grow.agriculture.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.beans.OTPFormBean;
import com.grow.agriculture.controllers.GrowAgricultureRequest;
import com.grow.agriculture.daoBean.OTPDaoBean;

public class OTPHelper {
	
	@Autowired
	GrowAgricultureRequest request;
	
	public OTPDaoBean getOtpBean(OTPFormBean formBean){
		OTPDaoBean OTPBean = new OTPDaoBean();
		OTPBean.setPhoneNumber(formBean.getPhoneNumber());
		OTPBean.setSessionId(formBean.getSessionId());
		OTPBean.setUserId(formBean.getUserId());
		OTPBean.setOTP(Long.parseLong(formBean.getOTP()));
		OTPBean.setCreatedDate(request.getCurrentSystemDate());
		return OTPBean;
		
	}

}
