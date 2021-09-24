package com.bitcamp.sc.mypage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.mypage.repository.MypageDao;
import com.bitcamp.sc.mypage.service.MemberDeleteService;

@Service
public class MemberDeleteServiceImpl implements MemberDeleteService {
	MypageDao managerDao;

	@Autowired
	public MemberDeleteServiceImpl(MypageDao managerDao) {
		this.managerDao = managerDao;
	}

	// 회원 탈퇴
	@Override
	public void deleteMember(Member member) {
		managerDao.deleteMember(member);
	}
}
