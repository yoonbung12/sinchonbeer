package com.bitcamp.sc.member.memberService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.domain.MemberRegRequest;
import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class MemberRegService {

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao memberDao;
	
	
	public int regMember(MemberRegRequest regRequest) {
		
		int resultCnt = 0;
		Member member = regRequest.toMember();
		memberDao = template.getMapper(MemberDao.class);
		resultCnt = memberDao.insertMember(member);
		System.out.println("새롭게 등록된 idx : " + member.getIdx());
		
		return resultCnt;
	}
}
