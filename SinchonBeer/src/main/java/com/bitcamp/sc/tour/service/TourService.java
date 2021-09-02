package com.bitcamp.sc.tour.service;

import org.springframework.stereotype.Service;

@Service
public interface TourService {
	
	int selectCount(String date);
	
}
