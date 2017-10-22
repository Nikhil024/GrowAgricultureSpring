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
import com.grow.agriculture.daoBean.UserDetails;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.helper.UserDetailsHelper;
import com.grow.agriculture.service.UserDetailsService;
import com.grow.agriculture.service.UsersService;

@Controller
public class ProfilePageComponentController {

	private static final Logger LOG = Logger.getLogger(ProfilePageComponentController.class);

	
	@Autowired
	@Qualifier("userDetailsValidator")
	Validator userDetailsValidator;
	
	@Autowired
	GrowAgricultureRequest request;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	UserDetailsHelper helper;
	
	private static final String VIEW_NAME = "profile";
	private static final String PROFILE_ACTIVE = "profileActive";
	private static final boolean SHOW = true;
	private static final String USER_DETAILS_FORM_BEAN_NAME = "userDetailsFormBean";
	private static final String PHONENUMBER = "phonenumber";
	private static final String FNAME = "fname";
	private static final String LNAME = "lname";
	private static final String DOB = "dob";
	private static final String ADDRESS = "address";
	private static final String CITY = "city";
	private static final String POSTALCODE = "code";
	private static final String ABOUTME = "aboutme";	
	private static final String USER_ID = "user_id";
	private static final String ERRORPAGE = "404Error";
	private static final String CURRENT_PAGE = "currentpage";
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getProfilePageComponent(Model model){
		if(request.getSessionAttr(PHONENUMBER) != null){
		UsersDaoBean user =  userService.retrive(Long.valueOf(request.getSessionAttr("phonenumber").toString()));
		UserDetails userdetails = userDetailsService.retrive(user.getId());
		
		if(userdetails != null){
			model.addAttribute(FNAME,userdetails.getFname());
			model.addAttribute(LNAME,userdetails.getLname());
			model.addAttribute(ADDRESS,userdetails.getAddress());
			model.addAttribute(CITY,userdetails.getCity());
			model.addAttribute(POSTALCODE,userdetails.getPostalcode());
			model.addAttribute(ABOUTME,userdetails.getAboutme());
			model.addAttribute(DOB,userdetails.getDob());
		}
		
		model.addAttribute(PROFILE_ACTIVE,SHOW);
		model.addAttribute(USER_ID,user.getId());
		model.addAttribute(USER_DETAILS_FORM_BEAN_NAME, new UserDetailsFormBean());
		model.addAttribute(PHONENUMBER ,request.getSessionAttr(PHONENUMBER));
		request.setSessionAttr(CURRENT_PAGE, VIEW_NAME);
		
		return VIEW_NAME;
		}
		else{
			return ERRORPAGE;
		}
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String postProfilePageComponent(@ModelAttribute(USER_DETAILS_FORM_BEAN_NAME) UserDetailsFormBean formBean,BindingResult result){
		userDetailsValidator.validate(formBean, result);
		formBean.setPhonenumber(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));
		if(userDetailsService.check(formBean.getUserid()) >= 1){
			userDetailsService.update(helper.getUserDetails(formBean));
		}else{
		userDetailsService.save(helper.getUserDetails(formBean));
		}
		return VIEW_NAME;
	}
	
	
}
