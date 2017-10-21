package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.ImagesDaoBean;

public class ImagesRowMapper implements RowMapper<ImagesDaoBean> {

	@Override
	public ImagesDaoBean mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		ImagesDaoBean images = new ImagesDaoBean();
		images.setId(resultSet.getInt("ID"));
		images.setImage(resultSet.getBytes("IMAGE_NAME"));
		images.setImageSize(resultSet.getInt("IMAGE_SIZE"));
		images.setImageType(resultSet.getString("IMAGE_TYPE"));
		images.setName(resultSet.getString("NAME"));
		images.setUsersId(resultSet.getInt("USERS_ID"));
		return images;
	}

}
