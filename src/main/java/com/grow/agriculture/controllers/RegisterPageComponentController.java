package com.grow.agriculture.controllers;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.OTPFormBean;
import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.helper.OTPHelper;
import com.grow.agriculture.helper.UsersHelper;
import com.grow.agriculture.service.ConfigurationService;
import com.grow.agriculture.service.JsonReaderService;
import com.grow.agriculture.service.OTPService;
import com.grow.agriculture.service.UsersService;

@Controller
@RequestMapping("/register")
@SessionAttributes("RegisterFormBean")
public class RegisterPageComponentController {
	private static final Logger LOG = Logger.getLogger(RegisterPageComponentController.class);


	@Autowired
	GrowAgricultureRequest request;

	@Autowired
	ConfigurationService configurationService;

	/** The validator. */
	@Autowired
	@Qualifier("otpValidator")
	Validator otpValidator;

	@Autowired
	@Qualifier("registerValidator")
	Validator registerFormValidator;

	@Autowired
	UsersService usersService;

	@Autowired
	OTPService otpService;

	@Autowired
	UsersHelper usersHelper;

	@Autowired
	OTPHelper otpHelper;

	@Autowired
	JsonReaderService jsonReaderService;

	private static final String VIEW_NAME = "registerPageComponent";
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
	private static final String SHOW_USER_ALREADY_EXISTS_SECTION = "showUserAlreadyExists";
	private static final String SHOW_RESEND_OTP = "showResendOTP";
	private static final boolean SHOW_OTP = true;
	private static final String PHONE_NUMBER = "phoneNumber";
	private static final String OTP_MATCHED = "OTP Matched";
	private static final String OTP_VERIFIED = "OTP_VERIFIED";



	@RequestMapping(value="/buyerRegister", method = RequestMethod.GET)
	public String buyerRegisterGetMethodComponent(Model model) throws ConfigurationException{
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
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
	public String buyerRegisterPostMethodComponent(@ModelAttribute(REGISTER_FORM_BEAN_NAME) RegisterFormBean formBean,BindingResult result,Model model,final RedirectAttributes redirectAttributes) throws ConfigurationException{
		formBean.setIsFarmer(false);
		LOG.info("this is the buyer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_NAME,BUYER_REGISTER_URL);
		if(result.hasErrors()){
			LOG.info("has errors");
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			if(usersService.check(Long.parseLong(formBean.getPhoneNumber())) == 0){
				usersService.save(usersHelper.getUsersBean(formBean));
				String URL = configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_2FACTOR_MAIN_URL);
				URL = URL.replaceAll("api_key",configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_2FACTOR_API_KEY));
				URL = URL.replace("{phone_number}", formBean.getPhoneNumber());
				LOG.info("total url::: "+URL);

				String checkOTP = jsonReaderService.sendRestUrl(URL);
				if(checkOTP != null){
					if(!checkOTP.equals("Error")){
						formBean.setSessionId(checkOTP);

						String demo = jsonReaderService.sendRestUrl(URL);
						if(demo != null){
							if(!demo.equals("Error")){
								formBean.setSessionId(demo);

								redirectAttributes.addFlashAttribute(REGISTER_FORM_BEAN_NAME, formBean);
								return "redirect:/register/buyerRegister/otp"; //+request.getSiteURL() + request.getContextPath() + File.separator +configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME).toLowerCase()+File.separator+FARMER_REGISTER_URL+File.separator+OTP;

							}else{
								return "errorpage";
							}
						}else{
							return "errorpage";
						}
					}
					else{
						model.addAttribute(SHOW_USER_ALREADY_EXISTS_SECTION,true);
						return VIEW_NAME;
					}
				}
			}
		}
		return null;
	}


