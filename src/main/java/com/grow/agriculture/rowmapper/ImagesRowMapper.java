package com.grow.agriculture.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grow.agriculture.daoBean.Images;

public class ImagesRowMapper implements RowMapper<Images> {

	@Override
	public Images mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Images images = new Images();
		images.setId(resultSet.getInt("ID"));
		images.setImage(resultSet.getBytes("IMAGE"));
		images.setImageSize(resultSet.getInt("IMAGE_SIZE"));
		images.setImageType(resultSet.getString("IMAGE_TYPE"));
		images.setName(resultSet.getString("IMAGE_NAME"));
		images.setUsersId(resultSet.getInt("USERS_ID"));
		return images;
	}

}
