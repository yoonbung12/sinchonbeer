package com.bitcamp.sc.mypage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.sc.mypage.domain.RezList;
import com.bitcamp.sc.mypage.repository.MypageDao;
import com.bitcamp.sc.mypage.service.MyRezListService;

@Service
public class MyRezListServiceImpl implements MyRezListService {
	MypageDao dao;

	@Autowired
	public MyRezListServiceImpl(MypageDao dao) {
		this.dao = dao;
	}

	// 예약 내역 조회
	@Override
	public List<RezList> getRezList(int idx) {
		return dao.getRezList(idx);
	}
}
