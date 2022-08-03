package com.cts.spring.boot.webmvc.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.cts.spring.boot.webmvc.demo.entity.BookEntity;

@SpringBootApplication
public class SpringBootWebmvcDatajpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebmvcDatajpaDemoApplication.class, args);
	}

	@Bean
	@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public List<BookEntity> shoppingCart(){
		return new ArrayList<>();
	}
}
