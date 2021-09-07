package com.bitcamp.sc.tour.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.tour.domain.TourOrderInfo;
import com.bitcamp.sc.tour.repository.impl.MybatisTourDao;
import com.bitcamp.sc.tour.service.TourService;
@Service
public class TourServiceImpl implements TourService {
	
	private MybatisTourDao dao;
	
	@Autowired
	public TourServiceImpl(MybatisTourDao dao) {
		this.dao = dao;
	}
	
	@Override
	public int selectCount(String date) {
		Date ckDate = Date.valueOf(date);
		return dao.selectCount(ckDate);
	}
	// 투어 주문 정보 가져오기
	public List<TourOrderInfo> getTourOrder(int midx,String category){
		return dao.getTourOrderByMidx(midx, category);
	}
	
	// 주문 테이블의 투어 날짜 변경
	@Override
	public void changeTourOrder(Map<String,Object> params) {
		int midx =Integer.parseInt((String) params.get("midx"));
		Date resDate = Date.valueOf((String) params.get("resDate"));
		Date newDate = Date.valueOf((String) params.get("newDate"));

		dao.changeDateByMidx(midx, newDate);	
		dao.addTourPeople(midx, newDate);
		dao.subTourPeople(midx, resDate);
	}

	
	
	// String -> Date
	public Date changeToDate(String date) {
		return Date.valueOf(date);
	}
	
}
