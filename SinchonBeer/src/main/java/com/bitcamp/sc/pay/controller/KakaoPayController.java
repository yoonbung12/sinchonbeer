package com.bitcamp.sc.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.MemberAddress;
import com.bitcamp.sc.member.service.MemberService;
import com.bitcamp.sc.order.domain.OrderInfo;
import com.bitcamp.sc.order.service.OrderService;
import com.bitcamp.sc.pay.domain.KakaoPayApproval;
import com.bitcamp.sc.pay.domain.PayInfo;
import com.bitcamp.sc.pay.service.impl.PayServiceImpl;
import com.bitcamp.sc.pay.service.impl.type.KakaoPay;
import com.bitcamp.sc.shop.domain.ShopDto;
import com.bitcamp.sc.tour.domain.TourDto;
import com.bitcamp.sc.tour.service.TourService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
@Controller
public class KakaoPayController {

	private KakaoPay kakaoPay;
	private PayServiceImpl payService;
	private OrderService orderService;
	private TourService tourService;
	private MemberService memberService;
	
	@GetMapping("/kakaoPay")
	public String kakaoPayGet() {
		return "pay/kakaoPay";
	}
	
	@PostMapping("/kakaoPay/tour")
	public String kakaoPayTour(
			@ModelAttribute TourDto tour,
			@RequestParam("pType") String pway,
			Model model
			) {
		
		OrderInfo orderInfo = OrderInfo.builder()
									   .category("tour")
									   .price(tour.getPrice())
									   .tourIdx(tourService.getTidxByTdate(tour.getSelectDate()))
									   .tourPeople(tour.getTourPeople())
									   .memberIdx(tour.getMidx())
									   .build();
		
		orderService.createOrder("tour", orderInfo);
			
		return "redirect:" + kakaoPay.kakaoPayReady(orderInfo);
	}
	
	@PostMapping("/kakaoPay/shop")
	public String kakaoPayShop(
			@ModelAttribute ShopDto shop,
			Model model
			) {
		
		OrderInfo orderInfo = OrderInfo.builder()
									   .category("shop")
									   .price(shop.getPrice())
									   .addressIdx(17) // 멤버정보로 주소정보를 가져오는 findByMidx 메소드 필요
									   .memberIdx(shop.getMidx()) // 주소 추가
									   .build();
		
		orderService.createOrder("shop", orderInfo);
			
		return "redirect:" + kakaoPay.kakaoPayReady(orderInfo);
	}
	
	@GetMapping("/kakaoPaySuccess")
	public String kakaoPaySuccess(
			@RequestParam("pg_token") String pg_token,
			@RequestParam("orderIdx") int orderIdx,
			Model model) {
		
		OrderInfo orderInfo = orderService.getOrderInfo(orderIdx);
		
		KakaoPayApproval kakaoPayApproval = kakaoPay.kakaoPayInfo(pg_token, orderInfo);
		
		PayInfo payInfo = payService.approvalToPayInfo(kakaoPayApproval);
		payService.savePayment(payInfo);
		
		log.info(payInfo.toString());
		model.addAttribute("payIdx", payInfo.getIdx());
		
		if (orderInfo.getCategory().equals("tour")) {
			tourService.addTourPeopleByDate(orderInfo.getTourPeople(), tourService.getTourDateByTidx(orderInfo.getTourIdx()));
		}
		
		orderService.confirmOrder(orderInfo.getIdx());
		
		return "pay/kakaoPaySuccess";
	}
	
	@GetMapping("/kakaoPayCancel")
	public String kakaoPayCancel(@RequestParam("orderIdx") int orderIdx, Model model) {
		if (orderService.getOrderInfo(orderIdx) != null) {
			orderService.deleteOrder(orderIdx);
		}
		return "pay/kakaoPayCancel";
	}
	
	@GetMapping("/kakaoPayComplete")
	public String kakaoPayComplete(@RequestParam("payIdx") String payIdx, Model model) {
		model.addAttribute("payIdx", payIdx);
		return "pay/kakaoPayComplete";
	}
	
	@GetMapping("/paySuccess")
	public String paySuccess(@RequestParam(value = "payIdx", required = false) String payIdx, Model model) {
		PayInfo payInfo = payService.getPayInfo(Integer.parseInt(payIdx));
		OrderInfo orderInfo = orderService.getOrderInfo(payInfo.getOrderIdx());
		
		model.addAttribute("payInfo", payInfo);
		model.addAttribute("orderInfo", orderInfo);
		
		addAddressToModel(orderInfo, model);
		
		return selectPaySuccessPageByType(orderInfo.getCategory());
	}
	
	private void addAddressToModel(OrderInfo orderInfo, Model model) {
		if (orderInfo.getCategory().equals("shop")) {
			// 모델에 주소 정보 추가, getAddressIdx -> 주소 정보를 가져옴
			
//			model.addAttribute("addressInfo", orderInfo.getAddressIdx());
			
			// 테스트용 하드 코딩 수정 필요
			LoginInfo member = memberService.getMember("test@naver.com");
			
			MemberAddress memberAddress = new MemberAddress();
			
			memberAddress.setAddress1("경기 성남시 분당구 판교역로10번길 3 (백현동)");
			memberAddress.setAddress2("111동 111호");
			
			model.addAttribute("addressInfo", memberAddress);
			model.addAttribute("memberInfo", member);
		}
	}
	
	private String selectPaySuccessPageByType(String type) {
		if (type.equals("tour")) {
			return "pay/tourPaySuccess";
		}
		return "pay/shopPaySuccess";
	}
}
