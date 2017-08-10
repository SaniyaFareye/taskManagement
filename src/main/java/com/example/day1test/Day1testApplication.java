package com.example.day1test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Day1testApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day1testApplication.class, args);
	}
}
