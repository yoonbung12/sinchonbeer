package com.bitcamp.sc.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class PwResetService {

	@Autowired
	private SqlSessionTemplate template;
	private MemberDao memberDao;
	
	public Boolean updateNewPw(String userEmail, String newPw) {
		
		Boolean result = false;
		
		memberDao=template.getMapper(MemberDao.class);
		int resultCnt = memberDao.updatePw(userEmail, newPw);
		if(resultCnt==1) {
			result = true;
		}
		
		return result;
	}
	
}
