package com.bitcamp.sc.tour.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ChangeTourDto {
	private int tourPeople;
	private int midx;
	private String resDate;
	private String newDate;
}
