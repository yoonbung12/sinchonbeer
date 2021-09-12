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
public class MemberAddress {

	private int aidx;
	private int midx;
	private String postcode;
	private String address1;
	private String address2;
	
	//주소를 모두 입력하였는지 확인하는 메소드
	public boolean formValidate() {
		System.out.println("formValidate()메소드 진입 성공");
		boolean check = false;
		//만일 우편번호, 주소, 상세주소가 모두 입력 되었다면 check는 true, 아니면 false를 반환
		if(!(postcode != null && address1 != null && address2 != null )) {
			if(!(postcode.trim().isEmpty() || address1.trim().isEmpty() || address2.trim().isEmpty())){
				check = true;
			}
		}
		return check;
	}
}
