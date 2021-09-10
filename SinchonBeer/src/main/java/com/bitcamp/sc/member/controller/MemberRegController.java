package com.bitcamp.sc.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.sc.member.domain.RegRequest;
import com.bitcamp.sc.member.memberService.MemberRegService;

@Controller
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	//일반회원 or 카카오 회원가입 선택하기
	@RequestMapping(value="/join/type",method=RequestMethod.GET)
	public String regMain() {
		return "member/regMain";
	}
	//회원가입 약관
	@RequestMapping("/join/agree")
	public String regAgree() {
		return "member/regAgree";
	}
	//회원가입 폼
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String regForm() {
		return "member/regForm";
	}
	//회원가입 성공/실패 화면
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String reg(
			//@ModelAttribute("regRequest") MemberRegRequest regRequest,
			RegRequest regRequest
			) {
		int result = regService.regMember(regRequest);
		//model.addAttribute("result", result);
		
		return "/member/reg";
	}
	
}
