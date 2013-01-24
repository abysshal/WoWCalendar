package com.abysshal.wow.calendar.model;

public class UserAuthToken {

	private String u;
	private String p;

	public UserAuthToken() {
	}

	public UserAuthToken(String user, String pass) {
		this.u = user;
		this.p = pass;
	}

	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
}
