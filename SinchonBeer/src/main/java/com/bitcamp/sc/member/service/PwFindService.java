package com.bitcamp.sc.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class PwFindService {

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao memberDao;
	
	public String pwSearch(String name, String email) {
		String resultEmail = null;
		
		memberDao = template.getMapper(MemberDao.class);
		System.out.println("[pw check service ] dao mapper 생성");
		
		try {
		Member member = memberDao.pwSearch(name, email);
		System.out.println("member 객체 : "+member);
		
		resultEmail = member.getEmail();
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("찾으려는 이메일이 없을 경우 발생하는 예외");
		}
		return resultEmail;
	}
}
