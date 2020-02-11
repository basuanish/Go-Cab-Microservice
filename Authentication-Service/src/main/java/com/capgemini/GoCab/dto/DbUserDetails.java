package com.capgemini.GoCab.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = DbUserDetails.class)
public class DbUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4347119240171860440L;
	private String username;
    private String password;
    private Integer active;
    private boolean isLocked;
    private boolean isExpired;
    private boolean isEnabled;
    private List<GrantedAuthority> grantedAuthorities;

    public DbUserDetails(String username, String password, Integer active, boolean isLocked, boolean isEnabled, boolean isExpired, String [] authorities) {
        this.username = username;
        this.password = password;
       this.active = active;
        this.isLocked = isLocked;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    public DbUserDetails(String username,  String [] authorities) {
        this.username = username;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    public DbUserDetails() {
        super();
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }


    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return active==1;
    }


    public boolean isAccountNonLocked() {
        return !isLocked;
    }

   
    public boolean isCredentialsNonExpired() {
        return !isExpired;
    }


    public boolean isEnabled() {
        return isEnabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//	
}
