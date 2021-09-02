package com.bitcamp.sc.tour.service.impl;

import java.sql.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.tour.dao.TourDao;
import com.bitcamp.sc.tour.service.TourService;
@Service
public class TourServiceImpl implements TourService {

	private TourDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int selectCount(String date) {
		Date ckDate = Date.valueOf(date);
		dao = template.getMapper(TourDao.class);
		return dao.selectCount(ckDate);
	}

}
