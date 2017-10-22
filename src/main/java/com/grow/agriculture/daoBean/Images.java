package com.grow.agriculture.daoBean;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Images {
	
	@Id
	@SequenceGenerator(name = "images_id", sequenceName = "images_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_id")
	private int id;
	private String name;
	@NotBlank(message = "Please Upload a image!")
	private byte[] image;
	@Column(name = "image_type")
	private String imageType;
	@Column(name = "image_size")
	private int imageSize;
	
	@OneToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public int getImageSize() {
		return imageSize;
	}

	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", name=" + name + ", image=" + Arrays.toString(image) + ", imageType=" + imageType
				+ ", imageSize=" + imageSize + ", user=" + user + "]";
	}
}
