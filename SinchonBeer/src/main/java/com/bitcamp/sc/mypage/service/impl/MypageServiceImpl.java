package com.bitcamp.sc.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.cart.domain.CartVO;
import com.bitcamp.sc.cart.repository.CartDao;
import com.bitcamp.sc.mypage.service.MypageService;
import com.bitcamp.sc.pay.domain.PayInfo;
import com.bitcamp.sc.pay.repository.PayDao;
import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.repository.impl.MybatisTourDao;

@Service
public class MypageServiceImpl implements MypageService {
	PayDao payDao;
	MybatisTourDao tourDao;

	@Autowired
	public MypageServiceImpl(PayDao payDao, MybatisTourDao tourDao) {
		this.payDao = payDao;
		this.tourDao = tourDao;
	}

	// 결제 정보 조회
	@Override
	public List<PayInfo> getPayInfosByType(String type, int memberIdx) {
		return payDao.findByCategoryAndMemberIdx(type, memberIdx);
	}

	// 주문 내역 조회

	// 예약 내역 조회
	@Override
	public List<TourOrderInfo> getTourOrder(int midx, String category) {
		return tourDao.getTourOrderByMidx(midx, category);
	}
}
