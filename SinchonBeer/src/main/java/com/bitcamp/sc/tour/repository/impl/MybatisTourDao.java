package com.bitcamp.sc.tour.repository.impl;

import java.sql.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.tour.repository.TourDao;

@Repository
public class MybatisTourDao implements TourDao {
	
	private static final String NAME_SPACE = "TourMapper";
	
	private final SqlSessionTemplate template;
	
	@Autowired
	public MybatisTourDao(SqlSessionTemplate template) {
		this.template = template;
	}

	@Override
	public int selectCount(Date date) {
		return template.selectOne(NAME_SPACE+".selectCount", date);
	}

}
