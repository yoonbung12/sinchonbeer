package com.bitcamp.sc.tour.service;


import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.repository.TourDao;

@Service
public class ChangeReservationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MailService mailService; 
	
	private TourDao tDao;
	
	
	public ChangeReservationService(TourDao tDao,MailService service) {
		this.tDao = tDao;
		this.mailService = service;
	}

	// 투어 주문 정보 가져오기
	public List<TourOrderInfo> getTourOrder(int midx,String category){
		logger.info("투어 예약 정보 가져오기");
		return tDao.getTourOrderByMidx(midx, category);
	}
	
	// 주문 테이블의 투어 날짜 변경
	public boolean changeTourOrder(ChangeTourDto changeDto,LoginInfo loginInfo)  {
		boolean result = false;
		logger.info("changeDto: "+changeDto.toString());
		
		int result1 = tDao.changeDateByMidx(changeDto.getMidx(), changeDto.getNewDate());
		logger.info("result1 값 :  "+result1);
		
		if(result1 == 1) {
			result =(modifyPeople(changeDto) == 2) ? true : false;
			logger.info("인원 변경 결과  :"+result);
			
			TourOrderInfo info = setOrderInfo(changeDto, loginInfo);
			logger.info("tourInfo : "+info);
			logger.info("memail : "+loginInfo.getEmail());
			
		
				sendMail(loginInfo.getEmail(), info);
				
		
				logger.info("메일 전송 실패");			
				
		
				logger.info("메일 전송 성공");
		
			
			
		}
		
		return result;
	}
	
	
	// 변경된 날짜와 기존 날짜 인원 증가,감소 확인
	private int modifyPeople(ChangeTourDto changeDto) {
		return tDao.modifyTour(changeDto.getTourPeople(),changeDto.getNewDate(), changeDto.getResDate());
	}
	// 메일 보내기 위한 set 객체
	private TourOrderInfo setOrderInfo(ChangeTourDto changeDto,LoginInfo loginInfo) {
		return new TourOrderInfo(loginInfo.getName(), changeDto.getNewDate(), changeDto.getTourPeople(), loginInfo.getPhone());
	}
	// 메일 서비스로 보내기
	private void sendMail(String email,TourOrderInfo info)  {
		logger.info("이메일 + info: "+email +" : "+info);
			mailService.sendMail(email,info);
	}
	
}
