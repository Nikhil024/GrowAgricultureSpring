package com.grow.agriculture.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	
	public String getCurrentSystemDate(){
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentSystemDate = simpleDateFormat.format(calendar.getTime());
        return currentSystemDate;
	}
	
	
}
