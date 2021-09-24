package com.bitcamp.sc.mypage.service;

import java.util.List;

import com.bitcamp.sc.mypage.domain.RezList;

public interface MyRezListService {

	// 예약 내역 조회
	List<RezList> getRezList(int idx);
}
