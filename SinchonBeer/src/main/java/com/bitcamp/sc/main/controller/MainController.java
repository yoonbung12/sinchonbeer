package com.bitcamp.sc.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// 메인화면 이동
	@GetMapping("/")
	public String index() {
		return "main";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
}
