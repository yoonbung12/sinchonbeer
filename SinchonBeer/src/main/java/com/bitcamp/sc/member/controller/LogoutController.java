package com.bitcamp.sc.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.sc.member.domain.LoginInfo;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		//로그인 세션이 있다면 세션을 끊고 메인페이지로 보내주기 - 나중에 메인페이지로 경로 수정해주기
		return "redirect:main";
	}
}
