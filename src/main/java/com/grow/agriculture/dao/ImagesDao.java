package com.grow.agriculture.dao;

import java.util.List;

<<<<<<< HEAD
import com.grow.agriculture.daoBean.Images;
=======
import com.grow.agriculture.daoBean.ImagesDaoBean;
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d

public interface ImagesDao {
	public void save(Images images);
	public Images retrive(int users_id);
	public int check(int users_id);
	public int update(Images images);
	public int delete(int users_id);
<<<<<<< HEAD
	public List<Images> getPicsOfOtherThanCurrentUser(int users_id);
	public List<Images> getPicsOfCurrentUser(int users_id);
=======
	public List<ImagesDaoBean> getPicsOfOtherThanCurrentUser(int users_id);
	public List<ImagesDaoBean> getPicsOfCurrentUser(int users_id);
	public List<ImagesDaoBean> getAllPics();
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
}
