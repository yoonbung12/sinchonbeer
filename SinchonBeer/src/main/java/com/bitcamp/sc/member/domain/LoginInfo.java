package com.bitcamp.sc.member.domain;

public class LoginInfo {

	private int idx;
	private String email;
	private String name;
	private String phone;
	public LoginInfo(int idx, String email, String name, String phone) {
		this.idx = idx;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	public int getIdx() {
		return idx;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", email=" + email + ", name=" + name + ", phone=" + phone + "]";
	}

	
	
}
