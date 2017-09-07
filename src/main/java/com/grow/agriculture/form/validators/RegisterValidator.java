package com.grow.agriculture.form.validators;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.service.ConfigurationService;

public class RegisterValidator implements Validator {

	private static final Logger LOG = Logger.getLogger(RegisterValidator.class);

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
			
				LOG.info("entered the non otp section");
				if(formBean.getPhoneNumber() == null || formBean.getPhoneNumber().equals("")){
					errors.rejectValue("phoneNumber", "formbean.phoneNumber", "Please enter a number");
				}
				if(formBean.getPhoneNumber() != null && !formBean.getPhoneNumber().isEmpty()){
					if(formBean.getPhoneNumber().length() < 10 || formBean.getPhoneNumber().length() > 10){
						errors.rejectValue("phoneNumber", "formbean.phoneNumber", "invalidnumber");
					}
				}
				if(formBean.getPassword() == null || formBean.getPassword().equals("")){
					errors.rejectValue("password", "formbean.password", "Please enter a password");
				}
				
				if(formBean.getPassword() != null && !formBean.getPassword().isEmpty()){
					if(formBean.getPassword().length() < 6){
					errors.rejectValue("password", "formbean.password", "Please enter min 6 characters as password");
					}
				}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
