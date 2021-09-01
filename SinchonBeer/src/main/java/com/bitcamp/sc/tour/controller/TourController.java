package com.bitcamp.sc.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TourController {
	@RequestMapping("/tour")
	public String getTour() {
		return "tour/tour";
	}
}
