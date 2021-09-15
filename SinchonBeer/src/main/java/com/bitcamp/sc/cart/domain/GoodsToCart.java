package com.bitcamp.sc.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GoodsToCart {

	private String gphoto;
	private int idx;
	private int gprice;
	private int amount;
	
	public GoodsToCart(String gphoto, int gprice, int amount) {
		this.gphoto = gphoto;
		this.gprice = gprice;
		this.amount = amount;
	}
	
	public GoodsToCart(int idx, int gprice, int amount) {
		this.idx = idx;
		this.gprice =gprice;
		this.amount = amount;
	}
}
