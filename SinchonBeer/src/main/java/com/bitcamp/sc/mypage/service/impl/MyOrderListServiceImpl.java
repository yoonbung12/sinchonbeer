package com.bitcamp.sc.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.mypage.domain.OrderList;
import com.bitcamp.sc.mypage.repository.MypageDao;
import com.bitcamp.sc.mypage.service.MyOrderListService;

@Service
public class MyOrderListServiceImpl implements MyOrderListService {
	MypageDao dao;

	@Autowired
	public MyOrderListServiceImpl(MypageDao dao) {
		this.dao = dao;
	}

	// 주문 내역 조회
	@Override
	public List<OrderList> getOrderList(int idx) {
		return dao.getOrderList(idx);
	}
}
