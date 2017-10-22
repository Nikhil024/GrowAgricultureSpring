package com.grow.agriculture.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grow.agriculture.additional.GrowAgricultureConstants;
import com.grow.agriculture.daoBean.Images;
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.helper.MD5PasswordEncryptionHelper;
import com.grow.agriculture.service.ImagesService;
import com.grow.agriculture.service.UsersService;

@Controller
public class FileUploadPageComponentController {
	private static final Logger LOG = Logger.getLogger(FileUploadPageComponentController.class);

	@Autowired
	GrowAgricultureRequest request;

	@Autowired
	ImagesService imagesService;

	@Autowired
	UsersService userService;



	private static final String UPLOAD_ACTIVE = "uploadActive";
	private static final String DASHBOARD_ACTIVE = "dashboardActive";
	private static final String PROFILE_ACTIVE = "profileActive";
	private static final String FARMERSLIST_ACTIVE = "farmersListActive";
	private static final String ABOUTUS_ACTIVE = "aboutusActive";
	private static final String PHONENUMBER = "phonenumber";
	private static final String CURRENT_PAGE = "currentpage";
	private String PAGE_NAME = null;
	private File IMAGES_STORE_LOCATION = null;
	private static final boolean SHOW = true;
	private static final String LOGIN = "login";

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getFileUploadComponent(Model model){
		if(request.getSessionAttr(CURRENT_PAGE) != null || request.getSessionAttr(PHONENUMBER) != null ) {
			PAGE_NAME = request.getSessionAttr(CURRENT_PAGE).toString();
			LOG.info("catalinahomelocation: "+GrowAgricultureConstants.CATALINA_HOME_LOCATION);
			LOG.info("is linux : "+SystemUtils.IS_OS_LINUX);

			model.addAttribute(DASHBOARD_ACTIVE,"");
			model.addAttribute(PROFILE_ACTIVE,"");
			model.addAttribute(FARMERSLIST_ACTIVE,"");
			model.addAttribute(ABOUTUS_ACTIVE,"");

			model.addAttribute(UPLOAD_ACTIVE, SHOW);

			return "forward:/"+PAGE_NAME;
		}else {
			return "redirect:/"+LOGIN;
		}
	}


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String postFileUploadComponent(Model model,@RequestParam("file") MultipartFile file,@RequestParam("imageType") String imageType) throws IOException{

		if(request.getSessionAttr(PHONENUMBER) != null) {

			PAGE_NAME = request.getSessionAttr(CURRENT_PAGE).toString();

			LOG.info("catalinahomelocation: "+GrowAgricultureConstants.CATALINA_HOME_LOCATION);

			if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(0))) {
				IMAGES_STORE_LOCATION = new File(GrowAgricultureConstants.CATALINA_HOME_LOCATION+GrowAgricultureConstants.PROFILE_IMAGE_STORE_LOCATION);
			}else if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(1))) {
				IMAGES_STORE_LOCATION = new File(GrowAgricultureConstants.CATALINA_HOME_LOCATION+GrowAgricultureConstants.OTHER_IMAGE_PROFILE_STORE_LOCATION);
			}

			if (!IMAGES_STORE_LOCATION.exists()) {
				IMAGES_STORE_LOCATION.mkdirs();
			}

			String filename = file.getOriginalFilename();
			String GENERATEDSTRING = RandomStringUtils.randomAlphanumeric(10);

			LOG.info("Location of catilana "+IMAGES_STORE_LOCATION+File.separator+filename);
			if(filename.contains(".jpg")||filename.contains(".png")||filename.contains(".jpeg")){

				if (!file.isEmpty()) {

					UsersDaoBean users = userService.retrive(Long.valueOf(request.getSessionAttr(PHONENUMBER).toString()));

					Images images = new Images();
					images.setImage(file.getBytes());
					images.setImageSize((int)file.getSize());
					images.setImageType(imageType);
					
					LOG.info("ALT TEXT :::::: "+GENERATEDSTRING);
					
					if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(0))) {
						images.setName(request.getSessionAttr(PHONENUMBER).toString()+GrowAgricultureConstants.UPLOAD_IMAGE_FILE_EXTENSION);
					}else if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(1))) {
						images.setName(GENERATEDSTRING+GrowAgricultureConstants.UPLOAD_IMAGE_FILE_EXTENSION);
					}
					
					images.setUsersId(users.getId());

					try{
						BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));

						File destination = null;
						
						LOG.info("ALT TEXT :::::: "+GENERATEDSTRING);
						
						if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(0))) {
							destination = new File(IMAGES_STORE_LOCATION+File.separator+request.getSessionAttr(PHONENUMBER).toString()+GrowAgricultureConstants.UPLOAD_IMAGE_FILE_EXTENSION);
						}else if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(1))) {
							destination = new File(IMAGES_STORE_LOCATION+File.separator+GENERATEDSTRING+GrowAgricultureConstants.UPLOAD_IMAGE_FILE_EXTENSION);
						}
						
						
						  // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
						ImageIO.write(src, "png", destination);

						if(imageType.equals(GrowAgricultureConstants.IMAGES_TYPES.get(0))) {
							if(imagesService.check(users.getId()) >= 1) {
								imagesService.update(images);
							}else {						
								imagesService.save(images);
							}
						}else {
							imagesService.save(images);
						}
						//Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
					}
					catch(FileNotFoundException fe){
						LOG.info("FileNotFoundException : "+fe);
						LOG.info("FileNotFoundException : in location : "+IMAGES_STORE_LOCATION);
						model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
						return "forward:/"+PAGE_NAME;
					}
					model.addAttribute("successmessage","Successfully Uploaded the picture.Please refresh this page to see your Uploads.");
					return "forward:/"+PAGE_NAME;
				}
			}
			model.addAttribute("warningmessage","Please Upload a Picture with .jpg,.gif or .png formats. ");
			return "forward:/"+PAGE_NAME;
		}else{
			return null;
		}
	}
}
