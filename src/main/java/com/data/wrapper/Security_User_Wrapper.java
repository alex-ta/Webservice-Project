package com.data.wrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.data.Roles;
import com.data.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class Security_User_Wrapper implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The unique username", required = true)
	private String name;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The password of an user", required = true)
	private String password;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The confirmation of that password", required = true)
	private String passwordConfirm; // auslagern
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The uuid of an user", required = true)
	private String uuid; // not required
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The roles belonging to an user", required = true)
	private List<Roles> roles; // should not provide roles -> can not been changed


	public Security_User_Wrapper(User user){
		this();
		if(user != null){
		this.name = user.getId();
		this.password = user.getPassword();
		this.uuid = user.getUuid();
		this.roles = user.getRoles();
		}
	}
	
	public Security_User_Wrapper() {
	}

	public User getUser(){
		User user = new User();
		if(this.getName() != null)
		user.setId(this.getName());
		if(this.getPassword() != null)
		user.setPassword(this.getPassword());
		if(this.getUuid() != null)
		user.setUuid(this.getUuid());
		if(this.getRoles() != null)
		user.setRoles(this.getRoles());
		return user;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRole(List<Roles> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return buildUserAuthority(this.getRoles());
	}

	@Override
	public String getUsername() {
		return this.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public List<GrantedAuthority> buildUserAuthority(List<Roles> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		
		if(roles.size() == 0){
			setAuths.add(new SimpleGrantedAuthority(Roles.ROLE_ANONYMOUS.name()));
		} else {
			for(Roles r : roles){
				setAuths.add(new SimpleGrantedAuthority(r.name()));
			}
		}
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}