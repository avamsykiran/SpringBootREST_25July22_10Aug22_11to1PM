package com.cts.spring.boot.datajpa.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDatajpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatajpaDemoApplication.class, args);
	}

	@Bean
	public Scanner kbin() {
		return new Scanner(System.in);
	}
}
