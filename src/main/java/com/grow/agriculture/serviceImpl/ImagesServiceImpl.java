<<<<<<< HEAD
package com.grow.agriculture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.dao.ImagesDao;
import com.grow.agriculture.daoBean.Images;
import com.grow.agriculture.service.ImagesService;

public class ImagesServiceImpl implements ImagesService {

	@Autowired
	ImagesDao imagesDao;
	
	
	@Override
	public void save(Images images) {
		imagesDao.save(images);

	}

	@Override
	public Images retrive(int users_id) {
		return imagesDao.retrive(users_id);
	}

	@Override
	public int check(int users_id) {
		return imagesDao.check(users_id);
	}

	@Override
	public int update(Images images) {
		return imagesDao.update(images);
	}

	@Override
	public int delete(int users_id) {
		return imagesDao.delete(users_id);
	}

	@Override
	public List<Images> getPicsOfOtherThanCurrentUser(int users_id) {
		return imagesDao.getPicsOfOtherThanCurrentUser(users_id);
	}
	
	@Override
	public List<Images> getPicsOfCurrentUser(int users_id) {
		return imagesDao.getPicsOfCurrentUser(users_id);
	}

}
=======
package com.grow.agriculture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.dao.ImagesDao;
import com.grow.agriculture.daoBean.ImagesDaoBean;
import com.grow.agriculture.service.ImagesService;

public class ImagesServiceImpl implements ImagesService {

	@Autowired
	ImagesDao imagesDao;
	
	
	@Override
	public void save(ImagesDaoBean images) {
		imagesDao.save(images);

	}

	@Override
	public ImagesDaoBean retrive(int users_id) {
		return imagesDao.retrive(users_id);
	}

	@Override
	public int check(int users_id) {
		return imagesDao.check(users_id);
	}

	@Override
	public int update(ImagesDaoBean images) {
		return imagesDao.update(images);
	}

	@Override
	public int delete(int users_id) {
		return imagesDao.delete(users_id);
	}

	@Override
	public List<ImagesDaoBean> getPicsOfOtherThanCurrentUser(int users_id) {
		return imagesDao.getPicsOfOtherThanCurrentUser(users_id);
	}
	
	@Override
	public List<ImagesDaoBean> getPicsOfCurrentUser(int users_id) {
		return imagesDao.getPicsOfCurrentUser(users_id);
	}

	@Override
	public List<ImagesDaoBean> getAllPics() {
		return imagesDao.getAllPics();
	}
	
	

}
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
