package com.bitcamp.sc.mypage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RezList {
	private int pidx;
	private int pprice;
	private String pway;
	private int otpeple; // orders table
	private String tdate;
}
