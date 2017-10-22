package com.grow.agriculture.helper;

import com.grow.agriculture.beans.UserDetailsFormBean;
import com.grow.agriculture.daoBean.UserDetails;

public class UserDetailsHelper {
	
	public UserDetails getUserDetails(UserDetailsFormBean formBean){
		UserDetails userdetails = new UserDetails();
		userdetails.setAboutme(formBean.getAboutMe());
		userdetails.setAddress(formBean.getAddress());
		userdetails.setCity(formBean.getCity());
		userdetails.setFname(formBean.getFname());
		userdetails.setLname(formBean.getLname());
		userdetails.setPhonenumber(formBean.getPhonenumber());
		userdetails.setPostalcode(formBean.getPostalCode());
		userdetails.setUserid(formBean.getUserid());
		userdetails.setDob(formBean.getDob());
		return userdetails;
	}

}
