package com.example.kadai_01.domain.model;

public class Role {

	private static final long serialVersionUID = 1L;

	private String userId;

	private String roles;

	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
