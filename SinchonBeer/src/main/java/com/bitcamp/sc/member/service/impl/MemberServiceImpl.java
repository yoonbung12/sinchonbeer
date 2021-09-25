package com.bitcamp.sc.member.service.impl;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.domain.MemberAddress;
import com.bitcamp.sc.member.repository.MemberDao;
import com.bitcamp.sc.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao memberDao;
	HttpSession session;
	
	@Override
	public LoginInfo getMember(int midx) {
		
		memberDao = template.getMapper(MemberDao.class);
		
		Member member = memberDao.selectByMidx(midx);
		LoginInfo loginInfo = member.toLoginInfo();
		
		return loginInfo;
	}

	
	

	@Override
	public MemberAddress getMemberAdd(int midx) {
memberDao = template.getMapper(MemberDao.class);
		
		MemberAddress memAddress = memberDao.selectAddressByMidx(midx);
		
		return memAddress;
	}
}
