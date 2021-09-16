package com.bitcamp.sc.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.tour.domain.TourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.service.TourService;

@Controller
@RequestMapping("/tour")
public class TourController {

//	TestMemberServiceImpl service;

	@Autowired
	TourService service;

	// 투어 메인 페이지
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getTour() {
		return "tour/views/tour";
	}

	// 투어 안내 페이지
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String getTourInfo() {
		return "tour/views/info";
	}

	// 투어 공지 페이지
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String getTourNotice() {
		return "tour/views/notice";
	}

	// 투어 공지 페이지에서 /번호로 식별
	@RequestMapping(value = "/notice/{idx}", method = RequestMethod.GET)
	public String getTourNoticeDesc(@PathVariable("idx") int idx) {
		return "tour/views/notice" + idx;
	}

	// 투어 예약 페이지 이동
	@RequestMapping(value = "/pick-date", method = RequestMethod.GET)
	public String getPickDate() {

		return "tour/makeReservation/pick-date";
	}

	// 날짜 , 인원 선택 후 예약 폼으로 이동 --> 로그인 여부 체크 / 날짜,인원,카테고리(투어), 회원 정보가 잘 들어오는지 ?
	@RequestMapping(value = "/reserve/form", method = RequestMethod.GET)
	public String getForm(
			@ModelAttribute TourDto tour,
			Model model
			) {

		System.out.println(tour);
		model.addAttribute("tour", tour);

		return "tour/makeReservation/reservationForm";
	}

	// 주문 테이블로 넘기기 위한 객체 맵핑 테스트 -> 성공
	@RequestMapping(value = "/final", method = RequestMethod.POST)
	public String getFinal(
			@ModelAttribute TourDto tour,
			@RequestParam("pType") String pway,
			Model model
			) {

		System.out.println(tour);

		model.addAttribute("tour", tour);
		model.addAttribute("pway", pway);
		return "tour/testFinal";
	}

	// 투어 예약 변경/확인/취소 페이지 가져오기
	@RequestMapping(value = "/change-info", method = RequestMethod.GET)
	public String getchangePage(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");

		// 로그인 상태가 아닐 경우 예약 페이지로 이동
		String category = "tour";
		// 로그인된 회원 중 예약 내역일 없을 경우도 예약 페이지로 이동
		List<TourOrderInfo> list = service.getTourOrder(login.getIdx(), category);

		// 로그인 상태이고 예약 정보가 있다면 모델에 저장
		model.addAttribute("tourOrderList", list);
		System.out.println(list);
		return "tour/changeReservation/change-info";
	}

}
