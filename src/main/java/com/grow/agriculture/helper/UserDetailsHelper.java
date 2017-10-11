package com.grow.agriculture.helper;

import com.grow.agriculture.beans.UserDetailsFormBean;
import com.grow.agriculture.daoBean.UserDetailsDaoBean;

public class UserDetailsHelper {
	
	public UserDetailsDaoBean getUserDetails(UserDetailsFormBean formBean){
		UserDetailsDaoBean userdetails = new UserDetailsDaoBean();
		userdetails.setAboutme(formBean.getAboutMe());
		userdetails.setAddress(formBean.getAddress());
		userdetails.setCity(formBean.getCity());
		userdetails.setFname(formBean.getFname());
		userdetails.setLname(formBean.getLname());
		userdetails.setPhonenumber(formBean.getPhonenumber());
		userdetails.setPostalcode(formBean.getPostalCode());
		userdetails.setUserid(formBean.getUserid());
		return userdetails;
	}

}
