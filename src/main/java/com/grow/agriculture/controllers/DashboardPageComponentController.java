package com.grow.agriculture.controllers;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.daoBean.ImagesDaoBean;
import com.grow.agriculture.daoBean.UserDetailsDaoBean;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.service.ImagesService;
import com.grow.agriculture.service.UserDetailsService;
import com.grow.agriculture.service.UsersService;

@Controller
public class DashboardPageComponentController {
	private static final Logger LOG = Logger.getLogger(DashboardPageComponentController.class);

	@Autowired
	GrowAgricultureRequest request;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	ImagesService imagesService;

	@Autowired
	UsersService usersService;

	private static final String DASHBOARD_VIEW_NAME = "dashboard";	
	private static final String USERSDAO_FORM_BEAN_NAME = "usersDaoBean";
	private static final String PHONENUMBER = "phonenumber";
	private static final String FNAME = "fname";
	private static final String lNAME = "lname";
	private static final String NAME = "name";
	private static final String PROFILE_PICTURE = "profile_picture";
	private static final String PROFILE_COMPLETION = "profile_completion";
	private static final String DASHBOARD_ACTIVE = "dashboardActive";
	private static final String CURRENT_PAGE = "currentpage";
	private static final boolean SHOW = true;
	private static final boolean HIDE = false;

	@RequestMapping("/dashboard")
	public ModelAndView getDashboardComponent(@ModelAttribute(USERSDAO_FORM_BEAN_NAME) UsersDaoBean users,Model model){
		ModelAndView modelandview  = new ModelAndView();

		UsersDaoBean usr  = usersService.retrive(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));

		if(userDetailsService.check(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString())) >= 1){
			if(imagesService.check(usr.getId()) >=1 ) {
				model.addAttribute(PROFILE_COMPLETION,100);
			}else{
				model.addAttribute(PROFILE_COMPLETION,50);
			}
		}else{
			model.addAttribute(PROFILE_COMPLETION,20);
		}
		model.addAttribute(PHONENUMBER,request.getSessionAttr(PHONENUMBER));
		model.addAttribute(NAME,users.getUsername());
		model.addAttribute(PROFILE_PICTURE,"");
		model.addAttribute(DASHBOARD_ACTIVE,SHOW);
		request.setSessionAttr(CURRENT_PAGE, DASHBOARD_VIEW_NAME);

		/*UsersDaoBean usr  = usersService.retrive(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));*/

		UserDetailsDaoBean usersDetails = userDetailsService.retrive(users.getId());

		if(usersDetails != null) {
			if(usersDetails.getFname() != null) {
				model.addAttribute(FNAME,usersDetails.getFname());
			}
			if(usersDetails.getLname() != null) {
				model.addAttribute(lNAME,usersDetails.getLname());
			}
		}

		List<ImagesDaoBean> currentUser = imagesService.getPicsOfCurrentUser(usr.getId());
		List<ImagesDaoBean> notCurrentUser = imagesService.getPicsOfOtherThanCurrentUser(usr.getId());

		modelandview.addObject("currentUser",currentUser);
		modelandview.addObject("notCurrentUser",notCurrentUser);

		modelandview.addObject("location",GrowAgricultureConstants.CATALINA_HOME_LOCATION+GrowAgricultureConstants.OTHER_IMAGE_PROFILE_STORE_LOCATION+File.separator);
		modelandview.setViewName(DASHBOARD_VIEW_NAME);


		return modelandview;
	}

}