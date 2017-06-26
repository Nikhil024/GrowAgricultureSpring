package com.grow.agriculture.form.validators;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grow.agriculture.beans.LoginFormBean;

public class LoginValidator implements Validator {
	private static final Logger LOG = Logger.getLogger(LoginValidator.class);
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		if(LoginFormBean.class.equals(clazz)){
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		LoginFormBean formBean = (LoginFormBean) obj;
		
		if(formBean.getPhoneNumber().length() < 10){
			errors.rejectValue("phoneNumber","loginformbean.phoneNumber","Please enter the phone number correctly.");
		}
		
		if(formBean.getPassword().length() < 6){
			errors.rejectValue("password", "loginformbean.password", "Please enter minimum 6 characters as password.");
		}
		
	}

}
