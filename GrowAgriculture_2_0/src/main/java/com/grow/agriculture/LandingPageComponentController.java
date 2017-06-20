package com.grow.agriculture;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LandingPageComponentController {
	public static final String VIEW_NAME =  "landingPageComponent";
	
	private static final Logger logger = LoggerFactory.getLogger(LandingPageComponentController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String landingPageMethod(){
		return VIEW_NAME;
	}
}
