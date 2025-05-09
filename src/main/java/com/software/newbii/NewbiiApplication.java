package com.software.newbii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class NewbiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewbiiApplication.class, args);
	}

}
