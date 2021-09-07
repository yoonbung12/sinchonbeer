package com.bitcamp.sc.member.mapper;

import com.bitcamp.sc.member.domain.Member;

public interface MemberDao {

	//로그인 하기
	Member selectByEmailPw(String email, String pw);
	//이메일로 회원정보 불러오기
	Member selectByEmail(String email);
	//회원가입
	int insertMember(Member member);
	//이메일(아이디) 중복 체크
	int selectByEmail2(String email);
}
