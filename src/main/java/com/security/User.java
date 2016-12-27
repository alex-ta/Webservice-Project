package com.security;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.data.Roles;

@Entity
@Table(name = "users_sec")
public class User {

	private String id;
	private String password;
	private String passwordConfirm;
	private boolean enabled;
	private String uid;
	private int role;

	public User() {
		this.enabled = true; // replace by email
		this.setRole(Roles.ROLE_USER);
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	@Transient
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Id
	@Column(name = "username", unique = true,
		nullable = false, length = 45)
	public String getId() {
		return this.id;
	}

	public void setId(String username) {
		this.id = username;
	}

	@Column(name = "password",
		nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
	public void setRole(Roles role) {
		this.role = role.ordinal();
	}


}