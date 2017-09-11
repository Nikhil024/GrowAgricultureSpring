package com.grow.agriculture.helper;

import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.daoBean.UsersDaoBean;

public class UsersHelper {
	
	public UsersDaoBean getUsersBean(RegisterFormBean registerFormbean){
		UsersDaoBean usersBean = new UsersDaoBean();
		usersBean.setPhonenumber(Integer.parseInt(registerFormbean.getPhoneNumber()));
		usersBean.setPassword(registerFormbean.getPassword());
		if (registerFormbean.getIsFarmer()) {
			usersBean.getUserType();
		} else {
			usersBean.getUserType();
		}
		return usersBean;
	}

}
