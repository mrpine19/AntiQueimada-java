package com.queimazero.queimazeroAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QueimazeroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueimazeroApiApplication.class, args);
	}

}
