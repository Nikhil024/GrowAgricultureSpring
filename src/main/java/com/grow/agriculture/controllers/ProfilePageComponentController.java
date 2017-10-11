package com.grow.agriculture.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grow.agriculture.beans.UserDetailsFormBean;

@Controller
public class ProfilePageComponentController {

	private static final Logger LOG = Logger.getLogger(ProfilePageComponentController.class);

	
	@Autowired
	@Qualifier("userDetailsValidator")
	Validator userDetailsValidator;
	
	@Autowired
	GrowAgricultureRequest request;
	
	
	
	
	private static final String VIEW_NAME = "profile";
	private static final String PROFILE_ACTIVE = "profileActive";
	private static final boolean SHOW = true;
	private static final String USER_DETAILS_FORM_BEAN_NAME = "userDetailsFormBean";
	private static final String PHONENUMBER = "phonenumber";
	private static final String FNAME = "fname";
	private static final String ADDRESS = "address";
	private static final String CITY = "city";
	private static final String POSTALCODE = "code";
	private static final String ABOUTME = "aboutme";	
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getProfilePageComponent(Model model){
		
		
		model.addAttribute(FNAME);
		model.addAttribute(ADDRESS);
		model.addAttribute(CITY);
		model.addAttribute(POSTALCODE);
		model.addAttribute(ABOUTME);
		
		
		
		model.addAttribute(PROFILE_ACTIVE,SHOW);
		model.addAttribute(USER_DETAILS_FORM_BEAN_NAME, new UserDetailsFormBean());
		model.addAttribute(PHONENUMBER ,request.getSessionAttr("phonenumber"));
		
		return VIEW_NAME;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String postProfilePageComponent(@ModelAttribute(USER_DETAILS_FORM_BEAN_NAME) UserDetailsFormBean formBean,BindingResult result){
		userDetailsValidator.validate(formBean, result);
		LOG.info("profile:: attr:: "+formBean.toString());
		return VIEW_NAME;
	}
	
	
}
