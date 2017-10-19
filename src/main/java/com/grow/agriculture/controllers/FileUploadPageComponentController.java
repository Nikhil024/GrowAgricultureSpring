package com.grow.agriculture.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grow.agriculture.helper.MD5PasswordEncryptionHelper;

@Controller
public class FileUploadPageComponentController {
	private static final Logger LOG = Logger.getLogger(FileUploadPageComponentController.class);

	@Autowired
	MD5PasswordEncryptionHelper MD5;
	
	@Autowired
	GrowAgricultureRequest request;
	
	private static final String CATALINA_HOME_LOCATION = System.getProperty("catalina.home");
	private static final String UPLOAD_ACTIVE = "uploadActive";
	private static final boolean SHOW = true;
	private static final String CURRENT_PAGE = "currentpage";
	private String PAGE_NAME = null;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getFileUploadComponent(Model model){
		LOG.info("catalinahomelocation: "+CATALINA_HOME_LOCATION);
		LOG.info("is linux : "+SystemUtils.IS_OS_LINUX);
		model.asMap().clear();
		model.addAttribute(UPLOAD_ACTIVE, SHOW);
		
		PAGE_NAME = request.getSessionAttr(CURRENT_PAGE).toString();
		
		
		return "forward:/"+PAGE_NAME;
	}
}
