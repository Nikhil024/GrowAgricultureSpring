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
	private static final String DASHBOARD_ACTIVE = "dashboardActive";
	private static final String PROFILE_ACTIVE = "profileActive";
	private static final String FARMERSLIST_ACTIVE = "farmersListActive";
	private static final String ABOUTUS_ACTIVE = "aboutusActive";
	private static final boolean SHOW = true;
	private static final String CURRENT_PAGE = "currentpage";
	private String PAGE_NAME = null;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getFileUploadComponent(Model model){
		LOG.info("catalinahomelocation: "+CATALINA_HOME_LOCATION);
		LOG.info("is linux : "+SystemUtils.IS_OS_LINUX);

		model.addAttribute(DASHBOARD_ACTIVE,"");
		model.addAttribute(PROFILE_ACTIVE,"");
		model.addAttribute(FARMERSLIST_ACTIVE,"");
		model.addAttribute(ABOUTUS_ACTIVE,"");
		
		model.addAttribute(UPLOAD_ACTIVE, SHOW);
		
		PAGE_NAME = request.getSessionAttr(CURRENT_PAGE).toString();
		
		
		return "forward:/"+PAGE_NAME;
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String postFileUploadComponent(Model model,@RequestParam("file") MultipartFile file) throws IOException{
		
		String filename = file.getOriginalFilename();
		
		
		LOG.info("catalinahomelocation: "+CATALINA_HOME_LOCATION);
		
		imagestorelocation = new File(catalinahomelocation+windowsimagestorelocation);
		
		if (SystemUtils.IS_OS_LINUX) {
			  imagestorelocation = new File(catalinahomelocation+uniximagesStoreLoacation);
			  log.info("OS is Linux based, image Storage Location is set to : "+imagestorelocation);
		    }
		
		if (!imagestorelocation.exists()) {
			imagestorelocation.mkdirs();
        }
		
		LOG.info("Location of catilana "+imagestorelocation+File.separator+filename);
		if(filename.contains(".jpg")||filename.contains(".png")||filename.contains(".jpeg")){
			
	if (!file.isEmpty()) {
		
		ImagesBean img = new ImagesBean();
		img.setId(users.getId());
		img.setFruitsvegetablesname(filename);
		img.setFruitvegetablespiclocation(imagestorelocation+File.separator+filename);
		img.setUploaddate(CurrentDate.getCurrentDate());
		ImagesDao.insertImagesData(img);
		try{
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 
	 File destination = new File(imagestorelocation+File.separator+filename); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 ImageIO.write(src, "png", destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
	 }
		catch(FileNotFoundException fe){
			LOG.info("FileNotFoundException : "+fe);
			LOG.info("FileNotFoundException : in location : "+imagestorelocation);
			model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
			return "warning";
		}
		model.addAttribute("successmessage","Successfully Uploaded the picture.Please refresh this page to see your Uploads.");
		return "uploadsuccess"; 
		}
}
		model.addAttribute("warningmessage","Please Upload a Picture with .jpg,.gif or .png formats. ");
		return "warning";
		
		
		
		
		
		
		
		
		
		
		
		
		LOG.info("inside the post with finle name value:::: "+filename);
		PAGE_NAME = request.getSessionAttr(CURRENT_PAGE).toString();
		return "forward:/"+PAGE_NAME;
		
	}
	
	
	/* private static final String CATALINA_HOME_LOCATION = System.getProperty("catalina.home");
	
	// @RequestMapping */
	
	/* public String getFileUploadComponent(){
		return null;
	}
	
	@RequestMapping
	public String postFileUploadComponent(Model model,@RequestParam("file") MultipartFile file) throws IOException{
			
			LOG.info("catalinahomelocation: "+CATALINA_HOME_LOCATION);
			
			imagestorelocation = new File(catalinahomelocation+windowsimagestorelocation);
			
			if (SystemUtils.IS_OS_LINUX) {
				  imagestorelocation = new File(catalinahomelocation+uniximagesStoreLoacation);
				  log.info("OS is Linux based, image Storage Location is set to : "+imagestorelocation);
			    }
			
			if (!imagestorelocation.exists()) {
				imagestorelocation.mkdirs();
	        }
			
			String filename = file.getOriginalFilename();
			log.info("Location of catilana "+imagestorelocation+File.separator+filename);
			if(filename.contains(".jpg")||filename.contains(".png")||filename.contains(".jpeg")){
				
		if (!file.isEmpty()) {
			
			ImagesBean img = new ImagesBean();
			img.setId(users.getId());
			img.setFruitsvegetablesname(filename);
			img.setFruitvegetablespiclocation(imagestorelocation+File.separator+filename);
			img.setUploaddate(CurrentDate.getCurrentDate());
			ImagesDao.insertImagesData(img);
			try{
		 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
		 
		 File destination = new File(imagestorelocation+File.separator+filename); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
		 ImageIO.write(src, "png", destination);
		 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
		 }
			catch(FileNotFoundException fe){
				log.info("FileNotFoundException : "+fe);
				log.info("FileNotFoundException : in location : "+imagestorelocation);
				model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
				return "warning";
			}
			model.addAttribute("successmessage","Successfully Uploaded the picture.Please refresh this page to see your Uploads.");
			return "uploadsuccess"; 
			}
	}
			model.addAttribute("warningmessage","Please Upload a Picture with .jpg,.gif or .png formats. ");
			return "warning";
	}*/
	
}
