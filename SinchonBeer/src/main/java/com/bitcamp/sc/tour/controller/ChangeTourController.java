package com.bitcamp.sc.tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.order.domain.OrderInfo;
import com.bitcamp.sc.order.service.OrderService;
import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.service.ChangeReservationService;
import com.bitcamp.sc.tour.service.TourService;

@Controller
public class ChangeTourController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private ChangeReservationService changeTourService;

	private OrderService orderService;

	private TourService service;

	public ChangeTourController(ChangeReservationService changeTourService, 
								OrderService orderService,
								TourService service) {

		this.changeTourService = changeTourService;
		this.orderService = orderService;
		this.service = service;
	}

	// 투어 예약 변경/확인/취소 페이지 가져오기
	@RequestMapping(value = "/tour/change-info", method = RequestMethod.GET)
	public String getChangePage(Model model, HttpServletRequest req) {

		LoginInfo login = getLoginInfo(req);
		logger.info("login: " + login);

		// 로그인된 회원 중 예약 내역일 없을 경우도 예약 페이지로 이동
		List<OrderInfo> list = orderService.getOrderInfosByType("tour", login.getIdx());

		logger.info("list : " + list);

		// 로그인 상태이고 예약 정보가 있다면 모델에 저장
		model.addAttribute("tourOrderList", list);

		if (!list.isEmpty()) {
			logger.info("예약 정보가 존재 합니다.");

			// 날짜가 담긴 리스트
			List<String> dateList = service.getDateToList(list);

			logger.info("list2 size : " + dateList.size());
			logger.info("새롭게 생성된  dateList : " + dateList);

			model.addAttribute("tourDate", dateList);
		}

		return "tour/changeReservation/change-info2";
	}

	// 예약 변경 확정 버튼 클릭 처리 -> orders테이블 tidx 수정 -> tour 테이블 날짜 각각 인원 수정
	@PostMapping("/tour/changeTour")
	@ResponseBody
	public boolean changeTour(@RequestBody ChangeTourDto changeDto) {
		boolean result = false;

		logger.info(changeDto.toString());

		return changeTourService.changeTourOrder(changeDto) == true ? true : result;
	}
	
	// 예약 변경 메일 전송
	@PostMapping("/tour/sendMailchange")
	@ResponseBody
	public void sendChangeMail(@RequestBody ChangeTourDto changeDto,HttpServletRequest req) {
		LoginInfo login = getLoginInfo(req);
		
		logger.info("changeDto : "+changeDto);
		if(changeDto != null && login != null) {
			changeTourService.sendMail(changeDto, login);
		}
		
	}
	
	
	// 예약 취소
	@GetMapping("/tour/cancleOrder")
	@ResponseBody
	public int cancelTourOrder(@RequestParam("idx") int oidx, @RequestParam("people") int people,
			@RequestParam("tdate") String tdate) {
		logger.info("idx / people / tdate = " + oidx + " / " + people + " / " + tdate);

		int result = orderService.changeOrderStatus(oidx, "cancled");
		logger.info("주문 상태 변경 결과 : " + result);

		return (result == 1) ? service.subTourPeopleByDate(people, tdate) : 0;
	}

	// 세션 정보 가져오기
	private LoginInfo getLoginInfo(HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");
		return login;
	}

}
