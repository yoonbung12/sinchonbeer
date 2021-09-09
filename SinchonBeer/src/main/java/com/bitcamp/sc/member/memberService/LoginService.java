package com.bitcamp.sc.member.memberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao memberDao;

	public boolean login(String email, String pw, String reEmail, HttpSession session, HttpServletResponse response) {
		//로그인체크 기본 값은 false
		boolean loginChk = false;
		// MemberDao를 클래스로 만들어 구현
		memberDao=template.getMapper(MemberDao.class);
		System.out.println("인터페이스 member dao mapper 생성");
		
		Member member = memberDao.selectByEmailPw(email, pw);
		//회원이 로그인 했다면 session 유지 시작, 로그인체크는 true로.
		System.out.println(member);
		if(member != null) {
			session.setAttribute("loginInfo", member.toLoginInfo());
			loginChk = true;
		}
		
		
		
		
		//이메일 기억하기 쿠키
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
}
