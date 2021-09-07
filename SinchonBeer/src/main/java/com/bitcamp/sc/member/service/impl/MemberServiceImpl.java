package com.bitcamp.sc.member.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.mapper.MemberDao;
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
	
	public boolean login(String email, String pw, String reEmail, HttpSession session, HttpServletResponse response) {
		
		//로그인체크 기본 값은 false
		boolean loginChk = false;
		// MemberDao를 클래스로 만들어 구현
		memberDao=template.getMapper(MemberDao.class);
		System.out.println("인터페이스 member dao mapper 생성");
		
		Member member = memberDao.selectByEmailPw(email, pw);
		//회원이 로그인 했다면 session 유지 시작, 로그인체크는 true로.
		if(member != null) {
			session.setAttribute("loginInfo", member.toLoginInfo());
			loginChk = true;
		}
		//이메일 기억 쿠키
		if(reEmail != null && reEmail.length() > 0) {
			//기억하기 체크하면 쿠키에 저장
			Cookie cookie = new Cookie("reEmail", email);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*365);
			
			response.addCookie(cookie);
		} else {
			//기억하기 체크 해제하면 쿠키에 저장 안함.
			Cookie cookie = new Cookie("reEmail", email);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
		}
		
		return loginChk;

	}

	@Override
	public int joinMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
}
