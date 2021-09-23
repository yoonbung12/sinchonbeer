package com.bitcamp.sc.tour.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.repository.TourDao;
import com.bitcamp.sc.tour.service.impl.MailServiceImpl;

@Service
public class ChangeReservationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private MailServiceImpl mailService;

	private TourDao tDao;

	public ChangeReservationService(TourDao tDao, MailServiceImpl service) {
		this.tDao = tDao;
		this.mailService = service;
	}

	// 주문 테이블의 투어 날짜 변경
	public boolean changeTourOrder(ChangeTourDto changeDto) {
		boolean result = false;
		logger.info("changeDto: " + changeDto.toString());

		int result1 = tDao.changeDateByMidx(changeDto.getOidx(), changeDto.getNewDate());
		logger.info("result1 값 :  " + result1);

		if (result1 == 1) {
			result = (modifyPeople(changeDto) == 2) ? true : false;
			logger.info("인원 변경 결과  :" + result);
		}

		return result;
	}

	// 변경된 날짜와 기존 날짜 인원 증가,감소 확인
	private int modifyPeople(ChangeTourDto changeDto) {
		return tDao.modifyTour(changeDto.getTourPeople(), changeDto.getNewDate(), changeDto.getResDate());
	}
	
	// 메일 서비스로 보내기
	public void sendMail(ChangeTourDto changeDto, LoginInfo loginInfo)  {
		
		Map<String,Object> params = new HashMap<>();
		
		params.put("email", loginInfo.getEmail());
		params.put("name", loginInfo.getName());
		params.put("phone", loginInfo.getPhone());
		params.put("people", changeDto.getTourPeople());
		params.put("newDate", changeDto.getNewDate());
		logger.info("map: "+params);
			mailService.sendMail(params);
	}

}
