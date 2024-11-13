package com.scb.firstspringbootrestfulhazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FirstspringbootrestfulhazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringbootrestfulhazelcastApplication.class, args);
	}

}
