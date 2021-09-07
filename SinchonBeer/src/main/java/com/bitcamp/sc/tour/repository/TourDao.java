package com.bitcamp.sc.tour.repository;

import java.sql.Date;
import java.util.List;

import com.bitcamp.sc.tour.domain.TourOrderInfo;

public interface TourDao {
	// 현재 인원 값을 가져오기
	int selectCount(Date date);
	// 새로운 예약, 예약 변경
	int addTourPeople(int midx,Date newDate);
	// 예약 취소, 예약 변경
	int subTourPeople(int midx,Date currentDate);
	
	// 
	int changeDateByMidx(int midx,Date newDate);
	
	List<TourOrderInfo> getTourOrderByMidx(int midx,String category);
	
	
	
	
	
	
}
