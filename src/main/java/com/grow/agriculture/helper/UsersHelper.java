package com.grow.agriculture.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.LoginFormBean;
import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.controllers.GrowAgricultureRequest;
import com.grow.agriculture.daoBean.UsersDaoBean;

public class UsersHelper {
	
	@Autowired
	GrowAgricultureRequest request;

	public UsersDaoBean getUsersBean(RegisterFormBean registerFormbean){
		UsersDaoBean usersBean = new UsersDaoBean();
		
		usersBean.setPhonenumber(Long.parseLong(registerFormbean.getPhoneNumber()));
		usersBean.setPassword(registerFormbean.getPassword());
		if (registerFormbean.getIsFarmer()) {
			usersBean.setUserType(GrowAgricultureConstants.USER_TYPE.get(0));
		} else {
			usersBean.setUserType(GrowAgricultureConstants.USER_TYPE.get(1));
		}
		usersBean.setLastupdateDate(request.getCurrentSystemDate());
		usersBean.setEmail("");
		usersBean.setCreatedDate(request.getCurrentSystemDate());
		usersBean.setUsername("");
		return usersBean;
	}
	
	public UsersDaoBean getUsersBean(LoginFormBean loginFormbean){
		UsersDaoBean usersBean = new UsersDaoBean();
		
		usersBean.setPhonenumber(Long.parseLong(loginFormbean.getPhoneNumber()));
		usersBean.setPassword(loginFormbean.getPassword());
		if (loginFormbean.isFarmer()) {
			usersBean.setUserType(GrowAgricultureConstants.USER_TYPE.get(0));
		} else {
			usersBean.setUserType(GrowAgricultureConstants.USER_TYPE.get(1));
		}
		usersBean.setLastupdateDate(request.getCurrentSystemDate());
		usersBean.setEmail("");
		usersBean.setCreatedDate(request.getCurrentSystemDate());
		usersBean.setUsername("");
		return usersBean;
	}
	
}
