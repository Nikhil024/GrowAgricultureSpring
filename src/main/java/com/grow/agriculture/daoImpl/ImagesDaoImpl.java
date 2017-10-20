package com.grow.agriculture.daoImpl;

import java.io.ByteArrayInputStream;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;

import com.grow.agriculture.dao.ImagesDao;
import com.grow.agriculture.daoBean.ImagesDaoBean;

@Repository
public class ImagesDaoImpl  implements ImagesDao{
	private static final Logger LOG = Logger.getLogger(ImagesDaoImpl.class);
	
	private String save = "INSERT INTO IMAGES (ID,IMAGE,USERS_ID,IMAGE_NAME,IMAGE_SIZE,IMAGE_TYPE) VALUES (IMAGES_ID.NEXTVAL,:name,:users_id,:image_name,:image_size,:image_type)"; 
	private String retrive = "SELECT ID,IMAGE,USERS_ID,IMAGE_NAME,IMAGE_SIZE,IMAGE_TYPE FROM IMAGES WHERE USERS_ID=:users_id";
	private String check = "SELECT COUNT(1) FROM IMAGES WHERE USERS_ID=:users_id";
	private String update = "UPDATE IMAGES SET IMAGE=:image where USERS_ID=:users_id";
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	@Override
	public void save(byte[] imageData) {
		String query = save;
		 try {
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            
	            parameters.put("image", new SqlLobValue(new ByteArrayInputStream(imageData), 
	                    imageData.length, new DefaultLobHandler()), Types.BLOB);
	            
	            SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
	            
	            
	            int count = namedParameterJdbcTemplate.update(query, namedParameters);
	        } catch (EmptyResultDataAccessException e) {
	            LOG.info("No image found");
	        }
	}
	@Override
	public ImagesDaoBean retrive(int users_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int check(int users_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(int users_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
