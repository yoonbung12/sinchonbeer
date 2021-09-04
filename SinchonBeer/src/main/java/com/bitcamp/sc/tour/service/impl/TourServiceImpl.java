package com.bitcamp.sc.tour.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
