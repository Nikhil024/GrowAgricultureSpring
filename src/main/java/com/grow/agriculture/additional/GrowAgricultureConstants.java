package com.grow.agriculture.additional;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

public class GrowAgricultureConstants {
	
	public static final String PROJECT_NAME = "growAgriculture.project.name";
	public static final String LANDING_PAGE_LOGO_IMAGE_NAME = "growAgriculture.landingMainPage.logo.image.name";
	public static final String LANDING_PAGE_DESCRIPTION = "growAgriculture.landingMainPage.description";
	public static final String LANDING_PAGE_BACKGROUND_IMAGE_NAME = "growAgriculture.landingMainPage.background.image.name";
	public static final String LOGIN_PAGE_FARMER_BACKGROUND_IMAGE_NAME = "growAgriculture.Login.farmer.background.image.name";
	public static final String LOGIN_PAGE_BUYER_BACKGROUND_IMAGE_NAME = "growAgriculture.Login.buyer.background.image.name";
	public static final String REGISTER_PAGE_BACKGROUND_IMAGE_NAME= "growAgriculture.Register.background.image.name";
	public static final String FORGOTPASSWORD_PAGE_BACKGROUND_IMAGE_NAME = "growAgriculture.ForgotPassword.background.image.name";
	public static final String ABOUTUS_PAGE_BACKGROUND_IMAGE_NAME = "growAgriculture.aboutUs.background.image.name";
	public static final String LOGIN_TITLE_NAME = "growAgriculture.login.title.name";
	public static final String ABOUTUS_TITLE_NAME = "growAgriculture.aboutUs.title.name";
	public static final String FORGOTPASSWORD_TITLE_NAME = "growAgriculture.forgotPassword.title.name";
	public static final String REGISTER_TITLE_NAME = "growAgriculture.Register.title.name";
	public static final String BUYERLOGIN_TITLE_NAME = "growAgriculture.buyerLogin.title.name";
	public static final String FARMERLOGIN_TITILE_NAME = "growAgriculture.farmerLogin.title.name";
	public static final String LOGINANDREGISTER_INPUT_PLACEHOLDER_TEXT = "growAgriculture.loginAndRegister.input.placeholder.text";
	public static final String INVALID_PHONENUMBER_ENTERED = "growAgriculture.invalid.phonenumber.input.message";
	public static final String INVALID_PASSWORD_ENTERED = "growAgriculture.invalid.password.input.message";
	public static final String OTP_PLACEHOLDER_NAME = "growAgriculture.otp.input.placeholder.text";
	public static final String OTP_TITLE_NAME = "growAgriculture.otp.title.name";
	public static final String OTP_WEBPAGE_NAME = "growAgriculture.otp.page.title.name";
	public static final String OTP_BUTTON_NAME = "growAgriculture.otp.button.name";
	public static final String OPT_BACKGROUND_IMAGE_NAME = "growAgriculture.otp.page.background.image.name";
	public static final List<String> USER_TYPE_URL = Collections.unmodifiableList(Arrays.asList("farmerRegister", "buyerRegister"));
	public static final List<String> USER_TYPE = Collections.unmodifiableList(Arrays.asList("farmer", "buyer", "both"));
	public static final String OTP_2FACTOR_API_KEY = "growAgriculture.2factor.otp.api.key";
	public static final String OTP_2FACTOR_MAIN_URL = "growAgriculture.2factor.otp.main.url";
	public static final String OTP_2FACTOR_OTP_CHECK_URL = "growAgriculture.2factor.otp.check.url";
	public static final String PROFILE_IMAGE_STORE_LOCATION = File.separator +"GAPics"+ File.separator +"profile";
	public static final String OTHER_IMAGE_PROFILE_STORE_LOCATION = File.separator +"GAPics"+ File.separator +"other";
	public static final List<String> IMAGES_TYPES = Collections.unmodifiableList(Arrays.asList("profile", "other"));
	public static final String CATALINA_HOME_LOCATION = System.getProperty("catalina.home");
	public static final String UPLOAD_IMAGE_FILE_EXTENSION = ".png";
}
