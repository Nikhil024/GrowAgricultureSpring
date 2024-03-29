package com.grow.agriculture.controllers;

<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.servlet.ModelAndView;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoBean.Images;
import com.grow.agriculture.daoBean.User;
import com.grow.agriculture.daoBean.UserDetails;
=======
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.daoBean.ImagesDaoBean;
import com.grow.agriculture.daoBean.UserDetailsDaoBean;
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
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
<<<<<<< HEAD
	UsersDao usersDao;

	private static final String DASHBOARD_VIEW_NAME = "dashboard";	
=======
	UsersService usersService;

	private static final String DASHBOARD_VIEW_NAME = "dashboardComponent";	
	private static final String REDIRECT_VIEW_NAME = "dashboard";	
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
	private static final String USERSDAO_FORM_BEAN_NAME = "usersDaoBean";
	private static final String PHONENUMBER = "phonenumber";
	private static final String FNAME = "fname";
	private static final String lNAME = "lname";
	private static final String NAME = "name";
	private static final String PROFILE_PICTURE = "profile_picture";
	private static final String PROFILE_COMPLETION = "profile_completion";
	private static final String DASHBOARD_ACTIVE = "dashboardActive";
	private static final String CURRENT_PAGE = "currentpage";
	private static final String IS_FARMER = "isFarmer";
	private static final String IS_BUYER = "isBuyer";
	private static final String IS_VIEWMORE = "viewMore";
	private static final String CURRENT_USER = "currentUser";
	private static final String FARMER_NAME = "farmerName";

	private static final boolean SHOW = true;
	private static final boolean HIDE = false;

	@RequestMapping("/dashboard")
<<<<<<< HEAD
	public ModelAndView getDashboardComponent(@ModelAttribute(USERSDAO_FORM_BEAN_NAME) User user,Model model){
		ModelAndView modelandview  = new ModelAndView();

		User usr  = usersDao.get(phonenumber);
=======
	public ModelAndView getDashboardComponent(@ModelAttribute(USERSDAO_FORM_BEAN_NAME) UsersDaoBean users,Model model){
		ModelAndView modelandview  = new ModelAndView();

		UsersDaoBean usr  = usersService.retrive(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d

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
		model.addAttribute(NAME,user.getUsername());
		model.addAttribute(PROFILE_PICTURE,"");
		model.addAttribute(DASHBOARD_ACTIVE,SHOW);
<<<<<<< HEAD
		request.setSessionAttr(CURRENT_PAGE, DASHBOARD_VIEW_NAME);

		/*UsersDaoBean usr  = usersService.retrive(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));*/

		UserDetails usersDetails = userDetailsService.retrive(users.getId());
=======

		if(usr.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(1))){
			model.addAttribute(IS_BUYER,SHOW);
		}else if(usr.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(0))){
			model.addAttribute(IS_FARMER,SHOW);
		}

		request.setSessionAttr(CURRENT_PAGE, REDIRECT_VIEW_NAME);

		/*UsersDaoBean usr  = usersService.retrive(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));*/

		UserDetailsDaoBean usersDetails = userDetailsService.retrive(users.getId());
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d

		if(usersDetails != null) {
			if(usersDetails.getFname() != null) {
				model.addAttribute(FNAME,usersDetails.getFname());
			}
			if(usersDetails.getLname() != null) {
				model.addAttribute(lNAME,usersDetails.getLname());
			}
		}

<<<<<<< HEAD
		List<Images> currentUser = imagesService.getPicsOfCurrentUser(usr.getId());
		List<Images> notCurrentUser = imagesService.getPicsOfOtherThanCurrentUser(usr.getId());

		modelandview.addObject("currentUser",currentUser);
		modelandview.addObject("notCurrentUser",notCurrentUser);

		modelandview.addObject("location",GrowAgricultureConstants.CATALINA_HOME_LOCATION+GrowAgricultureConstants.OTHER_IMAGE_PROFILE_STORE_LOCATION+File.separator);
=======
		if(usr.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(0))){
			List<ImagesDaoBean> currentUser = imagesService.getPicsOfCurrentUser(usr.getId());
			List<ImagesDaoBean> notCurrentUser = imagesService.getPicsOfOtherThanCurrentUser(usr.getId());

			modelandview.addObject(CURRENT_USER,currentUser);
			modelandview.addObject("notCurrentUser",notCurrentUser);
		}

		if(usr.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(1))){
			List<ImagesDaoBean> allPics = imagesService.getAllPics();
			modelandview.addObject("allPics",allPics);

		}


>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
		modelandview.setViewName(DASHBOARD_VIEW_NAME);


		return modelandview;
<<<<<<< HEAD
	}

=======
	}


	@RequestMapping(value="/dashboard/viewMore", method=RequestMethod.POST)
	public ModelAndView demo(@RequestParam("usersId") int users_id,Model model){
		ModelAndView modelandview  = new ModelAndView();

		UserDetailsDaoBean userDetails = userDetailsService.retrive(users_id);

		LOG.info("in dash board view more ::::: "+users_id);
		modelandview.addObject(IS_VIEWMORE,SHOW);
		List<ImagesDaoBean> currentUser = imagesService.getPicsOfCurrentUser(users_id);
		modelandview.addObject(CURRENT_USER,currentUser);

		if(userDetails != null){
			if(userDetails.getFname() != null || userDetails.getLname() != null){
				modelandview.addObject(FARMER_NAME,userDetails.getFname()+" "+userDetails.getLname());
			}
		}
		modelandview.setViewName(DASHBOARD_VIEW_NAME);

		return modelandview;
	}





>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
}