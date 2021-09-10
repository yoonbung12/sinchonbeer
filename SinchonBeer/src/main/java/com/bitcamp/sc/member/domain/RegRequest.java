package com.bitcamp.sc.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegRequest {

	private MemberRegRequest memberRegRequest;
	private MemberAddressRequest memberAddressRequest;
}
