package com.bitcamp.sc.mypage.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;

@Repository
public class MemberManagerDaoImpl implements MemberManagerDao {

	private static final String namespace = "MypageMapper";
	private final SqlSessionTemplate template;

	public MemberManagerDaoImpl(SqlSessionTemplate template) {
		this.template = template;
	}

	// 회원 정보 조회
	@Override
	public List<Member> readMember(int idx) {
		return template.selectOne(namespace + ".readMember", idx);
	}

	// 회원 정보 수정
	@Override
	public void updateMember(Member member) {
		template.update(namespace + ".updateMember", member);
	}

	// 회원 탈퇴
	@Override
	public void deleteMember(Member member) {
		template.delete(namespace + ".deleteMember", member);
	}
}
