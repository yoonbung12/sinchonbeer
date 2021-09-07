package com.bitcamp.sc.order.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.member.repository.MemberDao;
import com.bitcamp.sc.member.service.impl.MemberServiceImpl;
import com.bitcamp.sc.order.domain.OrderInfo;
import com.bitcamp.sc.order.service.impl.OrderServiceImpl;

@SpringBootTest
class OrderServiceTest {
	
	@Autowired
	MemberServiceImpl memberService;
	@Autowired
	OrderServiceImpl orderService;
	@Autowired
	MemberDao memberDao;
	
	@Test
	@Transactional
	@Rollback(true)
	@DisplayName("주문정보를 넣으면 주문이 생성된다")
	void createOrderTest() {
		// given
		// String category, int price, int tourIdx, int tourPeople, int memberIdx, int addressIdx
		OrderInfo orderInfo = new OrderInfo("tour", 3000, 60, 3, 2, 1);
		
		// when
		int orderIdx = orderService.createOrder("tour", orderInfo);
		
		// then
		OrderInfo findOrderInfo = orderService.getOrderInfo(orderIdx);
		
		assertThat(findOrderInfo.getCategory()).isEqualTo(orderInfo.getCategory());
		assertThat(findOrderInfo.getPrice()).isEqualTo(orderInfo.getPrice());
		assertThat(findOrderInfo.getTourIdx()).isEqualTo(orderInfo.getTourIdx());
		assertThat(findOrderInfo.getTourPeople()).isEqualTo(orderInfo.getTourPeople());
		assertThat(findOrderInfo.getMemberIdx()).isEqualTo(orderInfo.getMemberIdx());
		assertThat(findOrderInfo.getAddressIdx()).isEqualTo(orderInfo.getAddressIdx());
	}
	
	@Test
	void getMemberTest() {
		// given
		
		// when
		Member member = memberDao.selectByEmail("cool2");
		
		// then
		
		System.out.println(member);
	}
	
//	@Test
//	void getOrderInfoTest() {
//	}

//	@Test
//	@DisplayName("주문 카테고리와 멤버 아이디로 조회할 수 있다")
//	void getOrdersInfosTest() {
//		// given
//		List<OrderInfo> orderInfos = new ArrayList<>();
//		
//		// when
//		orderInfos = orderService.getOrdersInfos("shop", "cool@naver.com");
//		
//		System.out.println(orderInfos.size());
//		
//		// then
//		assertThat(orderInfos.size()).isEqualTo(5);
//	}
}
