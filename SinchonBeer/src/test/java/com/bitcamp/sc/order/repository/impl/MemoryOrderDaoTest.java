package com.bitcamp.sc.order.repository.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bitcamp.sc.order.domain.OrderInfo;

class MemoryOrderDaoTest {
	
	MemoryOrderDao dao;
	
	@BeforeEach
	void beforeEach() {
		dao = new MemoryOrderDao();
	}
	
	@AfterEach
	void afterEach() {
		dao.clearStore();
	}

	@Test
	void 주문등록() {
		// given
		LocalDateTime dateTime = LocalDateTime.of(2021, 9, 2, 11, 10); // 년, 월, 일, 시간, 분
		Timestamp timestamp = Timestamp.valueOf(dateTime);
		
		OrderInfo order = new OrderInfo("shop", 1, 2, 1, 22000, 3); // category, tourIdx, memberIdx, addressIdx, price, tourIdx 
		
		// when
		dao.save(order);
		
		// then
		assertThat(order).isEqualTo(dao.findByIdx(order.getIdx()));
	}
	
	@Test
	void 주문조회() {
		// given
		LocalDateTime dateTime = LocalDateTime.of(2021, 9, 2, 11, 10); // 년, 월, 일, 시간, 분
		Timestamp timestamp = Timestamp.valueOf(dateTime);
		
		OrderInfo order = new OrderInfo("shop", 1, 2, 1, 22000, 3); // category, tourIdx, memberIdx, addressIdx, price, tourIdx 
		dao.save(order);
		
		// when
		OrderInfo findOrder = new OrderInfo();
		findOrder = dao.findByIdx(order.getIdx());
		
		// then
		assertThat(findOrder).isEqualTo(order);
		System.out.println(order);
		System.out.println(findOrder);
	}

	@Test
	void 주문조회_실패() {
		// given
		LocalDateTime dateTime = LocalDateTime.of(2021, 9, 2, 11, 10); // 년, 월, 일, 시간, 분
		Timestamp timestamp = Timestamp.valueOf(dateTime);
		
		OrderInfo order = new OrderInfo("shop", 1, 2, 1, 22000, 3); // category, tourIdx, memberIdx, addressIdx, price, tourIdx 
		dao.save(order);
		
		// when
		OrderInfo findOrder = new OrderInfo();
		findOrder = dao.findByIdx(-1);
		
		// then
		assertThat(findOrder).isNotEqualTo(order);
	}

	@Test
	void 멤버인덱스로_주문조회() {
		// given
		LocalDateTime dateTime = LocalDateTime.of(2021, 9, 2, 11, 10); // 년, 월, 일, 시간, 분
		Timestamp timestamp = Timestamp.valueOf(dateTime);
		
		OrderInfo order1 = new OrderInfo("shop", 1, 2, 1, 22000, 3); // category, tourIdx, memberIdx, addressIdx, price, tourIdx 
		OrderInfo order2 = new OrderInfo("shop", 1, 2, 1, 22000, 3); // category, tourIdx, memberIdx, addressIdx, price, tourIdx 
		dao.save(order1);
		dao.save(order2);
		
		// when
		List<OrderInfo> findOrders = new ArrayList<>();
		findOrders = dao.findByMemberIdx(10);
		
		// then
		assertThat(findOrders.get(0)).isEqualTo(order1);
		assertThat(findOrders.get(1)).isEqualTo(order2);
	}

}
