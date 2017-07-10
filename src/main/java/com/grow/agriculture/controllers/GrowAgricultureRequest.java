package com.grow.agriculture.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class GrowAgricultureRequest {

	@Autowired
	private HttpServletRequest requests;


	public String getContextPath(){
		return requests.getContextPath();
	}

	public Object getSessionAttr(String attrName) {
		return requests.getSession().getAttribute(attrName);
	}

	public String getSiteURL() {
		return requests.getScheme() + "://" + requests.getServerName() + ":" + requests.getServerPort(); 

	}

	public String getIpAddress() {
		return requests.getRemoteAddr();
	}


}
