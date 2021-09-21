package com.bitcamp.sc.tour.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.repository.TourDao;

@Service
public class ChangeReservationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private TourDao tDao;
	
	@Autowired
	public ChangeReservationService(TourDao tDao) {
		this.tDao = tDao;
	}

	// 투어 주문 정보 가져오기
	public List<TourOrderInfo> getTourOrder(int midx,String category){
		logger.info("투어 예약 정보 가져오기");
		return tDao.getTourOrderByMidx(midx, category);
	}
	
	// 주문 테이블의 투어 날짜 변경
	public boolean changeTourOrder(ChangeTourDto changeDto) {
		boolean result = false;
		logger.info("changeDto: "+changeDto.toString());
		int result1 = tDao.changeDateByMidx(changeDto.getMidx(), changeDto.getNewDate());
		logger.info("result1 값 :  "+result1);
		if(result1 == 1) {
		result =(modifyPeople(changeDto) == 2) ? true : false;
		logger.info("인원 변경 결과  :"+result);
		}
		return result;
	}

	private int modifyPeople(ChangeTourDto changeDto) {
		return tDao.modifyTour(changeDto.getTourPeople(),changeDto.getNewDate(), changeDto.getResDate());
		
	}
	
}
