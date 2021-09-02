package com.bitcamp.sc.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	

	
}
