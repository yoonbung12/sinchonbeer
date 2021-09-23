package com.bitcamp.sc.basket.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
//	responsebody
	// 장바구니 결제 페이지로 (test)
	@RequestMapping(value="/basket/final_test", method = RequestMethod.GET)
	public String getTestPage(
			
			@ModelAttribute  BasketVo basketVo,
			
			@RequestParam("gphotoname") String gphotoname,
			@RequestParam("gname") String gname,
			@RequestParam("gidx") int gidx,
			@RequestParam("bidx") int bidx,
			@RequestParam("gprice") int gprice,
			@RequestParam("count") int count,
			@RequestParam("amount") int amount,
			
			Model model
			
			) {
		
			model.addAttribute("basketVo", basketVo);
		
			model.addAttribute("gphotoname", gphotoname);
			model.addAttribute("gname", gname);
			model.addAttribute("gidx", gidx);
			model.addAttribute("bidx", bidx);
			model.addAttribute("gprice", gprice);
			model.addAttribute("count", count);
			model.addAttribute("amount", amount);
			
			System.out.println(gphotoname);
			System.out.println(gname);
			System.out.println(gidx);
			System.out.println(bidx);
			System.out.println(gprice);
			System.out.println(count);
			
			return "basket/final_test";
		
	}
	
	
}