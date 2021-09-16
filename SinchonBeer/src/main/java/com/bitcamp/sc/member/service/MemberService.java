package com.bitcamp.sc.member.service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;

public interface MemberService {
	
	LoginInfo getMember(String email); 
	//회원가입
	int joinMember(Member member);
}
