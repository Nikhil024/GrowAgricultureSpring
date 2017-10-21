package com.grow.agriculture.controllers;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.LoginFormBean;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.helper.MD5PasswordEncryptionHelper;
import com.grow.agriculture.service.ConfigurationService;
import com.grow.agriculture.service.UsersService;

@Controller
@RequestMapping("/login")
public class LoginPageComponentController {

	private static final Logger LOG = Logger.getLogger(LoginPageComponentController.class);

	@Autowired
	ConfigurationService configurationService;

	@Autowired
	UsersService usersService;
	
	@Autowired
	GrowAgricultureRequest request;
	
	@Autowired
	MD5PasswordEncryptionHelper MD5;

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
	private static final String USERSDAO_FORM_BEAN_NAME = "usersDaoBean";
	private static final String LOGIN_FORM_NAME = "form_name";
	private static final String FARMER_LOGIN_URL = "farmerLogin";
	private static final String BUYER_LOGIN_URL = "buyerLogin";
	private static final boolean SHOW = true;
	private static final String PASSWORD_INVALID_ERROR = "passwordError";
	private static final String NO_USER_EXISTS = "nouserError";
	private static final String OTP_NOT_VERIFIED = "otpnotVerifiedError";
	private static final String WRONG_USER_TYPE = "wrongUserType";
	private static final String USER_TYPE = "user_type";


	@RequestMapping(value="/buyerLogin", method = RequestMethod.GET)
	public String BuyerLoginGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_BUYER_BACKGROUND_IMAGE_NAME));
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
	public String BuyerLoginPostMethodComponent(@ModelAttribute(LOGIN_FORM_BEAN_NAME) LoginFormBean formBean,Errors error,Model model,final RedirectAttributes redirectAttributes) throws ConfigurationException{
		formBean.setIsFarmer(false);
		LOG.info("this is the buyer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_BUYER_BACKGROUND_IMAGE_NAME));
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
			if(usersService.check(Long.parseLong(formBean.getPhoneNumber())) != 0){
				UsersDaoBean user = usersService.retrive(Long.parseLong(formBean.getPhoneNumber()));
				if(user.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(1)) || user.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(2))){
					if(user.getPassword().equals(MD5.encryption(formBean.getPassword()))){
						if(user.getOtpVerified() == 1){
							redirectAttributes.addFlashAttribute(USERSDAO_FORM_BEAN_NAME, user);
							return "redirect:/dashboard";
						}else{
							LOG.info("otp not verified for : "+formBean.getPhoneNumber());
							model.addAttribute(OTP_NOT_VERIFIED, SHOW);
							return VIEW_NAME;
						}
					}else{
						LOG.info("invalid password for : "+formBean.getPhoneNumber());
						model.addAttribute(PASSWORD_INVALID_ERROR, SHOW);
						return VIEW_NAME;
					}
				}else{
					LOG.info("Not registered as buyer or both :: "+formBean.getPhoneNumber());
					model.addAttribute(USER_TYPE, GrowAgricultureConstants.USER_TYPE.get(1));
					model.addAttribute(WRONG_USER_TYPE, SHOW);
					return VIEW_NAME;
				}
			}else{
				LOG.info("no user exists for : "+formBean.getPhoneNumber());
				model.addAttribute(NO_USER_EXISTS, SHOW);
				return VIEW_NAME;
			}
		}
	}


	@RequestMapping(value="/farmerLogin", method = RequestMethod.GET)
	public String FarmerLoginGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_FARMER_BACKGROUND_IMAGE_NAME));
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
	public String FarmerLoginPostMethodComponent(@ModelAttribute(LOGIN_FORM_BEAN_NAME) LoginFormBean formBean,Errors error,Model model,final RedirectAttributes redirectAttributes) throws ConfigurationException{
		formBean.setIsFarmer(true);
		LOG.info("this is the farmer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(LOGIN_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_PAGE_FARMER_BACKGROUND_IMAGE_NAME));
		model.addAttribute(LOGIN_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(LOGIN_PAGE_USER_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FARMERLOGIN_TITILE_NAME));
		model.addAttribute(LOGIN_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(LOGIN_FORM_NAME,FARMER_LOGIN_URL);
		if(error.hasErrors()){
			LOG.info("has errors");
			return VIEW_NAME;
		}else{
			if(usersService.check(Long.parseLong(formBean.getPhoneNumber())) != 0){
				UsersDaoBean user = usersService.retrive(Long.parseLong(formBean.getPhoneNumber()));
				if(user.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(0)) || user.getUserType().equals(GrowAgricultureConstants.USER_TYPE.get(2))){
					if(user.getPassword().equals(MD5.encryption(formBean.getPassword()))){
						if(user.getOtpVerified() == 1){
							redirectAttributes.addFlashAttribute(USERSDAO_FORM_BEAN_NAME, user);
							request.setSessionAttr("phonenumber", user.getPhonenumber());
							return "redirect:/dashboard";
						}else{
							LOG.info("otp not verified for : "+formBean.getPhoneNumber());
							model.addAttribute(OTP_NOT_VERIFIED, SHOW);
							return VIEW_NAME;
						}
					}else{
						LOG.info("invalid password for : "+formBean.getPhoneNumber());
						model.addAttribute(PASSWORD_INVALID_ERROR, SHOW);
						return VIEW_NAME;
					}
				}else{
					LOG.info("Not registered as farmer or both :: "+formBean.getPhoneNumber());
					model.addAttribute(USER_TYPE, GrowAgricultureConstants.USER_TYPE.get(0));
					model.addAttribute(WRONG_USER_TYPE, SHOW);
					return VIEW_NAME;
				}
			}else{
				LOG.info("no user exists for : "+formBean.getPhoneNumber());
				model.addAttribute(NO_USER_EXISTS, SHOW);
				return VIEW_NAME;
			}
		}
	}

	/*@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new LoginValidator());
	}*/
}
