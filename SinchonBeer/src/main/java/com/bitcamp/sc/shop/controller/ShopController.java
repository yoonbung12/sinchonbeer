package com.bitcamp.sc.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.sc.cart.domain.GoodsToCart;
import com.bitcamp.sc.shop.service.ShopService;

@Controller
public class ShopController {

//	@Autowired
//	ShopService service;
	
	// shop메인 페이지
	@RequestMapping(value="/shop", method = RequestMethod.GET)
	public String getShop() {
		return "shop/shopMain";
	}
	
	// 상품 상세페이지
	@RequestMapping(value="/shop/{idx}", method = RequestMethod.GET)
	public String getShopDesc(@PathVariable("idx") int idx) {
		String result = "shop/product";
			
		if(idx == 1) {
			result += "1";
			System.out.println("결과 : " + result + " : " + idx);
		} else if(idx == 2) {
			result += "2";
			System.out.println("결과 : " + result + " : " + idx);
		} else if(idx == 3) {
			result += "3";
			System.out.println("결과 : " + result + " : " + idx);
		} else if(idx == 4) {
			result += "4";
			System.out.println("결과 : " + result + " : " + idx);
		}
		return result;
		
	}
	
	
	 // BuyNow 페이지로 가기
	 // @RequestParam("name 이름") 타입지정 변수명
	
	@RequestMapping(value="/shop/shop_payment", method = RequestMethod.GET)
	public String getBuyNow(	
			
			@RequestParam("gphotoname") String gphotoname,
			@RequestParam("gname") String gname,
			@RequestParam("gidx") int gidx,
			@RequestParam("gprice") int gprice,
			@RequestParam("amount") int amount,
			
			Model model
			) {
			
			model.addAttribute("gphotoname", gphotoname);
			model.addAttribute("gname", gname);
			model.addAttribute("gidx", gidx);
			model.addAttribute("gprice",gprice);
			model.addAttribute("amount", amount);
			
			System.out.println("입력한 gname : " + gname);
			System.out.println("입력한 idx : " + gidx);
			System.out.println("입력한 gprice : " + gprice);
			System.out.println("입력한 amount : " + amount);
			
			return "shop/shop_payment";
		
	}
	// cart 페이지로 가기
	@RequestMapping(value="/cart/cart", method= RequestMethod.GET)
	public String getCart(
			GoodsToCart goodsToCart,
			@RequestParam("gphotoname") String gphotoname,
			@RequestParam("gname") String gname,
			@RequestParam("gidx") int gidx,
			@RequestParam("amount") int amount,
			@RequestParam("gprice") int gprice,
		
			Model model
			) {
		
		model.addAttribute("gphotoname", gphotoname);
		model.addAttribute("amount", amount);
		model.addAttribute("gname", gname);
		model.addAttribute("gidx", gidx);
		model.addAttribute("gprice",gprice);
		List<GoodsToCart> list = new ArrayList<>();
		
		list.add(new GoodsToCart(goodsToCart.getIdx(), goodsToCart.getGprice(), goodsToCart.getAmount()));
//		list.add(new GoodsToCart(goodsToCart.getIdx(), goodsToCart.getGprice(), goodsToCart.getAmount()));
//		list.add(new GoodsToCart(goodsToCart.getIdx(), goodsToCart.getGprice(), goodsToCart.getAmount()));
//		list.add(new GoodsToCart(goodsToCart.getIdx(), goodsToCart.getGprice(), goodsToCart.getAmount()));
		System.out.println(list.get(0).getIdx());
		model.addAttribute("list", list);
		return "cart/cart";
		
	}
	
	
}
