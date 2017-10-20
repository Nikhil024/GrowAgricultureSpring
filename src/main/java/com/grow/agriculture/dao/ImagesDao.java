package com.grow.agriculture.dao;

import com.grow.agriculture.daoBean.ImagesDaoBean;

public interface ImagesDao {
	public void save();
	public ImagesDaoBean retrive(int users_id);
	public int check(int users_id);
	public int update(int users_id);

}
