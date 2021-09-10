package com.bitcamp.sc.member.memberService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.domain.MemberAddress;
import com.bitcamp.sc.member.domain.RegRequest;
import com.bitcamp.sc.member.repository.MemberDao;

@Service
public class MemberRegService {

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao memberDao;
	
	
	public int regMember(RegRequest regRequest) {
		
		int resultCnt = 0;
		
		//주소를 제외한 회원가입 - toMember(): midx, email, pw, name, phone
		Member member = regRequest.getMemberRegRequest().toMember();
		memberDao = template.getMapper(MemberDao.class);
		resultCnt = memberDao.insertMember(member);
		System.out.println("새롭게 등록된 idx : " + member.getIdx());
		
		//사용자가 입력한 주소를 주소테이블에 넣기
		MemberAddress memberAddress = regRequest.getMemberAddressRequest().toMemberAddress();
		if(memberAddress.formValidate()) {
			//주소를 모두 입력하였다면
			memberAddress.setMidx(member.getIdx());
			
			resultCnt *= memberDao.insertAddress(memberAddress);
			System.out.println(resultCnt);
		}
		
		
		return resultCnt;
	}
}
