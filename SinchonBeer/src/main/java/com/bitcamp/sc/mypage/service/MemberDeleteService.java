package com.bitcamp.sc.mypage.service;

import com.bitcamp.sc.member.domain.Member;

public interface MemberDeleteService {

	// 회원 탈퇴
	public void deleteMember(Member member);
}
