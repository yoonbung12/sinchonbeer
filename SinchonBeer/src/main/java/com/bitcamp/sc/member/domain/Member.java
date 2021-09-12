package com.bitcamp.sc.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private int midx;
	private String memail;
	private String mpw;
	private String mname;
	private String mphone;

	
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.midx, this.memail, this.mname, this.mphone);
	}
	
}
