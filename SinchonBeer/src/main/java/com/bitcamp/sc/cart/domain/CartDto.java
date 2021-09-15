package com.bitcamp.sc.cart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDto {

	// 클라이언트 요청에 맵핑될 커맨드 클래스 db 저장 목적x
	private int totalPrice;
	private String category;
	private int count;
	private int memberIdx;
	private int goodsIdx;
}
