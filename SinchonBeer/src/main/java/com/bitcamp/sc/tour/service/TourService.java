package com.bitcamp.sc.tour.service;

import java.util.List;
import java.util.Map;

import com.bitcamp.sc.tour.domain.ChangeTourDto;
import com.bitcamp.sc.tour.domain.TourOrderInfo;

public interface TourService {
	// 현재 예약 가능 인원 가져오기
	int selectCount(String date);
	// 투어날짜로 tidx 값 가져오기
	int getTidxByTdate(String tdate);
	// 투어예약 : 주문+결제 완료
	int addTourPeopleByDate(int tourPeople,String tdate);
	
	//////////////////////////////////////////////////////////
	
	// 투어 예약 정보 가져오기
	List<TourOrderInfo> getTourOrder(int midx,String category);
	// 주문에 투어 예약 정보 변경
	void changeTourOrder(ChangeTourDto changeDto);

}
