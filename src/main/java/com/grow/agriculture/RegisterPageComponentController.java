package com.grow.agriculture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterPageComponentController {
	public static final String VIEW_NAME = "registerPageComponent";

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(){
		return VIEW_NAME;
	}
	
}
