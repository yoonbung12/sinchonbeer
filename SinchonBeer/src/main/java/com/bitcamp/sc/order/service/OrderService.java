package com.bitcamp.sc.order.service;

import java.util.List;

import com.bitcamp.sc.order.domain.OrderInfo;

public interface OrderService {
	int createOrder(String type, OrderInfo orderInfo); // 새로운 주문을 생성 
	OrderInfo getOrderInfo(int orderIdx); // 주문 번호로 주문정보를 받아옴
	List<OrderInfo> getOrdersInfos(String type, String memberId); // 유저 아이디로 주문정보 리스트를 받아옴
}
