package com.grow.agriculture.dao;

import com.grow.agriculture.daoBean.ImagesDaoBean;

public interface ImagesDao {
	public void save(ImagesDaoBean images);
	public ImagesDaoBean retrive(int users_id);
	public int check(int users_id);
	public int update(ImagesDaoBean images);
	public int delete(int users_id);
}
