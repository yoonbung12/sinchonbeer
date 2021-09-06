package com.bitcamp.sc.member.service;

import com.bitcamp.sc.member.domain.LoginInfo;

public interface MemberService {
	LoginInfo getMember(String memail); 
}
