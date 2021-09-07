package com.bitcamp.sc.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.sc.pay.service.impl.type.KakaoPay;

@Controller
public class PayController {

	@Autowired
	private KakaoPay kakaoPay;
	
	@GetMapping("/kakaoPay")
	public String kakaoPayGet() {
		return "pay/kakaoPay";
	}
	
	@PostMapping("/kakaoPay")
	public String kakaoPayPost() {
		return "redirect:" + kakaoPay.kakaoPayReady();
	}
	
	@GetMapping("/kakaoPaySuccess")
	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
		model.addAttribute("payInfo", kakaoPay.kakaoPayInfo(pg_token));
		return "pay/kakaoPaySuccess";
	}
	
	@GetMapping("/paySuccess")
	public String paySuccess() {
		return "pay/paySuccess";
	}
}
