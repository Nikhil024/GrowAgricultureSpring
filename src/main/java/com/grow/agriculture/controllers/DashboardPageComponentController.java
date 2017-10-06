package com.grow.agriculture.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grow.agriculture.daoBean.UsersDaoBean;

@Controller
public class DashboardPageComponentController {
	private static final Logger LOG = Logger.getLogger(LoginPageComponentController.class);

	private static final String DASHBOARD_VIEW_NAME = "dashboard";	
	private static final String USERSDAO_FORM_BEAN_NAME = "usersDaoBean";
	
	@RequestMapping("/dashboard")
	public String getDashboardComponent(@ModelAttribute(USERSDAO_FORM_BEAN_NAME) UsersDaoBean users){
		
		LOG.info("dashboard variables::::: "+users.toString());
		
		
		return DASHBOARD_VIEW_NAME;
	}
	
}