package com.bitcamp.sc.mypage.service;

import java.util.List;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;

public interface MemberManagerService {
	// 회원 정보 조회
	List<Member> readMember(int idx);

	// 회원 정보 수정
	public void updateMember(Member member);

	// 회원 탈퇴
	public void deleteMember(Member member);
}
