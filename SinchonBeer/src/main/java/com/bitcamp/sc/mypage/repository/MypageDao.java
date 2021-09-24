package com.bitcamp.sc.mypage.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.mypage.domain.OrderList;
import com.bitcamp.sc.mypage.domain.RezList;

@Repository
public class MypageDao {
	private static final String namespace = "MypageMapper";
	private final SqlSessionTemplate template;

	public MypageDao(SqlSessionTemplate template) {
		this.template = template;
	}

	// 주문 내역 조회
	public List<OrderList> getOrderList(int idx) {
		return template.selectOne(namespace + ".getOrderList", idx);
	}

	// 예약 내역 조회
	public List<RezList> getRezList(int idx) {
		return template.selectOne(namespace + ".getRezList", idx);
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
