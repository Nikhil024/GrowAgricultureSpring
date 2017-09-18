package com.grow.agriculture.form.validators;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grow.agriculture.beans.OTPFormBean;

public class OTPValidator implements Validator {
	private static final Logger LOG = Logger.getLogger(OTPValidator.class);


	@Override
	public boolean supports(Class<?> clazz) {
		return OTPFormBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OTPFormBean formBean = (OTPFormBean) target;

		if(formBean.getOTP() == null || formBean.getOTP().equals("")){
			LOG.info("entered the otp null section");
			errors.rejectValue("OTP", "formBean.OTP", "please enter a OTP.");
		}

		if(!(formBean.getOTP() == null || formBean.getOTP().equals(""))){

			if(formBean.getOTP().length() < 4){
				errors.rejectValue("OTP", "formBean.OTP", "invalid OTP. Please retry again.");
			}
		}
	}

}
