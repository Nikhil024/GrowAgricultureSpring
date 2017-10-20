package com.grow.agriculture.daoBean;

public class ImagesDaoBean {
	
	private int id;
	private String name;
	private byte[] imageName;
	private String imageType;
	private int usersId;
	private int imageSize;
	
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
	public byte[] getImageName() {
		return imageName;
	}
	public void setImageName(byte[] imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public int getImageSize() {
		return imageSize;
	}
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}
	
	@Override
	public String toString() {
		return "ImagesDao [id=" + id + ", name=" + name + ", imageName=" + imageName + ", imageType=" + imageType
				+ ", usersId=" + usersId + ", imageSize=" + imageSize + "]";
	}
}
