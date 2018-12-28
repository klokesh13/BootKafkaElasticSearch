package com.user.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootKafkaElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaElasticSearchApplication.class, args);
		System.out.println("Application Started...");
	}

}

