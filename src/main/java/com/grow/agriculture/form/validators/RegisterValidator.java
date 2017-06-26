package com.grow.agriculture.form.validators;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.service.ConfigurationService;

public class RegisterValidator implements Validator {

	@Autowired
	ConfigurationService configurationService;

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterFormBean.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors){
		RegisterFormBean formBean = (RegisterFormBean) obj;
		try {
			if(formBean.getPhoneNumber().length() < 10){
				errors.rejectValue("phonenumber", "formbean.phonenumber", configurationService.getConfiguration().getString(GrowAgricultureConstants.INVALID_PHONENUMBER_ENTERED));
			}
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

}
