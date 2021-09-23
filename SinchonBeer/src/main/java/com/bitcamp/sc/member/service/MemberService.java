package com.bitcamp.sc.member.service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.domain.MemberAddress;

public interface MemberService {
	//아무도 안써서 지울 예정
	//LoginInfo getMember(String email); 
	
	//회원가입
	int joinMember(Member member);
	
	//멤버 midx로 멤버 조회하기.(loginInfo객체 활용)
	//조회할 내용: midx, 
	LoginInfo getMember(int midx);
	
	
	//aidx로 주소 정보 가지고 오기 - 주문에서???
	//midx로 ...//
	MemberAddress getMemberAdd(int midx);
	
	
}
