package com.bitcamp.sc.tour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.tour.domain.TourInfo;

@Controller
public class TourController {
	
	// 투어 메인 페이지
	@RequestMapping(value = "/tour",method = RequestMethod.GET)
	public String getTour() {
		return "tour/tour";
	}
	
	// 투어 안내 페이지
	@RequestMapping(value = "/tour/info",method = RequestMethod.GET)
	public String getTourInfo() {
		return "tour/info";
	}
	
	// 투어 공지 페이지
	@RequestMapping(value= "/tour/notice", method = RequestMethod.GET)
	public String getTourNotice() {
		return "tour/notice";
	}
	
	// 투어 공지 페이지에서 /번호로 식별 
	@RequestMapping(value = "/tour/notice/{idx}", method = RequestMethod.GET)
	public String getTourNoticeDesc(@PathVariable("idx") int idx){
		String result = "tour/notice";
		
		if(idx == 1) {	
			result += "1";
			System.out.println("결과 :"+result+" : "+idx);
		}else if(idx == 2) {
			result += "2";
			System.out.println("결과 :"+result+" : "+idx);
		}else if(idx == 3) {
			result += "3";
			System.out.println("결과 :"+result+" : "+idx);
		}else if(idx == 4) {
			result += "4";
			System.out.println("결과 :"+result+" : "+idx);
		}
		return result;
	}
	
	// 투어 예약 페이지 이동
	@RequestMapping(value = "/tour/pick-date",method = RequestMethod.GET)
	public String getPickDate() {
		return "tour/pick-date";
	}
	
	// 날짜 , 인원 선택 후 예약 폼으로 이동 --> 로그인 여부 체크 / 날짜,인원,카테고리(투어), 회원 정보가 잘 들어오는지 ?
	@RequestMapping(value="/tour/reserve/form", method = RequestMethod.GET)
	public String getForm(
			@ModelAttribute TourInfo tour,
			Model model
			) {
		System.out.println(tour);
		model.addAttribute("tour",tour);

		return "tour/reservationForm";
	}
	
	
	
	
	
	
	// 투어 예약 변경/확인/취소 페이지 가져오기
	
	@RequestMapping(value="/tour/change-info",method=RequestMethod.GET)
	public String getchangePage() {
		return "tour/change-info";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
