package com.bitcamp.sc.member.service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.domain.MemberAddress;

public interface MemberService {
	
	//회원의 midx로 회원 정보 조회하기.
	LoginInfo getMember(int midx);
	
	//회원의 midx로 주소 정보 가지고 오기 
	MemberAddress getMemberAdd(int midx);
	
}
