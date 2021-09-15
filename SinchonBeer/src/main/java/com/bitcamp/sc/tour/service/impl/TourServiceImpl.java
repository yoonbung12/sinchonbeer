package com.bitcamp.sc.tour.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.repository.impl.MybatisTourDao;
import com.bitcamp.sc.tour.service.TourService;
@Service
public class TourServiceImpl implements TourService {
	
	private MybatisTourDao dao;
	
	@Autowired
	public TourServiceImpl(MybatisTourDao dao) {
		this.dao = dao;
	}
	// 투어 가능 인원 가져오기
	@Override
	public int selectCount(String date) {
		Date ckDate = Date.valueOf(date);
		return dao.selectCount(ckDate);
	}
	// 투어 날짜로 투어 번호 가져오기
	@Override
	public int getTidxByTdate(String tdate) {
		Date ckDate = Date.valueOf(tdate);
		return dao.getTidxbyTdate(ckDate);
	}
	
	// 투어 : 결제 성공시 예약 날짜 인원 증가  / 
	@Override
	public int addTourPeopleByDate(int tourPeople,String tdate) {
		Date ckDate = Date.valueOf(tdate);	
		return dao.addTourPeople(tourPeople, ckDate);
	}
	
	// 투어 : 결제 취소시 예약 날짜 인원 감소 
	@Override
	public int subTourPeopleByDate(int tourPeople, String tdate) {
		Date ckDate = Date.valueOf(tdate);	
		return dao.subTourPeople(tourPeople, ckDate);
	}
	
	
	// 투어 주문 정보 가져오기
	public List<TourOrderInfo> getTourOrder(int midx,String category){
		return dao.getTourOrderByMidx(midx, category);
	}
	
	// 주문 테이블의 투어 날짜 변경
	@Override
	public void changeTourOrder(ChangeTourDto changeDto) {
		System.out.println(changeDto);	
		int result = dao.changeDateByMidx(changeDto.getMidx(), changeDto.getNewDate());
		System.out.println(result);
		if(result == 1) {
			dao.addTourPeople(changeDto.getTourPeople(), changeDto.getNewDate());
			dao.subTourPeople(changeDto.getTourPeople(), changeDto.getResDate());
		}
		
	}

	
	
	// String -> Date
	public Date changeToDate(String date) {
		return Date.valueOf(date);
	}
	
	


	
}
