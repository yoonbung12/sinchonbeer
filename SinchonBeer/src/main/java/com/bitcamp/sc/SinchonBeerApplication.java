package com.bitcamp.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bitcamp.sc.tour.dao")
public class SinchonBeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinchonBeerApplication.class, args);
	}

}
