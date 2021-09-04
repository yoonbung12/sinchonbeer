package com.bitcamp.sc.tour.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MybatisTourDaoTest {
	
	@Autowired
	MybatisTourDao dao;
	
	@Test
	@Transactional
	@Rollback(false)
	void 가능인원조회() {
		
		String date = "2021-09-06";
		Date ckDate = Date.valueOf(date);
		
		int result = dao.selectCount(ckDate);
		
//		assertNotNull(result, "정상적으로 가져옴");
		assertEquals(2, result);
		
		
	}
}
