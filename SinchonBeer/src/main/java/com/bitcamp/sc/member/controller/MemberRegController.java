package com.bitcamp.sc.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

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
		System.out.println("get 방식 진입 성공");
		return "member/regForm";
	}
	//회원가입 성공/실패 화면
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public RedirectView reg(
			//@ModelAttribute("regRequest") MemberRegRequest regRequest,
			//RegRequest regRequest
			RegRequest regRequest
			
			) {
		System.out.println("post 방식 진입 성공");
		System.out.println("service 가기 전 controller에서 regReqeust의 toString"+regRequest);
		int result = regService.regMember(regRequest);
		System.out.println("[controller]DB insert성공 했다면 1 반환, 못했다면 0 반환"+result);
		
		return new RedirectView("/join/success");
	}
	
	@RequestMapping(value="/join/success", method=RequestMethod.GET)
	public String regSuccess() {
		return "member/reg";
	}
	
}
