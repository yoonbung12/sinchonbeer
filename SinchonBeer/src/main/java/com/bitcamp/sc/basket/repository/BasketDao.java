package com.bitcamp.sc.basket.repository;

import java.util.List;

import com.bitcamp.sc.basket.domain.BasketDto;
import com.bitcamp.sc.basket.domain.BasketVo;

public interface BasketDao {

	// 장바구니 생성
	int createBasket(BasketDto bDto);
	
	// 장바구니 확인
	int checkBasket(int gidx, int midx);
	List<BasketVo> getBasketList(int midx);
	int getTotalPay(int midx);
	int deleteRowByGidx(int gidx, int midx);
	void deleteAll(int midx);
	void modifyAmount(BasketDto bDto);
	int changeBasketAmount(BasketDto bDto);
}
