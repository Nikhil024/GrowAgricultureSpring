package com.grow.agriculture.helper;

import com.grow.agriculture.beans.OTPFormBean;
import com.grow.agriculture.daoBean.OTPDaoBean;

public class OTPHelper {
	
	public OTPDaoBean getOtpBean(OTPFormBean formBean){
		OTPDaoBean OTPBean = new OTPDaoBean();
		OTPBean.setPhoneNumber(formBean.getPhoneNumber());
		OTPBean.setSessionId(formBean.getSessionId());
		OTPBean.setUserId(formBean.getUserId());
		OTPBean.setOTP(formBean.getOTP());
		return OTPBean;
		
	}

}
