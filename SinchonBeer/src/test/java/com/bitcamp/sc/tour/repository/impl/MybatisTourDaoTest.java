package com.bitcamp.sc.tour.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.HashMap;
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
import com.bitcamp.sc.member.repository.MemberDao;
import com.bitcamp.sc.order.repository.impl.MemoryOrderDao;

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
		
		//select: 주문 테이블에서 투어예약 내역 조회
		
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
