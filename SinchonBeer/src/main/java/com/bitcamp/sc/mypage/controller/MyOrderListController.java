package com.bitcamp.sc.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.mypage.domain.OrderList;
import com.bitcamp.sc.mypage.service.MyOrderListService;

@Controller
public class MyOrderListController {
	@Autowired
	MyOrderListService service;

	// 주문 내역 페이지 이동
	@GetMapping("/mypage/shop")
	public String mypageShop(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");

		if (session.getAttribute("loginInfo") == null) {
			return "member/loginForm";
		}

		List<OrderList> orderList = service.getOrderList(login.getIdx());

		model.addAttribute("orderList", orderList);

		System.out.println("주문 내역 : " + orderList);
		
		return "mypage/shop";
	}
}
