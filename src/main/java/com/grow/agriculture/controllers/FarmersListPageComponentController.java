package com.grow.agriculture.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.service.UsersService;

@Controller
public class FarmersListPageComponentController {
	
	private static final Logger LOG = Logger.getLogger(FarmersListPageComponentController.class);
	
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	GrowAgricultureRequest request;
	
	
	private static final String VIEW_NAME = "farmersListComponent";	
	private static final String REDIRECT_VIEWNAME = "farmersList";
	private static final String CURRENT_PAGE = "currentpage";
	
	@RequestMapping(value = "/farmersList",method = RequestMethod.GET)
	public ModelAndView getFarmersListComponent(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW_NAME);
		List<UsersDaoBean> users = usersService.getAllUsers();
		mav.addObject("users",users);
		request.setSessionAttr(CURRENT_PAGE, REDIRECT_VIEWNAME);
		mav.addObject("farmersListActive",true);
		mav.addObject("isBuyer",true);
		return mav;
	}
	

}
