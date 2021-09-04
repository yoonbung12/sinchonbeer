package com.bitcamp.sc.tour.repository;

import java.sql.Date;

public interface TourDao {
	// 현재 인원 값을 가져오기
	int selectCount(Date date);
	
	
}
