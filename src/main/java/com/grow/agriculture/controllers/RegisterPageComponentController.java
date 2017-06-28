package com.grow.agriculture.controllers;

import java.io.File;

import javax.validation.Valid;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.form.validators.RegisterValidator;
import com.grow.agriculture.service.ConfigurationService;
import com.sun.org.glassfish.gmbal.ManagedAttribute;

@Controller
@RequestMapping("/register")
@SessionAttributes("RegisterFormBean")
public class RegisterPageComponentController {
	private static final Logger LOG = Logger.getLogger(RegisterPageComponentController.class);

	/*@Autowired
	JsonReaderService jsonReadService;*/

	
	@Autowired
	ConfigurationService configurationService;
	
	public static final String VIEW_NAME = "registerPageComponent";
	private static final String PROJECT_NAME = "project_name";
	private static final String REGISTER_PAGE_REGISTER_TEXT = "register";
	private static final String REGISTER_PAGE_ABOUTUS_TEXT = "aboutus";
	private static final String REGISTER_PAGE_FORGOTPASSWORD_TEXT = "forgotpassword";
	private static final String REGISTER_PAGE_BACKGROUND_IMAGE_NAME = "background_name";
	private static final String REGISTER_PAGE_LOGIN_TEXT = "login";
	private static final String REGISTER_PAGE_USER_REGISTER_TEXT = "user_register";
	private static final String REGISTER_PLACEHOLDER_TEXT = "register_placeholder_text";
	private static final String REGISTER_FORM_BEAN_NAME = "registerFormBean";
	private static final String REGISTER_FORM_NAME = "form_name";
	private static final String FARMER_REGISTER_URL = "farmerRegister";
	private static final String OTP = "otp";
	private static final String BUYER_REGISTER_URL = "buyerRegister";
	private static final String SHOW_OTP_SECTION = "showOTPSection";
	
	

	@RequestMapping(value="/buyerRegister", method = RequestMethod.GET)
	public String buyerRegisterGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_BEAN_NAME, new RegisterFormBean());
		model.addAttribute(REGISTER_FORM_NAME,BUYER_REGISTER_URL);
		return VIEW_NAME;
	}
	
	@RequestMapping(value="/buyerRegister", method = RequestMethod.POST)
	public String buyerRegisterPostMethodComponent(@Valid @ModelAttribute RegisterFormBean formBean,Errors error,Model model) throws ConfigurationException{
		formBean.setIsFarmer(false);
		LOG.info("this is the buyer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_NAME,BUYER_REGISTER_URL);
		if(error.hasErrors()){
			LOG.info("has errors");
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			return "home";
		}
	}
	
	
	@RequestMapping(value="/farmerRegister", method = RequestMethod.GET)
	public String farmeRegisterGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_BEAN_NAME, new RegisterFormBean());
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL);
		return VIEW_NAME;
	}
	
	
	@RequestMapping(value="/farmerRegister", method = RequestMethod.POST)
	public String farmerRegisterPostMethodComponent(@Valid @ModelAttribute RegisterFormBean formBean,Errors error,Model model) throws ConfigurationException{
		formBean.setIsFarmer(true);
		LOG.info("this is the farmer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL);
		if(error.hasErrors()){
			LOG.info("has errors");
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			model.asMap().clear();
			return "redirect:"+File.separator+FARMER_REGISTER_URL+OTP;
		}
	}
	
	@RequestMapping(value="/farmerRegister/otp",method=RequestMethod.GET)
	public String farmerGetRegisterOTP(Model model) throws ConfigurationException{
		model.addAttribute(SHOW_OTP_SECTION,true);
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_PLACEHOLDER_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_BEAN_NAME, new RegisterFormBean());
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_BUTTON_NAME));
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL+File.separator+OTP);
		return VIEW_NAME;
	}
	
	@RequestMapping(value="/farmerRegister/otp",method=RequestMethod.POST)
	public String farmerPostRegisterOTP(@ModelAttribute RegisterFormBean formBean, Model model) throws ConfigurationException{
		model.addAttribute(SHOW_OTP_SECTION,true);
		LOG.info("OTP "+formBean);
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_PLACEHOLDER_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_BUTTON_NAME));
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL+File.separator+OTP);
		return VIEW_NAME;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new RegisterValidator());
	}
	
}
