package com.bitcamp.sc.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberRegRequest {
	private String memail;
	private String mpw;
	private String mname;
	private String mphone;
	
	
	public Member toMember() {
		return new Member(0,this.memail, this.mpw, this.mname, this.mphone);
	}
}
