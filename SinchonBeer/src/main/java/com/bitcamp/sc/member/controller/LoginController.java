package com.bitcamp.sc.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.service.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	@RequestMapping( method = RequestMethod.GET)
	public String loginForm(
			//로그인 성공시 되돌아 갈 이전 페이지
			@RequestHeader(value = "referer", required = false) String redirectUri,
			@CookieValue(value="reEmail", required = false) String reEmail,
			HttpSession session,
			Model model
			) {
		//LoginInfo loginInfo = (LoginInfo)getSession();
		model.addAttribute("redirectUri", redirectUri);
		model.addAttribute("reEmail", reEmail);
		return "member/loginForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(
			@RequestBody Map<String,Object> params,
			HttpSession session, //로그인 정보에 대한 session
			HttpServletResponse response //쿠키를 받기위한 response
			//Model model 
			) {
		System.out.println("reEmail : " + params.get("reEmail"));
		System.out.println(params);
		System.out.println(params.get("memail")+": "+params.get("mpw"));
		System.out.println(params.get("redirectUri"));
		Map<String,Object> map = new HashMap<>();
		map.put("refererUri", (String)params.get("redirectUri"));
		
		//사용자가 입력한 정보를 서비스에서 처리하고 결과 받아오기
		Boolean loginChk = loginService.login((String)params.get("memail"), (String)params.get("mpw"), (String)params.get("reEmail"), session, response);
		map.put("result", loginChk);
		
		return map;
	}
	
	
	
	
	
}
