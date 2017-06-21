package com.grow.agriculture;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grow.agriculture.service.ConfigurationService;

@Controller
public class LoginPageComponentController {

	private static final Logger LOG = Logger.getLogger(LoginPageComponentController.class);

	/*@Autowired
	JsonReaderService jsonReadService;*/

	@Autowired
	ConfigurationService configurationService;

	private static final String VIEW_NAME = "loginPageComponent";

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginGetComponent(Model model) throws ConfigurationException{
		model.addAttribute("","");
		
		
		
		return VIEW_NAME;
	}

}
