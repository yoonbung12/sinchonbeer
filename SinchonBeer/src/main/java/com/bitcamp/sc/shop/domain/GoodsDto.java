package com.bitcamp.sc.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsDto {
	
	private int price;
	private String category;
	private int count;
	private int memberIdx;
	private int goodsIdx;
}
