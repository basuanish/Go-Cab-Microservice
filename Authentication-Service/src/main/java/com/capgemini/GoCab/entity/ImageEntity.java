//package com.capgemini.GoCab.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class ImageEntity {
//	public ImageEntity() {
//	}
//
//	public ImageEntity(String imageUsername, String type, byte[] image) {
//		super();
//		this.imageUsername = imageUsername;
//		this.type = type;
//		this.image = image;
//	}
//
//	@Id
//	@Column
//	private String imageUsername;
//	
//	@Column
//	private String type;
//	
//
//	@Column(length = 1000)
//	private byte[] image;
//
//	public String getImageUsername() {
//		return imageUsername;
//	}
//
//	public void setImageUsername(String imageUsername) {
//		this.imageUsername = imageUsername;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
//	
//	
//}
