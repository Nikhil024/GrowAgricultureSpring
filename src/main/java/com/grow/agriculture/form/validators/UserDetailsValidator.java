package com.grow.agriculture.form.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grow.agriculture.beans.LoginFormBean;
import com.grow.agriculture.beans.UserDetailsFormBean;

public class UserDetailsValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		if(LoginFormBean.class.equals(clazz)){
			return true;
		}
		return false;
	}

	

	@Override
	public void validate(Object obj, Errors errors) {
		UserDetailsFormBean ub = (UserDetailsFormBean) obj; 
		
	}

}
