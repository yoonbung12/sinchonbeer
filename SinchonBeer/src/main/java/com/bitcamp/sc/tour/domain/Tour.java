package com.bitcamp.sc.tour.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Tour {
	private String selectDate;
	private int count;
	private int price;
	private String category;
	
	@Override
	public String toString() {
		return "Tour [selectDate=" + selectDate + ", count=" + count + ", price=" + price + ", category=" + category + "]";
	}
	
	
	
}
