package com.cts.spring.boot.webmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.spring.boot.webmvc.demo.entity.BookEntity;

@Controller
public class DefaultController {
	
	@Autowired
	@Qualifier("shoppingCart")
	private List<BookEntity> shoppingCart;

	//@RequestMapping(value = {"","/","/home"},method=RequestMethod.GET)
	@GetMapping({"","/","/home"})
	public String homeAction() {
		return "home";
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView("header-segment","webTitle","LibraryPortal");
		mv.addObject("cartCount",shoppingCart.size());
		return mv;
	}
}
