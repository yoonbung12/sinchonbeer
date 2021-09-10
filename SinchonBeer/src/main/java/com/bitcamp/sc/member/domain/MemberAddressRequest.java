package com.bitcamp.sc.member.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberAddressRequest {

	private String postcode;
	private String address1;
	private String address2;
	
	public MemberAddress toMemberAddress() {
		return new MemberAddress(0,0,this.postcode, this.address1, this.address2);
	}
}
