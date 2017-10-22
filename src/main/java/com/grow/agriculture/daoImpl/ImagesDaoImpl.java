package com.grow.agriculture.daoImpl;

import java.io.ByteArrayInputStream;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
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
import com.grow.agriculture.daoBean.Images;
import com.grow.agriculture.rowmapper.ImagesRowMapper;

@Repository
public class ImagesDaoImpl  implements ImagesDao{
	private static final Logger LOG = Logger.getLogger(ImagesDaoImpl.class);
	
	private String save = "INSERT INTO IMAGES (ID,IMAGE,USERS_ID,IMAGE_NAME,IMAGE_SIZE,IMAGE_TYPE) VALUES (IMAGES_ID.NEXTVAL,:image,:users_id,:image_name,:image_size,:image_type)"; 
	private String retrive = "SELECT ID,IMAGE,USERS_ID,IMAGE_NAME,IMAGE_SIZE,IMAGE_TYPE FROM IMAGES WHERE USERS_ID=:users_id";
	private String check = "SELECT COUNT(1) FROM IMAGES WHERE USERS_ID=:users_id";
	private String update = "UPDATE IMAGES SET IMAGE=:image,IMAGE_NAME=:image_name,IMAGE_SIZE=:image_size,IMAGE_TYPE=:image_type WHERE USERS_ID=:users_id";
	private String delete = "DELETE FROM IMAGES WHERE USERS_ID=:users_id";
	private String getallpicswithoutCurrentUser = "SELECT ID,IMAGE,USERS_ID,IMAGE_NAME,IMAGE_SIZE,IMAGE_TYPE FROM IMAGES WHERE IMAGE_TYPE=:image_type AND USERS_ID !=:users_id";
	private String getallpicsofcurrentuser = "SELECT ID,IMAGE,USERS_ID,IMAGE_NAME,IMAGE_SIZE,IMAGE_TYPE FROM IMAGES WHERE IMAGE_TYPE=:image_type AND USERS_ID =:users_id";
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;
	
	@Override
	public void save(Images images) { 
		String query = save;
		 try {
	           /* Map<String, Object> parameters = new HashMap<String, Object>();*/
	            
	            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	            
	            namedParameters.addValue("users_id", images.getUsersId());
	            namedParameters.addValue("image_name",images.getName());
	            namedParameters.addValue("image_size",images.getImageSize());
	            namedParameters.addValue("image_type",images.getImageType());
	            namedParameters.addValue("image",  new SqlLobValue(new ByteArrayInputStream(images.getImage()), 
	            		images.getImage().length, new DefaultLobHandler()), Types.BLOB);
	            
	            int count = namedParameterJdbcTemplate.update(query, namedParameters);
	            
	            if(count>=1) {
	            	LOG.info("inserted image to db");
	            }
	            
	        } catch (EmptyResultDataAccessException e) {
	            LOG.info("No image found");
	        }
	}
	@Override
	public Images retrive(int users_id) {
		String query = retrive;
		 try {
	           Map<String, Object> parameters = new HashMap<String, Object>();
	           parameters.put("users_id", users_id);
			 MapSqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
			 
			Images images =  namedParameterJdbcTemplate.queryForObject(query, namedParameters,new ImagesRowMapper());
			return images;
			 
		 } catch (EmptyResultDataAccessException e) {
			 return null;
		 }
		
	}
	@Override
	public int check(int users_id) {
		String query = check;
	           Map<String, Object> parameters = new HashMap<String, Object>();
	           parameters.put("users_id", users_id);
			 MapSqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
			 
			 return namedParameterJdbcTemplate.queryForObject(query, namedParameters, Integer.class);
	}
	@Override
	public int update(Images images) {
		String query = update;
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        
        namedParameters.addValue("image_name",images.getName());
        namedParameters.addValue("image_size",images.getImageSize());
        namedParameters.addValue("image_type",images.getImageType());
        namedParameters.addValue("image",  new SqlLobValue(new ByteArrayInputStream(images.getImage()), 
        		images.getImage().length, new DefaultLobHandler()), Types.BLOB);
        namedParameters.addValue("users_id", images.getUsersId());
        return namedParameterJdbcTemplate.update(query, namedParameters);
	}
	
	@Override
	public int delete(int users_id) {
		String query = delete;
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("users_id", users_id);
		 MapSqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		 
		 return namedParameterJdbcTemplate.update(query, namedParameters);
	}
	
	@Override
	public List<Images> getPicsOfOtherThanCurrentUser(int users_id) {
		String query = getallpicswithoutCurrentUser;
		 Map<String, Object> parameters = new HashMap<String, Object>();
	        parameters.put("image_type", "other");
	        parameters.put("users_id", users_id);
			 MapSqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		return namedParameterJdbcTemplate.query(query,namedParameters, new ImagesRowMapper());
	}
	
	@Override
	public List<Images> getPicsOfCurrentUser(int users_id) {
		String query = getallpicsofcurrentuser;
		 Map<String, Object> parameters = new HashMap<String, Object>();
	        parameters.put("image_type", "other");
	        parameters.put("users_id", users_id);
			 MapSqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
		return namedParameterJdbcTemplate.query(query,namedParameters, new ImagesRowMapper());
	}


}
