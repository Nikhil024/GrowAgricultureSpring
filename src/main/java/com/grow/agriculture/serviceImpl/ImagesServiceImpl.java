package com.grow.agriculture.serviceImpl;

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

}
