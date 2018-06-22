package com.inc.dayary.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Member {
/*
	ID       NOT NULL VARCHAR2(10) 
	PASSWORD NOT NULL VARCHAR2(10) 
	NAME     NOT NULL VARCHAR2(30) 
	EMAIL    NOT NULL VARCHAR2(30) 
	GENDER            CHAR(1) m or f */
	
	@Pattern(regexp="[A-Za-z0-9]{3,10}", message="영대소문자(+숫자)의 조합만 가능합니다.")
	private String id;
	@Pattern(regexp="[A-Za-z0-9]{4,10}", message="패스워드는 알파벳 또는 숫자 4~10글자만 가능합니다.")
	private String password;
	private String passwordConfirm;
	@Pattern(regexp="[가-힣]{2,10}", message="이름은 한글 2~10글자만 가능합니다.")
	private String name;
	@Pattern(regexp="[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z]{2,10}")
	private String email;
	@NotEmpty(message="성별을 선택하세요")
	@Pattern(regexp="[m|f]{1}", message="비정상적 데이터 접근입니다.")
	private String gender;
	private String emailCode;
	
	
	//business logic
	public boolean isPasswordValid() {
		return this.password.equals(this.passwordConfirm);
	}
	
	
	//getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	
}
