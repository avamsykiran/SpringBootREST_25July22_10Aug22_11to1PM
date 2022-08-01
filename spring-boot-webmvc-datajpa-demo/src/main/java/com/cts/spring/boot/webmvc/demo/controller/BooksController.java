package com.cts.spring.boot.webmvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.spring.boot.webmvc.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public ModelAndView getAllBooksAction() {
		return new ModelAndView("books/books-list-page","books",bookService.getAll());
	}
}
