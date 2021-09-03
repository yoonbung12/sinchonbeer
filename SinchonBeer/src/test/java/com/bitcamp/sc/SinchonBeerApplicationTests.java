package com.bitcamp.sc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SinchonBeerApplicationTests {
	
	private DataSource dataSource;
	private Connection conn;

	@Autowired
	public SinchonBeerApplicationTests(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	void DBDriverTest() throws SQLException {
		System.out.println(dataSource);
		
		conn = dataSource.getConnection();
		
		System.out.println(conn);
	}
	
	
	

}
