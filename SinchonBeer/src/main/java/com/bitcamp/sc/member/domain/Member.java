package com.bitcamp.sc.member.domain;

public class Member {

	private int idx;
	private String email;
	private String name;
	private String pw;
	private String phone;

	public Member() {}
	
	public Member(int idx, String email, String name, String pw, String phone) {
		this.idx = idx;
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", email=" + email + ", name=" + name + ", pw=" + pw + ", phone=" + phone + "]";
	}
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.idx, this.email, this.name, this.phone);
	}
	
}
