package com.bitcamp.sc.basket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasketVO {

	private int idx; // 장바구니 번호
	private int count; // 수량
	private int memberIdx; // 멤버 번호
	private int goodsIdx; // 상품 번호
	
	
	public BasketVO(int count, int memberIdx, int goodsIdx) {
		this.count = count;
		this.memberIdx = memberIdx;
		this.goodsIdx = goodsIdx;
	}
	
}
