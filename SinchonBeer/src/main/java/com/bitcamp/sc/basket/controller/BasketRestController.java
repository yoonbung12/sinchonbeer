package com.bitcamp.sc.basket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.sc.basket.domain.BasketDto;
import com.bitcamp.sc.basket.service.BasketService;

@RestController
public class BasketRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private BasketService basketService;
	@Autowired
	public BasketRestController(BasketService basketService) {
		this.basketService = basketService;
	}
	
	@GetMapping("/deleteRow")
	public boolean getDeleteRow(@RequestParam("gidx") int gidx,@RequestParam("midx") int midx) {
		boolean result = false; 
		int cnt = basketService.getDeleteRowByGidx(gidx,midx);
		if(cnt > 0) {
			logger.info("선택 상품이 삭제되었습니다.");
			result = true;
		}
		return  result;
	}
	
	@GetMapping("/deleteAllByMidx/{midx}")
	public void deleteAll(@PathVariable("midx") int midx) {
		basketService.deleteAllByMidx(midx);
	}
	@GetMapping("/basket/changeAmount")
	public boolean modifyAmount(BasketDto bDto) {
		boolean result = false;
		int check = basketService.changeBasketAmount(bDto);
		if(check == 1) {
			result = true;
		}
		
		return result;
		
	}
	
	// 선택된 체크 박스 삭제
	@PostMapping("/deleteBasketByPicking")
	public int deleteBasketByPicking(
			
			@RequestParam(value="gidxList[]") List<Integer> gidxList,
			@RequestParam(value="midx") int midx
			
			
			) {
		
		int result = 0;
		logger.info("gidx List : " + gidxList.toString());
		logger.info("받아온 midx 값 : " + midx);
		// service에 반복문?
		if(!gidxList.isEmpty()) {
			result = basketService.getDeleteRowByGidx(gidxList, midx);
		}
		if(result > 0) {
			logger.info("삭제 성공");
		}
		return result;
		
	}
	
}