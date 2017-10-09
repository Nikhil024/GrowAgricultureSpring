package com.grow.agriculture.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class GrowAgricultureRequest {

	@Autowired
	private HttpServletRequest requests;

	@Autowired
	private HttpSession session;
	

	public String getContextPath(){
		return requests.getContextPath();
	}

	public Object getSessionAttr(String attrName) {
		return session.getAttribute(attrName);
	}

	public void setSessionAttr(String name, Object value){
		session.setAttribute(name, value);
	}
	
	public void removeSession(String name){
		session.removeAttribute(name);
	}
	
	public void removeSession(){
		session.invalidate();
	}
	
	public String getSiteURL() {
		return requests.getScheme() + "://" + requests.getServerName() + ":" + requests.getServerPort(); 

	}

	public String getIpAddress() {
		return requests.getRemoteAddr();
	}

	public void setRequestobject(String name, String variable) {
		requests.setAttribute(name, variable);
	}
	
	public String getRequestObject(String variableName) {
		return requests.getParameter(variableName);
	}
	
	public String getCurrentSystemDate(){
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentSystemDate = simpleDateFormat.format(calendar.getTime());
        return currentSystemDate;
	}
	
	
}
