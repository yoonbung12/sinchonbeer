package com.bitcamp.sc.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.mypage.repository.MemberManagerDao;
import com.bitcamp.sc.mypage.service.MemberManagerService;

@Service
public class MemberManagerServiceImpl implements MemberManagerService {
	MemberManagerDao managerDao;

	@Autowired
	public MemberManagerServiceImpl(MemberManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	// 회원 정보 조회
	@Override
	public List<Member> readMember(int idx) {
		return managerDao.readMember(idx);
	}

	// 회원 정보 수정
	@Override
	public void updateMember(Member member) {
		managerDao.updateMember(member);
	}

	// 회원 탈퇴
	@Override
	public void deleteMember(Member member) {
		managerDao.deleteMember(member);
	}
}
