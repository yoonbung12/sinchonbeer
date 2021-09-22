package com.bitcamp.sc.basket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.sc.basket.domain.BasketDto;
import com.bitcamp.sc.basket.domain.BasketVo;
import com.bitcamp.sc.basket.service.BasketService;
import com.bitcamp.sc.member.domain.LoginInfo;

@Controller
@RequestMapping("/basket")
public class BasketController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private BasketService basketService;

	@Autowired
	public BasketController(BasketService basketService) {
		this.basketService = basketService;
	}

	// 장바구니 조회 및 총 금액 가져오기
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getBasketPage(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		if (loginInfo != null) {
			List<BasketVo> list = basketService.getList(loginInfo.getIdx());
			model.addAttribute("list", list);
			int total = basketService.getTotalPayByMidx(loginInfo.getIdx());

			model.addAttribute("total", total);

			logger.info(model.getAttribute("list").toString());
		}

		return "basket/basket";
	}

	// 장바구니 목록생성
	@RequestMapping(value = "/basket", method = RequestMethod.GET) // 원래는POST로 받을것
	public String getBasket(BasketDto bDto) {
		logger.info(bDto.toString());

		// 장바구니 목록을 만들고
		if (bDto != null) {

			basketService.saveBasket(bDto);
		}
		return "redirect:/basket/cart";
	}
	
	// 장바구니 목록넘기기 테스트
	@RequestMapping(value = "/basket/finalTest", method = RequestMethod.GET)
	public String getTestPage(
			
			@RequestParam("payPrice") int payPrice,
			
			
			Model model
			
			
			) {
			
			model.addAttribute("payPrice", payPrice);
			return "basket/finalTest";
	}
	
	
}