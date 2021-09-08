package com.bitcamp.sc.tour.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.order.repository.impl.MemoryOrderDao;
import com.bitcamp.sc.tour.domain.TourOrderInfo;

@SpringBootTest
public class MybatisTourDaoTest {
	
	@Autowired
	MybatisTourDao dao;
	
	@Test
	@Transactional
	@Rollback(true)
	void 가능인원조회() {
		
		// given
		String date = "2021-09-06";
		Date ckDate = Date.valueOf(date);
		
		// when
		int result = dao.selectCount(ckDate);
		
		//then
//		assertNotNull(result, "정상적으로 가져옴");
		assertEquals(12, result);
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void 투어예약완료() {
	
		int midx = 3;
		String date = "2021-09-11";
		Date newDate = Date.valueOf(date);
		
		dao.addTourPeople(midx, newDate);		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void 투어취소() {
		int midx=3;
		String date ="2021-09-11";
		Date curDate = Date.valueOf(date);
		
		dao.subTourPeople(midx, curDate);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void 투어예약변경() {
		// 멤버 번호
		int midx=3;
		// 기존 예약 날짜
		String currentDate ="2021-09-11";
		Date cDate = Date.valueOf(currentDate);
		// 바뀌는 예약 날짜
		String newDate = "2021-09-12";
		Date nDate = Date.valueOf(newDate);
		String category = "tour";
		
		//select: 주문 테이블에서  회원의 투어예약 내역을 조회 화면에 뿌려줌 -> 
		// 회원이 날짜를 선택 해당 날짜의 가능인원 여부를 비동기 통신으로 가져옴 -> 
		// 바뀐 날짜가 선택되고 예약 변경 확정 버튼을 누르게 되면 회원번호와 새로운 날짜가 파라미터로 전송 -> 
		// 주문 테이블에 있는 투어번호키가 새로운 날짜로 update 바뀜 - > 
		// 동시에 투어에 기존예약 날짜의 인원은 (-) -> 바뀐예약 날짜의 인원은 (+)  
		List<TourOrderInfo> selectTourOrders = new ArrayList<>();
		selectTourOrders = dao.getTourOrderByMidx(midx, category);
		assertThat(selectTourOrders.size()).isEqualTo(1);
		
		
		//update: 주문 테이블 tidx 변경
		dao.changeDateByMidx(midx, nDate);
		//update : 기존 날짜 변경
		dao.subTourPeople(midx, cDate);
		//update : 바뀐 날짜 변경 
		dao.addTourPeople(midx, nDate);
		
		
	}
	// memberdao 테스트 ---> null....
	@Test
	@Transactional
	@Rollback(true)
	void 로그인테스트() {

		String email = "cool@naver.com";
		String pw= "1111";
//		Member member = mdao.selectByEmailPw(email, pw);
		
			
//		System.out.println(member.getIdx());
				
	}
	
	
	
	
	
	
	
}
