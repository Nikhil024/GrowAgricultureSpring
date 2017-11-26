package com.grow.agriculture.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grow.agriculture.dao.UsersDao;
<<<<<<< HEAD
import com.grow.agriculture.daoBean.User;
=======
import com.grow.agriculture.daoBean.UsersDaoBean;
import com.grow.agriculture.rowmapper.ImagesRowMapper;
import com.grow.agriculture.rowmapper.UserRowMapper;
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d

@Repository
public class UsersDaoImpl implements UsersDao {
	private static final Logger LOG = Logger.getLogger(UsersDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
<<<<<<< HEAD
=======
	private String createUserQuery = "INSERT INTO USERS (ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,OTP_VERIFIED,CREATED_DATE,LAST_UPDATE) VALUES (USERS_ID.NEXTVAL,:username,:phonenumber,:password,:email,:userType,:otp_verified,:createdDate,:lastUpdate)";
	private String deleteUserQuery = "DELETE FROM USERS WHERE PHONENUMBER=:phonenumber";
	private String selectUserQuery = "SELECT ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,OTP_VERIFIED,CREATED_DATE,LAST_UPDATE FROM USERS WHERE PHONENUMBER=:phonenumber";
	private String selectIfUserExistsQuery = "SELECT count(1) FROM USERS where PHONENUMBER=:phonenumber";
	private String UpdateUserQuery = "UPDATE USERS SET OTP_VERIFIED=:valuename where PHONENUMBER=:phonenumber";
	private String selectIfFarmer = "SELECT count(1) FROM USERS where PHONENUMBER=:phonenumber AND USER_TYPE=";
	private String selectIfBuyer = "SELECT count(1) FROM USERS where PHONENUMBER=:phonenumber";
	private String selectAllFarmers="SELECT ID,NAME,PHONENUMBER,PASSWORD,EMAIL,USER_TYPE,OTP_VERIFIED,CREATED_DATE,LAST_UPDATE FROM USERS WHERE USER_TYPE=:userType";
	
	
	
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d
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
	
	@Override
	public List<UsersDaoBean> getAllUsers(){
	String query = selectAllFarmers;
	 Map<String, Object> parameters = new HashMap<String, Object>();
     parameters.put("userType", "farmer");
		 MapSqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	return namedParameterJdbcTemplate.query(query,namedParameters, new UserRowMapper());
	}

}
