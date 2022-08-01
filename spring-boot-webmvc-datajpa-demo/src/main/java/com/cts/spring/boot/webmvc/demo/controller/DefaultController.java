package com.cts.spring.boot.webmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	//@RequestMapping(value = {"","/","/home"},method=RequestMethod.GET)
	@GetMapping({"","/","/home"})
	public String homeAction() {
		return "home";
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() {
		return new ModelAndView("header-segment","webTitle","LibraryPortal");
	}
}
