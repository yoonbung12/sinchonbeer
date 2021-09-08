package com.bitcamp.sc.member.service.impl;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.repository.MemberDao;
import com.bitcamp.sc.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao memberDao;
	HttpSession session;
	
	@Override
	public LoginInfo getMember(String email) {
		
		memberDao = template.getMapper(MemberDao.class);
		System.out.println("인터페이스 member dao mapper 생성");
		
		Member member = memberDao.selectByEmail(email);
		LoginInfo loginInfo = member.toLoginInfo();
		
		return loginInfo;
	}

	//회원가입에 필요한 메소드 - 아이디 중복방지 메소드. 회원 DB에 추가하는 메소드.
	
	@Override
	public int joinMember(Member member) {
		return 0;
	}
}