	@RequestMapping(value="/farmerRegister", method = RequestMethod.GET)
	public String farmeRegisterGetMethodComponent(Model model) throws ConfigurationException{
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setShowOTP(false);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_BEAN_NAME, formBean);
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL);
		return VIEW_NAME;
	}


	@RequestMapping(value="/farmerRegister", method = RequestMethod.POST)
	public String farmerRegisterPostMethodComponent(@ModelAttribute(REGISTER_FORM_BEAN_NAME) RegisterFormBean formBean,BindingResult result,Model model,final RedirectAttributes redirectAttributes) throws ConfigurationException{
		formBean.setIsFarmer(true);
		registerFormValidator.validate(formBean, result);
		LOG.info("this is the farmer login form bean "+formBean);
		model.addAttribute(PROJECT_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.PROJECT_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_FORGOTPASSWORD_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.FORGOTPASSWORD_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT));
		model.addAttribute(REGISTER_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL);
		if(result.hasErrors()){
			LOG.info("has errors"+result.getAllErrors());
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			if(usersService.check(Long.parseLong(formBean.getPhoneNumber())) == 0){
				usersService.save(usersHelper.getUsersBean(formBean));
				String URL = configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_2FACTOR_MAIN_URL);
				URL = URL.replaceAll("api_key",configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_2FACTOR_API_KEY));
				URL = URL.replace("{phone_number}", formBean.getPhoneNumber());
				LOG.info("total url::: "+URL);
				String checkOTP = jsonReaderService.sendRestUrl(URL);
				if(checkOTP != null){
					if(!checkOTP.equals("Error")){
						formBean.setSessionId(checkOTP);
						redirectAttributes.addFlashAttribute(REGISTER_FORM_BEAN_NAME, formBean);
						return "redirect:/register/farmerRegister/otp"; //+request.getSiteURL() + request.getContextPath() + File.separator +configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME).toLowerCase()+File.separator+FARMER_REGISTER_URL+File.separator+OTP;

					}else{
						return "errorpage";
					}
				}else{
					return "errorpage";
				}
			}
			else{
				model.addAttribute(SHOW_USER_ALREADY_EXISTS_SECTION,true);
				return VIEW_NAME;
			}
		}
	}

	@RequestMapping(value="/{userType}/otp",method=RequestMethod.GET)
	public String farmerGetRegisterOTP(Model model,@PathVariable("userType") String userType,@ModelAttribute(value = REGISTER_FORM_BEAN_NAME) RegisterFormBean registerFormBean) throws ConfigurationException{
		if(registerFormBean.getPhoneNumber() != null ){
			if(GrowAgricultureConstants.USER_TYPE_URL.contains(userType)){
				model.addAttribute(SHOW_OTP_SECTION,SHOW_OTP);
				model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_PLACEHOLDER_NAME));
				model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_TITLE_NAME));
				model.addAttribute(REGISTER_PAGE_ABOUTUS_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
				model.addAttribute(REGISTER_FORM_BEAN_NAME, new OTPFormBean());
				model.addAttribute(PHONE_NUMBER, registerFormBean.getPhoneNumber());
				model.addAttribute("sessionId", registerFormBean.getSessionId());
				model.addAttribute("userType",userType);
				model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
				model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.OPT_BACKGROUND_IMAGE_NAME));
				model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL+File.separator+OTP);
				return VIEW_NAME;
			}else{
				return "errorPage";
			}
		}else{
			return "errorPage";
		}
	}

	@RequestMapping(value = "/{userType}/otp",method = RequestMethod.POST)
	public String farmerPostRegisterOTP(@ModelAttribute(REGISTER_FORM_BEAN_NAME) OTPFormBean formBean,BindingResult result,@PathVariable("userType") String userType,Model model) throws ConfigurationException{
		otpValidator.validate(formBean, result);
		model.addAttribute(REGISTER_PLACEHOLDER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_PLACEHOLDER_NAME));
		model.addAttribute(REGISTER_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.OPT_BACKGROUND_IMAGE_NAME));
		model.addAttribute(REGISTER_PAGE_USER_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		model.addAttribute(REGISTER_FORM_NAME,FARMER_REGISTER_URL+File.separator+OTP);

		model.addAttribute(SHOW_OTP_SECTION,true);
		UsersDaoBean usersDaoBean = usersService.retrive(Long.parseLong(formBean.getPhoneNumber()));
		formBean.setUserId(String.valueOf(usersDaoBean.getId()));

		String URL = configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_2FACTOR_OTP_CHECK_URL);
		URL = URL.replaceAll("api_key",configurationService.getConfiguration().getString(GrowAgricultureConstants.OTP_2FACTOR_API_KEY));
		URL = URL.replace("{session_id}", formBean.getSessionId());
		URL = URL.replace("{otp_entered_by_user}", formBean.getOTP());
		String checkOTP = jsonReaderService.sendRestUrl(URL);

		if(checkOTP != null){
			if(!checkOTP.equals("Error")){
				if(checkOTP.equals(OTP_MATCHED)){
					otpService.save(otpHelper.getOtpBean(formBean));
					usersService.update(OTP_VERIFIED, 1, formBean.getPhoneNumber());
					model.addAttribute("showRegsiterSuccess",true);
					return VIEW_NAME;
				}
			}
		}


		if(result.hasErrors()){
			LOG.info("has errors");
			model.addAttribute(SHOW_RESEND_OTP,SHOW_OTP);
			return VIEW_NAME;
		}else{
			LOG.info("No errors");
			return "landingPage";
		}
	}


	/*@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new RegisterValidator());
		binder.addValidators(new OTPValidator());
	}*/

}
