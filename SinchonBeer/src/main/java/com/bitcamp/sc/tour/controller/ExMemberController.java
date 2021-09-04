package com.bitcamp.sc.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExMemberController {

	@RequestMapping("/ExLogin")
	public String getLoginForm() {
		return "tour/ExMember/loginForm";
	}
}
