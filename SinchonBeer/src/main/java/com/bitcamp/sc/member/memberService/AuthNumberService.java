package com.bitcamp.sc.member.memberService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class AuthNumberService {

	//디비에 있는 인증번호가 사용자가 입력한 인증번호와 일치하는지 여부를 판단하고 결과를 반환하기.
	//디비에 있는 인증번호 가지고 오기. 가지고 오기 위해서는 인증번호를 보냈던 이메일하고도 일치를 해야 한다.
	//  select mcode from member where memail=?
	
	@Autowired
	private SqlSessionTemplate template;
	private MemberDao memberDao;
	public Boolean checkAuthNum(String inputNum, String email) {
		
		Boolean result = false;
		
		memberDao = template.getMapper(MemberDao.class);
		Member member = memberDao.selectCode(email); 
		System.out.println(member);
		System.out.println("db 에 저장되어 있는 인증번호 : "+member.getCode());
		System.out.println("사용자가 입력한 인증번호 : "+inputNum);
		String memberCode = member.getCode();
		
		if(memberCode ==inputNum) {
			result=true;
		}
		System.out.println("일치한다면 true 반환 : "+ result);
		
		return result;
	}

}
