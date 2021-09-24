package com.bitcamp.sc.mypage.service;

import java.util.List;

import com.bitcamp.sc.mypage.domain.OrderList;

public interface MyOrderListService {
	
	// 주문 내역 조회
	List<OrderList> getOrderList(int idx);
}
