package com.bitcamp.sc.tour.repository.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.tour.repository.TourDao;

@Repository
public class MybatisTourDao implements TourDao {
	
	private static final String NAME_SPACE = "TourMapper";
	
	private final SqlSessionTemplate template;
	
	public MybatisTourDao(SqlSessionTemplate template) {
		this.template = template;
	}
	
	// 선택한 날짜의  예약 가능한 인원을 가져오는 메서드
	@Override
	public int selectCount(Date date) {
		return template.selectOne(NAME_SPACE+".selectCount", date);
	}
	
	// 새로운 예약, 예약 변경시 바뀌는 날짜 
	@Override
	public void addTourPeople(int midx, Date newDate) {
		Map<String,Object> params = new HashMap<>();
		params.put("midx", midx);
		params.put("tdate", newDate);
		template.update(NAME_SPACE+".addTourPeople", params);
	}
	// 예약 취소 , 예약 변경시 기존 날짜
	@Override
	public void subTourPeople(int midx, Date currnetDate) {
		Map<String,Object> params = new HashMap<>();
		params.put("midx", midx);
		params.put("tdate", currnetDate);
		template.update(NAME_SPACE+".subTourPeople",params);
		
	}
	// 주문 테이블의 예약 날짜를 변경 --> 현재는 test code
	@Override
	public void changeDateByMidx(int midx, Date newDate) {
		Map<String,Object> params = new HashMap<>();
		params.put("midx", midx);
		params.put("tdate", newDate);
		template.update(NAME_SPACE+".changeDateByMidx",params);
	}
	
	// 

}
