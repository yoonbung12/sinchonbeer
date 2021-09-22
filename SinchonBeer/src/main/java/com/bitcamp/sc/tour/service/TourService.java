package com.bitcamp.sc.tour.service;


public interface TourService {
	// 다른 패키지에서 사용되는 메서드 
	// 투어날짜로 tidx 값 가져오기
	int getTidxByTdate(String tdate);
	// 결제 : 투어 idx 로 투어 날짜 가져오기
	String getTourDateByTidx(int tidx);
	
	// 투어예약 : 주문+결제 완료
	int addTourPeopleByDate(int tourPeople,String tdate);
	// 투어예약 취소
	int subTourPeopleByDate(int tourPeople,String tdate);
	
	

}
