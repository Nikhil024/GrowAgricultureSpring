package com.grow.agriculture.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoBean.User;

@Repository
public class UsersDaoImpl implements UsersDao {
	private static final Logger LOG = Logger.getLogger(UsersDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public User get(long phonenumber) {
			return sessionFactory.getCurrentSession().get(User.class, Long.valueOf(phonenumber));
	}
	

	@Override
	public List<User> list(){
		return sessionFactory.getCurrentSession().createQuery("").setParameter("","").getResultList();
	}
	
	
	@Override
	public boolean createNewUser(User user) {
		try {
		sessionFactory.getCurrentSession().persist(user);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteUser(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

}
