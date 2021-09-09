package com.bitcamp.sc.tour.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.tour.domain.TourDto;
import com.bitcamp.sc.tour.service.TourService;
import com.bitcamp.sc.tour.service.impl.TourAuthPhoneNumberService;
import com.bitcamp.sc.tour.service.impl.TourServiceImpl;

@RestController
public class TourRestController {

	@Autowired
	TourService service;
	@Autowired
	TourAuthPhoneNumberService authNumberService;

	@GetMapping("/tour/count")
	public int getCount(@RequestParam("mid") String date) {
		System.out.println(date);
		return service.selectCount(date);
	}

	// 예약 변경 확정 버튼 클릭 처리 -> orders테이블 tidx 수정 -> tour 테이블 날짜 각각 인원 수정
	@PostMapping("/tour/changeTour")
	public void changeTour(@RequestParam Map<String, Object> params) {
		service.changeTourOrder(params);
	}
	
	// db 휴대전화번호와 일치여부 
	@GetMapping("/verifyMyPhone")
	public String verifyMyPhone(@RequestParam("phone") String ph,HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo)session.getAttribute("loginInfo");
		String result ="";
		if(login.getPhone().equals(ph)) {
			result = "Y";
			System.out.println("휴대전화 번호 일치");
		}else {
			result = "N";
			System.out.println("휴대전화 번호 불일치");
		}
			
		return result;
	}

	// 휴대전화 인증
	@ResponseBody
	@GetMapping("/sendMessage")
	public String getPhoneNumber(@RequestParam("phone") String ph) {
		
		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		System.out.println("수신자 번호 : " + ph);
		System.out.println("인증번호 : " + numStr);
		authNumberService.authNumberByPhone(ph, numStr);

		return numStr;

	}

}
