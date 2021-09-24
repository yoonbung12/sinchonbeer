package com.bitcamp.sc.mypage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.mypage.repository.MypageDao;
import com.bitcamp.sc.mypage.service.MemberEditService;

@Service
public class MemberEditServiceImpl implements MemberEditService {
	MypageDao managerDao;

	@Autowired
	public MemberEditServiceImpl(MypageDao managerDao) {
		this.managerDao = managerDao;
	}

	// 회원 정보 수정
	@Override
	public void updateMember(Member member) {
		managerDao.updateMember(member);
	}
}
