package com.fairrepair.fairrepair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FairrepairApplication {

	public static void main(String[] args) {
		SpringApplication.run(FairrepairApplication.class, args);
	}

}
