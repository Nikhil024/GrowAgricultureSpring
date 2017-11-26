package com.grow.agriculture.controllers;



import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.service.ConfigurationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LandingPageComponentController {
	
	@Autowired
	ConfigurationService configurationService;
	
	public static final String VIEW_NAME =  "landingPageComponent";
	public static final String LANDING_PAGE_LOGO_IMAGE_NAME = "landing_page_logo_image_name";
	public static final String LANDING_PAGE_BACKGROUND_IMAGE_NAME = "landing_page_background_image_name";
	public static final String LANDING_PAGE_DESCRIPTION = "landing_page_description";
	public static final String LANDING_PAGE_LOGIN_TEXT = "login";
	public static final String LANDING_PAGE_ABOUTUS = "aboutus";
	public static final String REGISTER_PAGE_REGISTER_TEXT = "register";
	
	private static final Logger log = LoggerFactory.getLogger(LandingPageComponentController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String landingPageMethod(Model model) throws ConfigurationException{
		model.addAttribute(LANDING_PAGE_LOGO_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LANDING_PAGE_LOGO_IMAGE_NAME));
		model.addAttribute(LANDING_PAGE_BACKGROUND_IMAGE_NAME,configurationService.getConfiguration().getString(GrowAgricultureConstants.LANDING_PAGE_BACKGROUND_IMAGE_NAME));
		model.addAttribute(LANDING_PAGE_DESCRIPTION,configurationService.getConfiguration().getString(GrowAgricultureConstants.LANDING_PAGE_DESCRIPTION));
		model.addAttribute(LANDING_PAGE_LOGIN_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.LOGIN_TITLE_NAME));
		model.addAttribute(LANDING_PAGE_ABOUTUS,configurationService.getConfiguration().getString(GrowAgricultureConstants.ABOUTUS_TITLE_NAME));
		model.addAttribute(REGISTER_PAGE_REGISTER_TEXT,configurationService.getConfiguration().getString(GrowAgricultureConstants.REGISTER_TITLE_NAME));
		return VIEW_NAME;
	}
}
