package com.capgemini.GoCab.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 
 *
 */

//Model Class for user where registered user's data would be saved and manipulated

@Entity
@Table(name = "user")
public class UserEntity {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "Id")
//	private int userId;
	@Column(name = "Name")
	private String userFullName;
	@Column(name = "Email")
	private String userEmailAddress;
	@Id
	@Column(name = "Contactno")
	private String userMobileNo;
//	@Column(name = "DOB")
//	private String userDob;
	@Column(name = "Role")
	private String userRole;
	
	
	//Getter and Setter
	
//	public String getUserDob() {
//		return userDob;
//	}
//	public void setUserDob(String userDob) {
//		this.userDob = userDob;
//	}
	
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
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
	
	public String getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	
//	public String getDob() {
//		return userDob;
//	}
//	public void setDob(String dob) {
//		this.userDob = dob;
//	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
