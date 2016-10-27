package com.joyuri.web.DAO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotBlank
	@Size(min = 6, max = 15)
	@Pattern(regexp = "^[a-zA-Z]+[0-9]*(?:[_.-]?[a-zA-Z0-9])*$")
	private String username;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9/*-+_]+$")
	@Size(min = 6, max = 20)
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	
	private String authority;
	private boolean enabled = false;

	public User() {
	}

	public User(String username, String password, String email, String authority, boolean enabled) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
