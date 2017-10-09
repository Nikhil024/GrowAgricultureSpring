package com.grow.agriculture.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyProfilePageComponentController {

	private static final Logger LOG = Logger.getLogger(MyProfilePageComponentController.class);

	private static final String VIEW_NAME = "profile";
	private static final String PROFILE_ACTIVE = "profileActive";
	private static final boolean SHOW = true;
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getProfilePageComponent(Model model){
		model.addAttribute(PROFILE_ACTIVE,SHOW);
		return VIEW_NAME;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String postProfilePageComponent(){
		
		return VIEW_NAME;
	}
	
	
}
