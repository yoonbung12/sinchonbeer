package com.bitcamp.sc.order.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
	private int idx;
	private Timestamp date;
	private String category;
	private int price;
	private int tourIdx;
	private int tourPeople;
	private int memberIdx;
	private int addressIdx;

	public OrderInfo(String category, int price, int tourIdx, int tourPeople, int memberIdx, int addressIdx) {
		this.category = category;
		this.price = price;
		this.tourIdx = tourIdx;
		this.tourPeople = tourPeople;
		this.memberIdx = memberIdx;
		this.addressIdx = addressIdx;
	}
}
