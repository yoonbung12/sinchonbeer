package com.bitcamp.sc.mypage.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.member.domain.Member;

@Repository
public class MemberManagerDao {
	private static final String namespace = "MypageMapper";
	private final SqlSessionTemplate template;

	public MemberManagerDao(SqlSessionTemplate template) {
		this.template = template;
	}

	// 회원 정보 수정
	public void updateMember(Member member) {
		template.update(namespace + ".updateMember", member);
	}

	// 회원 탈퇴
	public void deleteMember(Member member) {
		template.delete(namespace + ".deleteMember", member);
	}
}
