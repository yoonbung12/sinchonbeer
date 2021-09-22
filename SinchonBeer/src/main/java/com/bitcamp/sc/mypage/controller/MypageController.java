package com.bitcamp.sc.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.mypage.service.MypageService;
import com.bitcamp.sc.pay.domain.PayInfo;
import com.bitcamp.sc.tour.domain.TourOrderInfo;

@Controller
public class MypageController {
	@Autowired
	MypageService service;

	// 헤더 로고 클릭 시 메인화면 이동
	@GetMapping("/main")
	public String mainLogo() {
		return "main";
	}

	// 네비바 클릭 시 소개페이지 이동
	@GetMapping("/about")
	public String aboutNav() {
		return "about";
	}

	// 주문 내역 페이지 이동
	@GetMapping("/mypage/shop")
	public String mypageShop(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");

		String type = "tour";

		List<PayInfo> payInfo = service.getPayInfosByType(type, login.getIdx());

		model.addAttribute("payInfoList", payInfo);

		System.out.println("결제 리스트 : " + payInfo);

		return "mypage/shop";
	}

	// 예약 내역 페이지 이동
	@GetMapping("/mypage/tour")
	public String mypageTour(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");

		String type = "tour";
		String category = "tour";

		List<PayInfo> payInfo = service.getPayInfosByType(type, login.getIdx());
		List<TourOrderInfo> tourInfo = service.getTourOrder(login.getIdx(), category);

		model.addAttribute("payInfoList", payInfo);
		model.addAttribute("tourOrderList", tourInfo);

		System.out.println("결제 리스트 : " + payInfo);
		System.out.println("투어 리스트 : " + tourInfo);

		return "mypage/tour";
	}
}
