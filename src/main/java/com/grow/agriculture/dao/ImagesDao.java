package com.grow.agriculture.dao;

import java.util.List;

import com.grow.agriculture.daoBean.Images;

public interface ImagesDao {
	public void save(Images images);
	public Images retrive(int users_id);
	public int check(int users_id);
	public int update(Images images);
	public int delete(int users_id);
	public List<Images> getPicsOfOtherThanCurrentUser(int users_id);
	public List<Images> getPicsOfCurrentUser(int users_id);
}
