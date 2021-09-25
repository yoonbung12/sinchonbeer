package com.bitcamp.sc.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.mypage.domain.RezList;
import com.bitcamp.sc.mypage.service.MyRezListService;

@Controller
public class MyRezListController {
	@Autowired
	MyRezListService service;

	// 예약 내역 페이지 이동
	@GetMapping("/mypage/tour")
	public String mypageTour(Model model, HttpSession session) {
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");

		if (session.getAttribute("loginInfo") == null) {
			return "member/loginForm";
		} else {
			List<RezList> rezList = service.getRezList(login.getIdx());
			model.addAttribute("rezList", rezList);

			return "mypage/tour";
		}
	}
}
