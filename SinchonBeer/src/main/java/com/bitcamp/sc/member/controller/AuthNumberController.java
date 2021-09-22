package com.bitcamp.sc.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.memberService.AuthNumberService;

@Controller
public class AuthNumberController {

	@Autowired
	private AuthNumberService service;
	//인증번호가 사용자입력한 번호랑 같은지 체크하기.
	@RequestMapping("/inquiry/pw/input-code")
	@ResponseBody
	public String CheckAuthNum(
			@RequestBody Map<String, Object> param
			) {
		String result = "N";
		System.out.println("넘어온 inputNum의 값 : "+(String)param.get("inputNum"));
		System.out.println("넘어온 inputNum의 값 : "+(String)param.get("userEmail"));
		Boolean checkedAuthNum = service.checkAuthNum((String)param.get("inputNum"), (String)param.get("userEmail")); 
		System.out.println("checkedAuthNum : "+checkedAuthNum);
		if(checkedAuthNum) {
			result = "Y";
		}
		System.out.println(result);
		return result;
	}
}
