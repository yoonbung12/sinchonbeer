package com.bitcamp.sc.tour.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.service.ChangeReservationService;

@Controller
public class ChangeTourController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ChangeReservationService changeTourService;
	
	// 투어 예약 변경/확인/취소 페이지 가져오기
	@RequestMapping(value = "/tour/change-info", method = RequestMethod.GET)
	public String getChangePage(Model model, HttpServletRequest req) {

		
		LoginInfo login = getLoginInfo(req);
		logger.info("login: "+login);

		// 로그인된 회원 중 예약 내역일 없을 경우도 예약 페이지로 이동
		List<TourOrderInfo> list = changeTourService.getTourOrder(login.getIdx(), "tour");
		logger.info(list.toString());
		if(list.isEmpty()) {
			logger.info("예약 정보가 없습니다.");
			
		}
		// 로그인 상태이고 예약 정보가 있다면 모델에 저장
		model.addAttribute("tourOrderList", list);
		
		return "tour/changeReservation/change-info";
	}
	
	

	// 예약 변경 확정 버튼 클릭 처리 -> orders테이블 tidx 수정 -> tour 테이블 날짜 각각 인원 수정
	@PostMapping("/tour/changeTour")
	@ResponseBody
	public boolean changeTour(@ModelAttribute("changeTour") ChangeTourDto changeDto, HttpServletRequest req ) {
		boolean result = false;
		logger.info(changeDto.toString());
		
		LoginInfo login = getLoginInfo(req);
		
		
		return changeTourService.changeTourOrder(changeDto,login) == true ? true : result ;
	}
	
	// 세션 정보 가져오기
	private LoginInfo getLoginInfo(HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");
		return login;
	}
	
	
	
}
