package com.bitcamp.sc.member.memberService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class IdChkService {

	private MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//이메일이 중복이면  "Y", 중복되지 않았으면 "N"를 반환
	public String emailCheck(String email) {
		String result="Y";
		memberDao = template.getMapper(MemberDao.class);
		int cnt = memberDao.selectByEmail2(email);
		System.out.println("중복되었을 경우 1반환, 중복이 안되었으면 0을 반환. 결과는?? : "+cnt);
		
		if(memberDao.selectByEmail2(email)>0) {
			result="N";
			
		}
		return result;
	}
}
