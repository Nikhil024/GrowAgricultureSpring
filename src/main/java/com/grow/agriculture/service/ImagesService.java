package com.grow.agriculture.service;

import java.util.List;

import com.grow.agriculture.daoBean.ImagesDaoBean;

public interface ImagesService {
	public void save(ImagesDaoBean images);
	public ImagesDaoBean retrive(int users_id);
	public int check(int users_id);
	public int update(ImagesDaoBean images);
	public int delete(int users_id);
	public List<ImagesDaoBean> getPicsOfOtherThanCurrentUser(int users_id);
	public List<ImagesDaoBean> getPicsOfCurrentUser(int users_id);
	public List<ImagesDaoBean> getAllPics();
}
