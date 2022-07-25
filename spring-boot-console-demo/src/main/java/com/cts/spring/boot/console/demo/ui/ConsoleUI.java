package com.cts.spring.boot.console.demo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.boot.console.demo.service.GreetService;

@Component
public class ConsoleUI implements CommandLineRunner {

	@Autowired
	private Scanner kbin;
	
	@Autowired
	private GreetService greetService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("UserName: ");
		String userName = kbin.nextLine();
		System.out.println(greetService.greet(userName));
	}

}
