package com.bitcamp.sc.tour.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ChangeTourDto {
	private int tourPeople;
	private int midx;
	private Date resDate;
	private Date newDate;
}
