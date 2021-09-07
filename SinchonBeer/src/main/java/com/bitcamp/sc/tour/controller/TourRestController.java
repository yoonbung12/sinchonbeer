package com.bitcamp.sc.tour.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.sc.tour.domain.TourDto;
import com.bitcamp.sc.tour.service.TourService;
import com.bitcamp.sc.tour.service.impl.TourServiceImpl;

@RestController
public class TourRestController {
	
	@Autowired
	TourService service;
	
	@GetMapping("/tour/count")
	public int getCount(@RequestParam("mid") String date) {
		System.out.println(date);
		return service.selectCount(date);
	}
	// 예약 변경 확정 버튼 클릭 처리 -> orders테이블 tidx 수정 -> tour 테이블 날짜 각각 인원 수정
	@PostMapping("/tour/changeTour")
	public void changeTour(@RequestParam Map<String,Object> params) {
		// ajax로 넘겨받은 값
//		int midx =(Integer) params.get("midx");
//		System.out.println(midx);
//		String resDate =(String) params.get("resDate");
//		String newDate =(String) params.get("newDate");
		
		service.changeTourOrder(params);
		
		
	}

	

	
}
