package com.bitcamp.sc.mypage.service;

import java.util.List;

import com.bitcamp.sc.pay.domain.PayInfo;
import com.bitcamp.sc.tour.domain.TourOrderInfo;

public interface MypageService {
	// 결제 정보 조회
	List<PayInfo> getPayInfosByType(String type, int idx);

	// 주문 내역 조회

	// 예약 내역 조회
	List<TourOrderInfo> getTourOrder(int midx, String category);
}
