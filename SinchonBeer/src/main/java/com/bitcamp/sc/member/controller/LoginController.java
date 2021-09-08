package com.bitcamp.sc.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.memberService.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(
			//로그인 성공시 되돌아 갈 이전 페이지
			//@RequestHeader(value = "referer", required = false) String redirectUri, 
			//Model model
			) {
		//model.addAttribute("redirectUri", redirectUri);
		return "/member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public  boolean login(
			@RequestParam("memail") String email, 
			@RequestParam("mpw") String pw,
			//@RequestParam(value = "redirectUri", required = false) String redirectUri, 
			@RequestParam(value = "reEmail", required = false) String reEmail, 
			HttpSession session, //로그인 정보에 대한 session
			HttpServletResponse response, //쿠키를 받기위한 response
			Model model
			) {
		System.out.println(email+": "+pw);
		//사용자가 입력한 정보를 서비스에서 처리하고 결과 받아오기
		boolean loginChk = loginService.login(email, pw, reEmail, session, response);
		model.addAttribute("loginChk", loginChk);
		System.out.println(loginChk);
		//String view/* = "/login" */;
		
		//로그인 성공시 이전페이지 이력이 있다면 그 페이지로 되돌아가기.
//		if(redirectUri != null && loginChk) {
//			view = "redirect : "+redirectUri;
//		}else {
//			view = "/member/login";
//		}

		return loginChk;
	}
	
}
