package com.controllers;

import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackages={
		"com.controllers", "com.service"})
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}
