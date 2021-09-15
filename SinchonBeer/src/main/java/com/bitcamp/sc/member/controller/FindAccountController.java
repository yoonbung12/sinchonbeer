package com.bitcamp.sc.member.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FindAccountController {

	//이메일과 비밀번호 찾기 첫번째 화면
	@RequestMapping(value="/inquiry", method=RequestMethod.GET)
	public String findAccount() {
		return "member/findEmailPwForm";
	}
	
	// url 매핑 
	@RequestMapping("/test")
	public String getTest() {
		// 이메일 저장 처리 
		
		return "member/findEmailSuccess";	
		}
	
	@RequestMapping(value="/inquiry/email", method=RequestMethod.POST)
	@ResponseBody
	public boolean findEmailByName(
			@RequestBody Map<String,Object> params
			) {
		System.out.println("아이디 찾기 test");
		System.out.println(params);
		System.out.println((String)params.get("name"));
		System.out.println((String)params.get("phone"));
		// 있다 없다
		
		// 찾은 이메일 저장
		
		return true;
	}
	
	//이메일 찾기 성공 화면
/*	@RequestMapping(value="/inquiry", method=RequestMethod.POST)
//	@RequestMapping(value="/inquiry/email/success")
	public String findEmail(
			@RequestParam("mname")String name,
			@RequestParam("mphone")String phone,
			@RequestParam("memail")String email
			
			) {
		String view = null;
		
		//이메일 찾기 성공 화면
		//이름과 휴대폰 번호를 입력 받고 
		//DB와 비교하여 (sql 쿼리 : select count(*) from member where mname=? and mphone=?) -> 반환 타입:int
		//service에서 반환타입을 int로 받아, controller에서도 서비스 갔다와놓고 서비스 메소드의 반환타입을 int로 하기.
		//1을 반환하면 이메일 찾기 성공 뷰를 보여주고, 0을 반환하면 ajax로 alert을 띄우기
		
		//로그인 방식이다!!!
		
		view = "member/findEmailSuccess";
		
		
		//비밀번호 찾기 첫 단계
		view="member/findPwContinue";
		return view;
	}
*/	
//	//비밀번호 찾기 첫 단계 - 이메일 주소 확인하고 인증보내기 전단계
//	@RequestMapping(value="/inquiry/pw/email", method=RequestMethod.POST)
//	@RequestMapping(value="/inquiry")
//	public String findPw1() {
//		return "member/findPwContinue";
//	}
//	
//	
//	//비밀번호 찾기 두 번째 단계 - 이메일 인증 보내고 인증번호 입력 받는 화면
//	@RequestMapping(value="/inquiry/pw/input-code", method=RequestMethod.POST)
	@RequestMapping(value="/inquiry/pw/input-code")
	public String findPw2() {
		return "member/findPwAuth";
	}
//	
//	//비밀번호 찾기 세 번째 단계 - 비밀번호 재설정하기
//	@RequestMapping(value="/inquiry/pw/reset", method=RequestMethod.POST)
	@RequestMapping(value="/inquiry/pw/reset")
	public String findPw3() {
		return "member/findPwSetting";
	}
	
}
