package com.rmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@MapperScan(value = "com.mapper")
public class RmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmcApplication.class, args);
	}
}
