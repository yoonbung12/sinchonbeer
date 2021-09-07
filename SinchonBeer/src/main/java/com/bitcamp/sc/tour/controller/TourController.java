package com.bitcamp.sc.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.tour.domain.TourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.service.TourService;

@Controller
public class TourController {
	
	
//	TestMemberServiceImpl service;
	
	@Autowired
	TourService service;
	
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
			@ModelAttribute TourDto tour,
			Model model
			) {
		System.out.println(tour);
		model.addAttribute("tour",tour);

		return "tour/reservationForm";
	}
	
	// 주문 테이블로 넘기기 위한 객체 맵핑 테스트 -> 성공
	@RequestMapping(value="/tour/final",method = RequestMethod.POST)
	public String getFinal(@ModelAttribute TourDto tour,Model model) {
		
		System.out.println(tour);

	model.addAttribute("tour", tour);
		return "tour/testFinal";
	}
	
	
	
	// 투어 예약 변경/확인/취소 페이지 가져오기
	@RequestMapping(value="/tour/change-info",method=RequestMethod.GET)
	public String getchangePage(Model model) {
		String category="tour";
		int midx = 3;
		// 로그인 상태가 아닐 경우 예약 페이지로 이동
		if(midx == 0) {
			return "tour/pick-date";
		}
		// 로그인된 회원 중 예약 내역일 없을 경우도 예약 페이지로 이동
		List<TourOrderInfo> list = service.getTourOrder(midx, category);
		if(list == null) {
			// 예약 페이지 이동 처리
		}
		// 로그인 상태이고 예약 정보가 있다면 모델에 저장
		model.addAttribute("tourOrderList", list);
//		HttpSession session = req.getSession();
//		
//		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
//		if(loginInfo == null) {
//			System.out.println("로그인이 필요합니다");
//			return "tour/login";
//		}else {
//			System.out.println(loginInfo.getIdx());
//		}
			
		return "tour/change-info";
	}
	
	
	// ------------------테스트 중---------------- 
//	@PostMapping("/tour/loginCk")
//	public String getLogin(@RequestParam("email") String email, @RequestParam("pw") String pw,HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		if(service.login(email, pw, session)) {
//			System.out.println("로그인 성공");
//			return "tour/tour";
//		}else {
//			System.out.println("오류");
//			return "tour/info";
//		}
//		
//		
//	}
//	
//	
//	
	
	
	
	
	
	
}

