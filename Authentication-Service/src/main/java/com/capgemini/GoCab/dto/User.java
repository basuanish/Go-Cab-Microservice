package com.capgemini.GoCab.dto;


public class User {
	private String userFullName;
	private String userEmailAddress;
	private String userPassword;
	private String userMobileNo;
	//private long userDob;
	private String userRole;
	//private MultipartFile pImage;
	
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmailAddress() {
		return userEmailAddress;
	}
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	
//	public long getUserDob() {
//		return userDob;
//	}
//	public void setUserDob(long userDob) {
//		this.userDob = userDob;
//	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
//	public MultipartFile getpImage() {
//		return pImage;
//	}
//	public void setpImage(MultipartFile pImage) {
//		this.pImage = pImage;
//	}
	@Override
	public String toString() {
		return String.format(
				"User [userFullName=%s, userEmailAddress=%s, userPassword=%s, userMobileNo=%s, userRole=%s]",
				userFullName, userEmailAddress, userPassword, userMobileNo, userRole);
	}
	
}
