package com.bitcamp.sc.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberRegRequest {
	private String email;
	private String pw;
	private String name;
	private String phone;
	
	public Member toMember() {
		return new Member(0, email, pw, name, phone);
	}
}
