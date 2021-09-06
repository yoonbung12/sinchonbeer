package com.bitcamp.sc.tour.repository;

import java.sql.Date;

public interface TourDao {
	// 현재 인원 값을 가져오기
	int selectCount(Date date);
	// 새로운 예약, 예약 변경
	void addTourPeople(int midx,Date newDate);
	// 예약 취소, 예약 변경
	void subTourPeople(int midx,Date currentDate);
	
	// 
	void changeDateByMidx(int midx,Date newDate);
	
	
	
	
	
	
	
	
}
