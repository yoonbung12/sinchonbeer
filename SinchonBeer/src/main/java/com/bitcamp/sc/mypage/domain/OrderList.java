package com.bitcamp.sc.mypage.domain;

import java.sql.Timestamp;

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
public class OrderList {
	private int pidx;
	private int pprice;
	private Timestamp pdate;
	private String pstatus;
	private int oidx;
	private int ncount;
	private String gname;
	private String gphoto;
}
