package com.bitcamp.sc.member.domain;

import lombok.Data;

@Data
public class Member {

	private int idx;
	private String email;
	private String name;
	private String pw;
	private String phone;

	
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.idx, this.email, this.name, this.phone);
	}
	
}
