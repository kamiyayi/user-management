package com.example.kadai_01.app.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;



public class RegisterForm implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min=4, max=4)
	@Pattern(regexp="[0-9]")
	private String userId;
	
	@Size(min=1)
	private String username;

	private String birthDay;
	
	@Size(min=1)
	private String address;
	
	@Pattern(regexp="[0-9]")
	private String telNum;

	private String roles;
	
	@Size(min=4)
	private String password;
	
	@Size(min=4)
	private String confirmPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		//String strDate = birthDay;
		//Date date = Date.valueOf(strDate);
		this.birthDay = birthDay;

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

