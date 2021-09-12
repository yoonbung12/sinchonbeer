package com.bitcamp.sc.cart.repository;

import java.util.List;

import com.bitcamp.sc.cart.domain.CartVO;

public interface CartDao {

	// 1.장바구니 추가
	public CartVO insertCart(CartVO vo);
	
	// 2.장바구니 리스트
	public List<CartVO> listCart(int memberIdx); // 멤버번호로
	
	// 3.장바구니 삭제
	public void deleteCart(int idx);
	
	// 4.장바구니 수정
	public void modifyCart(CartVO vo);
	
	// 5.장바구니 금액 합계
	public int sumMoney(String memberIdx);
	
	// 6.장바구니 상품 확인
	public int countCart(int goodsIdx, int memberIdx);
	
	// 7.장바구니 상품 수량 변경
	public void updateCart(CartVO vo);


}
