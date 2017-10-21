package com.grow.agriculture.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.service.UserDetailsService;

@Controller
public class DashboardPageComponentController {
	private static final Logger LOG = Logger.getLogger(DashboardPageComponentController.class);

	@Autowired
	GrowAgricultureRequest request;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	private static final String DASHBOARD_VIEW_NAME = "dashboard";	
	private static final String USERSDAO_FORM_BEAN_NAME = "usersDaoBean";
	private static final String PHONENUMBER = "phonenumber";
	private static final String NAME = "name";
	private static final String PROFILE_PICTURE = "profile_picture";
	private static final String PROFILE_COMPLETION = "profile_completion";
	private static final String DASHBOARD_ACTIVE = "dashboardActive";
	private static final String CURRENT_PAGE = "currentpage";
	private static final boolean SHOW = true;
	private static final boolean HIDE = false;
	
	@RequestMapping("/dashboard")
	public String getDashboardComponent(@ModelAttribute(USERSDAO_FORM_BEAN_NAME) UsersDaoBean users,Model model){
			
		if(userDetailsService.check(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString())) >= 1){
			model.addAttribute(PROFILE_COMPLETION,50);
		}else{
			model.addAttribute(PROFILE_COMPLETION,20);
		}
		model.addAttribute(PHONENUMBER,request.getSessionAttr(PHONENUMBER));
		model.addAttribute(NAME,users.getUsername());
		model.addAttribute(PROFILE_PICTURE,"");
		model.addAttribute(DASHBOARD_ACTIVE,SHOW);
		model.addAttribute("","");
		request.setSessionAttr(CURRENT_PAGE, DASHBOARD_VIEW_NAME);
		
		return DASHBOARD_VIEW_NAME;
	}
	
}