package com.capgemini.GoCab.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6711956061860857120L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private String email;
	private String password;
	private String name;
	
	 private Integer active=1;
	 private boolean isLoacked=false;
	 private boolean isExpired=false;
	 private boolean isEnabled=true;
	 @ElementCollection(fetch = FetchType.EAGER)
	 private Set<String> role;
	
	 public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public boolean isLoacked() {
		return isLoacked;
	}

	public void setLoacked(boolean isLoacked) {
		this.isLoacked = isLoacked;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", active="
				+ active + ", isLoacked=" + isLoacked + ", isExpired=" + isExpired + ", isEnabled=" + isEnabled
				+ ", role=" + role + "]";
	}
	 
	 
	 
	 
}
