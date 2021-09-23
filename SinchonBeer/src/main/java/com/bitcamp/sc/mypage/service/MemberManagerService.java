package com.bitcamp.sc.mypage.service;

import com.bitcamp.sc.member.domain.Member;

public interface MemberManagerService {
	// 회원 정보 수정
	public void updateMember(Member member);

	// 회원 탈퇴
	public void deleteMember(Member member);
}
