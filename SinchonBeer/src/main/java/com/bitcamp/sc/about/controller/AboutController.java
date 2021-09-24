package com.bitcamp.sc.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

	// 네비바 클릭 시 소개페이지 이동
	@GetMapping("/about")
	public String aboutNav() {
		return "about";
	}
}