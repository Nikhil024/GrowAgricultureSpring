package com.grow.agriculture.controllers;

import javax.validation.Valid;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.LoginFormBean;
import com.grow.agriculture.form.validators.LoginValidator;
import com.grow.agriculture.service.ConfigurationService;

@Controller
@RequestMapping("/login")
public class LoginPageComponentController {

	private static final Logger LOG = Logger.getLogger(LoginPageComponentController.class);

	/*@Autowired
	JsonReaderService jsonReadService;*/

	@Autowired
	ConfigurationService configurationService;

	private static final String VIEW_NAME = "loginPageComponent";
	private static final String PROJECT_NAME = "project_name";
	private static final String LOGIN_PAGE_REGISTER_TEXT = "register";
	private static final String LOGIN_PAGE_ABOUTUS_TEXT = "aboutus";
	private static final String LOGIN_PAGE_FORGOTPASSWORD_TEXT = "forgotpassword";
	private static final String LOGIN_PAGE_BACKGROUND_IMAGE_NAME = "background_name";
	private static final String LOGIN_PAGE_LOGIN_TEXT = "login";
	private static final String LOGIN_PAGE_USER_LOGIN_TEXT = "user_login";
	private static final String LOGIN_PLACEHOLDER_TEXT = "login_placeholder_text";
	private static final String LOGIN_FORM_BEAN_NAME = "loginFormBean";
	private static final String LOGIN_FORM_NAME = "form_name";
	private static final String FARMER_LOGIN_URL = "farmerLogin";
	private static final String BUYER_LOGIN_URL = "buyerLogin";
	

	@RequestMapping(value="/buyerLogin", method = RequestMethod.GET)
	public String BuyerLoginGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(LOGIN_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_USER_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.BUYERLOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(LOGIN_FORM_BEAN_NAME, new LoginFormBean());
		model.addAttribute(LOGIN_FORM_NAME,BUYER_LOGIN_URL);
		return VIEW_NAME;
	}
	
	@RequestMapping(value="/buyerLogin", method = RequestMethod.POST)
	public String BuyerLoginPostMethodComponent(@ModelAttribute LoginFormBean formBean,Errors error,Model model) throws ConfigurationException{
		formBean.setIsFarmer(false);
		LOG.info("this is the buyer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(LOGIN_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_USER_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.BUYERLOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(LOGIN_FORM_NAME,BUYER_LOGIN_URL);
		if(error.hasErrors()){
			LOG.info("has errors");
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			return "home";
		}
	}
	
	
	@RequestMapping(value="/farmerLogin", method = RequestMethod.GET)
	public String FarmerLoginGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(LOGIN_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_USER_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FARMERLOGIN_TITILE_NAME));
		model.addAttribute(LOGIN_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(LOGIN_FORM_BEAN_NAME, new LoginFormBean());
		model.addAttribute(LOGIN_FORM_NAME,FARMER_LOGIN_URL);
		return VIEW_NAME;
	}
	
	
	@RequestMapping(value="/farmerLogin", method = RequestMethod.POST)
	public String FarmerLoginPostMethodComponent(@ModelAttribute(LOGIN_FORM_BEAN_NAME) LoginFormBean formBean,BindingResult result,Model model) throws ConfigurationException{
		formBean.setIsFarmer(true);
		LOG.info("this is the farmer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(LOGIN_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_USER_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FARMERLOGIN_TITILE_NAME));
		model.addAttribute(LOGIN_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(LOGIN_FORM_NAME,FARMER_LOGIN_URL);
		if(result.hasErrors()){
			LOG.info("has errors");
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			return "home";
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new LoginValidator());
	}
}
