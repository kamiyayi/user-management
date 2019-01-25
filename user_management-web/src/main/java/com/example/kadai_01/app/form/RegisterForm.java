package com.example.kadai_01.app.form;

import java.io.Serializable;

import javax.validation.OverridesAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import org.terasoluna.gfw.common.*;
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import com.example.kadai_01.domain.validation.Compare;


@Compare(left = "password", right = "confirmPassword", operator = com.example.kadai_01.domain.validation.Operator.EQUAL, requireBoth = true)
public class RegisterForm implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min=4, max=4)
	@Pattern(regexp="[0-9]*")
	private String userId;
	
	@NotNull
	@Size(max=30)
	private String username;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String birthDay;
	
	@NotNull
	@Size(min=60)
	private String address;
	
	@NotNull
	@Size(min=10,max=11)
	private String telNum;
	
	@NotNull
	private String roles;
	
	@Size(min=6)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String password;
	
	@NotNull
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

