package com.abysshal.wow.calendar.model;

public class User {
	private String username;
	private String password;
	private String email;
	private String mobilephone;
	private String sinaWeibo;
	private String nickname;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getSinaWeibo() {
		return sinaWeibo;
	}

	public void setSinaWeibo(String sinaWeibo) {
		this.sinaWeibo = sinaWeibo;
	}
}
